<%@ include file="../init.jsp" %>
<%
 ResultRow resultRow = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
 App app = (App)resultRow.getObject();
 String appId = String.valueOf(app.getOnlineAppId());
 %>


<liferay-portlet:actionURL var="deleteApp" portletConfiguration="true" >
	<portlet:param name="<%=OnlineSDKContsants.ACTION%>"
		value="<%=OnlineSDKContsants.ACTION_DELETE %>" />
	<portlet:param name="<%=OnlineSDKContsants.APP_ID %>"
		value="<%=appId%>" />
</liferay-portlet:actionURL>

<liferay-portlet:actionURL var="selectApp" portletConfiguration="true" >
	<portlet:param name="<%=OnlineSDKContsants.ACTION%>"
		value="<%=OnlineSDKContsants.ACTION_SELECT %>" />
	<portlet:param name="<%=OnlineSDKContsants.APP_ID %>"
		value="<%=appId%>" />
</liferay-portlet:actionURL>


<div class="dropdown" style="display: inline-block;">
	<button class="btn btn-default dropdown-toggle" data-toggle="dropdown"
		type="button">
		Action <span class="icon-caret-down"></span>
	</button>
	<ul class="dropdown-menu">
		<li><a href="<%=selectApp%>"><liferay-ui:message key="select"></liferay-ui:message> </a></li>
		<li><a href="<%=deleteApp%>" onclick="return confirm('Do you want delete app?')"><liferay-ui:message key="delete"></liferay-ui:message> </a></li>
	</ul>
</div>
