<!DOCTYPE html>
<html>
<head>




    <asset:stylesheet src='fullcalendar.min.css' rel='stylesheet' />
    <asset:stylesheet src='fullcalendar.print.min.css' rel='stylesheet' media='print' />
    <asset:javascript src="moment.min.js"/>
    <asset:javascript src="jquery.min.js"/>
    <asset:javascript src="fullcalendar.min.js"/>








    <script>

        $(document).ready(function() {

            $('#calendar').fullCalendar({
                header: {
                    left: 'prev,next today',
                    center: 'title',
                    right: 'month,agendaWeek,agendaDay,listWeek'
                },
                defaultDate: '2019-01-12',
                navLinks: true, // can click day/week names to navigate views
                editable: true,
                eventLimit: true, // allow "more" link when too many events
                events: [
                    <g:each in="${this.hotel.reserva}">


                    {
                        title: '${it.habitacion.nombre}  ocupada por   ${it.huesped.nombre} ',
                        start: '${it.fechaIN}',
                        end: '${it.fechaOut}'
                    },




                    </g:each>




                ]
            });

        });

    </script>
    <style>

    body {
        margin: 40px 10px;
        padding: 0;
        font-family: "Lucida Grande",Helvetica,Arial,Verdana,sans-serif;
        font-size: 14px;
    }

    #calendar {
        max-width: 900px;
        margin: 0 auto;
    }

    </style>








    </head>
<body>

<div id='calendar'></div>

</body>
</html>