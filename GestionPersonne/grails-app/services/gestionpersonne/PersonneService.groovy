package gestionpersonne

import grails.gorm.services.Service

@Service(Personne)
interface PersonneService {

    Personne get(Serializable id)

    List<Personne> list(Map args)

    Long count()

    void delete(Serializable id)

    Personne save(Personne personne)

}