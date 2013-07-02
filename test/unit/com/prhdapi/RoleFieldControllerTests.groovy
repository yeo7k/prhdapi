package com.prhdapi



import org.junit.*
import grails.test.mixin.*

@TestFor(RoleFieldController)
@Mock(RoleField)
class RoleFieldControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/roleField/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.roleFieldInstanceList.size() == 0
        assert model.roleFieldInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.roleFieldInstance != null
    }

    void testSave() {
        controller.save()

        assert model.roleFieldInstance != null
        assert view == '/roleField/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/roleField/show/1'
        assert controller.flash.message != null
        assert RoleField.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/roleField/list'

        populateValidParams(params)
        def roleField = new RoleField(params)

        assert roleField.save() != null

        params.id = roleField.id

        def model = controller.show()

        assert model.roleFieldInstance == roleField
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/roleField/list'

        populateValidParams(params)
        def roleField = new RoleField(params)

        assert roleField.save() != null

        params.id = roleField.id

        def model = controller.edit()

        assert model.roleFieldInstance == roleField
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/roleField/list'

        response.reset()

        populateValidParams(params)
        def roleField = new RoleField(params)

        assert roleField.save() != null

        // test invalid parameters in update
        params.id = roleField.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/roleField/edit"
        assert model.roleFieldInstance != null

        roleField.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/roleField/show/$roleField.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        roleField.clearErrors()

        populateValidParams(params)
        params.id = roleField.id
        params.version = -1
        controller.update()

        assert view == "/roleField/edit"
        assert model.roleFieldInstance != null
        assert model.roleFieldInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/roleField/list'

        response.reset()

        populateValidParams(params)
        def roleField = new RoleField(params)

        assert roleField.save() != null
        assert RoleField.count() == 1

        params.id = roleField.id

        controller.delete()

        assert RoleField.count() == 0
        assert RoleField.get(roleField.id) == null
        assert response.redirectedUrl == '/roleField/list'
    }
}
