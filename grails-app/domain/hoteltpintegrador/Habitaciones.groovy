package hoteltpintegrador

class Habitaciones {
    String nombre;
    static belongsTo = [hotel:Hotel]
    boolean disponible=false;
    Integer cantidadDePersonas;



    boolean itsDisponible(SolicitudHotel solicitudHotel){
        def habitacion = hotel.reserva.findAll { it.habitacion == this }
        if (habitacion.isEmpty()){
            println 'estoy aca'
            return disponible=true}else {

            habitacion.asImmutable()
            habitacion.toSorted { a, b -> a.fechaIN <=> b.fechaIN }

            boolean z = false;
            int count = 0;
            println habitacion
            println 'llege al dommio'
            while (z == false) {
                if (solicitudHotel.fechaIN > habitacion.last().fechaOut) {
                    z = true
                    return disponible = true
                } else if (solicitudHotel.fechaOut < habitacion.first().fechaIN) {
                    z = true
                    return disponible = true
                } else if (habitacion.size()>1){if (solicitudHotel.fechaIN > habitacion[count].fechaOut && solicitudHotel.fechaOut < habitacion[count + 1].fechaIN) {

                    z = true
                    return disponible = true
                } else if (solicitudHotel.fechaIN > habitacion[count].fechaOut) {
                    println("llege al if")
                    if (count < habitacion.size()) {
                        count = +1
                    } else {
                        println("llege aca abajo")
                        z = true
                        return disponible = false
                    }}else{z = true
                    return disponible = false}
                }else{
                    z = true
                    return disponible = false

                }


            }


        }
    }
    static constraints = {
        nombre unique:true;


    }
    String toString(){
        nombre
    }
}
