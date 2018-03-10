package gestionpersonne

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class FormationServiceSpec extends Specification {

    FormationService formationService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Formation(...).save(flush: true, failOnError: true)
        //new Formation(...).save(flush: true, failOnError: true)
        //Formation formation = new Formation(...).save(flush: true, failOnError: true)
        //new Formation(...).save(flush: true, failOnError: true)
        //new Formation(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //formation.id
    }

    void "test get"() {
        setupData()

        expect:
        formationService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Formation> formationList = formationService.list(max: 2, offset: 2)

        then:
        formationList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        formationService.count() == 5
    }

    void "test delete"() {
        Long formationId = setupData()

        expect:
        formationService.count() == 5

        when:
        formationService.delete(formationId)
        sessionFactory.currentSession.flush()

        then:
        formationService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Formation formation = new Formation()
        formationService.save(formation)

        then:
        formation.id != null
    }
}
