package com.prhdapi

class Facility {

    static belongsTo = [prescriptors: Professional]

    //BigInteger id
    //BigInteger id_prescriptor
    String facility_address_line1
    String facility_address_line2
    String facility_name
    String facility_city
    int facility_country_id
    int facility_state_id
    String facility_zip_code
    float facility_lat
    float facility_lon
    

    static constraints = {


        //id bigint(20) NOT NULL AUTO_INCREMENT,
        //id_prescriptor bigint(20) NOT NULL,
        facility_address_line1 (maxSize: 35)
        facility_address_line2 (maxSize: 35)
        facility_name (maxSize: 35)
        facility_city (maxSize: 35)
        facility_country_id (maxsize: 20)
        facility_state_id (maxSize: 20)
        facility_zip_code (maxSize: 20)
        facility_lat (nullable: true)
        facility_lon (nullable: true)
    }
}
