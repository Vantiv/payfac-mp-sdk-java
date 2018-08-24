package com.mp.sdk.unitTest;

import static com.mp.sdk.Communication.getBestProtocol;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import java.util.Properties;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import com.mp.sdk.ApprovedMccResponse;
import com.mp.sdk.Communication;
import com.mp.sdk.Configuration;
import com.mp.sdk.LegalEntityCreateResponse;
import com.mp.sdk.LegalEntityResponse;
import com.mp.sdk.PrincipalDeleteResponse;
import com.mp.sdk.XMLConverters;

public class TestCommunication {
    Communication communication;
    Communication communication2;
    String[] availableProtocols_empty;
    String[] availableProtocols;
    Configuration configuration;
    Properties config;


    @Before
    public void setUp(){
        configuration = new Configuration();
        config = configuration.getProperties();
        communication2 = new Communication(config);
        communication = new Communication();
        availableProtocols =new String[] {"TLSv1.2", "invalid protocol"};
        availableProtocols_empty = new String[]{};
    }

    @Test
    public void testGetBestProtocol(){
        assertNull(getBestProtocol(null));
        assertNull(getBestProtocol(availableProtocols_empty));
        assertEquals("TLSv1.2",getBestProtocol(availableProtocols));
        availableProtocols[0] = "invalid protocol";
        assertNull(getBestProtocol(availableProtocols));
    }

    @Test
    public void testNeuterXml(){
        String xml = "temp xml";
        assertNull(communication.neuterXml(null));
        assertEquals(xml,communication.neuterXml(xml));
    }


    @Test
    public void testHttpGetRequest(){
        String response = communication.httpGetRequest("https://www.testvantivcnp.com/sandbox/payfac/mcc");
        ApprovedMccResponse mccResponse = XMLConverters.generateMccResponse(response);
        assertNotNull(mccResponse.getTransactionId());
        assertTrue(mccResponse.getApprovedMccs().getApprovedMccs().contains("5967"));
        assertTrue(mccResponse.getApprovedMccs().getApprovedMccs().contains("5970"));
    }

    @Test
    public void testHttpPutRequest(){
        String xmlRequest = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
                "<legalEntityUpdateRequest\n" +
                "\txmlns=\"http://payfac.vantivcnp.com/api/merchant/onboard\">\n" +
                "\t<address>\n" +
                "\t\t<streetAddress1>LE Street Address 1</streetAddress1>\n" +
                "\t\t<streetAddress2>LE Street Address 2</streetAddress2>\n" +
                "\t\t<city>LE City</city>\n" +
                "\t\t<stateProvince>MA</stateProvince>\n" +
                "\t\t<postalCode>01730</postalCode>\n" +
                "\t\t<countryCode>USA</countryCode>\n" +
                "\t</address>\n" +
                "\t<contactPhone>9785550101</contactPhone>\n" +
                "\t<doingBusinessAs>Other Name Co.</doingBusinessAs>\n" +
                "\t<annualCreditCardSalesVolume>10000000</annualCreditCardSalesVolume>\n" +
                "\t<hasAcceptedCreditCards>true</hasAcceptedCreditCards>\n" +
                "\t<principal>\n" +
                "\t\t<principalId>9</principalId>\n" +
                "\t\t<title>CEO</title>\n" +
                "\t\t<emailAddress>jdoe@mail.net</emailAddress>\n" +
                "\t\t<contactPhone>9785551234</contactPhone>\n" +
                "\t\t<address>\n" +
                "\t\t\t<streetAddress1>p street address 1</streetAddress1>\n" +
                "\t\t\t<streetAddress2>p street address 2</streetAddress2>\n" +
                "\t\t\t<city>Boston</city>\n" +
                "\t\t\t<stateProvince>MA</stateProvince>\n" +
                "\t\t\t<postalCode>01890</postalCode>\n" +
                "\t\t\t<countryCode>USA</countryCode>\n" +
                "\t\t</address>\n" +
                "\t\t<backgroundCheckFields>\n" +
                "\t\t\t<firstName>p first</firstName>\n" +
                "\t\t\t<lastName>p last</lastName>\n" +
                "\t\t\t<ssn>123459876</ssn>\n" +
                "\t\t\t<dateOfBirth>1980-10-12</dateOfBirth>\n" +
                "\t\t\t<driversLicense>892327409832</driversLicense>\n" +
                "\t\t\t<driversLicenseState>MA</driversLicenseState>\n" +
                "\t\t</backgroundCheckFields>\n" +
                "\t</principal>\n" +
                "\t<backgroundCheckFields>\n" +
                "\t\t<legalEntityName>Company Name</legalEntityName>\n" +
                "\t\t<legalEntityType>INDIVIDUAL_SOLE_PROPRIETORSHIP</legalEntityType>\n" +
                "\t\t<taxId>123456789</taxId>\n" +
                "\t</backgroundCheckFields>\n" +
                "\t<legalEntityOwnershipType>PUBLIC</legalEntityOwnershipType>\n" +
                "\t<yearsInBusiness>10</yearsInBusiness>\n" +
                "</legalEntityUpdateRequest>";
        String response = communication.httpPutRequest(xmlRequest,"https://www.testvantivcnp.com/sandbox/payfac/legalentity/1000293");
        LegalEntityResponse legalEntityResponse = XMLConverters.generateLegalEntityResponse(response);
        assertNotNull(legalEntityResponse.getTransactionId());
        assertEquals("1000293",legalEntityResponse.getLegalEntityId());
        assertEquals((short)10,(short)legalEntityResponse.getResponseCode());
    }

