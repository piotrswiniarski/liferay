<%@ include file="../init.jsp"%>
<div class="online-sdk">
	<c:choose>
		<c:when test="<%=themeDisplay.isSignedIn()%>">
			<liferay-ui:error></liferay-ui:error>

			<%
				String scriptOutput = ParamUtil.getString(renderRequest, "script_output", "");
				String appBody = "Hello world!";
				String appName = "New app name";
				String appLanguage = OnlineSDKContsants.GROOVY;
				String screenWidth = portletPreferences.getValue(OnlineSDKContsants.SCREEN_WIDTH, "600");
				String screenHeight = portletPreferences.getValue(OnlineSDKContsants.SCREEN_HEIGHT, "600");
				String appIdString = portletPreferences.getValue(OnlineSDKContsants.APP_ID, "");
			%>
			<style type="text/css" media="screen">
				#editor {
					position: relative;
					width: <%=screenWidth%>px;
					height: <%=screenHeight%>px;
				}
			</style>
						
			<c:choose>
				<c:when test="<%="".equals(appIdString)%>">
					<div class="alert alert-dismissible alert-info"
						data-dismiss="alert" role="alert">
						<p>
							<liferay-ui:message key="new-app-will-be-created"></liferay-ui:message>
						</p>
					</div>
				</c:when>
				<c:otherwise>
					<c:if test="<%=!"".equals(appIdString)%>">
						<%
							long appId = Long.parseLong(appIdString);
						%>
						<c:if test="<%=appId > 0%>">
							<%
							try {
								App app = AppLocalServiceUtil.getApp(appId);
								appBody = app.getAppBody();
								appName = app.getAppName();
								appLanguage = app.getAppLanguage();
							} catch (NoSuchAppException e) {
							%>
								<div class="alert alert-dismissible alert-danger" data-dismiss="alert" role="alert">
									<p>
										<%=e.getMessage()%>
									</p>
									<p><liferay-ui:message key="new-app-will-be-created"></liferay-ui:message></p>
								</div>
							<%
							}
							%>
						</c:if>

					</c:if>
				</c:otherwise>
			</c:choose>
			<%
			String customErrorMsg = (String) request.getAttribute(OnlineSDKContsants.CUSTOM_ERROR_MSG);
			%>
			<c:if test="<%=customErrorMsg != null %>">
				<div class="alert alert-dismissible alert-danger"
					data-dismiss="alert" role="alert">
					<p><%=HtmlUtil.escape(customErrorMsg)%></p>
				</div>
			</c:if>

			<aui:input id="appName" name="appName" label="" value="<%=appName%>" />
			<div id="editor">Your code here</div>

			<script src="/OnlineSDK-portlet/js/src-min/ace.js"
				type="text/javascript" charset="utf-8"></script>
			<script>
				var editor = ace.edit("editor");
				editor.setTheme("ace/theme/monokai");
				editor.getSession().setMode("ace/mode/html");
				<%if (portletPreferences != null) {%>
					editor.setValue("<%=HtmlUtil.escapeJS(appBody)%>");
				<%}%>
			</script>

			<portlet:resourceURL var="saveBody">
			</portlet:resourceURL>

			<button class="btn btn-info" onclick="callServeResource()"
				data-toggle="modal"><liferay-ui:message key="save"></liferay-ui:message></button>

			<portlet:actionURL var="execute"></portlet:actionURL>
			<a id="execute" href="<%=execute%>" class="btn btn-warning"><liferay-ui:message key="execute"></liferay-ui:message></a>

			<div aria-labelledby="lexSmallModalLabel" class="fade modal"
				id="lexSmallModal" role="dialog" tabindex="-1"
				style="display: none;">
				<div class="modal-dialog modal-sm">
					<div class="modal-content">
						<div class="modal-header">
							<button aria-labelledby="Close" class="btn btn-default close"
								data-dismiss="modal" role="button" type="button">
								<svg aria-hidden="true" class="lexicon-icon lexicon-icon-times"
									viewBox="0 0 512 512">
									<path class="lexicon-icon-outline" d="M295.781 256l205.205-205.205c10.998-10.998 10.998-28.814 0-39.781-10.998-10.998-28.815-10.998-39.781 0l-205.205 205.205-205.205-205.238c-10.966-10.998-28.814-10.998-39.781 0-10.998 10.998-10.998 28.814 0 39.781l205.205 205.238-205.205 205.205c-10.998 10.998-10.998 28.815 0 39.781 5.467 5.531 12.671 8.265 19.874 8.265s14.407-2.734 19.907-8.233l205.205-205.238 205.205 205.205c5.5 5.5 12.703 8.233 19.906 8.233s14.407-2.734 19.906-8.233c10.998-10.998 10.998-28.815 0-39.781l-205.238-205.205z"></path>
								</svg>
							</button>

							<button
								class="btn btn-default modal-primary-action-button visible-xs"
								type="button">
								<svg aria-hidden="true" class="lexicon-icon lexicon-icon-check"
									viewBox="0 0 512 512">
									<path class="lexicon-icon-outline" d="M502.091 60.993c-9.909-9.91-25.962-9.91-35.843 0l-336.988 336.988-83.508-83.451c-9.881-9.909-25.962-9.909-35.843 0-9.909 9.909-9.909 25.962 0 35.843l98.257 98.257c2.608 2.608 5.679 4.433 8.924 5.679 4.028 2.464 8.403 4.115 12.952 4.115 6.49 0 12.981-2.464 17.936-7.418l354.112-354.141c9.909-9.909 9.909-25.962 0-35.871l0-0.001z"></path>
								</svg>
							</button>

							<h4 class="modal-title" id="lexSmallModalLabel"><liferay-ui:message key="status"></liferay-ui:message> </h4>
						</div>

						<div class="modal-body">
							<span id="message-body"></span>
						</div>

						<div class="modal-footer">
							<button class="btn btn-link close-modal" data-dismiss="modal"
								type="button">Close</button>
						</div>
					</div>
				</div>
			</div>


			<div class="portlet-msg-info">
				<%=scriptOutput%>

			</div>

			<select name="appLanguage" id="appLanguage" class="form-control">
				<c:choose>
					<c:when test="appLanguage.equals(OnlineSDKContsants.GROOVY">
						<option selected="true" value="<%=OnlineSDKContsants.GROOVY%>"><%=OnlineSDKContsants.GROOVY%></option>
						<option value="<%=OnlineSDKContsants.HTML%>"><%=OnlineSDKContsants.HTML%></option>
					</c:when>				
					<c:otherwise>
						<option value="<%=OnlineSDKContsants.GROOVY%>"><%=OnlineSDKContsants.GROOVY%></option>
						<option selected="true" value="<%=OnlineSDKContsants.HTML%>"><%=OnlineSDKContsants.HTML%></option>
					</c:otherwise>
				</c:choose>
			</select>

			<script type="text/javascript">
				function showStatus(text) {
					$('#message-body').text(text);
					$('#lexSmallModal').modal('show');
				};
				
				
				$(document).ready(function(){
					var lang = $("#appLanguage");
					if(lang.val()=="<%=OnlineSDKContsants.GROOVY%>"){
						$("#execute").show();
					}else{
						$("#execute").hide();
					}	
				});
				
					
					
				
				
				$("#appLanguage").change(function() {
				  if(this.value!="<%=OnlineSDKContsants.GROOVY%>"){
					  $("#execute").hide();
				  }else{
					  $("#execute").show();
				  }
				});
						
						
				
				
				function callServeResource(){
					var appName=AUI().one("#<portlet:namespace />appName").get('value');
				    AUI().use('aui-io-request', 'aui-node', function(A){
				        A.io.request('<%=saveBody.toString()%>', {
				        	method: 'POST',
				        	dataType: 'json',
				            data: {
				            	<portlet:namespace/><%=OnlineSDKContsants.APP_NAME%>: appName,
								<portlet:namespace/><%=OnlineSDKContsants.APP_BODY%>: editor.getValue(),
								<portlet:namespace/><%=OnlineSDKContsants.APP_LANGUAGE%>: A.one('#appLanguage').get('value')
							},
							on : {
								success : function() {
									var item = A.one("#lexSmallModal");
									showStatus(this.get('responseData'));
								}
							}
						});
					});
				};
			</script>
		</c:when>
		<c:otherwise>
			<div class="alert alert-dismissible alert-info" data-dismiss="alert"
				role="alert">
				<p><liferay-ui:message key="sign-in-to-access-portlet"></liferay-ui:message></p>
			</div>
		</c:otherwise>
	</c:choose>
</div>
