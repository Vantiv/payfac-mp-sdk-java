package com.mp.sdk.unitTest;

import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.matches;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.mp.sdk.AddressUpdatable;
import com.mp.sdk.Communication;
import com.mp.sdk.PayFacSubMerchant;
import com.mp.sdk.Response;
import com.mp.sdk.SubMerchantCreateRequest;
import com.mp.sdk.SubMerchantCreateResponse;
import com.mp.sdk.SubMerchantECheckFeature;
import com.mp.sdk.SubMerchantPrimaryContactUpdatable;
import com.mp.sdk.SubMerchantRetrievalResponse;
import com.mp.sdk.SubMerchantUpdateRequest;

public class TestPayFacSubMerchant {
    PayFacSubMerchant payFacSubMerchant;
    SubMerchantCreateRequest request;
    String name;
    String url;
    String customerServiceNumber;
    String hardCodedBillingDescriptor;
    long maxTransactionAmount;
    String merchantCategoryCOde;
    String bankRoutingNumber;
    String bankAccountNumber;
    String pspMerchantId;
    String settlementCurrency;
    SubMerchantUpdateRequest updateRequest;
    AddressUpdatable address;
    SubMerchantPrimaryContactUpdatable primaryContactUpdatable;
    SubMerchantECheckFeature eCheckFeature;

    @Before
    public void setUp(){
        payFacSubMerchant = new PayFacSubMerchant();

        name = "name";
        url = "url";
        customerServiceNumber = "11";
        hardCodedBillingDescriptor = "aaa";
        maxTransactionAmount = 123;
        merchantCategoryCOde = "2";
        bankRoutingNumber = "123";
        bankAccountNumber = "1234";
        pspMerchantId = "112";
        settlementCurrency = "123";
        request = new SubMerchantCreateRequest();
        request.setMerchantName(name);
        request.setUrl(url);
        request.setCustomerServiceNumber(customerServiceNumber);
        request.setHardCodedBillingDescriptor(hardCodedBillingDescriptor);
        request.setMaxTransactionAmount(maxTransactionAmount);
        request.setMerchantCategoryCode(merchantCategoryCOde);
        request.setBankRoutingNumber(bankRoutingNumber);
        request.setBankAccountNumber(bankAccountNumber);
        request.setPspMerchantId(pspMerchantId);
        request.setSettlementCurrency(settlementCurrency);

        address = new AddressUpdatable();
        address.setStreetAddress1("Street Address 1");
        address.setStreetAddress2("Street Address 2");
        address.setCity("City");
        address.setStateProvince("MA");
        address.setPostalCode("01970");

        primaryContactUpdatable = new SubMerchantPrimaryContactUpdatable();
        primaryContactUpdatable.setFirstName("John");
        primaryContactUpdatable.setLastName("Doe");
        primaryContactUpdatable.setPhone("9785552222");

        eCheckFeature = new SubMerchantECheckFeature();
        eCheckFeature.setECheckBillingDescriptor("9785552222");
        updateRequest = new SubMerchantUpdateRequest();
        updateRequest.setAmexMid("1234567890");
        updateRequest.setDiscoverConveyedMid("123456789012345");
        updateRequest.setUrl("http://merchantUrl");
        updateRequest.setCustomerServiceNumber("8407809000");
        updateRequest.setHardCodedBillingDescriptor("Descriptor");
        updateRequest.setMaxTransactionAmount(8400l);
        updateRequest.setBankRoutingNumber("840123124");
        updateRequest.setBankAccountNumber("84012312415");
        updateRequest.setPspMerchantId("785412365");
        updateRequest.setPurchaseCurrency("USD");
        updateRequest.setAddress(address);
        updateRequest.setPrimaryContact(primaryContactUpdatable);
        updateRequest.setECheck(eCheckFeature);
    }

    @Test
    public void testGetBySubMerchantId(){
        String expectedRequestUrl = "https://www.testvantivcnp.com/sandbox/payfac/legalentity/2018/submerchant/123456";
        String mockedResponse = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
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
        Communication mockedCommunication = Mockito.mock(Communication.class);
        when(mockedCommunication.httpGetRequest(matches(expectedRequestUrl))).thenReturn(mockedResponse);
        SubMerchantRetrievalResponse response = payFacSubMerchant.getBySubMerchantId(2018,123456);
        assertNotNull(response.getTransactionId());
    }

