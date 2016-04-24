<%@ include file="../init.jsp"%>
<div class="online-app">

<%
	String appBody = null;
	String appName = null;
	String appLanguage = null;
	String appIdString = portletPreferences.getValue(OnlineSDKContsants.APP_ID, "");
	if (!"".equals(appIdString)) {
		long appId = Long.parseLong(appIdString);
		if (appId > 0) {
			try {
				App app = AppLocalServiceUtil.getApp(appId);
				appBody = app.getAppBody();
				appName = app.getAppName();
				appLanguage = app.getAppLanguage();
			} catch (NoSuchAppException e) {
%>
 
	<div class="alert alert-dismissible alert-danger" data-dismiss="alert"
		role="alert">		
		<p>
			<%=e.getMessage()%>
		</p>
		<p><liferay-ui:message key="app-with-id-does-not-exist" arguments="<%=appIdString %>"></liferay-ui:message></p>
	</div>
	<%
		}
			}

		if(appLanguage.equals(OnlineSDKContsants.HTML)){
			out.print(appBody);
		}else{
			%><p><a href="" class="btn btn-warning" ><%=appName %></a></p><%
		}
		
		} else {
	%>
	<div class="alert alert-dismissible alert-info" data-dismiss="alert"
		role="alert">
		<p>No app selected. Check configuration of the portlet.</p>
	</div>
	<%
		}
	%>
</div>