package prhdapi

import com.prhdapi.Professional
import com.prhdapi.RoleField
import org.codehaus.groovy.grails.commons.DefaultGrailsDomainClass

class prhdAPIService {

    def String getAllProfessionals(String roleID) {

        def fieldList = new DefaultGrailsDomainClass( Professional.class )

        def professionalList = Professional.list()

        StringBuilder builder=new StringBuilder()


        def roleFields=RoleField.findAllByRoleID(roleID)

        def morethanone

        def rCollection = []

        roleFields.each() {
            rCollection.add(it.fieldID)


        }

        builder.append( "{\"professionals\":[")
        professionalList.each() {

            def presProperties
            StringBuilder builderFields=new StringBuilder()


            presProperties= it.properties
            if (morethanone)
            {
                builderFields.append ",{"
            }
            else
            {
                builderFields.append "{"
            }

            fieldList.properties.each{
                def roleFieldMatch
                roleFieldMatch= rCollection.grep(it.name)


                if (roleFieldMatch.size()>0)
                {
                    builderFields.append " \"" + it.name + "\":\"" + presProperties[it.name] + "\"  ,"

                }

            }
            builder.append builderFields.substring(0, builderFields.length() - 1)   + "}"
            morethanone=true

        }
        builder.append("]}")

        return builder.toString()

    }

 }

