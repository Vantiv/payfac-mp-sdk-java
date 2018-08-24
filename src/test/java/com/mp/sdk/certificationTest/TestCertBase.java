package com.mp.sdk.certificationTest;

import static org.junit.Assert.assertEquals;

import com.mp.sdk.PayFacSubMerchant;
import com.mp.sdk.SubMerchantCreateRequest;
import com.mp.sdk.SubMerchantCreateResponse;
import com.mp.sdk.SubMerchantECheckFeature;
import com.mp.sdk.SubMerchantFunding;
import com.mp.sdk.SubMerchantPrimaryContactUpdatable;
import com.mp.sdk.SubMerchantUpdateRequest;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import java.util.Random;
import com.mp.sdk.Address;
import com.mp.sdk.AddressUpdatable;
import com.mp.sdk.BackgroundCheckResults;
import com.mp.sdk.Configuration;
import com.mp.sdk.LegalEntityBackgroundCheckFields;
import com.mp.sdk.LegalEntityCreateRequest;
import com.mp.sdk.LegalEntityCreateResponse;
import com.mp.sdk.LegalEntityOwnershipType;
import com.mp.sdk.LegalEntityPrincipal;
import com.mp.sdk.LegalEntityPrincipalUpdatable;
import com.mp.sdk.LegalEntityRetrievalResponse;
import com.mp.sdk.LegalEntityType;
import com.mp.sdk.LegalEntityUpdateRequest;
import com.mp.sdk.PayFacLegalEntity;
import com.mp.sdk.PrincipalAddress;

@Ignore
public class TestCertBase {
    private PayFacLegalEntity payFacLegalEntity;
    private PayFacSubMerchant payFacSubMerchant;

    private Configuration configuration;
    private Properties properties;

    private LegalEntityCreateRequest legalEntityCreateRequest;
    private LegalEntityUpdateRequest legalEntityUpdateRequest;
    private SubMerchantCreateRequest submerchantCreateRequest;
    private SubMerchantUpdateRequest subMerchantUpdateRequest;


    private Address address;
    private PrincipalAddress principalAddress;
    private AddressUpdatable addressUpdatable;
    private Address CanadaAddress;

    private Date date = new Date();
    private Calendar calendar;

    private LegalEntityPrincipal principal;
    private LegalEntityPrincipalUpdatable legalEntityPrincipalUpdatable;

    private Random random;

    private String streetAdrss1ForTest1;
    private String streetAdrss1ForTest2;
    private String streetAdrss1ForTest3;
    private String streetAdrss1ForTestC1_1;
    private String streetAdrss1ForTestC1_2;
    private String streetAdrss1ForTestC1_3;
    private BackgroundCheckResults backgroundCheckResultsForTest2;
    private LegalEntityBackgroundCheckFields legalEntityBackgroundCheckFields;

    private String name;
    private String url;
    private String customerServiceNumber;
    private String hardCodedBillingDescriptor;
    private long maxTransactionAmount;
    private String merchantCategoryCode;
    private String bankRoutingNumber;
    private String bankAccountNumber;
    private String pspMerchantId;
    private String settlementCurrency;
    private SubMerchantPrimaryContactUpdatable primaryContactUpdatable;
    private SubMerchantECheckFeature eCheckFeature;




