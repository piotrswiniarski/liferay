package com.online.sdk;

import java.io.IOException;
import java.sql.Blob;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.GenericPortlet;
import javax.portlet.PortletConfig;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.ProcessAction;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.online.exception.NoSuchAppException;
import com.liferay.online.model.App;
import com.liferay.online.service.AppLocalServiceUtil;
import com.liferay.online.service.AppServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayOutputStream;
import com.liferay.portal.kernel.io.unsync.UnsyncPrintWriter;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.LiferayPortletConfig;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.scripting.ScriptingException;
import com.liferay.portal.kernel.scripting.ScriptingHelperUtil;
import com.liferay.portal.kernel.scripting.ScriptingUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.JavaConstants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.UnsyncPrintWriterPool;
import com.liferay.portal.kernel.util.WebKeys;




public class SDKPortlet extends MVCPortlet {

	private static Log _log = LogFactoryUtil.getLog(SDKPortlet.class);



	@Override
	public void serveResource(ResourceRequest aResourceRequest, ResourceResponse aResourceResponse)
			throws PortletException, IOException {
		
		ThemeDisplay td  =(ThemeDisplay)aResourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		if(td.isSignedIn()){
			User user = (User) aResourceRequest.getAttribute(WebKeys.USER);
			App app = null;
			String appBody = ParamUtil.getString(aResourceRequest, OnlineSDKContsants.APP_BODY);
			String appName = ParamUtil.getString(aResourceRequest, OnlineSDKContsants.APP_NAME);
			String appLanguage = ParamUtil.getString(aResourceRequest, OnlineSDKContsants.APP_LANGUAGE);
			PortletPreferences pp = aResourceRequest.getPreferences();
			
			String appIdString = pp.getValue(OnlineSDKContsants.APP_ID, "0");
			long appId = 0;
			if(!appIdString.isEmpty()){
				appId =Long.parseLong(appIdString); 
			}
			if(appId == 0){
				appId = CounterLocalServiceUtil.increment(App.class.getName());
				app = AppLocalServiceUtil.createApp(appId);
				appId = app.getOnlineAppId();
			}else{
				try {
					app = AppLocalServiceUtil.getApp(appId);
				} catch (NoSuchAppException e){
					appId = CounterLocalServiceUtil.increment(App.class.getName());
					app = AppLocalServiceUtil.createApp(appId);
					
				} catch (PortalException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					String textValue = "ERROR: "+e.getMessage();
					aResourceResponse.getWriter().write(textValue);
					super.serveResource(aResourceRequest, aResourceResponse);
					return;
				}
			}
			
			app.setAppBody(appBody);
			app.setAppName(appName);
			app.setAppLanguage(appLanguage);
			app.setUserId(user.getUserId());
			
			app = AppLocalServiceUtil.updateApp(app);
			if (appName != null && appBody != null) {		
				pp.setValue(OnlineSDKContsants.APP_ID, app.getOnlineAppId()+"");
				pp.store();
			}
			String textValue = "App "+app.getOnlineAppId()+" saved successfully";
			aResourceResponse.getWriter().write(textValue);
			
		}else{
			String textValue = "Unauthorized";
			aResourceResponse.getWriter().write(textValue);
			
		}
	}

	
	@Override
	public void processAction(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {
		// TODO Auto-generated method stub
		PortletPreferences pp = actionRequest.getPreferences();
		String appIdString = pp.getValue(OnlineSDKContsants.APP_ID, "");
		long appId = 0;
		try{
			appId = Long.parseLong(appIdString);
		}catch(NumberFormatException e){
			SessionErrors.add(actionRequest, e.getMessage());
			return;
		}
		_log.info(OnlineSDKContsants.APP_ID+": " + appId);
		if(appId>0){
			try {
				App app = AppLocalServiceUtil.getApp(appId);
				String language = app.getAppLanguage();
				String script = app.getAppBody();
				if(!language.equals(OnlineSDKContsants.GROOVY)){
					actionRequest.setAttribute(OnlineSDKContsants.CUSTOM_ERROR_MSG, "You can only execute groovy code.");
					return;
				}
				Map<String, Object> portletObjects = ScriptingHelperUtil.getPortletObjects(getPortletConfig(), getPortletContext(),
                        actionRequest, actionResponse);
                UnsyncByteArrayOutputStream unsyncByteArrayOutputStream = new UnsyncByteArrayOutputStream();

                UnsyncPrintWriter unsyncPrintWriter = UnsyncPrintWriterPool.borrow(unsyncByteArrayOutputStream);

                portletObjects.put("out", unsyncPrintWriter);

                _log.info("Executing script");
                ScriptingUtil.exec(null, portletObjects, language, script, StringPool.EMPTY_ARRAY);
                unsyncPrintWriter.flush();
                actionResponse.setRenderParameter("script_output", unsyncByteArrayOutputStream.toString());
			} catch (ScriptingException e) {
				_log.error(e.getMessage());
				actionRequest.setAttribute(OnlineSDKContsants.CUSTOM_ERROR_MSG, e.getMessage());
			} catch (PortalException e) {
				_log.error(e);
				actionRequest.setAttribute(OnlineSDKContsants.CUSTOM_ERROR_MSG, e.getMessage());
			}
		}else{
			SessionErrors.add(actionRequest, "incorrect-app-id");
		}
	}

	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		// TODO Auto-generated method stub
		
		String customErrorMsg = (String) renderRequest.getAttribute(OnlineSDKContsants.CUSTOM_ERROR_MSG);
		if(customErrorMsg!=null)
			renderRequest.setAttribute(OnlineSDKContsants.CUSTOM_ERROR_MSG, customErrorMsg);
		
		super.render(renderRequest, renderResponse);
	}

}
