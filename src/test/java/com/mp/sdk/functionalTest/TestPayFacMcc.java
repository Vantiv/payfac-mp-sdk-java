package com.mp.sdk.functionalTest;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import com.mp.sdk.ApprovedMccResponse;
import com.mp.sdk.Communication;
import com.mp.sdk.Configuration;
import com.mp.sdk.PayFacMcc;

public class TestPayFacMcc {

    PayFacMcc payFacMcc;
    PayFacMcc payFacMcc2;
    Configuration configuration;
    Properties config;
    Communication communication;


    @Before
    public void setUp(){
        communication = new Communication();
        configuration = new Configuration();
        config = configuration.getProperties();
        payFacMcc = new PayFacMcc();
        payFacMcc2 = new PayFacMcc(config);


    }

    @Test
    public void testSetCommunication(){
        payFacMcc.setCommunication(communication);
    }

    @Test
    public void testGetMcc(){
        ApprovedMccResponse response = payFacMcc.getMcc();
        assertNotNull(response.getTransactionId());
        ApprovedMccResponse.ApprovedMccs approvedMccs = response.getApprovedMccs();
        assertTrue(approvedMccs.getApprovedMccs().contains("5967"));
        assertTrue(approvedMccs.getApprovedMccs().contains("5970"));
    }

}
