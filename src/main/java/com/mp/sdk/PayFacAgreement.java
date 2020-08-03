package com.mp.sdk;

import java.util.Properties;

public class PayFacAgreement {

    private Properties properties;
    private Communication communication;
    private String baseUrl;

    public PayFacAgreement(){
        communication = new Communication();
        properties = (new Configuration()).getProperties();
        baseUrl = properties.getProperty("url");
    }

    public PayFacAgreement(Properties properties) {
        this.properties = properties;
        communication = new Communication(properties);
        baseUrl = this.properties.getProperty("url");
    }

    public void setCommunication(Communication communication) {
        this.communication = communication;
    }

    public LegalEntityAgreementCreateResponse postByLegalEntity(long legalEntityId, LegalEntityAgreement agreement) {

        LegalEntityAgreementCreateRequest request = new LegalEntityAgreementCreateRequest();
        request.setLegalEntityAgreement(agreement);

        return postAgreementResponse("legalentity", String.valueOf(legalEntityId), "agreement", request);
    }

    public LegalEntityAgreementRetrievalResponse getByLegalEntity(long legalEntityId) {

        return getAgreementResponse("legalentity", String.valueOf(legalEntityId), "agreement");
    }

    private LegalEntityAgreementCreateResponse postAgreementResponse(String key, String value, String key2, LegalEntityAgreementCreateRequest request) {

        request.setLanguage(Versions.language);
        request.setSdkVersion(Versions.sdkVersion);

        String agreementRequest = XMLConverters.generateAgreementCreateRequest(request);
        String suffix = "/" + key + "/" + value + "/" + key2;

        String url = baseUrl + suffix;
        LegalEntityAgreementCreateResponse response = XMLConverters.generateAgreementCreateResponse(communication.httpPostRequest(agreementRequest, url));
        return response;
    }

    private LegalEntityAgreementRetrievalResponse getAgreementResponse(String key, String value, String key2) {
        String suffix = "/" + key + "/" + value  + "/" + key2;
        String url = baseUrl + suffix;
        LegalEntityAgreementRetrievalResponse response = XMLConverters.generateAgreementRetrievalResponse(communication.httpGetRequest(url));
        return response;
    }
}
