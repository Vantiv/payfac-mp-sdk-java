package com.mp.sdk;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.assertNotNull;

public class TestXMLConverters {

    @Test
    public void testGenerateMccResponse() {
        String xmlResponse = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
                "<approvedMccResponse xmlns=\"http://payfac.vantivcnp.com/api/merchant/onboard\">\n" +
                "    <transactionId>2604414425</transactionId>\n" +
                "    <approvedMccs>\n" +
                "        <approvedMcc>5967</approvedMcc>\n" +
                "        <approvedMcc>5970</approvedMcc>\n" +
                "    </approvedMccs>\n" +
                "</approvedMccResponse>";
        ApprovedMccResponse response = XMLConverters.generateMccResponse(xmlResponse);
        assertNotNull(response);
    }

    @Test
    public void testGenerateAgreementCreateResponse() {
        String xmlResponse = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
                "<legalEntityAgreementCreateResponse xmlns=\"http://payfac.vantivcnp.com/api/merchant/onboard\">\n" +
                "    <transactionId>0238570470</transactionId>\n" +
                "</legalEntityAgreementCreateResponse>";
        LegalEntityAgreementCreateResponse response = XMLConverters.generateAgreementCreateResponse(xmlResponse);
        assertNotNull(response);
    }

    @Test
    public void testGenerateCreateResponse() {
        String xmlResponse = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
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
        LegalEntityCreateResponse response = XMLConverters.generateCreateResponse(xmlResponse);
        assertNotNull(response);
    }

    @Test
    public void testGenerateLegalEntityResponse() {

        String xmlResponse = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
                "<legalEntityResponse xmlns=\"http://payfac.vantivcnp.com/api/merchant/onboard\">\n" +
                "    <transactionId>0963204802</transactionId>\n" +
                "    <legalEntityId>2010</legalEntityId>\n" +
                "    <responseCode>10</responseCode>\n" +
                "    <responseDescription>Approved</responseDescription>\n" +
                "</legalEntityResponse>";

        LegalEntityResponse response = XMLConverters.generateLegalEntityResponse(xmlResponse);
        assertNotNull(response);
    }

    @Test
    public void testGenerateRetrievalResponse() {
        String xmlResponse = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
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

        LegalEntityRetrievalResponse response = XMLConverters.generateRetrievalResponse(xmlResponse);
        assertNotNull(response);
    }

    @Test
    public void testGeneratePrincipalCreateResponse() {
        String xmlResponse = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
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
        PrincipalCreateResponse response = XMLConverters.generatePrincipalCreateResponse(xmlResponse);
        assertNotNull(response);
    }

    @Test
    public void testGeneratePrincipalDeleteResponse() {
        String xmlResponse = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
                "<principalDeleteResponse xmlns=\"http://payfac.vantivcnp.com/api/merchant/onboard\">\n" +
                "    <transactionId>4234049185</transactionId>\n" +
                "    <legalEntityId>2018</legalEntityId>\n" +
                "    <principalId>9</principalId>\n" +
                "    <responseDescription>Legal Entity Principal successfully deleted</responseDescription>\n" +
                "</principalDeleteResponse>";
        PrincipalDeleteResponse response = XMLConverters.generatePrincipalDeleteResponse(xmlResponse);

        assertNotNull(response);
    }

    @Test
    public void testGenerateResponse() {
        String xmlResponse = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
                "<response xmlns=\"http://payfac.vantivcnp.com/api/merchant/onboard\">\n" +
                "    <transactionId>8366905079</transactionId>\n" +
                "</response>";
        Response response = XMLConverters.generateResponse(xmlResponse);
        assertNotNull(response);
    }

    @Test
    public void testGenerateSubMerchantCreateResponse() {
        String xmlResponse = "<subMerchantCreateResponse xmlns=\"http://payfac.vantivcnp.com/api/merchant/onboard\" duplicate=\"true\">\n" +
                "\t<transactionId>82821240469914003</transactionId>\n" +
                "\t<originalSubMerchant>\n" +
                "\t\t<merchantName>Merchant Name</merchantName>\n" +
                "\t\t<amexMid>1234567890</amexMid>\n" +
                "\t\t<discoverConveyedMid>123456789012345</discoverConveyedMid>\n" +
                "\t\t<url>http://merchantUrl</url>\n" +
                "\t\t<customerServiceNumber>8407809000</customerServiceNumber>\n" +
                "\t\t<hardCodedBillingDescriptor>billing Descriptor</hardCodedBillingDescriptor>\n" +
                "\t\t<maxTransactionAmount>8400</maxTransactionAmount>\n" +
                "\t\t<purchaseCurrency>USD</purchaseCurrency>\n" +
                "\t\t<merchantCategoryCode>5964</merchantCategoryCode>\n" +
                "\t\t<bankRoutingNumber>840123124</bankRoutingNumber>\n" +
                "\t\t<bankAccountNumber>84012312415</bankAccountNumber>\n" +
                "\t\t<pspMerchantId>123456</pspMerchantId>\n" +
                "\t\t<address>\n" +
                "\t\t\t<streetAddress1>Street Address 1</streetAddress1>\n" +
                "\t\t\t<streetAddress2>Street Address 2</streetAddress2>\n" +
                "\t\t\t<city>City</city>\n" +
                "\t\t\t<stateProvince>MA</stateProvince>\n" +
                "\t\t\t<postalCode>01970</postalCode>\n" +
                "\t\t\t<countryCode>USA</countryCode>\n" +
                "\t\t</address>\n" +
                "\t\t<primaryContact>\n" +
                "\t\t\t<firstName>John</firstName>\n" +
                "\t\t\t<lastName>Doe</lastName>\n" +
                "\t\t\t<phone>9785552222</phone>\n" +
                "\t\t\t<emailAddress>John.Doe@company.com</emailAddress>\n" +
                "\t\t</primaryContact>\n" +
                "\t\t<subMerchantId>1002</subMerchantId>\n" +
                "\t\t<merchantIdentString>01100002</merchantIdentString>\n" +
                "\t</originalSubMerchant>\n" +
                "</subMerchantCreateResponse>";

        SubMerchantCreateResponse response = XMLConverters.generateSubMerchantCreateResponse(xmlResponse);
        assertNotNull(response);
    }

