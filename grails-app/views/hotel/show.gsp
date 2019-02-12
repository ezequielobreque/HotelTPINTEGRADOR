<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'hotel.label', default: 'Hotel')}" />
        <title><g:message code="default.show.label" args="[entityName]" /></title>
        <style>

        /* Demo styles */
        html,body{background:#FFFFFF;margin:0;}
        body{border-top:4px solid #000;}
        .content{color:#777;font:12px/1.4 "helvetica neue",arial,sans-serif;width:620px;margin:20px auto;}
        h1{font-size:12px;font-weight:normal;color:#ddd;margin:0;}
        p{margin:0 0 20px}
        a {color:#22BCB9;text-decoration:none;}
        .cred{margin-top:20px;font-size:11px;}

        /* This rule is read by Galleria to define the gallery height: */
        #galleria{height:320px}


        </style>
    </head>
    <body>
        <a href="#show-hotel" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
<sec:ifLoggedIn>
                <li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
                <li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
</sec:ifLoggedIn>
            </ul>
        </div>
        <div id="show-hotel" class="content scaffold-show" role="main">
            <h2><f:display bean="hotel" property="nombre" /></h2>
        </div>
            <div>
                <div class="content">



                    <div id="galleria">
                <g:each  in="${this.hotel.imagen}">
                <asset:image  src="${it.nombre}"/>
                </g:each>
        </div>
    </div>

            <g:if test="${flash.message}">
            <div class="message" role="status">${flash.message}</div>
            </g:if>
            <sec:ifNotLoggedIn>
            <f:display bean="hotel" except="imagen,nombre,habitaciones,reserva"/>
                <fieldset class="buttons">
                <g:link controller="SolicitudHotel" action="create" id="${this.hotel.id}">reservar</g:link>
                </fieldset>
                </sec:ifNotLoggedIn>
                <sec:ifLoggedIn>
                    <f:display bean="hotel" except="imagen,nombre"/>
                </sec:ifLoggedIn>
            <g:form resource="${this.hotel}" method="DELETE">
                <sec:ifLoggedIn>
                <fieldset class="buttons">
                    <g:link class="edit" action="edit" resource="${this.hotel}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
                    <g:link controller="SolicitudHotel" action="create" id="${this.hotel.id}">reservar</g:link>

                    <input class="delete" type="submit" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
                </fieldset>
                </sec:ifLoggedIn>

            </g:form>
        </div>
            <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.js"></script>
            <!-- load Galleria -->
            <script src="https://cdnjs.cloudflare.com/ajax/libs/galleria/1.5.7/galleria.min.js"></script>
            <script src="https://cdnjs.cloudflare.com/ajax/libs/galleria/1.5.7/themes/classic/galleria.classic.min.js"></script>
            <script>
                $(function() {
                    Galleria.run('#galleria');
                });
            </script>
    </body>
</html>
