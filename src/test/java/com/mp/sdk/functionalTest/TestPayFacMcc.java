package com.mp.sdk.functionalTest;
import java.util.Properties;

import org.junit.Before;
import org.junit.Test;

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
        payFacMcc.getMcc();
    }

}
