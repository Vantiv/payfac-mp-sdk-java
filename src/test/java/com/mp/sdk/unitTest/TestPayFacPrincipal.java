package com.mp.sdk.unitTest;

import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.matches;
import static org.mockito.Mockito.when;

import java.util.Calendar;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.mp.sdk.ApprovedMccResponse;
import com.mp.sdk.Communication;
import com.mp.sdk.LegalEntityPrincipal;
import com.mp.sdk.PayFacPrincipal;
import com.mp.sdk.PrincipalAddress;
import com.mp.sdk.PrincipalCreateResponse;
import com.mp.sdk.PrincipalDeleteResponse;

public class TestPayFacPrincipal {
    PayFacPrincipal payFacPrincipal;
    LegalEntityPrincipal principal;
    PrincipalAddress address;
    Calendar calendar;

    @Before
    public void setUp(){
        payFacPrincipal = new PayFacPrincipal();

        principal = new LegalEntityPrincipal();

        address = new PrincipalAddress();
        address.setStreetAddress1("Street Address 1");
        address.setStreetAddress2("Street Address 2");
        address.setCity("City");
        address.setStateProvince("MA");
        address.setPostalCode("01970");
        address.setCountryCode("USA");

        calendar = Calendar.getInstance();
        calendar.set(1997, 4, 10);

        principal.setTitle("Mr.");
        principal.setFirstName("First");
        principal.setLastName("Last");
        principal.setEmailAddress("abc@gmail.com");
        principal.setSsn("123450015");
        principal.setAddress(address);
        principal.setContactPhone("11");
        principal.setDateOfBirth(calendar);
        principal.setStakePercent(31);
    }

    @Test
    public void testDeleteLegalEntityByPrincipalId(){
        String expectedRequestUrl = "https://www.testvantivcnp.com/sandbox/payfac/legalentity/2018/principal/9";
        String mockedResponse = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>" +
                "<principalDeleteResponse xmlns=\"http://payfac.vantivcnp.com/api/merchant/onboard\">" +
                "    <transactionId>4234049185</transactionId>" +
                "    <legalEntityId>2018</legalEntityId>" +
                "    <principalId>9</principalId>" +
                "    <responseDescription>Legal Entity Principal successfully deleted</responseDescription>" +
                "</principalDeleteResponse>";
        Communication mockedCommunication = Mockito.mock(Communication.class);
        when(mockedCommunication.httpDeleteRequest(expectedRequestUrl)).thenReturn(mockedResponse);
        payFacPrincipal.setCommunication(mockedCommunication);
        PrincipalDeleteResponse response = payFacPrincipal.deleteLegalEntityByPrincipalId(2018,9);
        assertNotNull(response.getTransactionId());
    }

    @Test
    public void testPostByLegalEntityID(){
        String expectedRequestUrl = "https://www.testvantivcnp.com/sandbox/payfac/legalentity/2018/principal";
        String expectedRequest = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>" +
                "<legalEntityPrincipalCreateRequest " +
                "xmlns=\"http://payfac.vantivcnp.com/api/merchant/onboard\">" +
                "<principal>" +
                "<title>Mr.</title>" +
                "<firstName>First</firstName>" +
                "<lastName>Last</lastName>" +
                "<emailAddress>abc@gmail.com</emailAddress>" +
                "<ssn>123450015</ssn>" +
                "<contactPhone>11</contactPhone>" +
                "<dateOfBirth>1997-05-10</dateOfBirth>" +
                "<address>" +
                "<streetAddress1>Street Address 1</streetAddress1>" +
                "<streetAddress2>Street Address 2</streetAddress2>" +
                "<city>City</city>" +
                "<stateProvince>MA</stateProvince>" +
                "<postalCode>01970</postalCode>" +
                "<countryCode>USA</countryCode>" +
                "</address>" +
                "<stakePercent>31</stakePercent>" +
                "</principal>" +
                "</legalEntityPrincipalCreateRequest>";
        String mockedResponse = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>" +
                "<principalCreateResponse xmlns=\"http://payfac.vantivcnp.com/api/merchant/onboard\">" +
                "    <legalEntityId>2018</legalEntityId>" +
                "    <principal>" +
                "        <principalId>4</principalId>" +
                "        <firstName>p first</firstName>" +
                "        <lastName>p last</lastName>" +
                "        <responseCode>10</responseCode>" +
                "        <responseDescription>Approved</responseDescription>" +
                "    </principal>" +
                "    <transactionId>2348770070</transactionId>" +
                "</principalCreateResponse>";
        Communication mockedCommunication = Mockito.mock(Communication.class);
        when(mockedCommunication.httpPostRequest(expectedRequest, expectedRequestUrl)).thenReturn(mockedResponse);
        payFacPrincipal.setCommunication(mockedCommunication);
        PrincipalCreateResponse response = payFacPrincipal.postByLegalEntityID(2018,principal);
        assertNotNull(response.getTransactionId());
    }
}
