package com.mp.sdk.functionalTest;
import com.mp.sdk.Communication;
import com.mp.sdk.Configuration;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.mockito.runners.MockitoJUnitRunner;


import static com.mp.sdk.Communication.getBestProtocol;
import static org.junit.Assert.*;

import java.util.Properties;

@RunWith(MockitoJUnitRunner.class)
public class TestCommunication {
  private Communication communication;
  private Configuration configuration;
  private Properties config;


  @Before
  public void setUp(){
    configuration = new Configuration();
    config = configuration.getProperties();
    communication = new Communication();
  }

  @Test
  public void testHttpGetRequest(){
    communication.httpGetRequest("https://www.testvantivcnp.com/sandbox/payfac/mcc");
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
    communication.httpPutRequest(xmlRequest,"https://www.testvantivcnp.com/sandbox/payfac/legalentity/1000293");
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
    communication.httpPostRequest(xmlRequest,"https://www.testvantivcnp.com/sandbox/payfac/legalentity");
  }

  @Test
  public void testHttpDeleteRequest(){
    communication.httpDeleteRequest("https://www.testvantivcnp.com/sandbox/payfac/legalentity/2018/principal/9");
  }

}