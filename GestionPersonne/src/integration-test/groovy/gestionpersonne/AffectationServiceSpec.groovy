package gestionpersonne

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class AffectationServiceSpec extends Specification {

    AffectationService affectationService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Affectation(...).save(flush: true, failOnError: true)
        //new Affectation(...).save(flush: true, failOnError: true)
        //Affectation affectation = new Affectation(...).save(flush: true, failOnError: true)
        //new Affectation(...).save(flush: true, failOnError: true)
        //new Affectation(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //affectation.id
    }

    void "test get"() {
        setupData()

        expect:
        affectationService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Affectation> affectationList = affectationService.list(max: 2, offset: 2)

        then:
        affectationList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        affectationService.count() == 5
    }

    void "test delete"() {
        Long affectationId = setupData()

        expect:
        affectationService.count() == 5

        when:
        affectationService.delete(affectationId)
        sessionFactory.currentSession.flush()

        then:
        affectationService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Affectation affectation = new Affectation()
        affectationService.save(affectation)

        then:
        affectation.id != null
    }
}