    @Before
    public void setUp(){

        random = new Random();
        configuration = new Configuration();
        properties = configuration.getProperties();
        properties.setProperty("url","https://payfac.vantivprelive.com");
        properties.setProperty("username","");
        properties.setProperty("password","");
        payFacLegalEntity = new PayFacLegalEntity(properties);

        streetAdrss1ForTest1 = "900 Chelmsford St";
        streetAdrss1ForTest2 = "912 Chelmsford St";
        streetAdrss1ForTest3 = "914 Chelmsford St";
        streetAdrss1ForTestC1_1 = "900 Chelmsford St";
        streetAdrss1ForTestC1_2 = "900 Chelmsford St";
        streetAdrss1ForTestC1_3 = "912 Chelmsford St";

        address = new Address();
        address.setStreetAddress1("Street Address 1");
        address.setStreetAddress2("Street Address 2");
        address.setCity("City");
        address.setStateProvince("MA");
        address.setPostalCode("01970");
        address.setCountryCode("USA");

        CanadaAddress = new Address();
        CanadaAddress.setStreetAddress1(null);
        CanadaAddress.setStreetAddress2("Street Address 2");
        CanadaAddress.setCity("City");
        CanadaAddress.setStateProvince("AB");
        CanadaAddress.setPostalCode("K1A0B1");
        CanadaAddress.setCountryCode("CAN");

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
        principal.setStakePercent(100);

        legalEntityCreateRequest = new LegalEntityCreateRequest();
        legalEntityCreateRequest.setLegalEntityName("test legalentity");
        legalEntityCreateRequest.setLegalEntityType(null);
        legalEntityCreateRequest.setTaxId("987654311");
        legalEntityCreateRequest.setAnnualCreditCardSalesVolume("500000");
        legalEntityCreateRequest.setHasAcceptedCreditCards(true);
        legalEntityCreateRequest.setLegalEntityOwnershipType(LegalEntityOwnershipType.PRIVATE);
        legalEntityCreateRequest.setAddress(address);
        legalEntityCreateRequest.setPrincipal(principal);

        addressUpdatable = new AddressUpdatable();
        addressUpdatable.setStreetAddress1("Street Address 1");
        addressUpdatable.setStreetAddress2("Street Address 2");
        addressUpdatable.setCity("City");
        addressUpdatable.setStateProvince("MA");
        addressUpdatable.setPostalCode("01970");
        addressUpdatable.setCountryCode("USA");

        legalEntityPrincipalUpdatable = new LegalEntityPrincipalUpdatable();
        legalEntityPrincipalUpdatable.setTitle("CEO");
        legalEntityPrincipalUpdatable.setPrincipalId(1);
        legalEntityPrincipalUpdatable.setEmailAddress("abc@gmail.com");
        legalEntityPrincipalUpdatable.setContactPhone("11");
        legalEntityPrincipalUpdatable.setAddress(principalAddress);

        legalEntityBackgroundCheckFields = new LegalEntityBackgroundCheckFields();
        legalEntityBackgroundCheckFields.setLegalEntityName("Company Name");
        legalEntityBackgroundCheckFields.setLegalEntityType(LegalEntityType.INDIVIDUAL_SOLE_PROPRIETORSHIP);
        legalEntityBackgroundCheckFields.setTaxId("123456789");


        legalEntityUpdateRequest = new LegalEntityUpdateRequest();
        legalEntityUpdateRequest.setAddress(addressUpdatable);
        legalEntityUpdateRequest.setContactPhone("77");
        legalEntityUpdateRequest.setDoingBusinessAs("Alternate Business Name");
        legalEntityUpdateRequest.setAnnualCreditCardSalesVolume(100000000l);
        legalEntityUpdateRequest.setHasAcceptedCreditCards(true);
        legalEntityUpdateRequest.setPrincipal(legalEntityPrincipalUpdatable);
        legalEntityUpdateRequest.setBackgroundCheckFields(legalEntityBackgroundCheckFields);


        //
        payFacSubMerchant = new PayFacSubMerchant(properties);
        submerchantCreateRequest = new SubMerchantCreateRequest();
        subMerchantUpdateRequest = new SubMerchantUpdateRequest();

        name = "name";
        url = "url";
        customerServiceNumber = "1234567894";
        hardCodedBillingDescriptor = "SDK*";
        maxTransactionAmount = 123;
        merchantCategoryCode = "5137";
        bankRoutingNumber = "211370545";
        bankAccountNumber = "84012312415";
        pspMerchantId = (100 + random.nextInt(900))+"";
        settlementCurrency = "USD";
        eCheckFeature = new SubMerchantECheckFeature();
        eCheckFeature.setECheckBillingDescriptor("9785552222");

        SubMerchantFunding subMerchantFunding = new SubMerchantFunding();
        subMerchantFunding.setFundingSubmerchantId("AUTO_GENERATE");
        subMerchantFunding.setEnabled(true);
        submerchantCreateRequest.setSubMerchantFunding(subMerchantFunding);

        submerchantCreateRequest.setMerchantName(name);
        submerchantCreateRequest.setUrl(url);
        submerchantCreateRequest.setCustomerServiceNumber(customerServiceNumber);
        submerchantCreateRequest.setHardCodedBillingDescriptor(hardCodedBillingDescriptor);
        submerchantCreateRequest.setMaxTransactionAmount(maxTransactionAmount);
        submerchantCreateRequest.setMerchantCategoryCode(merchantCategoryCode);
        submerchantCreateRequest.setBankRoutingNumber(bankRoutingNumber);
        submerchantCreateRequest.setBankAccountNumber(bankAccountNumber);
        submerchantCreateRequest.setPspMerchantId(pspMerchantId);
        submerchantCreateRequest.setSettlementCurrency(settlementCurrency);
        submerchantCreateRequest.setAddress(address);

        primaryContactUpdatable = new SubMerchantPrimaryContactUpdatable();
        primaryContactUpdatable.setFirstName("John");
        primaryContactUpdatable.setLastName("Doe");
        primaryContactUpdatable.setPhone("9785552222");



        subMerchantUpdateRequest.setAmexMid("1234567890");
        subMerchantUpdateRequest.setDiscoverConveyedMid("123456789012345");
        subMerchantUpdateRequest.setUrl("http://merchantUrl");
        subMerchantUpdateRequest.setCustomerServiceNumber("8407809000");
        subMerchantUpdateRequest.setHardCodedBillingDescriptor("SDK*");
        subMerchantUpdateRequest.setMaxTransactionAmount(8400l);
        subMerchantUpdateRequest.setBankRoutingNumber("211370545");
        subMerchantUpdateRequest.setBankAccountNumber("84012312415");
        subMerchantUpdateRequest.setPspMerchantId((100 + random.nextInt(900))+"");
        subMerchantUpdateRequest.setPurchaseCurrency("USD");
        subMerchantUpdateRequest.setAddress(addressUpdatable);
        subMerchantUpdateRequest.setPrimaryContact(primaryContactUpdatable);
    }
    //==========================================================================================
    //                             Legalentity certification Tests
    //==========================================================================================
    @Test
    public void test1(){
        legalEntityCreateRequest.setLegalEntityType(LegalEntityType.INDIVIDUAL_SOLE_PROPRIETORSHIP);
        address.setStreetAddress1(streetAdrss1ForTest1);
        legalEntityCreateRequest.setAddress(address);
        legalEntityCreateRequest.setTaxId((100000000 + random.nextInt(900000000))+"");


        LegalEntityCreateResponse response = payFacLegalEntity.postByLegalEntity(legalEntityCreateRequest);

        assertEquals((short) 10, (short) response.getResponseCode());
        assertEquals("Approved",response.getResponseDescription());

    }

