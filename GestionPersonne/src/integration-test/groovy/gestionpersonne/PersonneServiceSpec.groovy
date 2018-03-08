package gestionpersonne

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class PersonneServiceSpec extends Specification {

    PersonneService personneService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Personne(...).save(flush: true, failOnError: true)
        //new Personne(...).save(flush: true, failOnError: true)
        //Personne personne = new Personne(...).save(flush: true, failOnError: true)
        //new Personne(...).save(flush: true, failOnError: true)
        //new Personne(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //personne.id
    }

    void "test get"() {
        setupData()

        expect:
        personneService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Personne> personneList = personneService.list(max: 2, offset: 2)

        then:
        personneList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        personneService.count() == 5
    }

    void "test delete"() {
        Long personneId = setupData()

        expect:
        personneService.count() == 5

        when:
        personneService.delete(personneId)
        sessionFactory.currentSession.flush()

        then:
        personneService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Personne personne = new Personne()
        personneService.save(personne)

        then:
        personne.id != null
    }
}
