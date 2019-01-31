package hoteltpintegrador

import grails.test.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class HabitacionesServiceSpec extends Specification {

    HabitacionesService habitacionesService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Habitaciones(...).save(flush: true, failOnError: true)
        //new Habitaciones(...).save(flush: true, failOnError: true)
        //Habitaciones habitaciones = new Habitaciones(...).save(flush: true, failOnError: true)
        //new Habitaciones(...).save(flush: true, failOnError: true)
        //new Habitaciones(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //habitaciones.id
    }

    void "test get"() {
        setupData()

        expect:
        habitacionesService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Habitaciones> habitacionesList = habitacionesService.list(max: 2, offset: 2)

        then:
        habitacionesList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        habitacionesService.count() == 5
    }

    void "test delete"() {
        Long habitacionesId = setupData()

        expect:
        habitacionesService.count() == 5

        when:
        habitacionesService.delete(habitacionesId)
        sessionFactory.currentSession.flush()

        then:
        habitacionesService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Habitaciones habitaciones = new Habitaciones()
        habitacionesService.save(habitaciones)

        then:
        habitaciones.id != null
    }
}