    @Test
    public void test2(){
        legalEntityCreateRequest.setLegalEntityType(LegalEntityType.INDIVIDUAL_SOLE_PROPRIETORSHIP);
        address.setStreetAddress1(streetAdrss1ForTest2);
        legalEntityCreateRequest.setAddress(address);
        legalEntityCreateRequest.setTaxId((100000000 + random.nextInt(900000000))+"");

        LegalEntityCreateResponse response = payFacLegalEntity.postByLegalEntity(legalEntityCreateRequest);
        assertEquals((short) 20, (short) response.getResponseCode());
    }

    // Wait a minimum of two hours after submitting Test #2
    @Test
    public void test2and2a(){
        legalEntityCreateRequest.setLegalEntityType(LegalEntityType.INDIVIDUAL_SOLE_PROPRIETORSHIP);
        address.setStreetAddress1(streetAdrss1ForTest2);
        legalEntityCreateRequest.setAddress(address);
        legalEntityCreateRequest.setTaxId((100000000 + random.nextInt(900000000))+"");
        LegalEntityCreateResponse ResponseFromTest2 = payFacLegalEntity.postByLegalEntity(legalEntityCreateRequest);
        String legalEntityIdFromTest2 = ResponseFromTest2.getLegalEntityId();

        LegalEntityRetrievalResponse response = payFacLegalEntity.getByLegalEntityId(Long.parseLong(legalEntityIdFromTest2));
        backgroundCheckResultsForTest2 = response.getBackgroundCheckResults();
    }

    // Wait a minimum of two hours after submitting Test #2
    @Test
    public void test2and2b(){
        legalEntityCreateRequest.setLegalEntityType(LegalEntityType.INDIVIDUAL_SOLE_PROPRIETORSHIP);
        address.setStreetAddress1(streetAdrss1ForTest2);
        legalEntityCreateRequest.setAddress(address);
        legalEntityCreateRequest.setTaxId((100000000 + random.nextInt(900000000))+"");
        LegalEntityCreateResponse ResponseFromTest2 = payFacLegalEntity.postByLegalEntity(legalEntityCreateRequest);
        String legalEntityIdFromTest2 = ResponseFromTest2.getLegalEntityId();

        LegalEntityRetrievalResponse response = payFacLegalEntity.getByLegalEntityId(Long.parseLong(legalEntityIdFromTest2));
        assertEquals((short)10,(short)response.getResponseCode());
        assertEquals("Approved",response.getResponseDescription());
    }


    @Test
    public void test3(){
        legalEntityCreateRequest.setLegalEntityType(LegalEntityType.LIMITED_LIABILITY_COMPANY);
        address.setStreetAddress1(streetAdrss1ForTest3);
        legalEntityCreateRequest.setAddress(address);
        legalEntityCreateRequest.setTaxId((100000000 + random.nextInt(900000000))+"");

        LegalEntityCreateResponse response = payFacLegalEntity.postByLegalEntity(legalEntityCreateRequest);
        assertEquals((short) 10, (short) response.getResponseCode());
        assertEquals("Approved",response.getResponseDescription());
    }

//    @Test
//    public void testC1_1(){
//        legalEntityCreateRequest.setLegalEntityType(LegalEntityType.CORPORATION);
//        legalEntityCreateRequest.setDoingBusinessAs("Canada Cert Test Legal Entity A");
//        CanadaAddress.setStreetAddress1(streetAdrss1ForTestC1_1);
//        legalEntityCreateRequest.setAddress(CanadaAddress);
//
//        LegalEntityCreateResponse response = payFacLegalEntity.postByLegalEntity(legalEntityCreateRequest);
//        assertEquals((short) 10, (short) response.getResponseCode());
//        assertEquals("Approved",response.getResponseDescription());
//    }
//
//    @Test
//    public void testC1_2(){
//        legalEntityCreateRequest.setLegalEntityType(LegalEntityType.INDIVIDUAL_SOLE_PROPRIETORSHIP);
//        CanadaAddress.setStreetAddress1(streetAdrss1ForTestC1_2);
//        legalEntityCreateRequest.setAddress(CanadaAddress);
//
//        LegalEntityCreateResponse response = payFacLegalEntity.postByLegalEntity(legalEntityCreateRequest);
//        assertEquals((short) 10, (short) response.getResponseCode());
//        assertEquals("Approved",response.getResponseDescription());
//    }
//
//    @Test
//    public void testC1_3(){
//        legalEntityCreateRequest.setLegalEntityType(LegalEntityType.GENERAL_PARTNERSHIP);
//        CanadaAddress.setStreetAddress1(streetAdrss1ForTestC1_3);
//        legalEntityCreateRequest.setAddress(CanadaAddress);
//
//        LegalEntityCreateResponse response = payFacLegalEntity.postByLegalEntity(legalEntityCreateRequest);
//        assertEquals((short) 20, (short) response.getResponseCode());
//    }

