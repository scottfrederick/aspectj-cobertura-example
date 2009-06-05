package com.example;

import org.testng.annotations.Test;
import static org.testng.Assert.*;
import org.aspectj.lang.Aspects;

@Test
public class ExampleAspectTest {

  @Test
  public void testAspectIsInvoked() {
    ExampleAspect aspect = getAspectInstance(ExampleAspect.class);
    
    Something something = new Something();

    assertFalse(aspect.aspectWasInvoked);
    something.doSomething();
    assertTrue(aspect.aspectWasInvoked);
  }

  protected <T> T getAspectInstance(Class<T> clazz) {
     return Aspects.aspectOf(clazz);
  }
}
