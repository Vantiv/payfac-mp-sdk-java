package com.mp.sdk.unitTest;

import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.matches;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.mockito.Mockito;

import com.mp.sdk.ApprovedMccResponse;
import com.mp.sdk.Communication;
import com.mp.sdk.PayFacMcc;

public class TestPayFacMcc {
    PayFacMcc payFacMcc = new PayFacMcc();

    @Test
    public void testGetMcc(){
        String expectedRequestUrl = "https://www.testvantivcnp.com/sandbox/payfac/mcc";
        String mockedResponse = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
                "<approvedMccResponse xmlns=\"http://payfac.vantivcnp.com/api/merchant/onboard\">\n" +
                "    <transactionId>2604414425</transactionId>\n" +
                "    <approvedMccs>\n" +
                "        <approvedMcc>5967</approvedMcc>\n" +
                "        <approvedMcc>5970</approvedMcc>\n" +
                "    </approvedMccs>\n" +
                "</approvedMccResponse>";
        Communication mockedCommunication = Mockito.mock(Communication.class);
        when(mockedCommunication.httpGetRequest(matches(expectedRequestUrl))).thenReturn(mockedResponse);
        ApprovedMccResponse response = payFacMcc.getMcc();
        assertNotNull(response.getTransactionId());
    }
}
