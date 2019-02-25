package hoteltpintegrador

import grails.gorm.services.Service

@Service(Imagenes)
interface ImagenesService {

    Imagenes get(Serializable id)

    List<Imagenes> list(Map args)

    Long count()

    void delete(Serializable id)

    Imagenes save(Imagenes imagenes)

}