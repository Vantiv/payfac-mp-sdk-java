package com.mp.sdk;

import java.util.Properties;

public class PayFacLegalEntity {

    private Properties properties;
    private Communication communication;
    private String baseUrl;

    public PayFacLegalEntity(){
        communication = new Communication();
        properties = (new Configuration()).getProperties();
        baseUrl = properties.getProperty("url");
    }

    public PayFacLegalEntity(Properties properties) {
        this.properties = properties;
        communication = new Communication(properties);
        baseUrl = this.properties.getProperty("url");
    }

    public void setCommunication(Communication communication) {
        this.communication = communication;
    }

    public LegalEntityRetrievalResponse getByLegalEntityId(long legalEntityId) {

        return getLegalEntityResponse("legalentity", String.valueOf(legalEntityId));
    }

    public LegalEntityCreateResponse postByLegalEntity(LegalEntityPrincipal principal) {

        LegalEntityCreateRequest request = new LegalEntityCreateRequest();
        request.setPrincipal(principal);

        return postLegalEntityResponse("legalentity", request);
    }

    public LegalEntityResponse putByLegalEntity(long legalEntityId, LegalEntityPrincipalUpdatable principal, LegalEntityBackgroundCheckFields fields) {

        LegalEntityUpdateRequest request = new LegalEntityUpdateRequest();
        request.setPrincipal(principal);
        request.setBackgroundCheckFields(fields);

        return putLegalEntityResponse("legalentity", String.valueOf(legalEntityId), request);
    }

    public LegalEntityRetrievalResponse getLegalEntityResponse(String key, String value) {

        String suffix = "/" + key + "/" + value;
        String url = baseUrl + suffix;

        LegalEntityRetrievalResponse response = XMLConverters.generateRetrievalResponse(communication.httpGetRequest(url));
        return response;
    }

    public LegalEntityCreateResponse postLegalEntityResponse(String key, LegalEntityCreateRequest request) {

        String suffix = "/" + key;
        String url = baseUrl + suffix;

        String legalEntityRequest = XMLConverters.generateLegalEntityCreateRequest(request);

        LegalEntityCreateResponse response = XMLConverters.generateCreateResponse(communication.httpPostRequest(legalEntityRequest, url));
        return response;
    }

    public LegalEntityResponse putLegalEntityResponse(String key, String value, LegalEntityUpdateRequest request) {

        String suffix = "/" + key + "/" + value;
        String url = baseUrl + suffix;

        String legalEntityRequest = XMLConverters.generateUpdateRequest(request);

        LegalEntityResponse response = XMLConverters.generateLegalEntityResponse(communication.httpPutRequest(legalEntityRequest, url));
        return response;
    }
}
