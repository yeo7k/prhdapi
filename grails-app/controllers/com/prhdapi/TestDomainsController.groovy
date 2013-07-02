
package com.prhdapi
import org.codehaus.groovy.grails.commons.*

class TestDomainsController {
    def prhdAPIService
    def index() {



        render(contentType:"text/json",text:  prhdAPIService.getAllProfessionals("ROLE_ADMIN"))
}
}