package hoteltpintegrador

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class HabitacionesController {

    HabitacionesService habitacionesService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond habitacionesService.list(params), model:[habitacionesCount: habitacionesService.count()]
    }

    def show(Long id) {
        respond habitacionesService.get(id)
    }

    def create() {
        respond new Habitaciones(params)
    }

    def save(Habitaciones habitaciones) {
        if (habitaciones == null) {
            notFound()
            return
        }

        try {
            habitacionesService.save(habitaciones)
        } catch (ValidationException e) {
            respond habitaciones.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'habitaciones.label', default: 'Habitaciones'), habitaciones.id])
                redirect habitaciones
            }
            '*' { respond habitaciones, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond habitacionesService.get(id)
    }

    def update(Habitaciones habitaciones) {
        if (habitaciones == null) {
            notFound()
            return
        }

        try {
            habitacionesService.save(habitaciones)
        } catch (ValidationException e) {
            respond habitaciones.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'habitaciones.label', default: 'Habitaciones'), habitaciones.id])
                redirect habitaciones
            }
            '*'{ respond habitaciones, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        habitacionesService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'habitaciones.label', default: 'Habitaciones'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'habitaciones.label', default: 'Habitaciones'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