    @Test
    public void test1and4(){
        legalEntityCreateRequest.setLegalEntityType(LegalEntityType.INDIVIDUAL_SOLE_PROPRIETORSHIP);
        address.setStreetAddress1(streetAdrss1ForTest1);
        legalEntityCreateRequest.setAddress(address);
        legalEntityCreateRequest.setTaxId((100000000 + random.nextInt(900000000))+"");


        LegalEntityCreateResponse responseFromTest1 = payFacLegalEntity.postByLegalEntity(legalEntityCreateRequest);
        String legalEntityIdFromTest1 = responseFromTest1.getLegalEntityId();

        payFacLegalEntity.putByLegalEntity(Long.parseLong(legalEntityIdFromTest1), legalEntityUpdateRequest);
    }

    @Test
    public void test5(){
        try {
            payFacLegalEntity.putByLegalEntity(0, legalEntityUpdateRequest);
        }
        catch (Exception ex){
            assertEquals("Error in request: Could not find requested object.",ex.getMessage());
        }
    }

//    @Test
//    public void testC1_1andC2_2_1(){
//        legalEntityCreateRequest.setLegalEntityType(LegalEntityType.CORPORATION);
//        legalEntityCreateRequest.setDoingBusinessAs("Canada Cert Test Legal Entity A");
//        CanadaAddress.setStreetAddress1(streetAdrss1ForTestC1_1);
//        legalEntityCreateRequest.setAddress(CanadaAddress);
//
//        LegalEntityCreateResponse responseFromTestC1_1 = payFacLegalEntity.postByLegalEntity(legalEntityCreateRequest);
//        String legalEntityIdFromTestC1_1 = responseFromTestC1_1.getLegalEntityId();
//
//        legalEntityUpdateRequest.setDoingBusinessAs("Canada A");
//        payFacLegalEntity.putByLegalEntity(Long.parseLong(legalEntityIdFromTestC1_1),legalEntityUpdateRequest);
//    }
//
//
//    @Test
//    public void testC1_1andC2_2_2(){
//        legalEntityCreateRequest.setLegalEntityType(LegalEntityType.CORPORATION);
//        legalEntityCreateRequest.setDoingBusinessAs("Canada Cert Test Legal Entity A");
//        CanadaAddress.setStreetAddress1(streetAdrss1ForTestC1_1);
//        legalEntityCreateRequest.setAddress(CanadaAddress);
//
//        LegalEntityCreateResponse responseFromTestC1_1 = payFacLegalEntity.postByLegalEntity(legalEntityCreateRequest);
//        String legalEntityIdFromTestC1_1 = responseFromTestC1_1.getLegalEntityId();
//
//        principalAddress.setStateProvince("XX");
//        legalEntityPrincipalUpdatable.setAddress(principalAddress);
//        legalEntityUpdateRequest.setPrincipal(legalEntityPrincipalUpdatable);
//        try{
//            payFacLegalEntity.putByLegalEntity(Long.parseLong(legalEntityIdFromTestC1_1),legalEntityUpdateRequest);
//        }catch (Exception ex){
//            assertEquals("Legal Entity Principal stateProvince: “XX” is not valid for Legal Entity Principal country.",ex.getMessage());
//        }
//    }
//
//    @Test
//    public void testC1_1andC2_2_3(){
//        legalEntityCreateRequest.setLegalEntityType(LegalEntityType.CORPORATION);
//        legalEntityCreateRequest.setDoingBusinessAs("Canada Cert Test Legal Entity A");
//        CanadaAddress.setStreetAddress1(streetAdrss1ForTestC1_1);
//        legalEntityCreateRequest.setAddress(CanadaAddress);
//
//        LegalEntityCreateResponse responseFromTestC1_1 = payFacLegalEntity.postByLegalEntity(legalEntityCreateRequest);
//        String legalEntityIdFromTestC1_1 = responseFromTestC1_1.getLegalEntityId();
//
//        principalAddress.setPostalCode("01730");
//        legalEntityPrincipalUpdatable.setAddress(principalAddress);
//        legalEntityUpdateRequest.setPrincipal(legalEntityPrincipalUpdatable);
//        try{
//            payFacLegalEntity.putByLegalEntity(Long.parseLong(legalEntityIdFromTestC1_1),legalEntityUpdateRequest);
//        }catch (Exception ex){
//            assertEquals("Postal Code is not valid for country “CAN”.",ex.getMessage());
//        }
//    }
//
//    @Test
//    public void testC1_3andC2_2_4(){
//        legalEntityCreateRequest.setLegalEntityType(LegalEntityType.GENERAL_PARTNERSHIP);
//        CanadaAddress.setStreetAddress1(streetAdrss1ForTestC1_3);
//        legalEntityCreateRequest.setAddress(CanadaAddress);
//
//        LegalEntityCreateResponse responseFromTestC1_3 = payFacLegalEntity.postByLegalEntity(legalEntityCreateRequest);
//        String legalEntityIdFromTestC1_3 = responseFromTestC1_3.getLegalEntityId();
//
//        principalAddress.setPostalCode("01730");
//        legalEntityPrincipalUpdatable.setAddress(principalAddress);
//        legalEntityUpdateRequest.setPrincipal(legalEntityPrincipalUpdatable);
//        try{
//            payFacLegalEntity.putByLegalEntity(Long.parseLong(legalEntityIdFromTestC1_3),legalEntityUpdateRequest);
//        }catch (Exception ex){
//            assertEquals("Postal Code “01730” is not valid for country “CAN”.",ex.getMessage());
//        }
//    }
//
//    @Test
//    public void testC1_1andC2_2_5(){
//        legalEntityCreateRequest.setLegalEntityType(LegalEntityType.CORPORATION);
//        legalEntityCreateRequest.setDoingBusinessAs("Canada Cert Test Legal Entity A");
//        CanadaAddress.setStreetAddress1(streetAdrss1ForTestC1_1);
//        legalEntityCreateRequest.setAddress(CanadaAddress);
//
//        LegalEntityCreateResponse responseFromTestC1_1 = payFacLegalEntity.postByLegalEntity(legalEntityCreateRequest);
//        String legalEntityIdFromTestC1_1 = responseFromTestC1_1.getLegalEntityId();
//
//        legalEntityUpdateRequest.setDoingBusinessAs("Canada Cert Test C - Update");
//        try{
//            payFacLegalEntity.putByLegalEntity(Long.parseLong(legalEntityIdFromTestC1_1),legalEntityUpdateRequest);
//        }catch (Exception ex){
//            assertEquals("Due to its current status, requested Legal Entity is not updatable",ex.getMessage());
//        }
//    }
//
//    @Test
//    public void testC1_1andC2_2_6(){
//        legalEntityCreateRequest.setLegalEntityType(LegalEntityType.CORPORATION);
//        legalEntityCreateRequest.setDoingBusinessAs("Canada Cert Test Legal Entity A");
//        CanadaAddress.setStreetAddress1(streetAdrss1ForTestC1_1);
//        legalEntityCreateRequest.setAddress(CanadaAddress);
//
//        LegalEntityCreateResponse responseFromTestC1_1 = payFacLegalEntity.postByLegalEntity(legalEntityCreateRequest);
//        String legalEntityIdFromTestC1_1 = responseFromTestC1_1.getLegalEntityId();
//
//        legalEntityBackgroundCheckFields.setTaxId("123456789");
//        legalEntityUpdateRequest.setBackgroundCheckFields(legalEntityBackgroundCheckFields);
//        try{
//            payFacLegalEntity.putByLegalEntity(Long.parseLong(legalEntityIdFromTestC1_1),legalEntityUpdateRequest);
//        }catch (Exception ex){
//            assertEquals("Background check fields cannot be updated after background check.",ex.getMessage());
//        }
//    }

