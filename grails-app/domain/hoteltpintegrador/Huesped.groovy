package hoteltpintegrador

class Huesped {
    String nombre
    String apellido
    String email
    String tipoDocumento
    Integer nDocumento
    static hasMany=[reservas:Reservas]



    static constraints = {



    }
}
