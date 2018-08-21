package com.mp.sdk.unitTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import com.mp.sdk.PayFacWebException;

public class TestPayFacWebException {
    PayFacWebException payFacWebException;


    @Test
    public void testPayFacWebException_message_code_errorList(){
        ArrayList<String> errorList = new ArrayList<>();
        payFacWebException = new PayFacWebException("test message","1",errorList);
    }

    @Test
    public void testPayFacWebException_message_code(){
        payFacWebException = new PayFacWebException("test message","1");
    }

    @Test
    public void testPayFacWebException_message_ume(){
        payFacWebException = new PayFacWebException("test message",new Exception());
    }

    @Test
    public void testPayFacWebException_message(){
        payFacWebException = new PayFacWebException("test message");
    }

    @Test
    public void testGetCode(){
        payFacWebException = new PayFacWebException("test message","02");
        assertEquals("02",payFacWebException.getCode());

    }

    @Test
    public void testSetCode(){
        payFacWebException = new PayFacWebException("test message");
        assertEquals("0",payFacWebException.getCode());
        payFacWebException.setCode("2");
        assertEquals("2",payFacWebException.getCode());
    }

    @Test
    public void testGetErrorList(){
        ArrayList<String> errorList = new ArrayList<>();
        errorList.add("error1");
        payFacWebException = new PayFacWebException("test message","1",errorList);
        List testList = payFacWebException.getErrorList();
        assertEquals("error1",testList.get(0));
    }

    @Test
    public void testSetErrorList(){
        ArrayList<String> errorList = new ArrayList<>();
        errorList.add("error1");
        payFacWebException = new PayFacWebException("test message");
        payFacWebException.setErrorList(errorList);
        List testList = payFacWebException.getErrorList();
        assertEquals("error1",testList.get(0));
    }
}