    @Test
    public void testHttpPostRequest(){
        String xmlRequest = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
                "<legalEntityCreateRequest xmlns=\"http://payfac.vantivcnp.com/api/merchant/onboard\">\n" +
                "<legalEntityName>Legal Entity Name</legalEntityName>\n" +
                "<legalEntityType>CORPORATION</legalEntityType>\n" +
                "<legalEntityOwnershipType>PUBLIC</legalEntityOwnershipType>\n" +
                "<doingBusinessAs>Alternate Business Name</doingBusinessAs>\n" +
                "<taxId>123456789</taxId>\n" +
                "<contactPhone>7817659800</contactPhone>\n" +
                "<annualCreditCardSalesVolume>80000000</annualCreditCardSalesVolume>\n" +
                "<hasAcceptedCreditCards>true</hasAcceptedCreditCards>\n" +
                "<address>\n" +
                "\t<streetAddress1>Street Address 1</streetAddress1>\n" +
                "\t<streetAddress2>Street Address 2</streetAddress2>\n" +
                "\t<city>City</city>\n" +
                "\t<stateProvince>MA</stateProvince>\n" +
                "\t<postalCode>01730</postalCode>\n" +
                "\t<countryCode>USA</countryCode>\n" +
                "</address>\n" +
                "<principal>\n" +
                "\t\t<title>Chief Financial Officer</title>\n" +
                "\t<firstName>p first</firstName>\n" +
                "\t<lastName>p last</lastName>\n" +
                "\t<emailAddress>emailAddress</emailAddress>\n" +
                "\t<ssn>123459876</ssn>\n" +
                "\t<contactPhone>7817659800</contactPhone>\n" +
                "\t<dateOfBirth>1980-10-12</dateOfBirth>\n" +
                "\t<driversLicense>892327409832</driversLicense>\n" +
                "\t<driversLicenseState>MA</driversLicenseState>\n" +
                "\t<address>\n" +
                "\t\t<streetAddress1>p street address 1</streetAddress1>\n" +
                "\t\t<streetAddress2>p street address 2</streetAddress2>\n" +
                "\t\t<city>Boston</city>\n" +
                "\t\t<stateProvince>MA</stateProvince>\n" +
                "\t\t<postalCode>01890</postalCode>\n" +
                "\t\t<countryCode>USA</countryCode>\n" +
                "\t</address>\n" +
                "\t<stakePercent>33</stakePercent>\n" +
                "</principal>\n" +
                "<yearsInBusiness>12</yearsInBusiness>\n" +
                "</legalEntityCreateRequest>";
        String response = communication.httpPostRequest(xmlRequest,"https://www.testvantivcnp.com/sandbox/payfac/legalentity");
        LegalEntityCreateResponse legalEntityCreateResponse = XMLConverters.generateCreateResponse(response);
        assertNotNull(legalEntityCreateResponse.getTransactionId());
        assertNotNull(legalEntityCreateResponse.getLegalEntityId());
        assertEquals((short)10,(short)legalEntityCreateResponse.getResponseCode());
    }

    @Test
    public void testHttpDeleteRequest(){
        String response = communication.httpDeleteRequest("https://www.testvantivcnp.com/sandbox/payfac/legalentity/2018/principal/9");
        PrincipalDeleteResponse principalDeleteResponse = XMLConverters.generatePrincipalDeleteResponse(response);
        assertNotNull(principalDeleteResponse.getTransactionId());
        assertEquals("2018",principalDeleteResponse.getLegalEntityId());
        assertEquals((long)9,(long)principalDeleteResponse.getPrincipalId());
        assertEquals("Legal Entity Principal successfully deleted",principalDeleteResponse.getResponseDescription());

    }
}
