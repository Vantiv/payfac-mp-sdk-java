package com.mp.sdk;

import java.util.*;

public class PayFacPrincipal {

    private Properties properties;
    private Communication communication;
    private String baseUrl;

    public PayFacPrincipal() {
        communication = new Communication();
        properties = (new Configuration()).getProperties();
        baseUrl = properties.getProperty("url");
    }

    public PayFacPrincipal(Properties properties) {
        this.properties = properties;
        communication = new Communication(properties);
        baseUrl = this.properties.getProperty("url");
    }

    public void setCommunication(Communication communication) {
        this.communication = communication;
    }


    //All of the Principal API calls are dealt with in this class


    public PrincipalDeleteResponse deleteLegalEntityByPrincipalId(long legalEntityId, long principalId) {

        return deletePrincipalResponse("legalentity", String.valueOf(legalEntityId), "principal", String.valueOf(principalId));
    }

    public PrincipalCreateResponse postByLegalEntityID(long legalEntityId, LegalEntityPrincipal principal) {

        LegalEntityPrincipalCreateRequest request = new LegalEntityPrincipalCreateRequest();

        request.setPrincipal(principal);

        return postPrincipalResponse("legalentity", String.valueOf(legalEntityId), "principal", request);
    }



    ///////////////////////////////////////////////////////////////


    private PrincipalCreateResponse postPrincipalResponse(String key, String value, String key2, LegalEntityPrincipalCreateRequest request) {

        String principalRequest = XMLConverters.generatePrincipalCreateRequest(request);
        String suffix = "/" + key + "/" + value + "/" + key2;

        String url = baseUrl + suffix;
        PrincipalCreateResponse response = XMLConverters.generatePrincipalCreateResponse(communication.httpPostRequest(principalRequest, url));
        return response;
    }

    private PrincipalDeleteResponse deletePrincipalResponse(String key, String value, String key2, String value2) {
        String suffix = "/" + key + "/" + value + "/" + key2 + "/" + value2;

        String url = baseUrl + suffix;
        PrincipalDeleteResponse response = XMLConverters.generatePrincipalDeleteResponse(communication.httpDeleteRequest(url));
        return response;
    }
}
