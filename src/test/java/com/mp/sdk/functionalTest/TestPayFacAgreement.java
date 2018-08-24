package com.mp.sdk.functionalTest;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Properties;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import com.mp.sdk.Communication;
import com.mp.sdk.Configuration;
import com.mp.sdk.LegalEntityAgreement;
import com.mp.sdk.LegalEntityAgreementCreateResponse;
import com.mp.sdk.LegalEntityAgreementRetrievalResponse;
import com.mp.sdk.LegalEntityAgreementType;
import com.mp.sdk.PayFacAgreement;
import com.mp.sdk.PayFacWebException;

public class TestPayFacAgreement {
    private PayFacAgreement payFacAgreement;
    private Communication communication;
    private LegalEntityAgreement legalEntityAgreement;


    @Before
    public void setUp() throws ParseException, DatatypeConfigurationException {
        communication = new Communication();
        Configuration configuration = new Configuration();
        Properties config = configuration.getProperties();
        payFacAgreement = new PayFacAgreement();
        PayFacAgreement payFacAgreement2 = new PayFacAgreement(config);
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
    public void testSetCommunication(){
        payFacAgreement.setCommunication(communication);
    }

    @Test
    public void testPostByLegalEntity(){
        LegalEntityAgreementCreateResponse response = payFacAgreement.postByLegalEntity(201003,legalEntityAgreement);
        assertNotNull(response.getTransactionId());

    }

    @Test
    public void testGetByLegalEntity(){
        LegalEntityAgreementRetrievalResponse response = payFacAgreement.getByLegalEntity(201003);
        assertNotNull(response.getTransactionId());
        assertEquals("201003",response.getLegalEntityId());

    }

    @Test(expected = PayFacWebException.class)
    public void testGetByLegalEntity_ex(){
        payFacAgreement.getByLegalEntity(201400);
    }


}
