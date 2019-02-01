package hoteltpintegrador

import grails.plugin.springsecurity.annotation.Secured
import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*
@Secured('ROLE_ADMIN')
class ReservasController {

    ReservasService reservasService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond reservasService.list(params), model:[reservasCount: reservasService.count()]
    }

    def show(Long id) {
        respond reservasService.get(id)
    }

    def create() {
        respond new Reservas(params)
    }

    def save(Reservas reservas) {
        if (reservas == null) {
            notFound()
            return
        }

        try {
            reservasService.save(reservas)
        } catch (ValidationException e) {
            respond reservas.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'reservas.label', default: 'Reservas'), reservas.id])
                redirect reservas
            }
            '*' { respond reservas, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond reservasService.get(id)
    }

    def update(Reservas reservas) {
        if (reservas == null) {
            notFound()
            return
        }

        try {
            reservasService.save(reservas)
        } catch (ValidationException e) {
            respond reservas.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'reservas.label', default: 'Reservas'), reservas.id])
                redirect reservas
            }
            '*'{ respond reservas, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        reservasService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'reservas.label', default: 'Reservas'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'reservas.label', default: 'Reservas'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
