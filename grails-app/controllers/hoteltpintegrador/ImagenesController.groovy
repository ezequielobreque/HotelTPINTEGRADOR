package hoteltpintegrador

import grails.plugin.springsecurity.annotation.Secured
import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*
@Secured('ROLE_ADMIN')
class ImagenesController {

    ImagenesService imagenesService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond imagenesService.list(params), model:[imagenesCount: imagenesService.count()]
    }

    def show(Long id) {
        respond imagenesService.get(id)
    }

    def create() {
        respond new Imagenes(params)
    }

    def save(Imagenes imagenes) {
        if (imagenes == null) {
            notFound()
            return
        }

        try {
            imagenesService.save(imagenes)
        } catch (ValidationException e) {
            respond imagenes.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'imagenes.label', default: 'Imagenes'), imagenes.id])
                redirect imagenes
            }
            '*' { respond imagenes, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond imagenesService.get(id)
    }

    def update(Imagenes imagenes) {
        if (imagenes == null) {
            notFound()
            return
        }

        try {
            imagenesService.save(imagenes)
        } catch (ValidationException e) {
            respond imagenes.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'imagenes.label', default: 'Imagenes'), imagenes.id])
                redirect imagenes
            }
            '*'{ respond imagenes, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        imagenesService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'imagenes.label', default: 'Imagenes'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'imagenes.label', default: 'Imagenes'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
