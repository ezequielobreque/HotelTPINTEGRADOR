package hoteltpintegrador

import grails.plugin.springsecurity.annotation.Secured
import grails.validation.ValidationException
import hoteltpintegrador.grails.FeaturedImageCommand

import static org.springframework.http.HttpStatus.*
@Secured('ROLE_ADMIN')
class HotelController {

    HotelService hotelService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond hotelService.list(params), model:[hotelCount: hotelService.count()]
    }

    def show(Long id) {
        respond hotelService.get(id)
    }

    def create() {
        respond new Hotel(params)

    }


    def save(Hotel hotel) {
        if (hotel == null) {
            notFound()
            return
        }

        try {


            hotelService.save(hotel)
        } catch (ValidationException e) {
            respond hotel.errors, view:'create'
            return
        }



        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'hotel.label', default: 'Hotel'), hotel.id])
                redirect hotel
            }
            '*' { respond hotel, [status: CREATED] }
        }
    }
    def featuredImage(Long id) {
        Hotel hotel = hotelService.get(id)
        if (!hotel || hotel.featuredImageBytes == null) {
            notFound()
            return
        }
        render file: hotel.featuredImageBytes,
                contentType: hotel.featuredImageContentType
    }
    def editFeaturedImage(Long id) {
        Hotel hotel = hotelService.get(id)
        if (!hotel ) {
            notFound()
        }
        [hotel: hotel]
    }
    def edit(Long id) {
        respond hotelService.get(id)
    }

    def uploadFeaturedImage(FeaturedImageCommand cmd) {
        if (cmd == null) {
            notFound()
            return
        }

        if (cmd.hasErrors()) {
            respond(cmd.errors, model: [hotel: cmd], view: 'editFeaturedImage')
            return
        }

        Hotel hotel = hotelService.update(cmd.id,
                cmd.version,
                cmd.featuredImageFile.bytes,
                cmd.featuredImageFile.contentType)

        if (hotel == null) {
            notFound()
            return
        }

        if (hotel.hasErrors()) {
            respond(hotel.errors, model: [hotel: hotel], view: 'editFeaturedImage')
            return
        }



        redirect hotel
    }
    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        hotelService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'hotel.label', default: 'Hotel'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'hotel.label', default: 'Hotel'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
