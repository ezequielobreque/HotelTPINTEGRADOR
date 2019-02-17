<!DOCTYPE html>
<html>
    <head>
    <meta name="layout" content="main" />
    <g:set var="entityName" value="${message(code: 'solicitudHotel.label', default: 'SolicitudHotel')}" />
    <title><g:message code="default.show.label" args="[entityName]" /></title>
</head>
    <body>
        <a href="#show-solicitudHotel" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
    <div class="fondo">

        <fieldset class="nav" role="navigation">
            <fieldset class="buttons">
            <ul>
                <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                <sec:ifLoggedIn>
                <li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
                <li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
                </sec:ifLoggedIn>
            </ul>
            </fieldset>
        </fieldset>
        <div id="show-solicitudHotel" class="content scaffold-show" role="main">
            <div class="titulo">
            <h1>Datos de su solicitud de hotel</h1>
            </div>

            <g:if test="${flash.message}">
            <div class="message" role="status">${flash.message}</div>
            </g:if>

            <div class="row" >
                <div class="col-sm-6 col-md-6">
                    <div class="textoBean">
            <f:display bean="solicitudHotel" />
                        </div>
                </div>
            </div>


            <g:form resource="${this.solicitudHotel}" method="DELETE">
                <fieldset class="buttons">
                    <g:link action="aceptarSolicitud" resource="${this.solicitudHotel}">aceptar solicitud</g:link>
                    <g:link class="edit" action="edit" resource="${this.solicitudHotel}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
                    <input class="delete" type="submit" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
                </fieldset>
            </g:form>
        </div>
        </div>
    </body>
</html>
