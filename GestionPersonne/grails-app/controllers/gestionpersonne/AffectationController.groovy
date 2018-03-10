package gestionpersonne

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class AffectationController {

    AffectationService affectationService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
       def listPersonne  = Personne.findAll();
       def listeformation   = Formation.findAll();
       [listePersonne : listPersonne , listeFormations: listeformation]
       
    }

    def afficherListe(){
        def listePersonneSelected  = params.selectPersonne.toList()
        def formationSelected  = params.selectFormation
        def f =  Formation.get(formationSelected)
        listePersonneSelected.each {personne ->  
         def pp  =  Personne.get(personne) ; 
         pp.addToFormations(f) ; 
         pp.save flush:true;          
        }       
        
    }

    def show(Long id) {
        respond affectationService.get(id)
    }

    def create() {
        respond new Affectation(params)
    }

    def save(Affectation affectation) {
        if (affectation == null) {
            notFound()
            return
        }

        try {
            affectationService.save(affectation)
        } catch (ValidationException e) {
            respond affectation.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'affectation.label', default: 'Affectation'), affectation.id])
                redirect affectation
            }
            '*' { respond affectation, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond affectationService.get(id)
    }

    def update(Affectation affectation) {
        if (affectation == null) {
            notFound()
            return
        }

        try {
            affectationService.save(affectation)
        } catch (ValidationException e) {
            respond affectation.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'affectation.label', default: 'Affectation'), affectation.id])
                redirect affectation
            }
            '*'{ respond affectation, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        affectationService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'affectation.label', default: 'Affectation'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'affectation.label', default: 'Affectation'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }

    

}
