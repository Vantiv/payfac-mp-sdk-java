package com.mp.sdk.unitTest;

import com.mp.sdk.CalendarPrinter;
import com.mp.sdk.JAXBConverters;
import java.util.Calendar;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestJAXBConverters {

  String temString;
  String longString;
  CalendarPrinter calendarPrinter;
  JAXBConverters jaxbConverters;

  @Before
  public void setUp() {
    temString = "1234";
    longString = "9000000000000000000";
    calendarPrinter = new CalendarPrinter();
    jaxbConverters = new JAXBConverters();
  }

  @Test
  public void testParseDate() {
    assertNull(JAXBConverters.parseDate(null));
    Calendar calendar = JAXBConverters.parseDate(temString);
    assertNotNull(calendar);
  }

  @Test
  public void testPrintDate() {
    assertNull(JAXBConverters.printDate(null));
    Calendar calendar = JAXBConverters.parseDate(temString);
    assertNotNull(JAXBConverters.printDate(calendar));
  }

  @Test
  public void testParseString() {
    assertNull(JAXBConverters.parseString(null));
    String string = JAXBConverters.parseString(temString);
    assertEquals(temString, string);
  }

  @Test
  public void testPrintString(){
    assertNull(JAXBConverters.printString(null));
    String string = JAXBConverters.printString(temString);
    assertEquals(temString, string);
  }

  @Test
  public void testParseLong(){
    assertNull(JAXBConverters.parseLong(null));
    Long longValue = JAXBConverters.parseLong(longString);
    assertEquals(Long.valueOf(longString),longValue);
  }

  @Test
  public void testPrintLong(){
    assertNull(JAXBConverters.printLong(null));
    String longValue = JAXBConverters.printLong(Long.valueOf(longString));
    assertEquals(longString,longValue);
  }
}
