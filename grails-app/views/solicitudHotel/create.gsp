<!DOCTYPE html>

<head>

        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'solicitudHotel.label', default: 'SolicitudHotel')}" />
        <title><g:message code="default.create.label" args="[entityName]" /></title>



</head>
    <body>
    <a href="#create-solicitudHotel" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
    <div class="fondo">
        <fieldset class="buttons">
            <fieldset class="form">

        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                <sec:ifLoggedIn>
                <li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
                </sec:ifLoggedIn>
            </ul>

        </div>
            </fieldset>
        </fieldset>

        <div id="create-solicitudHotel" class="content scaffold-create" role="main">
            <div class="titulo">
            <h1>Solicitud de reserva para el  ${this.solicitudHotel.hotel} </h1>
            </div>
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
                <div class="row" >
                    <div class="col-sm-4">
                        <div class="textoBean">
                <fieldset class="form">



                <div class="form-group row justify-content-center" bean="solicitudHotel" property="nombre">
                <label for="example-text-input" class="col-1 col-form-label">Nombre</label>
                <div class="col-3"><g:field type="text"  name="nombre" value="${solicitudHotelInstance?.nombre}" required="true" />
                </div>
                 </div>
                <div class="form-group row justify-content-center" bean="solicitudHotel" property="apellido">
                <label for="example-text-input" class="col-1 col-form-label">apellido</label>
                <div class="col-3"><g:field type="text"  name="apellido" value="${solicitudHotelInstance?.apellido}" required="true" />
                </div>
                </div>
                <div class="form-group row justify-content-center" bean="solicitudHotel" property="email">
                <label for="example-text-input" class="col-1 col-form-label">email</label>
                <div class="col-3"><g:field type="email"  name="email" value="${solicitudHotelInstance?.email}" required="true" />
                </div>
                </div>

                <div class="form-group row justify-content-center" bean="solicitudHotel" property="tipoDocumento">
                <label for="example-text-input" class="col-1 col-form-label">tipo de documento</label>
                <div class="col-3">
                <g:select name="tipoDocumento" from="['DNI','libreta cívica']" value="${solicitudHotelInstance?.tipoDocumento}" required="true"/>
                </div>
                </div>

                <div class="form-group row justify-content-center" bean="solicitudHotel" property="nDocumento">
                <label for="example-number-input" class="col-1 col-form-label">numero de documento</label>
                <div class="col-3"><g:field type="number"  name="nDocumento" value="${solicitudHotelInstance?.nDocumento}" required="true" />
                </div>
                </div>

                <div class="form-group row justify-content-center" bean="solicitudHotel" property="cantidadHuesped">
                <label for="example-number-input" class="col-1 col-form-label">Cantidad de huespedes</label>
                <div class="col-3"><g:field type="number"  name="cantidadHuesped" value="${solicitudHotelInstance?.cantidadHuesped}" required="true" />
                </div>
                </div>
                <div class="form-group row justify-content-center" bean="solicitudHotel" property="fechaIN">
                    <label for="example-date-input" class="col-1 col-form-label">Fecha Ingreso</label>
                    <div class="col-3"><g:field type="date" id="datepicker" name="fechaIN" value="${solicitudHotelInstance?.fechaIN}" required="true" /></div>

                </div>
                <div class="form-group row justify-content-center" bean="solicitudHotel" property="fechaOut">
                    <label for="example-date-input" class="col-1 col-form-label">Fecha Egreso</label>
                    <div class="col-3">
                        <g:field type="date" id="datepicker" name="fechaOut" value="${solicitudHotelInstance?.fechaOut}" required="true" />
                    </div>
                </div>


                    <div class="col-sm-4">
                <f:all bean="solicitudHotel" except="nombre,apellido,email,tipoDocumento,nDocumento,cantidadHuesped,fechaIN,fechaOut"/>
                </div>








                </fieldset>
                    </div>
                </div>
                </div>
                <fieldset class="buttons">
                    <g:submitButton name="create" class="save" value="${message(code: 'default.button.create.label', default: 'Create')}" />
                </fieldset>
            </g:form>
        </div>

    </div>
    </body>
</html>
