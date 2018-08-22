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
    Date date = new Date();
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

        date = new Date();
        calendar = Calendar.getInstance();
        calendar.setTime(date);

        principal.setTitle("Mr.");
        principal.setFirstName("First");
        principal.setLastName("Last");
        principal.setEmailAddress("abc@gmail.com");
        principal.setSsn("123450015");
        principal.setAddress(address);
        principal.setContactPhone("11");
        principal.setDateOfBirth(calendar);
    }

    @Test
    public void testDeleteLegalEntityByPrincipalId(){
        String expectedRequestUrl = "https://www.testvantivcnp.com/sandbox/payfac/legalentity/2018/principal/9";
        String mockedResponse = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
                "<principalDeleteResponse xmlns=\"http://payfac.vantivcnp.com/api/merchant/onboard\">\n" +
                "    <transactionId>4234049185</transactionId>\n" +
                "    <legalEntityId>2018</legalEntityId>\n" +
                "    <principalId>9</principalId>\n" +
                "    <responseDescription>Legal Entity Principal successfully deleted</responseDescription>\n" +
                "</principalDeleteResponse>";
        Communication mockedCommunication = Mockito.mock(Communication.class);
        when(mockedCommunication.httpDeleteRequest(matches(expectedRequestUrl))).thenReturn(mockedResponse);
        PrincipalDeleteResponse response = payFacPrincipal.deleteLegalEntityByPrincipalId(2018,9);
        assertNotNull(response.getTransactionId());
    }

    @Test
    public void testPostByLegalEntityID(){
        String expectedRequestUrl = "https://www.testvantivcnp.com/sandbox/payfac/legalentity/2018/principal";
        String expectedRequest = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
                "<legalEntityPrincipalCreateRequest\n" +
                "\txmlns=\"http://payfac.vantivcnp.com/api/merchant/onboard\">\n" +
                "\t<principal>\n" +
                "\t\t<title>Mr.</title>\n" +
                "\t\t<firstName>First</firstName>\n" +
                "\t\t<lastName>Last</lastName>\n" +
                "\t\t<emailAddress>abc@gmail.com</emailAddress>\n" +
                "\t\t<ssn>123450015</ssn>\n" +
                "\t\t<dateOfBirth>1980-10-12</dateOfBirth>\n" +
                "\t\t<address>\n" +
                "\t\t\t<streetAddress1>p2 street address 1</streetAddress1>\n" +
                "\t\t\t<streetAddress2>p2 street address 2</streetAddress2>\n" +
                "\t\t\t<city>Boston2</city>\n" +
                "\t\t\t<stateProvince>MA</stateProvince>\n" +
                "\t\t\t<postalCode>01892</postalCode>\n" +
                "\t\t\t<countryCode>USA</countryCode>\n" +
                "\t\t</address>\n" +
                "\t\t<stakePercent>31</stakePercent>\n" +
                "\t</principal>\n" +
                "</legalEntityPrincipalCreateRequest>";
        String mockedResponse = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
                "<principalCreateResponse xmlns=\"http://payfac.vantivcnp.com/api/merchant/onboard\">\n" +
                "    <legalEntityId>2018</legalEntityId>\n" +
                "    <principal>\n" +
                "        <principalId>4</principalId>\n" +
                "        <firstName>p first</firstName>\n" +
                "        <lastName>p last</lastName>\n" +
                "        <responseCode>10</responseCode>\n" +
                "        <responseDescription>Approved</responseDescription>\n" +
                "    </principal>\n" +
                "    <transactionId>2348770070</transactionId>\n" +
                "</principalCreateResponse>";
        Communication mockedCommunication = Mockito.mock(Communication.class);
        when(mockedCommunication.httpPostRequest(matches(expectedRequest),matches(expectedRequestUrl))).thenReturn(mockedResponse);
        PrincipalCreateResponse response = payFacPrincipal.postByLegalEntityID(2018,principal);
        assertNotNull(response.getTransactionId());
    }
}
