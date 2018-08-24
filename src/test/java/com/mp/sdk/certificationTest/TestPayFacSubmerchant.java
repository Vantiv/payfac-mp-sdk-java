//package com.mp.sdk.certificationTest;
//
//import java.util.Properties;
//
//import org.junit.Before;
//import org.junit.Test;
//import static org.junit.Assert.*;
//
//import com.mp.sdk.Address;
//import com.mp.sdk.AddressUpdatable;
//import com.mp.sdk.Configuration;
//import com.mp.sdk.PayFacSubMerchant;
//import com.mp.sdk.SubMerchantCreateRequest;
//import com.mp.sdk.SubMerchantCreateResponse;
//import com.mp.sdk.SubMerchantECheckFeature;
//import com.mp.sdk.SubMerchantPrimaryContactUpdatable;
//import com.mp.sdk.SubMerchantUpdateRequest;
//
//public class TestPayFacSubmerchant {
//    private PayFacSubMerchant payFacSubMerchant;
//    private Configuration configuration;
//    private Properties config;
//    private SubMerchantCreateRequest createRequest;
//    private String name;
//    private String url;
//    private String customerServiceNumber;
//    private String hardCodedBillingDescriptor;
//    private long maxTransactionAmount;
//    private String merchantCategoryCOde;
//    private String bankRoutingNumber;
//    private String bankAccountNumber;
//    private String pspMerchantId;
//    private String settlementCurrency;
//    private SubMerchantUpdateRequest updateRequest;
//    private Address address;
//    private AddressUpdatable addressUpdatable;
//    private SubMerchantPrimaryContactUpdatable primaryContactUpdatable;
//    private SubMerchantECheckFeature eCheckFeature;
//
//    private String submerchantIdForTest8;
//    private String submerchantIdForTestC4_1;
//
//    @Before
//    public void setUp() {
//        configuration = new Configuration();
//        config = configuration.getProperties();
//        config.setProperty("url", "https://payfac.vantivprelive.com");
//        config.setProperty("username","");
//        config.setProperty("password","");
//        payFacSubMerchant = new PayFacSubMerchant(config);
//        createRequest = new SubMerchantCreateRequest();
//        updateRequest = new SubMerchantUpdateRequest();
//
//        name = "name";
//        url = "url";
//        customerServiceNumber = "11";
//        hardCodedBillingDescriptor = "aaa";
//        maxTransactionAmount = 123;
//        merchantCategoryCOde = "2";
//        bankRoutingNumber = "123";
//        bankAccountNumber = "1234";
//        pspMerchantId = "112";
//        settlementCurrency = "123";
//
//        address = new Address();
//
//        createRequest.setMerchantName(name);
//        createRequest.setUrl(url);
//        createRequest.setCustomerServiceNumber(customerServiceNumber);
//        createRequest.setHardCodedBillingDescriptor(hardCodedBillingDescriptor);
//        createRequest.setMaxTransactionAmount(maxTransactionAmount);
//        createRequest.setMerchantCategoryCode(merchantCategoryCOde);
//        createRequest.setBankRoutingNumber(bankRoutingNumber);
//        createRequest.setBankAccountNumber(bankAccountNumber);
//        createRequest.setPspMerchantId(pspMerchantId);
//        createRequest.setSettlementCurrency(settlementCurrency);
//        createRequest.setAddress(address);
//
//        addressUpdatable = new AddressUpdatable();
//        addressUpdatable.setStreetAddress1("Street Address 1");
//        addressUpdatable.setStreetAddress2("Street Address 2");
//        addressUpdatable.setCity("City");
//        addressUpdatable.setStateProvince("MA");
//        addressUpdatable.setPostalCode("01970");
//
//        primaryContactUpdatable = new SubMerchantPrimaryContactUpdatable();
//        primaryContactUpdatable.setFirstName("John");
//        primaryContactUpdatable.setLastName("Doe");
//        primaryContactUpdatable.setPhone("9785552222");
//
//        eCheckFeature = new SubMerchantECheckFeature();
//        eCheckFeature.setECheckBillingDescriptor("9785552222");
//
//        updateRequest.setAmexMid("1234567890");
//        updateRequest.setDiscoverConveyedMid("123456789012345");
//        updateRequest.setUrl("http://merchantUrl");
//        updateRequest.setCustomerServiceNumber("8407809000");
//        updateRequest.setHardCodedBillingDescriptor("Descriptor");
//        updateRequest.setMaxTransactionAmount(8400l);
//        updateRequest.setBankRoutingNumber("840123124");
//        updateRequest.setBankAccountNumber("84012312415");
//        updateRequest.setPspMerchantId("785412365");
//        updateRequest.setPurchaseCurrency(null);
//        updateRequest.setAddress(addressUpdatable);
//        updateRequest.setPrimaryContact(primaryContactUpdatable);
//        updateRequest.setECheck(eCheckFeature);
//
//    }
//
//    @Test
//    public void test8() {
//        SubMerchantCreateResponse response = payFacSubMerchant.postSubMerchant(Long.parseLong(TestCertBase.legalEntityIdForTest1), createRequest);
//        submerchantIdForTest8 = response.getSubMerchantId();
//    }
//
//    @Test
//    public void test9() {
//        try {
//            payFacSubMerchant.postSubMerchant(0, createRequest);
//        }
//        catch (Exception ex) {
//            assertEquals("Error in request: Could not find requested object.", ex.getMessage());
//        }
//    }
//
//    @Test
//    public void test10() {
//        try {
//            payFacSubMerchant.postSubMerchant(Long.parseLong(TestCertBase.legalEntityIdForTest2), createRequest);
//        }
//        catch (Exception ex) {
//            assertEquals("Error in request: Legal entity [legalEntityName] is in inactive state. You cannot add/update a submerchant.", ex.getMessage());
//        }
//    }
//
//    @Test
//    public void testC4_1() {
//        SubMerchantCreateResponse response = payFacSubMerchant.postSubMerchant(Long.parseLong(TestCertBase.legalEntityIdForTestC1_1), createRequest);
//        submerchantIdForTestC4_1 = response.getSubMerchantId();
//    }
//
//    @Test
//    public void test4_2() {
//        createRequest.setPurchaseCurrency("USD");
//        createRequest.setSettlementCurrency("CAD");
//        try {
//            payFacSubMerchant.postSubMerchant(Long.parseLong(TestCertBase.legalEntityIdForTestC1_1), createRequest);
//        }
//        catch (Exception ex) {
//            assertEquals("Error in request: No processing group defined with purchaseCurrencyCode <840> and settlementCurrencyCode <124>", ex
//                    .getMessage());
//        }
//    }
//
//    @Test
//    public void testC4_3() {
//        address.setCountryCode("USA");
//        createRequest.setAddress(address);
//        try {
//            payFacSubMerchant.postSubMerchant(Long.parseLong(TestCertBase.legalEntityIdForTestC1_1), createRequest);
//        }
//        catch (Exception ex) {
//            assertEquals("Error in request: Submerchant country code “USA” does not match Legal Entity country code “CAN”", ex
//                    .getMessage());
//        }
//    }
//
//    @Test
//    public void testC4_4() {
//        try {
//            payFacSubMerchant.postSubMerchant(Long.parseLong(TestCertBase.legalEntityIdForTestC1_3), createRequest);
//        }
//        catch (Exception ex) {
//            assertEquals("Error in request: Legal Entity “Legal Entity Name” has not been approved", ex
//                    .getMessage());
//        }
//    }
//
//    @Test
//    public void testC4_5() {
//        address.setPostalCode("01970");
//        createRequest.setAddress(address);
//        try {
//            payFacSubMerchant.postSubMerchant(Long.parseLong(TestCertBase.legalEntityIdForTestC1_1), createRequest);
//        }
//        catch (Exception ex) {
//            assertEquals("Postal Code “01970” is not valid for country “CAN”.", ex
//                    .getMessage());
//        }
//    }
//
//    @Test
//    public void test11() {
//        payFacSubMerchant.putBySubMerchantId(Long.parseLong(TestCertBase.legalEntityIdForTest1), Long.parseLong(submerchantIdForTest8), updateRequest);
//    }
//
//    @Test
//    public void test12() {
//
//        try {
//            payFacSubMerchant.putBySubMerchantId(0, Long.parseLong(submerchantIdForTest8), updateRequest);
//        }
//        catch (Exception ex) {
//            assertEquals("Error in request: Could not find requested object.", ex
//                    .getMessage());
//        }
//    }
//
//    @Test
//    public void test13() {
//
//        try {
//            payFacSubMerchant.putBySubMerchantId(Long.parseLong(TestCertBase.legalEntityIdForTest1), 0, updateRequest);
//        }
//        catch (Exception ex) {
//            assertEquals("Error in request: Could not find requested object.", ex
//                    .getMessage());
//        }
//    }
//
//    @Test
//    public void testC5_1() {
//        payFacSubMerchant.putBySubMerchantId(Long.parseLong(TestCertBase.legalEntityIdForTestC1_1), Long.parseLong(submerchantIdForTestC4_1), updateRequest);
//    }
//
//    @Test
//    public void testC5_2() {
//
//        try {
//            payFacSubMerchant.putBySubMerchantId(0, 0, updateRequest);
//        }
//        catch (Exception ex) {
//            assertEquals("Error in request: Could not find requested object.", ex
//                    .getMessage());
//        }
//    }
//
//    @Test
//    public void testC5_3() {
//
//        try {
//            payFacSubMerchant.putBySubMerchantId(Long.parseLong(TestCertBase.legalEntityIdForTestC1_1), 0, updateRequest);
//        }
//        catch (Exception ex) {
//            assertEquals("Error in request: Could not find requested object.", ex
//                    .getMessage());
//        }
//    }
//
//    @Test
//    public void test14(){
//        payFacSubMerchant.getBySubMerchantId(Long.parseLong(TestCertBase.legalEntityIdForTest1),Long.parseLong(submerchantIdForTest8));
//    }
//
//
//    @Test
//    public void test15(){
//        try{
//            payFacSubMerchant.getBySubMerchantId(0,Long.parseLong(submerchantIdForTest8));
//        }catch (Exception ex) {
//            assertEquals("Error in request: Could not find requested object.", ex
//                    .getMessage());
//        }
//    }
//    @Test
//    public void test16(){
//        try{
//            payFacSubMerchant.getBySubMerchantId(Long.parseLong(TestCertBase.legalEntityIdForTest1),0);
//        }catch (Exception ex) {
//            assertEquals("Error in request: Could not find requested object.", ex
//                    .getMessage());
//        }
//    }
//
//    @Test
//    public void test14_2(){
//        payFacSubMerchant.getBySubMerchantId(Long.parseLong(TestCertBase.legalEntityIdForTestC1_1),Long.parseLong(submerchantIdForTestC4_1));
//    }
//
//}
