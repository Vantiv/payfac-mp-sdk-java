package com.mp.sdk.unitTest;

import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.matches;
import static org.mockito.Mockito.when;

import java.util.Calendar;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.mp.sdk.Address;
import com.mp.sdk.AddressUpdatable;
import com.mp.sdk.Communication;
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
import com.mp.sdk.XMLConverters;

public class TestPayFacLegalEntity {
    PayFacLegalEntity payFacLegalEntity;
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
        payFacLegalEntity = new PayFacLegalEntity();

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
    public void testGetByLegalEntityId(){
        String expectedRequestUrl = "https://www.testvantivcnp.com/sandbox/payfac/legalentity/1000293";
        String mockedResponse = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
                "<legalEntityRetrievalResponse xmlns=\"http://payfac.vantivcnp.com/api/merchant/onboard\" overallStatus=\"Approved\">\n" +
                "    <legalEntityName>Legal Entity Name</legalEntityName>\n" +
                "    <legalEntityType>CORPORATION</legalEntityType>\n" +
                "    <legalEntityOwnershipType>PUBLIC</legalEntityOwnershipType>\n" +
                "    <doingBusinessAs>Alternate Name</doingBusinessAs>\n" +
                "    <taxId>123456789</taxId>\n" +
                "    <contactPhone>7817659800</contactPhone>\n" +
                "    <annualCreditCardSalesVolume>80</annualCreditCardSalesVolume>\n" +
                "    <hasAcceptedCreditCards>true</hasAcceptedCreditCards>\n" +
                "    <address>\n" +
                "        <streetAddress1>12 Norton St</streetAddress1>\n" +
                "        <city>City</city>\n" +
                "        <stateProvince>NH</stateProvince>\n" +
                "        <postalCode>03064</postalCode>\n" +
                "        <countryCode>USA</countryCode>\n" +
                "    </address>\n" +
                "    <principal>\n" +
                "        <principalId>1</principalId>\n" +
                "        <title>CEO</title>\n" +
                "        <firstName>p first</firstName>\n" +
                "        <lastName>p last</lastName>\n" +
                "        <emailAddress>emailAddress</emailAddress>\n" +
                "        <ssn>XXXXX-9876</ssn>\n" +
                "        <contactPhone>7817659800</contactPhone>\n" +
                "        <dateOfBirth>1980-10-12</dateOfBirth>\n" +
                "        <driversLicense>XXXXXXXX-9832</driversLicense>\n" +
                "        <driversLicenseState>MA</driversLicenseState>\n" +
                "        <address>\n" +
                "            <streetAddress1>p street address 1</streetAddress1>\n" +
                "            <streetAddress2>p street address 2</streetAddress2>\n" +
                "            <city>Boston</city>\n" +
                "            <stateProvince>MA</stateProvince>\n" +
                "            <postalCode>01890</postalCode>\n" +
                "            <countryCode>USA</countryCode>\n" +
                "        </address>\n" +
                "        <stakePercent>0</stakePercent>\n" +
                "    </principal>\n" +
                "    <legalEntityId>2018</legalEntityId>\n" +
                "    <responseCode>10</responseCode>\n" +
                "    <responseDescription>Approved</responseDescription>\n" +
                "    <backgroundCheckResults>\n" +
                "        <business>\n" +
                "            <verificationResult>\n" +
                "                <overallScore>\n" +
                "                    <score>10</score>\n" +
                "                    <description>Significant contradictory findings</description>\n" +
                "                </overallScore>\n" +
                "                <nameAddressTaxIdAssociation>\n" +
                "                    <code>NAME_OR_ADDRESS</code>\n" +
                "                    <description>The name or the address is verified.</description>\n" +
                "                </nameAddressTaxIdAssociation>\n" +
                "                <nameAddressPhoneAssociation>\n" +
                "                    <code>NAME_ADDRESS_PHONE</code>\n" +
                "                    <description>Name, address, and phone verified.</description>\n" +
                "                </nameAddressPhoneAssociation>\n" +
                "                <verificationIndicators>\n" +
                "                    <nameVerified>true</nameVerified>\n" +
                "                    <addressVerified>true</addressVerified>\n" +
                "                    <cityVerified>true</cityVerified>\n" +
                "                    <stateVerified>true</stateVerified>\n" +
                "                    <zipVerified>true</zipVerified>\n" +
                "                    <phoneVerified>true</phoneVerified>\n" +
                "                    <taxIdVerified>true</taxIdVerified>\n" +
                "                </verificationIndicators>\n" +
                "                <riskIndicators>\n" +
                "                    <riskIndicator>\n" +
                "                        <code>UNKNOWN</code>\n" +
                "                        <description>Supplied information could not be not verified.</description>\n" +
                "                    </riskIndicator>\n" +
                "                </riskIndicators>\n" +
                "            </verificationResult>\n" +
                "        </business>\n" +
                "        <principal>\n" +
                "            <verificationResult>\n" +
                "                <overallScore>\n" +
                "                    <score>10</score>\n" +
                "                    <description>OFAC matches</description>\n" +
                "                </overallScore>\n" +
                "                <nameAddressSsnAssociation>\n" +
                "                    <code>NOTHING</code>\n" +
                "                    <description>Supplied information could not be not verified.</description>\n" +
                "                </nameAddressSsnAssociation>\n" +
                "                <nameAddressPhoneAssociation>\n" +
                "                    <code>WRONG_PHONE</code>\n" +
                "                    <description>Supplied Phone number is wrong.</description>\n" +
                "                </nameAddressPhoneAssociation>\n" +
                "                <verificationIndicators>\n" +
                "                    <nameVerified>true</nameVerified>\n" +
                "                    <addressVerified>true</addressVerified>\n" +
                "                    <phoneVerified>true</phoneVerified>\n" +
                "                    <ssnVerified>true</ssnVerified>\n" +
                "                    <dobVerified>true</dobVerified>\n" +
                "                </verificationIndicators>\n" +
                "                <riskIndicators>\n" +
                "                    <riskIndicator>\n" +
                "                        <code>UNKNOWN</code>\n" +
                "                        <description>Supplied information could not be not verified.</description>\n" +
                "                    </riskIndicator>\n" +
                "                </riskIndicators>\n" +
                "            </verificationResult>\n" +
                "        </principal>\n" +
                "        <businessToPrincipalAssociation>\n" +
                "            <score>10</score>\n" +
                "            <description>Principalâ€™s verified name partially matches input Business name.</description>\n" +
                "        </businessToPrincipalAssociation>\n" +
                "        <backgroundCheckDecisionNotes>Additional Info About Decision</backgroundCheckDecisionNotes>\n" +
                "        <bankruptcyData>\n" +
                "            <bankruptcyType>none</bankruptcyType>\n" +
                "            <bankruptcyCount>1</bankruptcyCount>\n" +
                "            <companyName>Company Name</companyName>\n" +
                "            <streetAddress1>100 Main Street</streetAddress1>\n" +
                "            <streetAddress2>Suite 2</streetAddress2>\n" +
                "            <city>Boston</city>\n" +
                "            <state>MA</state>\n" +
                "            <zip>01150</zip>\n" +
                "            <zip4>2202</zip4>\n" +
                "            <filingDate>2011-05-13</filingDate>\n" +
                "        </bankruptcyData>\n" +
                "        <lienResult>\n" +
                "            <lienType>Subtype of Lien</lienType>\n" +
                "            <releasedCount>2</releasedCount>\n" +
                "            <unreleasedCount>1</unreleasedCount>\n" +
                "            <companyName>Company Name</companyName>\n" +
                "            <streetAddress1>100 Main Street</streetAddress1>\n" +
                "            <streetAddress2>Suite 2</streetAddress2>\n" +
                "            <city>Boston</city>\n" +
                "            <state>MA</state>\n" +
                "            <zip>01150</zip>\n" +
                "            <zip4>2202</zip4>\n" +
                "            <filingDate>2011-05-13</filingDate>\n" +
                "        </lienResult>\n" +
                "    </backgroundCheckResults>\n" +
                "    <transactionId>82820200338801030</transactionId>\n" +
                "    <tinValidationStatus>Approved</tinValidationStatus>\n" +
                "    <sub_merchant_processing_status>true</sub_merchant_processing_status>\n" +
                "</legalEntityRetrievalResponse>";
        Communication mockedCommunication = Mockito.mock(Communication.class);
        when(mockedCommunication.httpGetRequest(matches(expectedRequestUrl))).thenReturn(mockedResponse);
        LegalEntityRetrievalResponse response = payFacLegalEntity.getByLegalEntityId(201003);
        assertNotNull(response.getTransactionId());
    }

