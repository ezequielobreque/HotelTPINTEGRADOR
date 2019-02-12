package hoteltpintegrador

import grails.plugin.springsecurity.annotation.Secured
import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*
@Secured('permitAll')
class SolicitudHotelController {

    SolicitudHotelService solicitudHotelService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]
    @Secured("ROLE_ADMIN")
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond solicitudHotelService.list(params), model:[solicitudHotelCount: solicitudHotelService.count()]
    }

    def show(Long id) {
        respond solicitudHotelService.get(id)
    }

    def create(Long id) {
        params.hotel=id
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
    @Secured("ROLE_ADMIN")
    def aceptar(SolicitudHotel solicitudReserva) {


        if (solicitudReserva == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        solicitudReserva.delete flush:true


                flash.message= "Solicitud de reserva "+solicitudReserva.id+" aceptado"
                redirect (action:"index")


    }
    @Secured("ROLE_ADMIN")
    def aceptarSolicitud(SolicitudHotel solicitudReserva){

        def lista = solicitudReserva.getHotel().getHabitaciones()
        def habitacionesDisponibles = lista.findAll { it.itsDisponible(solicitudReserva) == true }
        println('llege')
        def habitacion = habitacionesDisponibles.find { it.cantidadDePersonas >= solicitudReserva.cantidadHuesped}
        println('llege')
        if (habitacion != null) {

            habitacion.disponible=false
            Huesped huespe = new Huesped()
            huespe.nombre = solicitudReserva.nombre
            huespe.apellido = solicitudReserva.apellido
            huespe.tipoDocumento = solicitudReserva.tipoDocumento
            huespe.nDocumento = solicitudReserva.nDocumento
            huespe.email = solicitudReserva.email
            huespe.save flush:true



            Reservas reserva=new Reservas()
            reserva.fechaIN=solicitudReserva.fechaIN
            reserva.cantidadHuesped=solicitudReserva.cantidadHuesped
            reserva.habitacion=habitacion
            reserva.hotel=solicitudReserva.hotel
            reserva.huesped=huespe

            reserva.fechaOut=solicitudReserva.fechaOut
            reserva.nombre=solicitudReserva.nombre +"-"+solicitudReserva.getHotel().getNombre()+ habitacion
            reserva.link="reserva/show/${Reservas.list().size()+1}"

            reserva.create()
            reserva.save flush:true
            habitacion.save flush:true

            sendMail {
                from "UNTDFtpHOTEL@gmail.com"
                to huespe.email
                subject params.subject
                text "se realizo la reserva en el "+reserva.hotel.getNombre()+"    link de la reserva "+"reserva/show/${Reservas.list().size()+1}"
            }

            aceptar(solicitudReserva)

        }else if (habitacion==null) {



            flash.message = "error habitaciones ocupadas"
            redirect(action: 'index')

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
