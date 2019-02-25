package hoteltpintegrador

class Imagenes {

    String nombre;
    static belongsTo = [hotel:Hotel]

    static constraints = {
        id nullable: true
    }
    String toString(){
        nombre


    }
}
