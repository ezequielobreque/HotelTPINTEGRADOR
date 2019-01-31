package hoteltpintegrador

import grails.test.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class ReservasServiceSpec extends Specification {

    ReservasService reservasService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Reservas(...).save(flush: true, failOnError: true)
        //new Reservas(...).save(flush: true, failOnError: true)
        //Reservas reservas = new Reservas(...).save(flush: true, failOnError: true)
        //new Reservas(...).save(flush: true, failOnError: true)
        //new Reservas(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //reservas.id
    }

    void "test get"() {
        setupData()

        expect:
        reservasService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Reservas> reservasList = reservasService.list(max: 2, offset: 2)

        then:
        reservasList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        reservasService.count() == 5
    }

    void "test delete"() {
        Long reservasId = setupData()

        expect:
        reservasService.count() == 5

        when:
        reservasService.delete(reservasId)
        sessionFactory.currentSession.flush()

        then:
        reservasService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Reservas reservas = new Reservas()
        reservasService.save(reservas)

        then:
        reservas.id != null
    }
}
