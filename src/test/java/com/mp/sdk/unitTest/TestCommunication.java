package com.mp.sdk.unitTest;

import static com.mp.sdk.Communication.getBestProtocol;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.Properties;

import org.junit.Before;
import org.junit.Test;

import com.mp.sdk.Communication;
import com.mp.sdk.Configuration;

public class TestCommunication {
    Communication communication;
    Communication communication2;
    String[] availableProtocols_empty;
    String[] availableProtocols;
    Configuration configuration;
    Properties config;


    @Before
    public void setUp(){
        configuration = new Configuration();
        config = configuration.getProperties();
        communication2 = new Communication(config);
        communication = new Communication();
        availableProtocols =new String[] {"TLSv1.2", "invalid protocol"};
        availableProtocols_empty = new String[]{};
    }

    @Test
    public void testGetBestProtocol(){
        assertNull(getBestProtocol(null));
        assertNull(getBestProtocol(availableProtocols_empty));
        assertEquals("TLSv1.2",getBestProtocol(availableProtocols));
        availableProtocols[0] = "invalid protocol";
        assertNull(getBestProtocol(availableProtocols));
    }

    @Test
    public void testNeuterXml(){
        String xml = "temp xml";
        assertNull(communication.neuterXml(null));
        assertEquals(xml,communication.neuterXml(xml));
    }
}
