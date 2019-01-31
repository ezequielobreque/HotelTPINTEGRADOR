package hoteltpintegrador

class BootStrap {

    def init = { servletContext ->
        Random rnd = new Random ()
        5.times { hotelIndex ->
                Hotel hotel = new Hotel(nombre: "Hotel ${hotelIndex}",direccion: (rnd.nextInt(300)),estrellas: (rnd.nextInt(5)))
                10.times { habitacionesIndex ->
                    hotel.addToHabitaciones(nombre: "Hotel${hotelIndex} - Habitacion${habitacionesIndex}",cantidadDePersonas:(rnd . nextInt ( 3 )))
                    //Habitaciones habitacion= new Habitaciones(nombre: "Habitacion${habitacionesIndex}")

                }
                hotel.save()
            }
    }
    def destroy = {
    }
}
