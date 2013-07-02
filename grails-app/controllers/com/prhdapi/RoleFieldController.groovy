package com.prhdapi

import grails.plugins.springsecurity.Secured
import org.springframework.dao.DataIntegrityViolationException
@Secured("ROLE_ADMIN")
class RoleFieldController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [roleFieldInstanceList: RoleField.list(params), roleFieldInstanceTotal: RoleField.count()]
    }

    def create() {
        [roleFieldInstance: new RoleField(params)]
    }

    def save() {
        def roleFieldInstance = new RoleField(params)
        if (!roleFieldInstance.save(flush: true)) {
            render(view: "create", model: [roleFieldInstance: roleFieldInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'roleField.label', default: 'RoleField'), roleFieldInstance.id])
        redirect(action: "show", id: roleFieldInstance.id)
    }

    def show(Long id) {
        def roleFieldInstance = RoleField.get(id)
        if (!roleFieldInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'roleField.label', default: 'RoleField'), id])
            redirect(action: "list")
            return
        }

        [roleFieldInstance: roleFieldInstance]
    }

    def edit(Long id) {
        def roleFieldInstance = RoleField.get(id)
        if (!roleFieldInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'roleField.label', default: 'RoleField'), id])
            redirect(action: "list")
            return
        }

        [roleFieldInstance: roleFieldInstance]
    }

    def update(Long id, Long version) {
        def roleFieldInstance = RoleField.get(id)
        if (!roleFieldInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'roleField.label', default: 'RoleField'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (roleFieldInstance.version > version) {
                roleFieldInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                        [message(code: 'roleField.label', default: 'RoleField')] as Object[],
                        "Another user has updated this RoleField while you were editing")
                render(view: "edit", model: [roleFieldInstance: roleFieldInstance])
                return
            }
        }

        roleFieldInstance.properties = params

        if (!roleFieldInstance.save(flush: true)) {
            render(view: "edit", model: [roleFieldInstance: roleFieldInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'roleField.label', default: 'RoleField'), roleFieldInstance.id])
        redirect(action: "show", id: roleFieldInstance.id)
    }

    def delete(Long id) {
        def roleFieldInstance = RoleField.get(id)
        if (!roleFieldInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'roleField.label', default: 'RoleField'), id])
            redirect(action: "list")
            return
        }

        try {
            roleFieldInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'roleField.label', default: 'RoleField'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'roleField.label', default: 'RoleField'), id])
            redirect(action: "show", id: id)
        }
    }
}
