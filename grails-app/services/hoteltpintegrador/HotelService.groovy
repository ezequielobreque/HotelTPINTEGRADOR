package hoteltpintegrador

import grails.gorm.services.Service

@Service(Hotel)
interface HotelService {

   // Hotel get(Serializable id)

   // List<Hotel> list(Map args)

    //Long count()

    //void delete(Serializable id)

    //Hotel save(Hotel hotel)


        Hotel get(Long id)
        List<Hotel> list(Map args)
        Number count()
        void delete(Serializable id)
        Hotel update(Serializable id, Long version, String nombre)
        Hotel update(Serializable id, Long version, byte[] featuredImageBytes, String featuredImageContentType)
        Hotel save(String nombre)

}