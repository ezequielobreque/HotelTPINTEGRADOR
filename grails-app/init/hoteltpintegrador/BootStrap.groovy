package hoteltpintegrador

class BootStrap {

    def init = { servletContext ->
        Random rnd = new Random ()
        2.times { hotelIndex ->
                Hotel hotel = new Hotel(nombre: "Hotel ${hotelIndex}",direccion: (rnd.nextInt(300)),estrellas: (rnd.nextInt(5)))
                1.times { habitacionesIndex ->
                    hotel.addToHabitaciones(nombre: "Hotel${hotelIndex} - Habitacion${habitacionesIndex}",cantidadDePersonas:(rnd . nextInt ( 3 ))+2)
                    //Habitaciones habitacion= new Habitaciones(nombre: "Habitacion${habitacionesIndex}")

                }
                hotel.addToImagen(nombre:  '92262806.jpg')
                 hotel.addToImagen(nombre:  "hotel-albatros.jpg")
                hotel.save()
            }





        User user = new User(username: "admin",password:"admin").save()
        Role role=new Role(authority:  "ROLE_ADMIN").save()
        UserRole.create(user,role)
    }
    def destroy = {
    }
}
