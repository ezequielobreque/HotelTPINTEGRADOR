package hoteltpintegrador

class Hotel {

    String nombre;
    String direccion;

    String informacion;

    static hasMany=[habitaciones:Habitaciones,reserva:Reservas];

    Integer estrellas;




    byte[] featuredImageBytes // <1>
    String featuredImageContentType // <2>

    static mapping = {
        featuredImageBytes column: 'featured_image_bytes', sqlType: 'longblob' // <3>
    }
    String toString(){
        nombre


    }

    static constraints = {
    nombre unique:true;

    estrellas(min:0,Max:5);
    habitaciones(nullable:true)
        informacion nullable: true
        featuredImageBytes nullable: true
        featuredImageContentType nullable: true



    }
}