    @Test
    public void testPostByLegalEntity(){
        String expectedRequestUrl = "https://www.testvantivcnp.com/sandbox/payfac/legalentity";
        String expectedRequest = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
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
        String mockedResponse = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
                "<legalEntityCreateResponse xmlns=\"http://payfac.vantivcnp.com/api/merchant/onboard\">\n" +
                "    <transactionId>9671076910</transactionId>\n" +
                "    <legalEntityId>02013</legalEntityId>\n" +
                "    <responseCode>10</responseCode>\n" +
                "    <responseDescription>Approved</responseDescription>\n" +
                "    <backgroundCheckResults>\n" +
                "        <business>\n" +
                "            <verificationResult>\n" +
                "                <overallScore>\n" +
                "                    <score>40</score>\n" +
                "                    <description>Business identity is confirmed at the input address</description>\n" +
                "                </overallScore>\n" +
                "                <nameAddressTaxIdAssociation>\n" +
                "                    <code>NAME_ADDRESS_TAX_ID</code>\n" +
                "                    <description>Name, address, and Tax Id verified.</description>\n" +
                "                </nameAddressTaxIdAssociation>\n" +
                "                <nameAddressPhoneAssociation>\n" +
                "                    <code>NAME_ADDRESS_PHONE</code>\n" +
                "                    <description>Name, address, and phone verified.</description>\n" +
                "                </nameAddressPhoneAssociation>\n" +
                "                <verificationIndicators>\n" +
                "                    <nameVerified>true</nameVerified>\n" +
                "                    <addressVerified>true</addressVerified>\n" +
                "                    <cityVerified>true</cityVerified>\n" +
                "                    <stateVerified>true</stateVerified>\n" +
                "                    <zipVerified>true</zipVerified>\n" +
                "                    <phoneVerified>true</phoneVerified>\n" +
                "                    <taxIdVerified>true</taxIdVerified>\n" +
                "                </verificationIndicators>\n" +
                "                <riskIndicators>\n" +
                "                    <riskIndicator>\n" +
                "                        <code>PHONE_NUMBER_MOBILE</code>\n" +
                "                        <description>The submitted phone number is a mobile number.</description>\n" +
                "                    </riskIndicator>\n" +
                "                    <riskIndicator>\n" +
                "                        <code>PHONE_NUMBER_MOBILE</code>\n" +
                "                        <description>The submitted phone number is a mobile number.</description>\n" +
                "                    </riskIndicator>\n" +
                "                </riskIndicators>\n" +
                "            </verificationResult>\n" +
                "        </business>\n" +
                "        <principal>\n" +
                "            <verificationResult>\n" +
                "                <overallScore>\n" +
                "                    <score>50</score>\n" +
                "                    <description>Full name, address, phone, and SSN verified.</description>\n" +
                "                </overallScore>\n" +
                "                <nameAddressSsnAssociation>\n" +
                "                    <code>FIRST_LAST_ADDRESS_SSN</code>\n" +
                "                    <description>First name, last name, address, and SSN verified.</description>\n" +
                "                </nameAddressSsnAssociation>\n" +
                "                <nameAddressPhoneAssociation>\n" +
                "                    <code>LAST_ADDRESS_PHONE</code>\n" +
                "                    <description>Last name, address, and phone number verified.</description>\n" +
                "                </nameAddressPhoneAssociation>\n" +
                "                <verificationIndicators>\n" +
                "                    <nameVerified>true</nameVerified>\n" +
                "                    <addressVerified>true</addressVerified>\n" +
                "                    <phoneVerified>true</phoneVerified>\n" +
                "                    <ssnVerified>true</ssnVerified>\n" +
                "                    <dobVerified>true</dobVerified>\n" +
                "                </verificationIndicators>\n" +
                "                <riskIndicators>\n" +
                "                    <riskIndicator>\n" +
                "                        <code>PHONE_NUMBER_MOBILE</code>\n" +
                "                        <description>The submitted phone number is a mobile number.</description>\n" +
                "                    </riskIndicator>\n" +
                "                    <riskIndicator>\n" +
                "                        <code>PHONE_NUMBER_MOBILE</code>\n" +
                "                        <description>The submitted phone number is a mobile number.</description>\n" +
                "                    </riskIndicator>\n" +
                "                </riskIndicators>\n" +
                "            </verificationResult>\n" +
                "        </principal>\n" +
                "        <businessToPrincipalAssociation>\n" +
                "            <score>20</score>\n" +
                "            <description>Principal’s verified address matches input Business address.</description>\n" +
                "        </businessToPrincipalAssociation>\n" +
                "        <backgroundCheckDecisionNotes>2TYmo5BCfiB85KtFY4LT</backgroundCheckDecisionNotes>\n" +
                "        <bankruptcyData>\n" +
                "            <bankruptcyType>P81LA</bankruptcyType>\n" +
                "            <bankruptcyCount>0</bankruptcyCount>\n" +
                "            <companyName>Company Name</companyName>\n" +
                "            <streetAddress1>100 Main Street</streetAddress1>\n" +
                "            <streetAddress2>Suite 2</streetAddress2>\n" +
                "            <city>Boston</city>\n" +
                "            <state>MA</state>\n" +
                "            <zip>01150</zip>\n" +
                "            <zip4>2202</zip4>\n" +
                "            <filingDate>2018-07-17</filingDate>\n" +
                "        </bankruptcyData>\n" +
                "        <lienResult>\n" +
                "            <lienType>BKRCIq85xTLZ8mD</lienType>\n" +
                "            <releasedCount>0</releasedCount>\n" +
                "            <unreleasedCount>4</unreleasedCount>\n" +
                "            <companyName>Company Name</companyName>\n" +
                "            <streetAddress1>100 Main Street</streetAddress1>\n" +
                "            <streetAddress2>Suite 2</streetAddress2>\n" +
                "            <city>Boston</city>\n" +
                "            <state>MA</state>\n" +
                "            <zip>01150</zip>\n" +
                "            <zip4>2202</zip4>\n" +
                "            <filingDate>2018-07-17</filingDate>\n" +
                "        </lienResult>\n" +
                "    </backgroundCheckResults>\n" +
                "    <principal>\n" +
                "        <principalId>93497</principalId>\n" +
                "        <firstName>p_first</firstName>\n" +
                "        <lastName>p_last</lastName>\n" +
                "    </principal>\n" +
                "</legalEntityCreateResponse>";
        Communication mockedCommunication = Mockito.mock(Communication.class);
        when(mockedCommunication.httpPostRequest(matches(expectedRequest),matches(expectedRequestUrl))).thenReturn(mockedResponse);
        LegalEntityCreateResponse response = payFacLegalEntity.postByLegalEntity(createRequest);
        assertNotNull(response.getTransactionId());
    }

    @Test
    public void testPutByLegalEntity(){
        String expectedRequestUrl = "https://www.testvantivcnp.com/sandbox/payfac/legalentity/1000293";
        String expectedRequest = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
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
        String mockedResponse = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
                "<legalEntityResponse xmlns=\"http://payfac.vantivcnp.com/api/merchant/onboard\">\n" +
                "    <transactionId>0963204802</transactionId>\n" +
                "    <legalEntityId>2010</legalEntityId>\n" +
                "    <responseCode>10</responseCode>\n" +
                "    <responseDescription>Approved</responseDescription>\n" +
                "</legalEntityResponse>";
        Communication mockedCommunication = Mockito.mock(Communication.class);
        when(mockedCommunication.httpPutRequest(matches(expectedRequest),matches(expectedRequestUrl))).thenReturn(mockedResponse);
        LegalEntityResponse response = payFacLegalEntity.putByLegalEntity(1000293l,updateRequest);
        assertNotNull(response.getTransactionId());
    }
}
