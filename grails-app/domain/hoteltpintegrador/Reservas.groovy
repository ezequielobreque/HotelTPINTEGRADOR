package hoteltpintegrador

class Reservas {
    static hasOne =[huesped:Huesped];
    static belongsTo = [hotel:Hotel];
    int cantidadHuesped;
    Date fechaIN;
    Date fechaOut

    static constraints = {
        fechaOut(blank:false,validator: { val, obj -> val?.after(obj.fechaIN)
        });

    }
}
