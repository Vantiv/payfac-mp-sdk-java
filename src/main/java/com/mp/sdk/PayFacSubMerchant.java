package com.mp.sdk;

import java.util.Properties;

public class PayFacSubMerchant {

    private Properties properties;
    private Communication communication;
    private String baseUrl;

    public PayFacSubMerchant(){
        communication = new Communication();
        properties = (new Configuration()).getProperties();
        baseUrl = properties.getProperty("url");
    }

    public PayFacSubMerchant(Properties properties) {
        this.properties = properties;
        communication = new Communication(properties);
        baseUrl = this.properties.getProperty("url");
    }

    public void setCommunication(Communication communication) {
        this.communication = communication;
    }

    public SubMerchantRetrievalResponse getBySubMerchantId(long legalEntityId, long subMerchantId) {

        return getSubMerchantResponse("legalentity", String.valueOf(legalEntityId), "submerchant", String.valueOf(subMerchantId));
    }

    public SubMerchantCreateResponse postSubMerchant(long legalEntityId, SubMerchantCreateRequest request) {

        return postSubMerchantResponse("legalentity", String.valueOf(legalEntityId), "submerchant", request);
    }

    public SubMerchantCreateResponse postSubMerchantWithDuplicateAll(long legalEntityId, SubMerchantCreateRequest request) {
        request.setMerchantName("duplicate all matching");
        return postSubMerchantResponse("legalentity", String.valueOf(legalEntityId), "submerchant", request);
    }

    public SubMerchantCreateResponse postSubMerchantWithDuplicateNotAll(long legalEntityId, SubMerchantCreateRequest request) {
        request.setMerchantName("duplicate not matching");
        return postSubMerchantResponse("legalentity", String.valueOf(legalEntityId), "submerchant", request);
    }

    public Response putBySubMerchantId(long legalEntityId, long subMerchantId, SubMerchantUpdateRequest request) {
        return putSubMerchantResponse("legalentity", String.valueOf(legalEntityId), "submerchant", String.valueOf(subMerchantId), request);
    }

    private SubMerchantRetrievalResponse getSubMerchantResponse(String key, String value, String key2, String value2) {

        String suffix = "/" + key + "/" + value + "/" + key2 + "/" + value2;

        String url = baseUrl + suffix;
        SubMerchantRetrievalResponse response = XMLConverters.generateSubMerchantRetrievalResponse(communication.httpGetRequest(url));
        return response;
    }

    private SubMerchantCreateResponse postSubMerchantResponse(String key, String value, String key2, SubMerchantCreateRequest request) {

        String suffix = "/" + key + "/" + value + "/" + key2;

        String url = baseUrl + suffix;
        String subMerchantRequest = XMLConverters.generateSubMerchantCreateRequest(request);

        SubMerchantCreateResponse response = XMLConverters.generateSubMerchantCreateResponse(communication.httpPostRequest(subMerchantRequest, url));
        return response;
    }

    private Response putSubMerchantResponse(String key, String value, String key2, String value2, SubMerchantUpdateRequest request) {

        String suffix = "/" + key + "/" + value + "/" + key2 + "/" + value2;

        String url = baseUrl + suffix;
        String subMerchantrequest = XMLConverters.generateSubMerchantUpdateRequest(request);

        Response response = (Response) XMLConverters.generateResponse(communication.httpPutRequest(subMerchantrequest, url));
        return response;
    }

}
