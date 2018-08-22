package com.mp.sdk.unitTest;

import static junit.framework.TestCase.assertSame;
import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.mockito.PowerMockito.when;

import com.mp.sdk.CnpContext;
import com.mp.sdk.ObjectFactory;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

public class TestCnpContext {
  CnpContext cnpContext;

  @Before
  public void setUp(){
    cnpContext = new CnpContext();
  }

  @Test
  public void testGetJAXBContextReturnsSameObject() {
    JAXBContext context1 = CnpContext.getJAXBContext();
    JAXBContext context2 = CnpContext.getJAXBContext();

    assertSame(context1, context2);
  }

  @Test
  public void testGetObjectFactoryReturnsSameObject() {
    ObjectFactory factory1 = CnpContext.getObjectFactory();
    ObjectFactory factory2 = CnpContext.getObjectFactory();
    assertSame(factory1, factory2);
  }
}

