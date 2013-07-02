
<%@ page import="com.prhdapi.RoleField" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'roleField.label', default: 'RoleField')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-roleField" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-roleField" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list roleField">
			
				<g:if test="${roleFieldInstance?.fieldID}">
				<li class="fieldcontain">
					<span id="fieldID-label" class="property-label"><g:message code="roleField.fieldID.label" default="Field ID" /></span>
					
						<span class="property-value" aria-labelledby="fieldID-label"><g:fieldValue bean="${roleFieldInstance}" field="fieldID"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${roleFieldInstance?.roleID}">
				<li class="fieldcontain">
					<span id="roleID-label" class="property-label"><g:message code="roleField.roleID.label" default="Role ID" /></span>
					
						<span class="property-value" aria-labelledby="roleID-label"><g:fieldValue bean="${roleFieldInstance}" field="roleID"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${roleFieldInstance?.id}" />
					<g:link class="edit" action="edit" id="${roleFieldInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
