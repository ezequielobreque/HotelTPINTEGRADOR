package hoteltpintegrador

class Habitaciones {
    String nombre;
    static belongsTo = [hotel:Hotel]
    boolean disponible=true;
    Integer cantidadDePersonas;




    static constraints = {
        nombre unique:true;


    }
    String toString(){
        nombre
    }
}
