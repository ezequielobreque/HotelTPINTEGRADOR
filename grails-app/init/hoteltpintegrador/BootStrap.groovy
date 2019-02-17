package hoteltpintegrador

class BootStrap {

    def init = { servletContext ->
        Random rnd = new Random ()
      /* 2.times { hotelIndex ->
                Hotel hotel = new Hotel(nombre: "Hotel ${hotelIndex}",direccion: (rnd.nextInt(300)),estrellas: (rnd.nextInt(5)))
                1.times { habitacionesIndex ->
                    hotel.addToHabitaciones(nombre: "Hotel${hotelIndex} - Habitacion${habitacionesIndex}",cantidadDePersonas:(rnd . nextInt ( 3 ))+2)
                    //Habitaciones habitacion= new Habitaciones(nombre: "Habitacion${habitacionesIndex}")

                }

                hotel.save()
            }*/
        Hotel hotelalba =new Hotel(nombre: "Hotel Alabatroz",direccion: "Calle Maipu 505, Ushuaia V9410BJK, Argentina",estrellas: 4,informacion: "Hotel Albatros es un alojamiento ubicado frente al Canal de Beagle, a 1 minuto caminando del Puerto de Ushuaia y del centro comercial de la ciudad, que cuenta con spa y servicio de conserjería. Se encuentra a 3 km del Aeropuerto Internacional de Ushuaia Malvinas Argentinas, a 8 km del Tren del Fin del Mundo y a 300 m del Museo del Fin del Mundo. ")
        3.times { habitacionesIndex ->
            hotelalba.addToHabitaciones(nombre: "Habitacion${habitacionesIndex}",cantidadDePersonas:(rnd . nextInt ( 3 ))+2)
            //Habitaciones habitacion= new Habitaciones(nombre: "Habitacion${habitacionesIndex}")

        }
        hotelalba.addToImagen(nombre:  "hotel_albatroz1.jpg")
        hotelalba.addToImagen(nombre:  "hotel_albatroz2.jpg")
        hotelalba.addToImagen(nombre:  "hotel_albatroz3.jpg")
        hotelalba.addToImagen(nombre:  "hotel_albatroz4.jpg")
        hotelalba.addToImagen(nombre:  "hotel_albatroz5.jpg")


        Hotel hotellengas =new Hotel(nombre: "Hotel Las Lengas",direccion: "Goleta Florencia 1722, V9410 Ushuaia, Tierra del Fuego, Argentina",estrellas: 3,informacion: "Hotel Las Lengas está emplazado frente al Parque Centenario, predio con una elevación del terreno con vista panorámica de la ciudad. Está ubicado a 15 minutos en auto del Aeropuerto Internacional de Ushuaia Islas Malvinas y a 5 minutos del Puerto de Ushuaia desde donde inician excursiones de navegación al Canal de Beagle. La Avenida San Martín está a 200 metros. En áreas comunes del hotel, el Wi-Fi es gratuito. ")
        3.times { habitacionesIndex ->
            hotellengas.addToHabitaciones(nombre: "Habitacion${habitacionesIndex}",cantidadDePersonas:(rnd . nextInt ( 3 ))+2)
            //Habitaciones habitacion= new Habitaciones(nombre: "Habitacion${habitacionesIndex}")

        }

        hotellengas.addToImagen(nombre:  "hotel_las_lengas1.jpg")
        hotellengas.addToImagen(nombre:  "hotel_las_lengas2.jpg")
        hotellengas.addToImagen(nombre:  "hotel_las_lengas3.jpg")
        hotellengas.addToImagen(nombre:  "hotel_las_lengas4.jpg")


        Hotel hotelush =new Hotel(nombre: "Hotel Ushuaia",direccion: "Comodoro Augusto Laserre 933, Ushuaia, Tierra del Fuego",estrellas: 4,informacion: "El Hotel Ushuaia se ubica en un punto alto con una hermosa vista de la ciudad y el canal, tanto de las habitaciones como de los espacios comunes. Lo invitamos a descubrir un espacio de tranquilidad con servicios de primera categoría.")
        3.times { habitacionesIndex ->
            hotelush.addToHabitaciones(nombre: "Habitacion${habitacionesIndex}",cantidadDePersonas:(rnd . nextInt ( 3 ))+2)
            //Habitaciones habitacion= new Habitaciones(nombre: "Habitacion${habitacionesIndex}")

        }
        hotelush.addToImagen(nombre:  "hotel_ush1.jpg")
        hotelush.addToImagen(nombre:  "hotel_ush2.jpg")
        hotelush.addToImagen(nombre:  "hotel_ush3.jpg")
        hotelush.addToImagen(nombre:  "hotel_ush4.jpg")


        hotelush.save( flush: true,failOnError: true)
        hotelalba.save( flush: true,failOnError: true)
        hotellengas.save( flush: true,failOnError: true)

        User user = new User(username: "admin",password:"admin").save()
        Role role=new Role(authority:  "ROLE_ADMIN").save()
        UserRole.create(user,role)
    }
    def destroy = {
    }
}
