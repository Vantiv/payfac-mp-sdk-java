package com.mp.sdk.functionalTest;

import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

import org.junit.Before;
import org.junit.Test;

import com.mp.sdk.Address;
import com.mp.sdk.AddressUpdatable;
import com.mp.sdk.Communication;
import com.mp.sdk.Configuration;
import com.mp.sdk.LegalEntityCreateRequest;
import com.mp.sdk.LegalEntityOwnershipType;
import com.mp.sdk.LegalEntityPrincipal;
import com.mp.sdk.LegalEntityPrincipalUpdatable;
import com.mp.sdk.LegalEntityType;
import com.mp.sdk.LegalEntityUpdateRequest;
import com.mp.sdk.PayFacLegalEntity;
import com.mp.sdk.PrincipalAddress;

public class TestPayFacLegalEntity {

    PayFacLegalEntity payFacLegalEntity;
    PayFacLegalEntity payFacLegalEntity2;
    Communication communication;
    Properties config;
    Configuration configuration;
    LegalEntityPrincipal principal;
    LegalEntityPrincipalUpdatable legalEntityPrincipalUpdatable;
    Address address;
    PrincipalAddress principalAddress;
    AddressUpdatable addressUpdatable;
    Date date = new Date();
    Calendar calendar;
    LegalEntityCreateRequest createRequest;
    LegalEntityUpdateRequest updateRequest;

    @Before
    public void setUp(){
        communication = new Communication();
        configuration = new Configuration();
        config = configuration.getProperties();
        payFacLegalEntity = new PayFacLegalEntity();
        payFacLegalEntity2 = new PayFacLegalEntity(config);

        createRequest = new LegalEntityCreateRequest();

        address = new Address();
        principalAddress = new PrincipalAddress();
        addressUpdatable = new AddressUpdatable();
        address.setStreetAddress1("Street Address 1");
        address.setStreetAddress2("Street Address 2");
        address.setCity("City");
        address.setStateProvince("MA");
        address.setPostalCode("01970");
        address.setCountryCode("USA");
        principalAddress.setStreetAddress1("Street Address 1");
        principalAddress.setStreetAddress2("Street Address 2");
        principalAddress.setCity("City");
        principalAddress.setStateProvince("MA");
        principalAddress.setPostalCode("01970");
        principalAddress.setCountryCode("USA");
        addressUpdatable.setStreetAddress1("Street Address 1");
        addressUpdatable.setStreetAddress2("Street Address 2");
        addressUpdatable.setCity("City");
        addressUpdatable.setStateProvince("MA");
        addressUpdatable.setPostalCode("01970");
        addressUpdatable.setCountryCode("USA");

        date = new Date();
        calendar = Calendar.getInstance();
        calendar.setTime(date);

        principal = new LegalEntityPrincipal();
        legalEntityPrincipalUpdatable = new LegalEntityPrincipalUpdatable();
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
        legalEntityPrincipalUpdatable.setTitle("CEO");
        legalEntityPrincipalUpdatable.setPrincipalId(9);
        legalEntityPrincipalUpdatable.setEmailAddress("abc@gmail.com");
        legalEntityPrincipalUpdatable.setContactPhone("11");
        legalEntityPrincipalUpdatable.setAddress(principalAddress);

        createRequest.setLegalEntityName("LegalEntityCreateRequest request");
        createRequest.setLegalEntityType(LegalEntityType.CORPORATION);
        createRequest.setLegalEntityOwnershipType(LegalEntityOwnershipType.PUBLIC);
        createRequest.setDoingBusinessAs("Alternate Business Name");
        createRequest.setTaxId("123456789");
        createRequest.setContactPhone("77");
        createRequest.setAnnualCreditCardSalesVolume("80000000");
        createRequest.setHasAcceptedCreditCards(true);
        createRequest.setAddress(address);
        createRequest.setPrincipal(principal);

        updateRequest = new LegalEntityUpdateRequest();
        updateRequest.setAddress(addressUpdatable);
        updateRequest.setContactPhone("77");
        updateRequest.setDoingBusinessAs("Alternate Business Name");
        updateRequest.setAnnualCreditCardSalesVolume(100000000l);
        updateRequest.setHasAcceptedCreditCards(true);
        updateRequest.setPrincipal(legalEntityPrincipalUpdatable);

    }

    @Test
    public void testSetCommunication(){
        payFacLegalEntity.setCommunication(communication);
    }

    @Test
    public void testGetByLegalEntityId(){
        payFacLegalEntity.getByLegalEntityId(1000293);
    }

    @Test
    public void testPostByLegalEntity(){
        payFacLegalEntity.postByLegalEntity(createRequest);
    }

    @Test
    public void testPutByLegalEntity(){
        payFacLegalEntity.putByLegalEntity(1000293l,updateRequest);
    }

}