    @Test
    public void test2and6(){
        legalEntityCreateRequest.setLegalEntityType(LegalEntityType.INDIVIDUAL_SOLE_PROPRIETORSHIP);
        address.setStreetAddress1(streetAdrss1ForTest2);
        legalEntityCreateRequest.setAddress(address);
        legalEntityCreateRequest.setTaxId((100000000 + random.nextInt(900000000))+"");

        LegalEntityCreateResponse responseFromTest2 = payFacLegalEntity.postByLegalEntity(legalEntityCreateRequest);
        String legalEntityIdFromTest2 = responseFromTest2.getLegalEntityId();

        LegalEntityRetrievalResponse response = payFacLegalEntity.getByLegalEntityId(Long.parseLong(legalEntityIdFromTest2));
        assertEquals((short)20,(short)response.getResponseCode());
    }

    @Test
    public void test7(){
        try{
            payFacLegalEntity.getByLegalEntityId(0);
        }catch (Exception ex){
            assertEquals("Error in request: Could not find requested object.",ex.getMessage());
        }
    }

//    @Test
//    public void testC1_2andC3_1(){
//        legalEntityCreateRequest.setLegalEntityType(LegalEntityType.INDIVIDUAL_SOLE_PROPRIETORSHIP);
//        CanadaAddress.setStreetAddress1(streetAdrss1ForTestC1_2);
//        legalEntityCreateRequest.setAddress(CanadaAddress);
//
//        LegalEntityCreateResponse responseFromTestC1_2 = payFacLegalEntity.postByLegalEntity(legalEntityCreateRequest);
//        String legalEntityIdFromTestC1_2 = responseFromTestC1_2.getLegalEntityId();
//
//        LegalEntityRetrievalResponse response = payFacLegalEntity.getByLegalEntityId(Long.parseLong(legalEntityIdFromTestC1_2));
//        assertEquals((short)10,(short)response.getResponseCode());
//        assertEquals("Approved",response.getResponseDescription());
//    }
//
//    @Test
//    public void testC3_2(){
//        try{
//            payFacLegalEntity.getByLegalEntityId(0);
//        }catch (Exception ex){
//            assertEquals("Error in request: Could not find requested object.",ex.getMessage());
//        }
//    }

        //==========================================================================================
        //                             Submerchant certification Tests
        //==========================================================================================

      @Test
      public void test1and8() {
        legalEntityCreateRequest.setLegalEntityType(LegalEntityType.INDIVIDUAL_SOLE_PROPRIETORSHIP);
        address.setStreetAddress1(streetAdrss1ForTest1);
        legalEntityCreateRequest.setAddress(address);
        legalEntityCreateRequest.setTaxId((100000000 + random.nextInt(900000000))+"");


        LegalEntityCreateResponse responseFromTest1 = payFacLegalEntity.postByLegalEntity(legalEntityCreateRequest);
        String legalEntityIdFromTest1 = responseFromTest1.getLegalEntityId();

        SubMerchantCreateResponse response = payFacSubMerchant.postSubMerchant(Long.parseLong(legalEntityIdFromTest1), submerchantCreateRequest);
      }

      @Test
      public void test9() {
        try {
          payFacSubMerchant.postSubMerchant(0, submerchantCreateRequest);
        }
        catch (Exception ex) {
          assertEquals("Error in request: Could not find requested object.", ex.getMessage());
        }
      }

