package hoteltpintegrador

import grails.test.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class ImagenesServiceSpec extends Specification {

    ImagenesService imagenesService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Imagenes(...).save(flush: true, failOnError: true)
        //new Imagenes(...).save(flush: true, failOnError: true)
        //Imagenes imagenes = new Imagenes(...).save(flush: true, failOnError: true)
        //new Imagenes(...).save(flush: true, failOnError: true)
        //new Imagenes(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //imagenes.id
    }

    void "test get"() {
        setupData()

        expect:
        imagenesService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Imagenes> imagenesList = imagenesService.list(max: 2, offset: 2)

        then:
        imagenesList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        imagenesService.count() == 5
    }

    void "test delete"() {
        Long imagenesId = setupData()

        expect:
        imagenesService.count() == 5

        when:
        imagenesService.delete(imagenesId)
        sessionFactory.currentSession.flush()

        then:
        imagenesService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Imagenes imagenes = new Imagenes()
        imagenesService.save(imagenes)

        then:
        imagenes.id != null
    }
}
