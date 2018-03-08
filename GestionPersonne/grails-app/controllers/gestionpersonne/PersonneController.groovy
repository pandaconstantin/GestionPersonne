package gestionpersonne

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*
import nine.jasper.JasperService
import nine.jasper.spring.JasperReportDef
import nine.reports.ReportFormat

class PersonneController {

    PersonneService personneService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond personneService.list(params), model:[personneCount: personneService.count()]
    }

    def show(Long id) {
        respond personneService.get(id)
    }

    def create() {
        respond new Personne(params)
    }

    def save(Personne personne) {
        if (personne == null) {
            notFound()
            return
        }

        try {
            personneService.save(personne)
        } catch (ValidationException e) {
            respond personne.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'personne.label', default: 'Personne'), personne.id])
                redirect personne
            }
            '*' { respond personne, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond personneService.get(id)
    }

    def update(Personne personne) {
        if (personne == null) {
            notFound()
            return
        }

        try {
            personneService.save(personne)
        } catch (ValidationException e) {
            respond personne.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'personne.label', default: 'Personne'), personne.id])
                redirect personne
            }
            '*'{ respond personne, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        personneService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'personne.label', default: 'Personne'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'personne.label', default: 'Personne'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }

    def generateReports(){
        def reportData = Personne.findAll()
        println(params.name)
        chain(controller:'jasper',action:'index',model:[data:reportData],params:params)        
    }

    def generateReportParametre() {
        def reportDataparam  = Personne.findAllByNom(params.name)
        chain(controller:'jasper',action:'index',model:[data:reportDataparam],params:params) 
    }
}
