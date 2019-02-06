package hoteltpintegrador

class BootStrap {

    def init = { servletContext ->
        Random rnd = new Random ()
        3.times { hotelIndex ->
                Hotel hotel = new Hotel(nombre: "Hotel ${hotelIndex}",direccion: (rnd.nextInt(300)),estrellas: (rnd.nextInt(5)))
                3.times { habitacionesIndex ->
                    hotel.addToHabitaciones(nombre: "Hotel${hotelIndex} - Habitacion${habitacionesIndex}",cantidadDePersonas:(rnd . nextInt ( 3 )))
                    //Habitaciones habitacion= new Habitaciones(nombre: "Habitacion${habitacionesIndex}")

                }
                hotel.imagen='92262806.jpg'
                hotel.save()
            }





        User user = new User(username: "admin",password:"admin").save()
        Role role=new Role(authority:  "ROLE_ADMIN").save()
        UserRole.create(user,role)
    }
    def destroy = {
    }
}
