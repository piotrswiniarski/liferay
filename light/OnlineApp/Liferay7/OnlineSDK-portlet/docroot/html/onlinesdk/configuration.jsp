<%@ include file="../init.jsp" %>

<%

String selectedAppId = portletPreferences.getValue(OnlineSDKContsants.APP_ID, "none");
String selectedAppName = portletPreferences.getValue(OnlineSDKContsants.APP_NAME, "");
boolean somePreferenceKey_cfg = GetterUtil.getBoolean(portletPreferences.getValue("somePreferenceKey", StringPool.TRUE));
List<App> apps = AppLocalServiceUtil.getApps(-1, -1);
String screenWidth = portletPreferences.getValue(OnlineSDKContsants.SCREEN_WIDTH, "600");
String screenHeight = portletPreferences.getValue(OnlineSDKContsants.SCREEN_HEIGHT, "600");

%>
<p class="portlet-msg-info">
	<liferay-ui:message key="currently-selected-app"></liferay-ui:message>
	<%=selectedAppId+" "+selectedAppName %></p>

<liferay-ui:search-container emptyResultsMessage="no-apps-found">
	<liferay-ui:search-container-results results="<%=apps%>" />
	<liferay-ui:search-container-row
		className="com.liferay.online.model.App" keyProperty="onlineAppId"
		modelVar="app">
		<liferay-ui:search-container-column-text name="id"
			property="onlineAppId" />
		<liferay-ui:search-container-column-text name="name"
			property="appName" />
		<liferay-ui:search-container-column-text name="description"
			property="appDescription" />
		<liferay-ui:search-container-column-jsp path="/html/onlinesdk/row_action.jsp" />
	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />

</liferay-ui:search-container>


<liferay-portlet:actionURL var="setScreen" portletConfiguration="true" >
	<portlet:param name="<%=OnlineSDKContsants.ACTION%>"
		value="<%=OnlineSDKContsants.ACTION_SET_SCREEN %>" />
</liferay-portlet:actionURL>


<div class="input-group-default">
<aui:form action="<%=setScreen %>" method="post">
	<aui:input name="<%=OnlineSDKContsants.SCREEN_WIDTH%>" value="<%=screenWidth%>" type="text"/> 
	<aui:input name="<%=OnlineSDKContsants.SCREEN_HEIGHT%>" value="<%=screenHeight%>" type="text"/>
	<aui:input name="submit" type="submit" value="Set" />
</aui:form> 
</div>

