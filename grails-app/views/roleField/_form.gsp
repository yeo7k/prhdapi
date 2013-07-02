<%@ page import="com.prhdapi.RoleField" %>



<div class="fieldcontain ${hasErrors(bean: roleFieldInstance, field: 'fieldID', 'error')} ">
	<label for="fieldID">
		<g:message code="roleField.fieldID.label" default="Field ID" />
		
	</label>
	<g:textField name="fieldID" value="${roleFieldInstance?.fieldID}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: roleFieldInstance, field: 'roleID', 'error')} ">
	<label for="roleID">
		<g:message code="roleField.roleID.label" default="Role ID" />
		
	</label>
	<g:textField name="roleID" value="${roleFieldInstance?.roleID}"/>
</div>

