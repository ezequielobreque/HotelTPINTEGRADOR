<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Welcome to Grails</title>

    <asset:link rel="icon" href="favicon.ico" type="image/x-ico" />

    <link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/fontawesome/4.7.0/css/font-awesome.min.css"/>
    <style>/*============ Service Features style ============*/
    .service-heading-block{
        display:block;
        margin-bottom:30px;
    }
    .title {
        display: block;
        font-size: 30px;
        font-weight: 200;
        margin-bottom: 10px;
    }
    .sub-title {
        font-size: 18px;
        font-weight: 100;
        line-height: 24px;
    }
    .feature-block {
        background-color: #fff;
        border-radius: 2px;
        padding: 15px;
        box-shadow: 0 2px 2px 0 rgba(0, 0, 0, 0.14), 0 3px 1px -2px rgba(0, 0, 0, 0.2), 0 1px 5px 0 rgba(0, 0, 0, 0.12);
        margin-bottom: 15px;
        transition:all ease .5s
    }
    .ms-feature:hover,
    .ms-feature:focus {
        background-color: #fafafa;
        box-shadow: 0 3px 4px 3px rgba(0, 0, 0, 0.14), 0 3px 3px -2px rgba(0, 0, 0, 0.2), 0 1px 8px 3px rgba(0, 0, 0, 0.12);
    }
    .fb-icon {
        border-radius: 50%;
        display: block;
        font-size: 36px;
        height: 80px;
        line-height: 80px;
        text-align:center;
        margin:1rem auto;
        width: 80px;
        transition: all 0.5s ease 0s;
    }
    .feature-block:hover .fb-icon,
    .feature-block:focus .fb-icon {
        box-shadow: 0 4px 5px 0 rgba(0, 0, 0, 0.14), 0 1px 10px 0 rgba(0, 0, 0, 0.12), 0 2px 4px -1px rgba(0, 0, 0, 0.2);
        transform: rotate(360deg);
    }
    .fb-icon.color-info {
        background-color: #5bc0de;
        color: #fff;
    }
    .fb-icon.color-warning {
        background-color: #eea236;
        color: #fff;
    }
    .fb-icon.color-success {
        background-color: #5cb85c;
        color: #fff;
    }
    .fb-icon.color-danger {
        background-color: #d9534f;
        color: #fff;
    }
    .feature-block h4 {
        font-size: 16px;
        font-weight: 500;
        margin: 3rem 0 1rem;
    }
    .color-info {
        color: #46b8da;
    }
    .color-warning {
        color: #f0ad4e;
    }
    .color-success {
        color: #4cae4c;
    }
    .color-danger {
        color: #d43f3a;
    }
    .btn-custom{
        border: medium none;
        border-radius: 2px;
        cursor: pointer;
        font-size: 14px;
        font-weight: 500;
        letter-spacing: 0;
        margin: 10px 1px;
        outline: 0 none;
        padding: 8px 30px;
        position: relative;
        text-decoration: none;
        text-transform: uppercase;
    }</style>
</head>
<body>
<div class="fondo">
<div class="titulo">
    <div style=" font-family: Georgia;font-size: 30px;">Hoteles ushuaia</div>
