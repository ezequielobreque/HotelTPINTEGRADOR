package hoteltpintegrador

class Hotel {

    String nombre;
    String direccion;

    String informacion;

    static hasMany=[habitaciones:Habitaciones,reserva:Reservas,imagen:Imagenes];

    Integer estrellas;






    String toString(){
        nombre


    }

    static constraints = {
    nombre unique:true;

    estrellas(min:0,Max:5);
    habitaciones(nullable:true)
        informacion nullable: true
        reserva(nullable: true)
        imagen(nullable: true)


    }
}
