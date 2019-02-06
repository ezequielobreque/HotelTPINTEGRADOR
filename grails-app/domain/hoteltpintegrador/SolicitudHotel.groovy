package hoteltpintegrador

class SolicitudHotel {
    static belongsTo = [hotel:Hotel];
    int cantidadHuesped;
    String nombre
    String apellido
    String email
    String tipoDocumento
    Integer nDocumento
    Date fechaIN;
    Date fechaOut;

    static constraints = {
    }
}
