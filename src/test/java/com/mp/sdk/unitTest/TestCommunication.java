package com.mp.sdk.unitTest;


import com.mp.sdk.Communication;
import java.util.Properties;
import org.junit.Before;
import org.junit.Test;

import static com.mp.sdk.Communication.getBestProtocol;
import static org.junit.Assert.*;

public class TestCommunication {
  Communication communication;
  String[] availableProtocols_empty;
  String[] availableProtocols;
  Properties config;

  @Before
  public void setUp(){
    config = new Properties();
    communication = new Communication(config);
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
