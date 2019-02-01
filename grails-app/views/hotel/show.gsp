<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'hotel.label', default: 'Hotel')}" />
        <title><g:message code="default.show.label" args="[entityName]" /></title>
    </head>
    <body>
        <a href="#show-hotel" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                <li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
                <li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
            </ul>
        </div>
        <div id="show-hotel" class="content scaffold-show" role="main">
            <h1><g:message code="default.show.label" args="[entityName]" /></h1>
            <h1><f:display bean="hotel" property="nombre" /></h1>
            <g:if test="${this.hotel.featuredImageBytes}">
                <img src="<g:createLink controller="hotel" action="featuredImage" id="${this.hotel.id}"/>" width="400"/>
            </g:if>
            <g:if test="${flash.message}">
            <div class="message" role="status">${flash.message}</div>
            </g:if>
            <f:display bean="hotel" except="featuredImageBytes,featuredImageContentType"/>
            <g:form resource="${this.hotel}" method="DELETE">
                <fieldset class="buttons">
                    <g:link class="edit" action="edit" resource="${this.hotel}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
                    <g:link class="edit" action="editFeaturedImage" resource="${this.hotel}"><g:message code="hotel.featuredImageUrl.edit.label" default="Edit Featured Image" /></g:link>
                    <input class="delete" type="submit" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
                </fieldset>
            </g:form>
        </div>
    </body>
</html>
