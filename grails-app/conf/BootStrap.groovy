import com.prhdapi.Professional
import com.prhdapi.Role
import com.prhdapi.User
import com.prhdapi.UserRole
import com.prhdapi.RoleField
class BootStrap {
    def init = { servletContext ->
        def adminRole = new Role(authority: 'ROLE_ADMIN').save(flush: true)
        def userRole = new Role(authority: 'ROLE_USER').save(flush: true)
        def testUser = new User(username: 'me', enabled: true, password: 'password')
        testUser.save(flush: true)
        UserRole.create testUser, adminRole, true
        assert User.count() == 1
        assert Role.count() == 2
        assert UserRole.count() == 1

        new RoleField(roleID: "ROLE_ADMIN", fieldID: "f_name").save()
        new RoleField(roleID: "ROLE_ADMIN", fieldID: "l_name1").save()
        new RoleField(roleID: "ROLE_ADMIN", fieldID: "l_name2").save()
        new RoleField(roleID: "ROLE_ADMIN", fieldID: "facility_phone").save()
        new RoleField(roleID: "ROLE_ADMIN", fieldID: "facility_lon").save()
        new RoleField(roleID: "ROLE_ADMIN", fieldID: "facility_lat").save()
        new RoleField(roleID: "ROLE_ADMIN", fieldID: "acility_address_line1").save()
        new RoleField(roleID: "ROLE_ADMIN", fieldID: "facility_address_line2").save()
        new RoleField(roleID: "ROLE_ADMIN", fieldID: "facility_city").save()
        new RoleField(roleID: "ROLE_ADMIN", fieldID: "facility_name").save()
        new RoleField(roleID: "ROLE_ADMIN", fieldID: "profesional_specialty").save()



        new Professional(dea_address_line1: "Urb. Monte Santo #444",
                dea_country_id: 1,dea_city: "San Juan", dea_zip_code: "00971", dea_lic: 1111111,
                dm_city: "San Juan", dm_zip_code: "00971",email_address: "medico@sanjuanero.com",
                l_name1: "Villanueva",l_name2:"Perez", f_name: "Ricardo",facility_phone: "7871111111", facility_zip_code: "009971",
                facility_lat: 18.424163,facility_lon: -66.065525, facility_address_line1: "Villas del Toa Alta",
                facility_address_line2: "#321", facility_city: "Toa Alta", facility_name: "Oftalmología Toa",
                profesional_specialty: "Oftalmologo").save()

        new Professional(dea_address_line1: "Cond Randal #123",
                dea_country_id: 1,dea_city: "Ponce", dea_zip_code: "00977", dea_lic: 1111111,
                dm_city: "Ponce", dm_zip_code: "00977",email_address: "medico@poncista.com",
                l_name1: "Villalba", l_name2:"Rivera",f_name: "Juan",facility_phone: "7875555555", facility_zip_code: "00977",
                facility_lat: 18.004856,facility_lon: -66.57795, facility_address_line1: "Cond. Randal",
                facility_address_line2: "#123", facility_city: "Ponce", facility_name: "Dentista",
                profesional_specialty: "Dentista").save()



        new Professional(dea_address_line1: "Condominio Regal",
                dea_country_id: 1,dea_city: "Toa Alta", dea_zip_code: "00956", dea_lic: 1111111,
                dm_city: "Toa Alta", dm_zip_code: "00971",email_address: "medico@toalteno.com",
                l_name1: "Huertas", l_name2:"Guti",f_name: "Antonio",facility_phone: "7871233218", facility_zip_code: "00956",
                facility_lat: 18.38776,facility_lon: -66.246922, facility_address_line1: "Condominio Regal",
                facility_address_line2: "#321", facility_city: "Toa Alta", facility_name: "Prediatrico para Niños",
                profesional_specialty: "Prediatrico").save()
        def y = 5000






    }
}