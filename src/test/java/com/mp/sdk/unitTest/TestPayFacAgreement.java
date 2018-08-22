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
        String expectedRequest = "<legalEntityAgreementCreateRequest\n" +
                "\txmlns=\"http://payfac.vantivcnp.com/api/merchant/onboard\">\n" +
                "\t<legalEntityAgreement>\n" +
                "\t\t<legalEntityAgreementType>MERCHANT_AGREEMENT</legalEntityAgreementType>\n" +
                "\t\t<agreementVersion>agreementVersion1</agreementVersion>\n" +
                "\t\t<userFullName>userFullName</userFullName>\n" +
                "\t\t<userSystemName>systemUserName</userSystemName>\n" +
                "\t\t<userIPAddress>196.198.100.100</userIPAddress>\n" +
                "\t\t<manuallyEntered>false</manuallyEntered>\n" +
                "\t\t<acceptanceDateTime>2017-02-11T12:00:00-06:00</acceptanceDateTime>\n" +
                "\t</legalEntityAgreement>\n" +
                "</legalEntityAgreementCreateRequest>";
        String mockedResponse = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
                "<legalEntityAgreementCreateResponse xmlns=\"http://payfac.vantivcnp.com/api/merchant/onboard\">\n" +
                "    <transactionId>0238570470</transactionId>\n" +
                "</legalEntityAgreementCreateResponse>";
        Communication mockedCommunication = Mockito.mock(Communication.class);
        when(mockedCommunication.httpPostRequest(matches(expectedRequest), matches(expectedRequestUrl))).thenReturn(mockedResponse);
        LegalEntityAgreementCreateResponse response = payFacAgreement.postByLegalEntity(201003,legalEntityAgreement);
        assertNotNull(response.getTransactionId());
    }

    @Test
    public void testGetByLegalEntity(){
        String expectedRequestUrl = "https://www.testvantivcnp.com/sandbox/payfac/legalentity/201003/agreement";
        String mockedResponse = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
                "<legalEntityAgreementRetrievalResponse xmlns=\"http://payfac.vantivcnp.com/api/merchant/onboard\">\n" +
                "    <legalEntityId>201003</legalEntityId>\n" +
                "    <transactionId>8524972465</transactionId>\n" +
                "    <agreements>\n" +
                "        <legalEntityAgreement>\n" +
                "            <legalEntityAgreementType>MERCHANT_AGREEMENT</legalEntityAgreementType>\n" +
                "            <agreementVersion>agreementVersion1</agreementVersion>\n" +
                "            <userFullName>userFullName1</userFullName>\n" +
                "            <userSystemName>userSystemName1</userSystemName>\n" +
                "            <userIPAddress>196.198.100.100</userIPAddress>\n" +
                "            <manuallyEntered>false</manuallyEntered>\n" +
                "            <acceptanceDateTime>2017-06-11T13:00:00-05:00</acceptanceDateTime>\n" +
                "        </legalEntityAgreement>\n" +
                "        <legalEntityAgreement>\n" +
                "            <legalEntityAgreementType>MERCHANT_AGREEMENT</legalEntityAgreementType>\n" +
                "            <agreementVersion>agreementVersion2</agreementVersion>\n" +
                "            <userFullName>userFullName2</userFullName>\n" +
                "            <userSystemName>userSystemName2</userSystemName>\n" +
                "            <userIPAddress>196.198.100.100</userIPAddress>\n" +
                "            <manuallyEntered>false</manuallyEntered>\n" +
                "            <acceptanceDateTime>2017-06-11T13:00:00-05:00</acceptanceDateTime>\n" +
                "        </legalEntityAgreement>\n" +
                "        <legalEntityAgreement>\n" +
                "            <legalEntityAgreementType>MERCHANT_AGREEMENT</legalEntityAgreementType>\n" +
                "            <agreementVersion>agreementVersion3</agreementVersion>\n" +
                "            <userFullName>userFullName3</userFullName>\n" +
                "            <userSystemName>userSystemName3</userSystemName>\n" +
                "            <userIPAddress>196.198.100.100</userIPAddress>\n" +
                "            <manuallyEntered>false</manuallyEntered>\n" +
                "            <acceptanceDateTime>2017-06-11T13:00:00-05:00</acceptanceDateTime>\n" +
                "        </legalEntityAgreement>\n" +
                "    </agreements>\n" +
                "</legalEntityAgreementRetrievalResponse>";
        Communication mockedCommunication = Mockito.mock(Communication.class);
        when(mockedCommunication.httpGetRequest(matches(expectedRequestUrl))).thenReturn(mockedResponse);
        LegalEntityAgreementRetrievalResponse response = payFacAgreement.getByLegalEntity(201003);
        assertNotNull(response.getTransactionId());
    }


}