</div>
<sec:ifLoggedIn>

    <div class="container text-center">
    <div class="row">
        <!--<div class="col-lg-12 col-md-12 col-sm-12">
            <div class="service-heading-block">
                <h2 class="text-center text-primary title">Our amazing Service features</h2>
                <p class="text-center sub-title">Lorem ipsum dolor sit amet,<span class="text-primary">consectetur adipisicing</span> elit.<br/> Dolor alias provident excepturi eligendi, nam numquam iusto eum illum, ea quisquam.</p>
            </div>
        </div>-->
        <div class="col-lg-3 col-md-6 col-sm-6">
            <div class="text-center feature-block">
                <span class="fb-icon color-info">
                    <i class="fa fa-home" aria-hidden="true"></i>
                </span>
                <h4 class="color-info">Hoteles</h4>
                <p class="">base de datos de hoteles,creacion y edicion de los mismos</p>

                <g:link class="btn btn-info btn-custom" controller="hotel" action="index"> Click here</g:link>
            </div>
        </div>

        <div class="col-lg-3 col-md-6 col-sm-6">
            <div class="text-center feature-block">
                <span class="fb-icon color-warning">
                    <i class="fa fa-tasks" aria-hidden="true"></i>
                </span>
                <h4 class="color-warning">Reservas</h4>
                <p class="">base de datos de reservas,creacion y edicion de las mismas</p>
                <g:link class="btn btn-warning btn-custom" controller="reservas" action="index"> Click here</g:link>
            </div>
        </div>

        <div class="col-lg-3 col-md-6 col-sm-6">
            <div class="text-center feature-block">
                <span class="fb-icon color-success">
                    <i class="fa fa-bed" aria-hidden="true"></i>
                </span>
                <h4 class="color-success">Habitaciones</h4>
                <p class="">base de datos de habitaciones,creacion y edicion de las mismas</p>
                <g:link class="btn btn-success btn-custom" controller="habitaciones" action="index"> Click here</g:link>
            </div>
        </div>

        <div class="col-lg-3 col-md-6 col-sm-6">
            <div class="text-center feature-block">
                <span class="fb-icon color-danger">
                    <i class="fa fa-check" aria-hidden="true"></i>
                </span>
                <h4 class="color-danger">Solitudes hoteles</h4>
                <p class="">Aceptacion de solicitudes y vista de las mismas</p>
                <g:link class="btn btn-danger btn-custom" controller="solicitudHotel" action="index"> Click here</g:link>
            </div>
        </div>
    </div>
    </div>
    <div class="container text-center">
        <div class="row">
        <div class="col-lg-3 col-md-6 col-sm-6">
            <div class="text-center feature-block">
                <span class="fb-icon color-info">
                    <i class="fa fa-user" aria-hidden="true"></i>
                </span>
                <h4 class="color-info">Huespedes</h4>
                <p class="">Base de datos de los huespedes</p>
                <g:link class="btn btn-info btn-custom" controller="huesped" action="index"> Click here</g:link>
            </div>
        </div>
        <div class="col-lg-3 col-md-6 col-sm-6">
            <div class="text-center feature-block">
                <span class="fb-icon color-success">
                    <i class="fa fa-picture-o" aria-hidden="true"></i>
                </span>
                <h4 class="color-success">Imagenes</h4>
                <p class="">Los nombres de las imagenes de los hoteles ,que se encuentran en assets/images</p>
                <g:link class="btn btn-success btn-custom" controller="Imagenes" action="index"> Click here</g:link>
            </div>
        </div>
    </div>



    </div>

</sec:ifLoggedIn>
<content tag="nav">
    <li class="dropdown">
        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Application Status <span class="caret"></span></a>
        <ul class="dropdown-menu">
            <li><a href="#">Environment: ${grails.util.Environment.current.name}</a></li>
            <li><a href="#">App profile: ${grailsApplication.config.grails?.profile}</a></li>
            <li><a href="#">App version:
                <g:meta name="info.app.version"/></a>
            </li>
            <li role="separator" class="divider"></li>
            <li><a href="#">Grails version:
                <g:meta name="info.app.grailsVersion"/></a>
            </li>
            <li><a href="#">Groovy version: ${GroovySystem.getVersion()}</a></li>
            <li><a href="#">JVM version: ${System.getProperty('java.version')}</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="#">Reloading active: ${grails.util.Environment.reloadingAgentEnabled}</a></li>
        </ul>
    </li>
    <li class="dropdown">
        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Artefacts <span class="caret"></span></a>
        <ul class="dropdown-menu">
            <li><a href="#">Controllers: ${grailsApplication.controllerClasses.size()}</a></li>
            <li><a href="#">Domains: ${grailsApplication.domainClasses.size()}</a></li>
            <li><a href="#">Services: ${grailsApplication.serviceClasses.size()}</a></li>
            <li><a href="#">Tag Libraries: ${grailsApplication.tagLibClasses.size()}</a></li>
        </ul>
    </li>
    <li class="dropdown">
        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Installed Plugins <span class="caret"></span></a>
        <ul class="dropdown-menu">
            <g:each var="plugin" in="${applicationContext.getBean('pluginManager').allPlugins}">
                <li><a href="#">${plugin.name} - ${plugin.version}</a></li>
            </g:each>
        </ul>
    </li>
</content>





    <sec:ifNotLoggedIn>


        <g:each  in="${hoteltpintegrador.Hotel.all}">
            <h1>


            </h1>
            <div class="row">
                <div class="col-sm-6 col-md-6"><asset:image   src="${it.imagen.first()}"/></div>

                <div class="col-sm-6 col-md-6" ><div class="texto" ><h1>${it.nombre}</h1>
                    <h1>Estrellas: ${it.estrellas}</h1>
                    <h1>Direccion: ${it.direccion}</h1>
                    <h1>Informacion : ${it.informacion}</h1>
                </div>
                    <fieldset class="buttons">
                        <h2><div align="center">
                            <g:link controller="hotel" action="show" id="${it.id}" >Mirar Hotel</g:link>
                        </div></h2>
                    </fieldset>

                </div>

            </div>



        </g:each>
    </sec:ifNotLoggedIn>

</div>




</body>
</html>