      @Test
      public void test2and10() {
        legalEntityCreateRequest.setLegalEntityType(LegalEntityType.INDIVIDUAL_SOLE_PROPRIETORSHIP);
        address.setStreetAddress1(streetAdrss1ForTest2);
        legalEntityCreateRequest.setAddress(address);
        legalEntityCreateRequest.setTaxId((100000000 + random.nextInt(900000000))+"");

        LegalEntityCreateResponse responseFromTest2 = payFacLegalEntity.postByLegalEntity(legalEntityCreateRequest);
        String legalEntityIdFromTest2 = responseFromTest2.getLegalEntityId();

        try {
          payFacSubMerchant.postSubMerchant(Long.parseLong(legalEntityIdFromTest2), submerchantCreateRequest);
        }
        catch (Exception ex) {
          assertEquals("Legal Entity is in inactive state. You cannot add/update a submerchant.", ex.getMessage());
        }
      }

//      @Test
//      public void testC1_1andC4_1() {
//        legalEntityCreateRequest.setLegalEntityType(LegalEntityType.CORPORATION);
//        legalEntityCreateRequest.setDoingBusinessAs("Canada Cert Test Legal Entity A");
//        CanadaAddress.setStreetAddress1(streetAdrss1ForTestC1_1);
//        legalEntityCreateRequest.setAddress(CanadaAddress);
//
//        LegalEntityCreateResponse responseFromTestC1_1 = payFacLegalEntity.postByLegalEntity(legalEntityCreateRequest);
//        String legalEntityIdFromTestC1_1 = responseFromTestC1_1.getLegalEntityId();
//
//        SubMerchantCreateResponse response = payFacSubMerchant.postSubMerchant(Long.parseLong(legalEntityIdFromTestC1_1), submerchantCreateRequest);
//      }
//
//        @Test
//        public void testC1_1andC4_2() {
//            legalEntityCreateRequest.setLegalEntityType(LegalEntityType.CORPORATION);
//            legalEntityCreateRequest.setDoingBusinessAs("Canada Cert Test Legal Entity A");
//            CanadaAddress.setStreetAddress1(streetAdrss1ForTestC1_1);
//            legalEntityCreateRequest.setAddress(CanadaAddress);
//
//            LegalEntityCreateResponse responseFromTestC1_1 = payFacLegalEntity.postByLegalEntity(legalEntityCreateRequest);
//            String legalEntityIdFromTestC1_1 = responseFromTestC1_1.getLegalEntityId();
//
//            submerchantCreateRequest.setPurchaseCurrency("USD");
//            submerchantCreateRequest.setSettlementCurrency("CAD");
//            try {
//                payFacSubMerchant.postSubMerchant(Long.parseLong(legalEntityIdFromTestC1_1), submerchantCreateRequest);
//            }
//            catch (Exception ex) {
//                assertEquals("Error in request: No processing group defined with purchaseCurrencyCode <840> and settlementCurrencyCode <124>", ex
//                    .getMessage());
//            }
//        }
//
//        @Test
//        public void testC1_1andC4_3() {
//            legalEntityCreateRequest.setLegalEntityType(LegalEntityType.CORPORATION);
//            legalEntityCreateRequest.setDoingBusinessAs("Canada Cert Test Legal Entity A");
//            CanadaAddress.setStreetAddress1(streetAdrss1ForTestC1_1);
//            legalEntityCreateRequest.setAddress(CanadaAddress);
//
//            LegalEntityCreateResponse responseFromTestC1_1 = payFacLegalEntity.postByLegalEntity(legalEntityCreateRequest);
//            String legalEntityIdFromTestC1_1 = responseFromTestC1_1.getLegalEntityId();
//
//            address.setCountryCode("USA");
//            submerchantCreateRequest.setAddress(address);
//            try {
//                payFacSubMerchant.postSubMerchant(Long.parseLong(legalEntityIdFromTestC1_1), submerchantCreateRequest);
//            }
//            catch (Exception ex) {
//                assertEquals("Error in request: Submerchant country code “USA” does not match Legal Entity country code “CAN”", ex
//                    .getMessage());
//            }
//        }
//
//        @Test
//        public void testC1_3andC4_4() {
//            legalEntityCreateRequest.setLegalEntityType(LegalEntityType.GENERAL_PARTNERSHIP);
//            CanadaAddress.setStreetAddress1(streetAdrss1ForTestC1_3);
//            legalEntityCreateRequest.setAddress(CanadaAddress);
//
//            LegalEntityCreateResponse responseFromTestC1_3 = payFacLegalEntity.postByLegalEntity(legalEntityCreateRequest);
//            String legalEntityIdFromTestC1_3 = responseFromTestC1_3.getLegalEntityId();
//
//
//            try {
//                payFacSubMerchant.postSubMerchant(Long.parseLong(legalEntityIdFromTestC1_3), submerchantCreateRequest);
//            }
//            catch (Exception ex) {
//                assertEquals("Error in request: Legal Entity “Legal Entity Name” has not been approved", ex
//                    .getMessage());
//            }
//        }
//
//
//        @Test
//        public void testC1_1andC4_5() {
//            legalEntityCreateRequest.setLegalEntityType(LegalEntityType.CORPORATION);
//            legalEntityCreateRequest.setDoingBusinessAs("Canada Cert Test Legal Entity A");
//            CanadaAddress.setStreetAddress1(streetAdrss1ForTestC1_1);
//            legalEntityCreateRequest.setAddress(CanadaAddress);
//
//            LegalEntityCreateResponse responseFromTestC1_1 = payFacLegalEntity.postByLegalEntity(legalEntityCreateRequest);
//            String legalEntityIdFromTestC1_1 = responseFromTestC1_1.getLegalEntityId();
//
//            address.setPostalCode("01970");
//            submerchantCreateRequest.setAddress(address);
//            try {
//                payFacSubMerchant.postSubMerchant(Long.parseLong(legalEntityIdFromTestC1_1), submerchantCreateRequest);
//            }
//            catch (Exception ex) {
//                assertEquals("Postal Code “01970” is not valid for country “CAN”.", ex
//                    .getMessage());
//            }
//        }