    @Test
    public void testPostSubMerchant(){
        String expectedRequestUrl = "https://www.testvantivcnp.com/sandbox/payfac/legalentity/2018/submerchanta";
        String expectedRequest ="<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
                "<subMerchantCreateRequest\n" +
                "\txmlns=\"http://payfac.vantivcnp.com/api/merchant/onboard\">\n" +
                "\t<merchantName>Merchant Name</merchantName>\n" +
                "\t<amexMid>1234567890</amexMid>\n" +
                "\t<discoverConveyedMid>123456789012345</discoverConveyedMid>\n" +
                "\t<url>http://merchantUrl</url>\n" +
                "\t<customerServiceNumber>8407809000</customerServiceNumber>\n" +
                "\t<hardCodedBillingDescriptor>billing\n" +
                "Descriptor</hardCodedBillingDescriptor>\n" +
                "\t<maxTransactionAmount>8400</maxTransactionAmount>\n" +
                "\t<purchaseCurrency>USD</purchaseCurrency>\n" +
                "\t<merchantCategoryCode>5964</merchantCategoryCode>\n" +
                "\t<bankRoutingNumber>840123124</bankRoutingNumber>\n" +
                "\t<bankAccountNumber>84012312415</bankAccountNumber>\n" +
                "\t<pspMerchantId>123456</pspMerchantId>\n" +
                "\t<fraud enabled=\"true\"></fraud>\n" +
                "\t<amexAcquired enabled=\"false\"></amexAcquired>\n" +
                "\t<address>\n" +
                "\t\t<streetAddress1>Street Address 1</streetAddress1>\n" +
                "\t\t<streetAddress2>Street Address 2</streetAddress2>\n" +
                "\t\t<city>City</city>\n" +
                "\t\t<stateProvince>MA</stateProvince>\n" +
                "\t\t<postalCode>01970</postalCode>\n" +
                "\t\t<countryCode>USA</countryCode>\n" +
                "\t</address>\n" +
                "\t<primaryContact>\n" +
                "\t\t<firstName>John</firstName>\n" +
                "\t\t<lastName>Doe</lastName>\n" +
                "\t\t<emailAddress>John.Doe@company.com</emailAddress>\n" +
                "\t\t<phone>9785552222</phone>\n" +
                "\t</primaryContact>\n" +
                "\t<createCredentials>true</createCredentials>\n" +
                "\t<eCheck enabled=\"true\">\n" +
                "\t\t<eCheckCompanyName>Company Name</eCheckCompanyName>\n" +
                "\t\t<eCheckBillingDescriptor>9785552222</eCheckBillingDescriptor>\n" +
                "\t</eCheck>\n" +
                "\t<subMerchantFunding enabled=\"false\"></subMerchantFunding>\n" +
                "\t<settlementCurrency>USD</settlementCurrency>\n" +
                "</subMerchantCreateRequest>";
        String mockedResponse = "<subMerchantCreateResponse\n" +
                "\txmlns=\"http://payfac.vantivcnp.com/api/merchant/onboard\" duplicate=\"true\">\n" +
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
        Communication mockedCommunication = Mockito.mock(Communication.class);
        when(mockedCommunication.httpPostRequest(matches(expectedRequest),matches(expectedRequestUrl))).thenReturn(mockedResponse);
        SubMerchantCreateResponse response = payFacSubMerchant.postSubMerchant(2018,request);
        assertNotNull(response.getTransactionId());
    }

