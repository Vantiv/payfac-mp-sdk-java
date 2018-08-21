package com.mp.sdk.unitTest;

import static junit.framework.TestCase.assertSame;

import com.mp.sdk.CnpContext;
import com.mp.sdk.ObjectFactory;
import javax.xml.bind.JAXBContext;
import org.junit.Test;

public class TestCnpContext {
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
