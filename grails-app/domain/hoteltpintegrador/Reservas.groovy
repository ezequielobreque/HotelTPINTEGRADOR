package hoteltpintegrador

class Reservas {
    String nombre
    static belongsTo = [hotel:Hotel];
    Habitaciones habitacion;
    int cantidadHuesped;
    Date fechaIN;
    String link
    Date fechaOut;
    Huesped huesped;



    static constraints = {
        fechaOut(blank:false,validator: { val, obj -> val?.after(obj.fechaIN)
        });

    }

}