    @Test
    public void testPostSubMerchantWithDuplicateAll(){
        String expectedRequestUrl = "https://www.testvantivcnp.com/sandbox/payfac/legalentity/2018/submerchanta";
        String expectedRequest ="<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
                "<subMerchantCreateRequest\n" +
                "\txmlns=\"http://payfac.vantivcnp.com/api/merchant/onboard\">\n" +
                "\t<merchantName>duplicate all matching</merchantName>\n" +
                "\t<amexMid>1234567890</amexMid>\n" +
                "\t<discoverConveyedMid>123456789012345</discoverConveyedMid>\n" +
                "\t<url>http://merchantUrl</url>\n" +
                "\t<customerServiceNumber>8407809000</customerServiceNumber>\n" +
                "\t<hardCodedBillingDescriptor>billing\n" +
                "Descriptor</hardCodedBillingDescriptor>\n" +
                "\t<maxTransactionAmount>8400</maxTransactionAmount>\n" +
                "\t<purchaseCurrency>USD</purchaseCurrency>\n" +
                "\t<merchantCategoryCode>5964</merchantCategoryCode>\n" +
                "\t<bankRoutingNumber>840123124</bankRoutingNumber>\n" +
                "\t<bankAccountNumber>84012312415</bankAccountNumber>\n" +
                "\t<pspMerchantId>123456</pspMerchantId>\n" +
                "\t<fraud enabled=\"true\"></fraud>\n" +
                "\t<amexAcquired enabled=\"false\"></amexAcquired>\n" +
                "\t<address>\n" +
                "\t\t<streetAddress1>Street Address 1</streetAddress1>\n" +
                "\t\t<streetAddress2>Street Address 2</streetAddress2>\n" +
                "\t\t<city>City</city>\n" +
                "\t\t<stateProvince>MA</stateProvince>\n" +
                "\t\t<postalCode>01970</postalCode>\n" +
                "\t\t<countryCode>USA</countryCode>\n" +
                "\t</address>\n" +
                "\t<primaryContact>\n" +
                "\t\t<firstName>John</firstName>\n" +
                "\t\t<lastName>Doe</lastName>\n" +
                "\t\t<emailAddress>John.Doe@company.com</emailAddress>\n" +
                "\t\t<phone>9785552222</phone>\n" +
                "\t</primaryContact>\n" +
                "\t<createCredentials>true</createCredentials>\n" +
                "\t<eCheck enabled=\"true\">\n" +
                "\t\t<eCheckCompanyName>Company Name</eCheckCompanyName>\n" +
                "\t\t<eCheckBillingDescriptor>9785552222</eCheckBillingDescriptor>\n" +
                "\t</eCheck>\n" +
                "\t<subMerchantFunding enabled=\"false\"></subMerchantFunding>\n" +
                "\t<settlementCurrency>USD</settlementCurrency>\n" +
                "</subMerchantCreateRequest>";
        String mockedResponse = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
                "<subMerchantCreateResponse\n" +
                "\txmlns=\"http://payfac.vantivcnp.com/api/merchant/onboard\" duplicate=\"true\">\n" +
                "\t<transactionId>82821240469914003</transactionId>\n" +
                "\t<subMerchantId>1100003</subMerchantId>\n" +
                "\t<merchantIdentString>01100003</merchantIdentString>\n" +
                "</subMerchantCreateResponse>";
        Communication mockedCommunication = Mockito.mock(Communication.class);
        when(mockedCommunication.httpPostRequest(matches(expectedRequest),matches(expectedRequestUrl))).thenReturn(mockedResponse);
        SubMerchantCreateResponse response = payFacSubMerchant.postSubMerchantWithDuplicateAll(2018,request);
        assertNotNull(response.getTransactionId());
    }

    @Test
    public void testPostSubMerchantWithDuplicateNotAll(){
        String expectedRequestUrl = "https://www.testvantivcnp.com/sandbox/payfac/legalentity/2018/submerchanta";
        String expectedRequest ="<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
                "<subMerchantCreateRequest\n" +
                "\txmlns=\"http://payfac.vantivcnp.com/api/merchant/onboard\">\n" +
                "\t<merchantName>duplicate not matching</merchantName>\n" +
                "\t<amexMid>1234567890</amexMid>\n" +
                "\t<discoverConveyedMid>123456789012345</discoverConveyedMid>\n" +
                "\t<url>http://merchantUrl</url>\n" +
                "\t<customerServiceNumber>8407809000</customerServiceNumber>\n" +
                "\t<hardCodedBillingDescriptor>billing\n" +
                "Descriptor</hardCodedBillingDescriptor>\n" +
                "\t<maxTransactionAmount>8400</maxTransactionAmount>\n" +
                "\t<purchaseCurrency>USD</purchaseCurrency>\n" +
                "\t<merchantCategoryCode>5964</merchantCategoryCode>\n" +
                "\t<bankRoutingNumber>840123124</bankRoutingNumber>\n" +
                "\t<bankAccountNumber>84012312415</bankAccountNumber>\n" +
                "\t<pspMerchantId>123456</pspMerchantId>\n" +
                "\t<fraud enabled=\"true\"></fraud>\n" +
                "\t<amexAcquired enabled=\"false\"></amexAcquired>\n" +
                "\t<address>\n" +
                "\t\t<streetAddress1>Street Address 1</streetAddress1>\n" +
                "\t\t<streetAddress2>Street Address 2</streetAddress2>\n" +
                "\t\t<city>City</city>\n" +
                "\t\t<stateProvince>MA</stateProvince>\n" +
                "\t\t<postalCode>01970</postalCode>\n" +
                "\t\t<countryCode>USA</countryCode>\n" +
                "\t</address>\n" +
                "\t<primaryContact>\n" +
                "\t\t<firstName>John</firstName>\n" +
                "\t\t<lastName>Doe</lastName>\n" +
                "\t\t<emailAddress>John.Doe@company.com</emailAddress>\n" +
                "\t\t<phone>9785552222</phone>\n" +
                "\t</primaryContact>\n" +
                "\t<createCredentials>true</createCredentials>\n" +
                "\t<eCheck enabled=\"true\">\n" +
                "\t\t<eCheckCompanyName>Company Name</eCheckCompanyName>\n" +
                "\t\t<eCheckBillingDescriptor>9785552222</eCheckBillingDescriptor>\n" +
                "\t</eCheck>\n" +
                "\t<subMerchantFunding enabled=\"false\"></subMerchantFunding>\n" +
                "\t<settlementCurrency>USD</settlementCurrency>\n" +
                "</subMerchantCreateRequest>";
        String mockedResponse = "<subMerchantCreateResponse\n" +
                "\txmlns=\"http://payfac.vantivcnp.com/api/merchant/onboard\" duplicate=\"true\">\n" +
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
        Communication mockedCommunication = Mockito.mock(Communication.class);
        when(mockedCommunication.httpPostRequest(matches(expectedRequest),matches(expectedRequestUrl))).thenReturn(mockedResponse);
        SubMerchantCreateResponse response = payFacSubMerchant.postSubMerchantWithDuplicateNotAll(2018,request);
        assertNotNull(response.getTransactionId());
    }

