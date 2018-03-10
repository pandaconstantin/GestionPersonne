package gestionpersonne

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class FormationController {

    FormationService formationService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond formationService.list(params), model:[formationCount: formationService.count()]
    }

    def show(Long id) {
        respond formationService.get(id)
    }

    def create() {
        respond new Formation(params)
    }

    def save(Formation formation) {
        if (formation == null) {
            notFound()
            return
        }

        try {
            formationService.save(formation)
        } catch (ValidationException e) {
            respond formation.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'formation.label', default: 'Formation'), formation.id])
                redirect formation
            }
            '*' { respond formation, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond formationService.get(id)
    }

    def update(Formation formation) {
        if (formation == null) {
            notFound()
            return
        }

        try {
            formationService.save(formation)
        } catch (ValidationException e) {
            respond formation.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'formation.label', default: 'Formation'), formation.id])
                redirect formation
            }
            '*'{ respond formation, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        formationService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'formation.label', default: 'Formation'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'formation.label', default: 'Formation'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
