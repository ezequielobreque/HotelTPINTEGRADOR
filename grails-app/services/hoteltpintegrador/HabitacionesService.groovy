package hoteltpintegrador

import grails.gorm.services.Service

@Service(Habitaciones)
interface HabitacionesService {

    Habitaciones get(Serializable id)

    List<Habitaciones> list(Map args)

    Long count()

    void delete(Serializable id)

    Habitaciones save(Habitaciones habitaciones)

}