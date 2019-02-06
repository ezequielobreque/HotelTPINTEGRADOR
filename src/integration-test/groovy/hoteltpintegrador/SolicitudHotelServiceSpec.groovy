package hoteltpintegrador

import grails.test.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SolicitudHotelServiceSpec extends Specification {

    SolicitudHotelService solicitudHotelService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SolicitudHotel(...).save(flush: true, failOnError: true)
        //new SolicitudHotel(...).save(flush: true, failOnError: true)
        //SolicitudHotel solicitudHotel = new SolicitudHotel(...).save(flush: true, failOnError: true)
        //new SolicitudHotel(...).save(flush: true, failOnError: true)
        //new SolicitudHotel(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //solicitudHotel.id
    }

    void "test get"() {
        setupData()

        expect:
        solicitudHotelService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SolicitudHotel> solicitudHotelList = solicitudHotelService.list(max: 2, offset: 2)

        then:
        solicitudHotelList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        solicitudHotelService.count() == 5
    }

    void "test delete"() {
        Long solicitudHotelId = setupData()

        expect:
        solicitudHotelService.count() == 5

        when:
        solicitudHotelService.delete(solicitudHotelId)
        sessionFactory.currentSession.flush()

        then:
        solicitudHotelService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SolicitudHotel solicitudHotel = new SolicitudHotel()
        solicitudHotelService.save(solicitudHotel)

        then:
        solicitudHotel.id != null
    }
}
