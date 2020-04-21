package com.mp.sdk.unitTest;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.mp.sdk.Communication;
import com.mp.sdk.LegalEntityAgreement;
import com.mp.sdk.LegalEntityAgreementCreateResponse;
import com.mp.sdk.LegalEntityAgreementRetrievalResponse;
import com.mp.sdk.LegalEntityAgreementType;
import com.mp.sdk.PayFacAgreement;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.matches;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class TestPayFacAgreement {
    private PayFacAgreement payFacAgreement = new PayFacAgreement();
    private LegalEntityAgreement legalEntityAgreement;

    @Before
    public void setUp() throws ParseException, DatatypeConfigurationException {
        legalEntityAgreement = new LegalEntityAgreement();
        legalEntityAgreement.setLegalEntityAgreementType(LegalEntityAgreementType.MERCHANT_AGREEMENT);
        legalEntityAgreement.setAgreementVersion("v1");
        legalEntityAgreement.setUserFullName("fullName");
        legalEntityAgreement.setUserSystemName("system");
        legalEntityAgreement.setUserIPAddress("196.198.100.100");
        legalEntityAgreement.setManuallyEntered(false);
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date date = format.parse("2014-04-24 11:15:00");
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        XMLGregorianCalendar xmlGregorianCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(calendar);
        legalEntityAgreement.setAcceptanceDateTime(xmlGregorianCalendar);
    }

    @Test
    public void testPostByLegalEntity(){
        String expectedRequestUrl = "https://www.testvantivcnp.com/sandbox/payfac/legalentity/201003/agreement";
        String expectedRequest = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
                "<legalEntityAgreementCreateResponse xmlns=\"http://payfac.vantivcnp.com/api/merchant/onboard\">\n" +
                "  <transactionId>7662777105</transactionId>\n" +
                "</legalEntityAgreementCreateResponse>\n";
        Communication mockedCommunication = Mockito.mock(Communication.class);
        doReturn(expectedRequest).when(mockedCommunication).httpPostRequest("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><legalEntityAgreementCreateRequest xmlns=\"http://payfac.vantivcnp.com/api/merchant/onboard\"><legalEntityAgreement><legalEntityAgreementType>MERCHANT_AGREEMENT</legalEntityAgreementType><agreementVersion>v1</agreementVersion><userFullName>fullName</userFullName><userSystemName>system</userSystemName><userIPAddress>196.198.100.100</userIPAddress><manuallyEntered>false</manuallyEntered><acceptanceDateTime>2014-04-24T11:15:00.000-04:00</acceptanceDateTime></legalEntityAgreement></legalEntityAgreementCreateRequest>", expectedRequestUrl);
        payFacAgreement.setCommunication(mockedCommunication);
        LegalEntityAgreementCreateResponse response = payFacAgreement.postByLegalEntity(201003,legalEntityAgreement);
        assertEquals(7662777105L, response.getTransactionId().longValue());
    }

    @Test
    public void testGetByLegalEntity(){
        String expectedRequestUrl = "https://www.testvantivcnp.com/sandbox/payfac/legalentity/201003/agreement";
        String mockedResponse = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
                "<legalEntityAgreementRetrievalResponse xmlns=\"http://payfac.vantivcnp.com/api/merchant/onboard\">\n" +
                "  <legalEntityId>201003</legalEntityId>\n" +
                "  <transactionId>0186907222</transactionId>\n" +
                "  <agreements>\n" +
                "    <legalEntityAgreement>\n" +
                "      <legalEntityAgreementType>MERCHANT_AGREEMENT</legalEntityAgreementType>\n" +
                "      <agreementVersion>agreementVersion1</agreementVersion>\n" +
                "      <userFullName>userFullName1</userFullName>\n" +
                "      <userSystemName>userSystemName1</userSystemName>\n" +
                "      <userIPAddress>196.198.100.100</userIPAddress>\n" +
                "      <manuallyEntered>false</manuallyEntered>\n" +
                "      <acceptanceDateTime>2017-06-11T13:00:00-05:00</acceptanceDateTime>\n" +
                "    </legalEntityAgreement>\n" +
                "    <legalEntityAgreement>\n" +
                "      <legalEntityAgreementType>MERCHANT_AGREEMENT</legalEntityAgreementType>\n" +
                "      <agreementVersion>agreementVersion2</agreementVersion>\n" +
                "      <userFullName>userFullName2</userFullName>\n" +
                "      <userSystemName>userSystemName2</userSystemName>\n" +
                "      <userIPAddress>196.198.100.100</userIPAddress>\n" +
                "      <manuallyEntered>false</manuallyEntered>\n" +
                "      <acceptanceDateTime>2017-06-11T13:00:00-05:00</acceptanceDateTime>\n" +
                "    </legalEntityAgreement>\n" +
                "    <legalEntityAgreement>\n" +
                "      <legalEntityAgreementType>MERCHANT_AGREEMENT</legalEntityAgreementType>\n" +
                "      <agreementVersion>agreementVersion3</agreementVersion>\n" +
                "      <userFullName>userFullName3</userFullName>\n" +
                "      <userSystemName>userSystemName3</userSystemName>\n" +
                "      <userIPAddress>196.198.100.100</userIPAddress>\n" +
                "      <manuallyEntered>false</manuallyEntered>\n" +
                "      <acceptanceDateTime>2017-06-11T13:00:00-05:00</acceptanceDateTime>\n" +
                "    </legalEntityAgreement>\n" +
                "  </agreements>\n" +
                "</legalEntityAgreementRetrievalResponse>\n";
        Communication mockedCommunication = Mockito.mock(Communication.class);
        doReturn(mockedResponse).when(mockedCommunication).httpGetRequest(expectedRequestUrl);
        payFacAgreement.setCommunication(mockedCommunication);
        LegalEntityAgreementRetrievalResponse response = payFacAgreement.getByLegalEntity(201003);
        assertEquals("201003", response.getLegalEntityId());
    }


}
