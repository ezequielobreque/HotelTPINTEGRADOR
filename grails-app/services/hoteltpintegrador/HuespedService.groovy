package hoteltpintegrador

import grails.gorm.services.Service

@Service(Huesped)
interface HuespedService {

    Huesped get(Serializable id)

    List<Huesped> list(Map args)

    Long count()

    void delete(Serializable id)

    Huesped save(Huesped huesped)

}