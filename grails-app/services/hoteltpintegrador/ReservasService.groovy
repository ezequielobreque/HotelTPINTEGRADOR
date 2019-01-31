package hoteltpintegrador

import grails.gorm.services.Service

@Service(Reservas)
interface ReservasService {

    Reservas get(Serializable id)

    List<Reservas> list(Map args)

    Long count()

    void delete(Serializable id)

    Reservas save(Reservas reservas)

}