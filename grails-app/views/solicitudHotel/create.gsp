<!DOCTYPE html>

<head>

        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'solicitudHotel.label', default: 'SolicitudHotel')}" />
        <title><g:message code="default.create.label" args="[entityName]" /></title>
    </head>
    <body>
        <a href="#create-solicitudHotel" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                <li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
            </ul>
        </div>
        <div id="create-solicitudHotel" class="content scaffold-create" role="main">
            <h1>Solicitud de reserva para el  ${this.solicitudHotel.hotel} </h1>
            <g:if test="${flash.message}">
            <div class="message" role="status">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${this.solicitudHotel}">
            <ul class="errors" role="alert">
                <g:eachError bean="${this.solicitudHotel}" var="error">
                <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
                </g:eachError>
            </ul>
            </g:hasErrors>
            <g:form resource="${this.solicitudHotel}" method="POST">
                <fieldset class="form">
                    <f:all bean="solicitudHotel" except="fechaIN,fechaOut"/>

                <div class="form-group row justify-content-center" bean="solicitudHabitacion" property="fechaIN">
                <label for="example-date-input" class="col-1 col-form-label">Fecha Ingreso</label>
                <div class="col-3"><g:field type="date" id="datepicker" name="fechaIN" value="${solicitudHabitacionInstance?.fechaIN}" required="true" /></div>

                </div>
                <div class="form-group row justify-content-center" bean="solicitudHabitacion" property="fechaOut">
                    <label for="example-date-input" class="col-1 col-form-label">Fecha Egreso</label>
                    <div class="col-3">
                        <g:field type="date" id="datepicker" name="fechaOut" value="${solicitudHabitacionInstance?.fechaOut}" required="true" />
                    </div>
                </div>


                <fieldset class="buttons">
                    <g:submitButton name="create" class="save" value="${message(code: 'default.button.create.label', default: 'Create')}" />
                </fieldset>
            </g:form>
        </div>
    <script>
        $( function() {
            $( "#datepicker" ).datepicker();
        } );
    </script>

    </body>
</html>
