package com.mp.sdk.certificationTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.matches;
import static org.mockito.Mockito.when;

import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.mp.sdk.Address;
import com.mp.sdk.AddressUpdatable;
import com.mp.sdk.Communication;
import com.mp.sdk.Configuration;
import com.mp.sdk.LegalEntityCreateRequest;
import com.mp.sdk.LegalEntityCreateResponse;
import com.mp.sdk.LegalEntityOwnershipType;
import com.mp.sdk.LegalEntityPrincipal;
import com.mp.sdk.LegalEntityPrincipalUpdatable;
import com.mp.sdk.LegalEntityResponse;
import com.mp.sdk.LegalEntityRetrievalResponse;
import com.mp.sdk.LegalEntityType;
import com.mp.sdk.LegalEntityUpdateRequest;
import com.mp.sdk.PayFacLegalEntity;
import com.mp.sdk.PrincipalAddress;

public class TestCreatePayFacLegalEntity {
    PayFacLegalEntity payFacLegalEntity;
    Configuration configuration;
    Properties properties;
    LegalEntityCreateRequest createRequest;
    LegalEntityPrincipal principal;
    Address address;
    PrincipalAddress principalAddress;
    AddressUpdatable addressUpdatable;
    Date date = new Date();
    Calendar calendar;
    LegalEntityUpdateRequest updateRequest;
    String streetAdrss1ForTest1;
    String streetAdrss1ForTest2;
    String streetAdrss1ForTest3;
    String streetAdrss1ForTestC1_1;
    String streetAdrss1ForTestC1_2;
    String streetAdrss1ForTestC1_3;



    @Before
    public void setUp(){
        streetAdrss1ForTest1 = "900 Chelmsford St";
        streetAdrss1ForTest2 = "912 Chelmsford St";
        streetAdrss1ForTest3 = "914 Chelmsford St";
        streetAdrss1ForTestC1_1 = "900 Chelmsford St";
        streetAdrss1ForTestC1_2 = "900 Chelmsford St";
        streetAdrss1ForTestC1_3 = "912 Chelmsford St";

        configuration = new Configuration();
        properties = configuration.getProperties();
        properties.setProperty("url","https://payfac.vantivprelive.com");
        payFacLegalEntity = new PayFacLegalEntity(properties);

        address = new Address();
        addressUpdatable = new AddressUpdatable();
        address.setStreetAddress1(null);
        address.setStreetAddress2("Street Address 2");
        address.setCity("City");
        address.setStateProvince("MA");
        address.setPostalCode("01970");
        address.setCountryCode("USA");

        principalAddress = new PrincipalAddress();
        principalAddress.setStreetAddress1("Street Address 1");
        principalAddress.setStreetAddress2("Street Address 2");
        principalAddress.setCity("City");
        principalAddress.setStateProvince("MA");
        principalAddress.setPostalCode("01970");
        principalAddress.setCountryCode("USA");

        date = new Date();
        calendar = Calendar.getInstance();
        calendar.setTime(date);

        principal = new LegalEntityPrincipal();
        principal.setTitle("Chief Financial Officer");
        principal.setFirstName("First");
        principal.setLastName("Last");
        principal.setEmailAddress("abc@gmail.com");
        principal.setSsn("123450015");
        principal.setContactPhone("11");
        principal.setDateOfBirth(calendar);
        principal.setDriversLicense("892327409832");
        principal.setDriversLicenseState("MA");
        principal.setAddress(principalAddress);
        principal.setStakePercent(33);

        createRequest = new LegalEntityCreateRequest();
        createRequest.setLegalEntityName("test legalentity");
        createRequest.setLegalEntityType(null);
        createRequest.setTaxId("1123");
        createRequest.setAnnualCreditCardSalesVolume("500000");
        createRequest.setHasAcceptedCreditCards(true);
        createRequest.setLegalEntityOwnershipType(LegalEntityOwnershipType.PUBLIC);
        createRequest.setAddress(address);
        createRequest.setPrincipal(principal);

    }

    @Test
    public void test1(){
//        createRequest.setLegalEntityType(LegalEntityType.INDIVIDUAL_SOLE_PROPRIETORSHIP);
//        address.setStreetAddress1(streetAdrss1ForTest1);
//        createRequest.setAddress(address);
//
//        LegalEntityCreateResponse response = payFacLegalEntity.postByLegalEntity(createRequest);
//        assertEquals((short) 201, (short) response.getResponseCode());
//        assertEquals("Approved",response.getResponseDescription());

    }

    @Test
    public void test2(){

    }
}