        @Test
        public void test1and8and11() {
            legalEntityCreateRequest.setLegalEntityType(LegalEntityType.INDIVIDUAL_SOLE_PROPRIETORSHIP);
            address.setStreetAddress1(streetAdrss1ForTest1);
            legalEntityCreateRequest.setAddress(address);
            legalEntityCreateRequest.setTaxId((100000000 + random.nextInt(900000000))+"");


            LegalEntityCreateResponse responseFromTest1 = payFacLegalEntity.postByLegalEntity(legalEntityCreateRequest);
            String legalEntityIdFromTest1 = responseFromTest1.getLegalEntityId();

            SubMerchantCreateResponse responseFromTest8 = payFacSubMerchant.postSubMerchant(Long.parseLong(legalEntityIdFromTest1), submerchantCreateRequest);
            String submerchantIdFromTest8 = responseFromTest8.getSubMerchantId();

            payFacSubMerchant.putBySubMerchantId(Long.parseLong(legalEntityIdFromTest1), Long.parseLong(submerchantIdFromTest8), subMerchantUpdateRequest);

    }

        @Test
        public void test8and12() {
            legalEntityCreateRequest.setLegalEntityType(LegalEntityType.INDIVIDUAL_SOLE_PROPRIETORSHIP);
            address.setStreetAddress1(streetAdrss1ForTest1);
            legalEntityCreateRequest.setAddress(address);
            legalEntityCreateRequest.setTaxId((100000000 + random.nextInt(900000000))+"");


            LegalEntityCreateResponse responseFromTest1 = payFacLegalEntity.postByLegalEntity(legalEntityCreateRequest);
            String legalEntityIdFromTest1 = responseFromTest1.getLegalEntityId();

            SubMerchantCreateResponse responseFromTest8 = payFacSubMerchant.postSubMerchant(Long.parseLong(legalEntityIdFromTest1), submerchantCreateRequest);
            String submerchantIdFromTest8 = responseFromTest8.getSubMerchantId();

            try {
                payFacSubMerchant.putBySubMerchantId(0, Long.parseLong(submerchantIdFromTest8), subMerchantUpdateRequest);
            }
            catch (Exception ex) {
                assertEquals("Error in request: Could not find requested object.", ex
                    .getMessage());
            }
        }

        @Test
        public void test1and13() {
            legalEntityCreateRequest.setLegalEntityType(LegalEntityType.INDIVIDUAL_SOLE_PROPRIETORSHIP);
            address.setStreetAddress1(streetAdrss1ForTest1);
            legalEntityCreateRequest.setAddress(address);
            legalEntityCreateRequest.setTaxId((100000000 + random.nextInt(900000000))+"");


            LegalEntityCreateResponse responseFromTest1 = payFacLegalEntity.postByLegalEntity(legalEntityCreateRequest);
            String legalEntityIdFromTest1 = responseFromTest1.getLegalEntityId();


            try {
                payFacSubMerchant.putBySubMerchantId(Long.parseLong(legalEntityIdFromTest1), 0, subMerchantUpdateRequest);
            }
            catch (Exception ex) {
                assertEquals("Error in request: Could not find requested object.", ex
                    .getMessage());
            }
        }

//        @Test
//        public void testC1_1andC4_1andC5_1() {
//            legalEntityCreateRequest.setLegalEntityType(LegalEntityType.CORPORATION);
//            legalEntityCreateRequest.setDoingBusinessAs("Canada Cert Test Legal Entity A");
//            CanadaAddress.setStreetAddress1(streetAdrss1ForTestC1_1);
//            legalEntityCreateRequest.setAddress(CanadaAddress);
//
//            LegalEntityCreateResponse responseFromTestC1_1 = payFacLegalEntity.postByLegalEntity(legalEntityCreateRequest);
//            String legalEntityIdFromTestC1_1 = responseFromTestC1_1.getLegalEntityId();
//
//            SubMerchantCreateResponse responseFromTestC4_1 = payFacSubMerchant.postSubMerchant(Long.parseLong(legalEntityIdFromTestC1_1), submerchantCreateRequest);
//            String submerchantIdFromTestC4_1 = responseFromTestC4_1.getSubMerchantId();
//
//            payFacSubMerchant.putBySubMerchantId(Long.parseLong(legalEntityIdFromTestC1_1), Long.parseLong(submerchantIdFromTestC4_1), subMerchantUpdateRequest);
//        }
//
//
//        @Test
//        public void testC5_2() {
//
//            try {
//                payFacSubMerchant.putBySubMerchantId(0, 0, subMerchantUpdateRequest);
//            }
//            catch (Exception ex) {
//                assertEquals("Error in request: Could not find requested object.", ex
//                    .getMessage());
//            }
//        }
//
//        @Test
//        public void testC1_1andC5_3() {
//            legalEntityCreateRequest.setLegalEntityType(LegalEntityType.CORPORATION);
//            legalEntityCreateRequest.setDoingBusinessAs("Canada Cert Test Legal Entity A");
//            CanadaAddress.setStreetAddress1(streetAdrss1ForTestC1_1);
//            legalEntityCreateRequest.setAddress(CanadaAddress);
//
//            LegalEntityCreateResponse responseFromTestC1_1 = payFacLegalEntity.postByLegalEntity(legalEntityCreateRequest);
//            String legalEntityIdFromTestC1_1 = responseFromTestC1_1.getLegalEntityId();
//
//            try {
//                payFacSubMerchant.putBySubMerchantId(Long.parseLong(legalEntityIdFromTestC1_1), 0, subMerchantUpdateRequest);
//            }
//            catch (Exception ex) {
//                assertEquals("Error in request: Could not find requested object.", ex
//                    .getMessage());
//            }
//        }

