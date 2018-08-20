package com.mp.sdk.unitTest;

import org.junit.Test;

import com.mp.sdk.PayFacException;

public class TestPayFacException {

    @Test
    public void testPayFacException_1(){
        new PayFacException("test message");
    }

    @Test
    public void testPayFacException_2(){
        new PayFacException("test message",new Exception());
    }
}
