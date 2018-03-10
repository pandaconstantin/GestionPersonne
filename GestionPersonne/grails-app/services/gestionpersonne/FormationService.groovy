package gestionpersonne

import grails.gorm.services.Service

@Service(Formation)
interface FormationService {

    Formation get(Serializable id)

    List<Formation> list(Map args)

    Long count()

    void delete(Serializable id)

    Formation save(Formation formation)

}