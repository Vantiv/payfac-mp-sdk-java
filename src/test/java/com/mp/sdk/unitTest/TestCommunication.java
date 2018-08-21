package com.mp.sdk.unitTest;


import com.mp.sdk.Communication;
import com.mp.sdk.ErrorResponse;
import com.mp.sdk.ErrorResponse.Errors;
import com.sun.xml.internal.ws.api.ha.StickyFeature;
import java.util.Properties;
import org.apache.http.HttpResponse;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static com.mp.sdk.Communication.getBestProtocol;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.nullable;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

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
