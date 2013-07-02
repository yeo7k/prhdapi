package com.prhdapi

import grails.plugins.springsecurity.Secured
import com.prhdapi.*

class ListProfessionalsController {




    def springSecurityService
    def prhdAPIService

    def index() {



        if (loggedIn) {
            // will be a List of String
            def roleNames = principal.authorities*.authority
            def roleID=roleNames[0]    //Only one role per user

           render(contentType:"text/json",text:  prhdAPIService.getAllProfessionals(roleID))




        }
    }
}
