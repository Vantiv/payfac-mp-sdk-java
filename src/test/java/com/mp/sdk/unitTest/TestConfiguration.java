package com.mp.sdk.unitTest;

import com.mp.sdk.Configuration;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import static org.junit.Assert.*;

public class TestConfiguration {
  Configuration configuration;

  @Before
  public void setUp(){
    configuration = new Configuration();
  }

  @Test
  public void testLocation(){
    File file = configuration.location();
    assertNotNull(file);
  }
}