        @Test
        public void test1and8and14(){
            legalEntityCreateRequest.setLegalEntityType(LegalEntityType.INDIVIDUAL_SOLE_PROPRIETORSHIP);
            address.setStreetAddress1(streetAdrss1ForTest1);
            legalEntityCreateRequest.setAddress(address);
            legalEntityCreateRequest.setTaxId((100000000 + random.nextInt(900000000))+"");


            LegalEntityCreateResponse responseFromTest1 = payFacLegalEntity.postByLegalEntity(legalEntityCreateRequest);
            String legalEntityIdFromTest1 = responseFromTest1.getLegalEntityId();

            SubMerchantCreateResponse responseFromTest8 = payFacSubMerchant.postSubMerchant(Long.parseLong(legalEntityIdFromTest1), submerchantCreateRequest);
            String submerchantIdFromTest8 = responseFromTest8.getSubMerchantId();

            payFacSubMerchant.getBySubMerchantId(Long.parseLong(legalEntityIdFromTest1),Long.parseLong(submerchantIdFromTest8));
        }

        @Test
        public void test8and15(){
            legalEntityCreateRequest.setLegalEntityType(LegalEntityType.INDIVIDUAL_SOLE_PROPRIETORSHIP);
            address.setStreetAddress1(streetAdrss1ForTest1);
            legalEntityCreateRequest.setAddress(address);
            legalEntityCreateRequest.setTaxId((100000000 + random.nextInt(900000000))+"");


            LegalEntityCreateResponse responseFromTest1 = payFacLegalEntity.postByLegalEntity(legalEntityCreateRequest);
            String legalEntityIdFromTest1 = responseFromTest1.getLegalEntityId();

            SubMerchantCreateResponse responseFromTest8 = payFacSubMerchant.postSubMerchant(Long.parseLong(legalEntityIdFromTest1), submerchantCreateRequest);
            String submerchantIdFromTest8 = responseFromTest8.getSubMerchantId();

            try{
                payFacSubMerchant.getBySubMerchantId(0,Long.parseLong(submerchantIdFromTest8));
            }catch (Exception ex) {
                assertEquals("Error in request: Could not find requested object.", ex
                    .getMessage());
            }
        }

        @Test
        public void test1and16(){
            legalEntityCreateRequest.setLegalEntityType(LegalEntityType.INDIVIDUAL_SOLE_PROPRIETORSHIP);
            address.setStreetAddress1(streetAdrss1ForTest1);
            legalEntityCreateRequest.setAddress(address);
            legalEntityCreateRequest.setTaxId((100000000 + random.nextInt(900000000))+"");


            LegalEntityCreateResponse responseFromTest1 = payFacLegalEntity.postByLegalEntity(legalEntityCreateRequest);
            String legalEntityIdFromTest1 = responseFromTest1.getLegalEntityId();

            try{
                payFacSubMerchant.getBySubMerchantId(Long.parseLong(legalEntityIdFromTest1),0);
            }catch (Exception ex) {
                assertEquals("Error in request: Could not find requested object.", ex
                    .getMessage());
            }
        }

//        @Test
//        public void testC1_1andC4_1and14_2(){
//            legalEntityCreateRequest.setLegalEntityType(LegalEntityType.CORPORATION);
//            legalEntityCreateRequest.setDoingBusinessAs("Canada Cert Test Legal Entity A");
//            CanadaAddress.setStreetAddress1(streetAdrss1ForTestC1_1);
//            legalEntityCreateRequest.setAddress(CanadaAddress);
//
//            LegalEntityCreateResponse responseFromTestC1_1 = payFacLegalEntity.postByLegalEntity(legalEntityCreateRequest);
//            String legalEntityIdFromTestC1_1 = responseFromTestC1_1.getLegalEntityId();
//
//            SubMerchantCreateResponse responseFromTestC4_1 = payFacSubMerchant.postSubMerchant(Long.parseLong(legalEntityIdFromTestC1_1), submerchantCreateRequest);
//            String submerchantIdFromTestC4_1 = responseFromTestC4_1.getSubMerchantId();
//
//            payFacSubMerchant.getBySubMerchantId(Long.parseLong(legalEntityIdFromTestC1_1),Long.parseLong(submerchantIdFromTestC4_1));
//        }


}
