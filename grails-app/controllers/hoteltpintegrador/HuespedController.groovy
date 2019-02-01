package hoteltpintegrador

import grails.plugin.springsecurity.annotation.Secured
import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*
@Secured('ROLE_ADMIN')
class HuespedController {

    HuespedService huespedService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond huespedService.list(params), model:[huespedCount: huespedService.count()]
    }

    def show(Long id) {
        respond huespedService.get(id)
    }

    def create() {
        respond new Huesped(params)
    }

    def save(Huesped huesped) {
        if (huesped == null) {
            notFound()
            return
        }

        try {
            huespedService.save(huesped)
        } catch (ValidationException e) {
            respond huesped.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'huesped.label', default: 'Huesped'), huesped.id])
                redirect huesped
            }
            '*' { respond huesped, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond huespedService.get(id)
    }

    def update(Huesped huesped) {
        if (huesped == null) {
            notFound()
            return
        }

        try {
            huespedService.save(huesped)
        } catch (ValidationException e) {
            respond huesped.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'huesped.label', default: 'Huesped'), huesped.id])
                redirect huesped
            }
            '*'{ respond huesped, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        huespedService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'huesped.label', default: 'Huesped'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'huesped.label', default: 'Huesped'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
