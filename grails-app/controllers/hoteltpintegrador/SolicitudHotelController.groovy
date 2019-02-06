package hoteltpintegrador

import grails.plugin.springsecurity.annotation.Secured
import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*
@Secured('ROLE_ADMIN')
class SolicitudHotelController {

    SolicitudHotelService solicitudHotelService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond solicitudHotelService.list(params), model:[solicitudHotelCount: solicitudHotelService.count()]
    }

    def show(Long id) {
        respond solicitudHotelService.get(id)
    }

    def create() {
        respond new SolicitudHotel(params)
    }

    def save(SolicitudHotel solicitudHotel) {
        if (solicitudHotel == null) {
            notFound()
            return
        }

        try {
            solicitudHotelService.save(solicitudHotel)
        } catch (ValidationException e) {
            respond solicitudHotel.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'solicitudHotel.label', default: 'SolicitudHotel'), solicitudHotel.id])
                redirect solicitudHotel
            }
            '*' { respond solicitudHotel, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond solicitudHotelService.get(id)
    }

    def update(SolicitudHotel solicitudHotel) {
        if (solicitudHotel == null) {
            notFound()
            return
        }

        try {
            solicitudHotelService.save(solicitudHotel)
        } catch (ValidationException e) {
            respond solicitudHotel.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'solicitudHotel.label', default: 'SolicitudHotel'), solicitudHotel.id])
                redirect solicitudHotel
            }
            '*'{ respond solicitudHotel, [status: OK] }
        }
    }
    def aceptar(SolicitudHotel solicitudReserva) {


        if (solicitudReserva == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        solicitudReserva.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message= "Solicitud de reserva "+solicitudReserva.id+" aceptado"
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    def aceptarSolicitud(SolicitudHotel solicitudReserva){

        def lista = solicitudReserva.getHotel().getHabitaciones()
        def habitacionesDisponibles = lista.findAll { it.disponible == true }
        def habitacion = habitacionesDisponibles.find { it.cantidadDePersonas >= solicitudReserva.cantidadHuesped}

        if (habitacion != null) {

            habitacion.disponible=false
            Huesped titular = new Huesped()
            titular.nombre = solicitudReserva.nombre
            titular.apellido = solicitudReserva.apellido
            titular.tipoDocumento = solicitudReserva.tipoDocumento
            titular.nDocumento = solicitudReserva.nDocumento
            titular.email = solicitudReserva.email
            titular.save flush:true


            Reservas reserva=new Reservas()
            reserva.fechaIN=solicitudReserva.fechaIN
            reserva.cantidadHuesped=solicitudReserva.cantidadHuesped
            reserva.habitacion=habitacion
            reserva.hotel=solicitudReserva.hotel
            reserva.huesped=titular

            reserva.fechaOut=solicitudReserva.fechaOut
            reserva.nombre=solicitudReserva.nombre +"-"+solicitudReserva.getHotel().getNombre()+ habitacion
            reserva.link="reserva/show/${Reservas.list().size()+1}"

            reserva.create()
            reserva.save flush:true
            habitacion.save flush:true

         /*   def reservaDiaHabitacion =DiaReserva.list().find { it.start == solicitudReserva.fechaInicio && it.tipo == "Habitacion"}
            if (reservaDiaHabitacion == null){
                DiaReserva diaReserva=new DiaReserva()
                diaReserva.tipo="Habitacion"
                diaReserva.cantidadReservas++
                diaReserva.start=solicitudReserva.fechaInicio
                diaReserva.title=diaReserva.cantidadReservas+" habitac. reservadas"
                diaReserva.save flush:true
            }else{
                reservaDiaHabitacion.cantidadReservas++
                //reservaDiaHabitacion.start=solicitudReserva.fechaInicio
                reservaDiaHabitacion.title=reservaDiaHabitacion.cantidadReservas+" habitac. reservadas"
                reservaDiaHabitacion.save flush:true
            }*/

            aceptar(solicitudReserva)

        }else if (habitacion==null) {

            request.withFormat {
                form multipartForm {
                    flash.message = "No se han encontrado habitaciones disponibles"
                    redirect action:"index", method:"GET"
                }
                '*'{ render status: NO_CONTENT }
            }
        }

    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        solicitudHotelService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'solicitudHotel.label', default: 'SolicitudHotel'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'solicitudHotel.label', default: 'SolicitudHotel'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
