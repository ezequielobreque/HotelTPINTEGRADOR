package hoteltpintegrador
import java.sql.Date
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
        fechaOut(blank:false,validator: { val, obj -> val?.after(obj.fechaIN)
        });
        tipoDocumento(inList:['DNI','libreta cívica'])

    }
}
