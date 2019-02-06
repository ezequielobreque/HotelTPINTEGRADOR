package hoteltpintegrador

import grails.gorm.services.Service

@Service(SolicitudHotel)
interface SolicitudHotelService {

    SolicitudHotel get(Serializable id)

    List<SolicitudHotel> list(Map args)

    Long count()

    void delete(Serializable id)

    SolicitudHotel save(SolicitudHotel solicitudHotel)

}