    @Test
    public void testPutBySubMerchantId(){
        String expectedRequestUrl = "https://www.testvantivcnp.com/sandbox/payfac/legalentity/2018/submerchant/123456";
        String expectedRequest ="<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
                "<subMerchantUpdateRequest\n" +
                "\txmlns=\"http://payfac.vantivcnp.com/api/merchant/onboard\">\n" +
                "\t<amexMid>1234567890</amexMid>\n" +
                "\t<discoverConveyedMid>123456789012345</discoverConveyedMid>\n" +
                "\t<url>http://merchantUrl</url>\n" +
                "\t<customerServiceNumber>8407809000</customerServiceNumber>\n" +
                "\t<hardCodedBillingDescriptor>Descriptor</hardCodedBillingDescriptor>\n" +
                "\t<maxTransactionAmount>8400</maxTransactionAmount>\n" +
                "\t<bankRoutingNumber>840123124</bankRoutingNumber>\n" +
                "\t<bankAccountNumber>84012312415</bankAccountNumber>\n" +
                "\t<pspMerchantId>785412365</pspMerchantId>\n" +
                "\t<purchaseCurrency>USD</purchaseCurrency>\n" +
                "\t<address>\n" +
                "\t\t<streetAddress1>Street Address 1</streetAddress1>\n" +
                "\t\t<streetAddress2>Street Address 2</streetAddress2>\n" +
                "\t\t<city>City</city>\n" +
                "\t\t<stateProvince>MA</stateProvince>\n" +
                "\t\t<postalCode>01970</postalCode>\n" +
                "\t</address>\n" +
                "\t<primaryContact>\n" +
                "\t\t<firstName>John</firstName>\n" +
                "\t\t<lastName>Doe</lastName>\n" +
                "\t\t<phone>9785552222</phone>\n" +
                "\t</primaryContact>\n" +
                "\t<fraud enabled=\"true\"></fraud>\n" +
                "\t<amexAcquired enabled=\"true\"></amexAcquired>\n" +
                "\t<eCheck enabled=\"true\">\n" +
                "\t\t<eCheckBillingDescriptor>9785552222</eCheckBillingDescriptor>\n" +
                "\t</eCheck>\n" +
                "</subMerchantUpdateRequest>";
        String mockedResponse = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
                "<response xmlns=\"http://payfac.vantivcnp.com/api/merchant/onboard\">\n" +
                "    <transactionId>8366905079</transactionId>\n" +
                "</response>";
        Communication mockedCommunication = Mockito.mock(Communication.class);
        when(mockedCommunication.httpPutRequest(matches(expectedRequest),matches(expectedRequestUrl))).thenReturn(mockedResponse);
        Response response = payFacSubMerchant.putBySubMerchantId(2018,123456,updateRequest);
        assertNotNull(response.getTransactionId());
    }
}
