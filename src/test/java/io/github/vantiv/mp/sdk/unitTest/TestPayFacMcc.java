package io.github.vantiv.mp.sdk.unitTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.matches;
import static org.mockito.Mockito.doReturn;

import org.junit.Test;
import org.mockito.Mockito;

import io.github.vantiv.mp.sdk.ApprovedMccResponse;
import io.github.vantiv.mp.sdk.Communication;
import io.github.vantiv.mp.sdk.PayFacMcc;

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
        Communication mockedCommunication = Mockito.spy(Communication.class);
        doReturn("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
                "<approvedMccResponse xmlns=\"http://payfac.vantivcnp.com/api/merchant/onboard\">\n" +
                "  <transactionId>5264410268</transactionId>\n" +
                "  <approvedMccs>\n" +
                "    <approvedMcc>5967</approvedMcc>\n" +
                "    <approvedMcc>5970</approvedMcc>\n" +
                "  </approvedMccs>\n" +
                "</approvedMccResponse>\n").when(mockedCommunication).httpGetRequest("https://www.testvantivcnp.com/sandbox/payfac/mcc");
        doReturn(mockedResponse).when(mockedCommunication).httpGetRequest(matches(expectedRequestUrl));
        payFacMcc.setCommunication(mockedCommunication);
        ApprovedMccResponse response = payFacMcc.getMcc();
        assertNotNull(response.getApprovedMccs().getApprovedMccs());
        assertEquals("5967", response.getApprovedMccs().getApprovedMccs().get(0));
        assertEquals("5970", response.getApprovedMccs().getApprovedMccs().get(1));
    }
}
