package gestionpersonne

import grails.gorm.services.Service

@Service(Affectation)
interface AffectationService {

    Affectation get(Serializable id)

    List<Affectation> list(Map args)

    Long count()

    void delete(Serializable id)

    Affectation save(Affectation affectation)

}