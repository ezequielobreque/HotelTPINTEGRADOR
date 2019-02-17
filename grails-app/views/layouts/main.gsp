<!doctype html>
<html lang="en" class="no-js">
<head>

    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <title>
        <g:layoutTitle default="Grails"/>
    </title>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>

    <asset:stylesheet src="application.css"/>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <g:layoutHead/>
</head>
<script>function myFunction() {
    var x = document.getElementById("myTopnav");
    if (x.className === "topnav") {
        x.className += " responsive";
    } else {
        x.className = "topnav";
    }
}</script>
<div class="navbar navbar-default navbar-static-top" role="navigation">
    <div class="container">

<a class="navbar-brand" href="/#">
    <i class="fa grails-icon">
        <asset:image src="depositphotos_184030724-stock-illustration-hotel-vector-icon-green-background.jpg"/>
    </i> Hoteles Ushuaia
</a>


<div class="topnav" id="myTopnav">
    <a href="/" >Hoteles</a>
    <a href="/login/index">Log In</a>
    <a href="/logout">Log Out</a>

    <a href="javascript:void(0);" class="icon" onclick="myFunction()">
        <i class="fa fa-bars"></i>
    </a>

</div>
    </div>
</div>













    <g:layoutBody/>

    <div class="footer" role="contentinfo"></div>

    <div id="spinner" class="spinner" style="display:none;">
        <g:message code="spinner.alt" default="Loading&hellip;"/>
    </div>

    <asset:javascript src="application.js"/>



</body>
</html>
