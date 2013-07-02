package com.prhdapi

class Professional {




    //int id
    int version
    int auto_refill

    String dea_address_line1
    String dea_address_line2
    String dea_city
    int dea_country_id
    String dea_lic
    Date dea_lic_exp
    int dea_state_id
    String dea_zip_code
    String dm_address_line1
    String dm_address_line2
    String dm_city
    int dm_country_id
    String dm_zip_code
    Date dob
    String email_address
    String f_name
    String gender
    String l_name1
    String l_name2
    String mid_initial
    String npi
    String soc_sec_num_enc
    Date statecslic_exp
    String state_lic
    Date state_lic_exp
    String statecs_lic

    int dm_state_id
    double facility_lat
    double facility_lon
    String profesional_specialty
    String facility_address_line1
    String facility_address_line2
    String facility_name
    String facility_city
    String facility_country
    String facility_state
    String facility_zip_code
    String facility_phone


    static constraints = {


        profesional_specialty (maxSize: 50,nullable:true)
        facility_phone(maxSize: 11,nullable:true)
        facility_zip_code(maxSize: 5,nullable:true)
        facility_name(maxSize: 50,nullable:true)
        facility_country (maxSize: 25,nullable:true)
        facility_state(maxSize: 25,nullable:true)
        version (maxSize:20,nullable:true)

        dea_address_line1 (maxSize:35,nullable:true)
        dea_address_line2 (maxSize:35,nullable:true)
        dea_city (maxSize:35,nullable:true)
        dea_country_id (maxSize:20,nullable:true)
        dea_lic (maxSize:9,nullable:true)
        dob (nullable:true)
        statecslic_exp (nullable:true)
        dea_lic_exp (nullable:true)
        dea_state_id (maxSize:20,nullable:true)
        dea_zip_code (maxSize:5,nullable:true)
        dm_address_line1 (maxSize: 35,nullable:true)
        dm_address_line2 (maxsize:35,nullable:true)
        dm_city (maxSize: 35,nullable:true)
        dm_country_id (maxSize: 20,nullable:true)
        dm_state_id ( maxSize: 20,nullable:true)
        dm_zip_code (maxSize:5,nullable:true)

        email_address (maxSize:255,nullable:true)
        f_name (maxSize: 35,nullable:true)
        gender (maxSize: 6,nullable:true)
        l_name1 (maxSize:35,nullable:true)
        l_name2 (maxSize: 35,nullable:true)
        mid_initial (maxSize: 35,nullable:true)
        npi (maxSize:10,nullable:true)
        soc_sec_num_enc (maxSize:50,nullable:true)

        state_lic (maxSize: 25,nullable:true)

        state_lic_exp (nullable:true)
        statecs_lic (maxSize: 25,nullable:true)
        facility_lat (nullable: true)
        facility_lon (nullable: true)

        //id_facilities
        //id_profesionals_specialties
    }
}


