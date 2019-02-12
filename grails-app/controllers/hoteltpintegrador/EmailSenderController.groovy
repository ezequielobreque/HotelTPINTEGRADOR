package hoteltpintegrador

import grails.plugin.springsecurity.annotation.Secured

@Secured('ROLE_ADMIN')
class EmailSenderController {
    def mailService
    def index() { }
    def send() {
        mailService.sendMail {
            from "UNTDFtpHOTEL@gmail.com"
            to "ezequielobreque777@gmail.com"
            subject params.subject
            text params.body
        }

        flash.message = "Message sent at "+new Date()
        redirect action:"index"
    }
}
