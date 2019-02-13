<!DOCTYPE html>
<html>
<head>
    <meta charset='utf-8' />

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



                    {
                        title: 'All Day Event',
                        start: '2019-01-01',
                    },
                    {
                        title: 'Long Event',
                        start: '2019-01-07',
                        end: '2019-01-10'
                    },
                    {
                        id: 999,
                        title: 'Repeating Event',
                        start: '2019-01-09T16:00:00'
                    },
                    {
                        id: 999,
                        title: 'Repeating Event',
                        start: '2019-01-16T16:00:00'
                    },
                    {
                        title: 'Conference',
                        start: '2019-01-11',
                        end: '2019-01-13'
                    },
                    {
                        title: 'Meeting',
                        start: '2019-01-12T10:30:00',
                        end: '2019-01-12T12:30:00'
                    },
                    {
                        title: 'Lunch',
                        start: '2019-01-12T12:00:00'
                    },
                    {
                        title: 'Meeting',
                        start: '2019-01-12T14:30:00'
                    },
                    {
                        title: 'Happy Hour',
                        start: '2019-01-12T17:30:00'
                    },
                    {
                        title: 'Dinner',
                        start: '2019-01-12T20:00:00'
                    },
                    {
                        title: 'Birthday Party',
                        start: '2019-01-13T07:00:00'
                    },
                    {
                        title: 'Click for Google',
                        url: 'http://google.com/',
                        start: '2019-01-28'
                    }
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