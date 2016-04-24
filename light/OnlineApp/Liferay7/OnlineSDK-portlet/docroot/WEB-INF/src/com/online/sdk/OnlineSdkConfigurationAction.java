package com.online.sdk;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.ProcessAction;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.online.service.AppLocalServiceUtil;
import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;



public class OnlineSdkConfigurationAction extends DefaultConfigurationAction {
	
	
	
	@Override
	public void processAction(
	    PortletConfig portletConfig, ActionRequest actionRequest,
	    ActionResponse actionResponse) throws Exception {  
		String action = ParamUtil.getString(actionRequest, OnlineSDKContsants.ACTION);
		if(action.equals(OnlineSDKContsants.ACTION_SET_SCREEN)){
			String screenWidth = ParamUtil.getString(actionRequest, OnlineSDKContsants.SCREEN_WIDTH);
			String screenHeight = ParamUtil.getString(actionRequest, OnlineSDKContsants.SCREEN_HEIGHT);
		    PortletPreferences prefs = actionRequest.getPreferences();
		    prefs.setValue(OnlineSDKContsants.SCREEN_WIDTH, screenWidth);
		    prefs.setValue(OnlineSDKContsants.SCREEN_HEIGHT, screenHeight);
		    prefs.store();
		    System.out.println("width: "+screenWidth+" height: "+screenHeight);
			
		}else{
			
			System.out.println("in process action");
			String appId = ParamUtil.getString(actionRequest, OnlineSDKContsants.APP_ID);
			long appIdLong = 0;
			try{
				appIdLong = Long.parseLong(appId);
			}catch(NumberFormatException e){
				System.out.println("number exception");
				SessionErrors.add(actionRequest, "incorrect-app-id");
				super.processAction(portletConfig, actionRequest, actionResponse);
				return;
				
			}
			if(appIdLong<=0){
				SessionErrors.add(actionRequest, "incorrect-app-id");
				super.processAction(portletConfig, actionRequest, actionResponse);
				return;
			}
			if(action.equals(OnlineSDKContsants.ACTION_SELECT)){
				    PortletPreferences prefs = actionRequest.getPreferences();
				    prefs.setValue(OnlineSDKContsants.APP_ID, appId);
				    prefs.store();
			}
			
			if(action.equals(OnlineSDKContsants.ACTION_DELETE)){
			    PortletPreferences prefs = actionRequest.getPreferences();
			    if(appId.equals(prefs.getValue(OnlineSDKContsants.APP_ID, appId))){
				    prefs.setValue(OnlineSDKContsants.APP_ID, "-1");
				    prefs.store();
			    }
			    AppLocalServiceUtil.deleteApp(Long.parseLong(appId));
			    SessionMessages.add(actionRequest, "Application "+appId+" deleted");
			}
		}
	    super.processAction(portletConfig, actionRequest, actionResponse);


System.out.println("in prefs");
	}

}