    @Test
    public void testGenerateSubMerchantRetrievalResponse() {
        String xmlResponse = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
                "<subMerchantRetrievalResponse xmlns=\"http://payfac.vantivcnp.com/api/merchant/onboard\">\n" +
                "    <merchantName>Merchant Name</merchantName>\n" +
                "    <amexMid>1234567890</amexMid>\n" +
                "    <discoverConveyedMid>123456789012345</discoverConveyedMid>\n" +
                "    <url>http://merchantUrl.com</url>\n" +
                "    <customerServiceNumber>8407809000</customerServiceNumber>\n" +
                "    <hardCodedBillingDescriptor>billingDescriptor</hardCodedBillingDescriptor>\n" +
                "    <maxTransactionAmount>100000</maxTransactionAmount>\n" +
                "    <purchaseCurrency>USD</purchaseCurrency>\n" +
                "    <merchantCategoryCode>5964</merchantCategoryCode>\n" +
                "    <bankRoutingNumber>840123124</bankRoutingNumber>\n" +
                "    <bankAccountNumber>XXXXX-3124</bankAccountNumber>\n" +
                "    <pspMerchantId>123456</pspMerchantId>\n" +
                "    <fraud enabled=\"false\" />\n" +
                "    <address>\n" +
                "        <streetAddress1>Street Address 1</streetAddress1>\n" +
                "        <streetAddress2>Street Address 2</streetAddress2>\n" +
                "        <city>City</city>\n" +
                "        <stateProvince>MA</stateProvince>\n" +
                "        <postalCode>01970</postalCode>\n" +
                "        <countryCode>USA</countryCode>\n" +
                "    </address>\n" +
                "    <primaryContact>\n" +
                "        <firstName>John</firstName>\n" +
                "        <lastName>Doe</lastName>\n" +
                "        <emailAddress>John.Doe@company.com</emailAddress>\n" +
                "        <phone>9785552222</phone>\n" +
                "    </primaryContact>\n" +
                "    <eCheck enabled=\"true\">\n" +
                "        <eCheckCompanyName>Company Name</eCheckCompanyName>\n" +
                "        <eCheckBillingDescriptor>9785552222</eCheckBillingDescriptor>\n" +
                "    </eCheck>\n" +
                "    <subMerchantFunding enabled=\"true\">\n" +
                "        <fundingSubmerchantId>12345678901234</fundingSubmerchantId>\n" +
                "    </subMerchantFunding>\n" +
                "    <settlementCurrency>USD</settlementCurrency>\n" +
                "    <subMerchantId>123456</subMerchantId>\n" +
                "    <amexSellerId>12345678901234</amexSellerId>\n" +
                "    <disabled>true</disabled>\n" +
                "    <transactionId>1944734001</transactionId>\n" +
                "    <merchantIdentString>011000022</merchantIdentString>\n" +
                "    <credentials>\n" +
                "        <username>Username</username>\n" +
                "        <password>Password</password>\n" +
                "        <passwordExpirationDate>2017-10-03T11:18:23.127-04:00</passwordExpirationDate>\n" +
                "    </credentials>\n" +
                "    <paypageCredentials>\n" +
                "        <paypageCredential>\n" +
                "            <username>PSPxm1V8</username>\n" +
                "            <paypageId>Asd23thI974Jpk32</paypageId>\n" +
                "        </paypageCredential>\n" +
                "        <paypageCredential>\n" +
                "            <username>PSPxm1V8Two</username>\n" +
                "            <paypageId>odzhgcbQX3e3EaKV</paypageId>\n" +
                "        </paypageCredential>\n" +
                "        <paypageCredential>\n" +
                "            <username>PSPxm1V8Three</username>\n" +
                "            <paypageId>qmnpUBM6G47YJAcq</paypageId>\n" +
                "        </paypageCredential>\n" +
                "    </paypageCredentials>\n" +
                "    <updateDate>2017-09-30T11:18:23.127-04:00</updateDate>\n" +
                "</subMerchantRetrievalResponse>";
        SubMerchantRetrievalResponse response = XMLConverters.generateSubMerchantRetrievalResponse(xmlResponse);
        assertNotNull(response);
    }

    @Test
    public void testGenerateErrorResponse() {
        String xmlResponse = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
                "<errorResponse xmlns=\"http://payfac.vantivcnp.com/api/merchant/onboard\">\n" +
                "    <transactionId>7926469083</transactionId>\n" +
                "    <errors>\n" +
                "        <error>Could not find requested object.</error>\n" +
                "    </errors>\n" +
                "</errorResponse>";

        ErrorResponse response = XMLConverters.generateErrorResponse(xmlResponse);
        assertNotNull(response);
    }

    @Test
    public void testGenerateAgreementCreateRequest() {

        LegalEntityAgreementCreateRequest request = new LegalEntityAgreementCreateRequest();
        LegalEntityAgreement agreement = new LegalEntityAgreement();
        request.setLegalEntityAgreement(agreement);

        String reqString = XMLConverters.generateAgreementCreateRequest(request);
        assertNotNull(reqString);
    }


}
