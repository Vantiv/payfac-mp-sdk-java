package com.mp.sdk;

import java.util.Properties;

public class PayFacMcc {

    private Properties properties;
    private Communication communication;
    private String baseUrl;

    public PayFacMcc(){
        communication = new Communication();
        properties = (new Configuration()).getProperties();
        baseUrl = properties.getProperty("url");
    }

    public PayFacMcc(Properties properties) {
        this.properties = properties;
        communication = new Communication(properties);
        baseUrl = this.properties.getProperty("url");
    }

    public void setCommunication(Communication communication) {
        this.communication = communication;
    }

    public ApprovedMccResponse getMcc() {

        String suffix = "/mcc";

        String url = baseUrl + suffix;
        return XMLConverters.generateMccResponse(communication.httpGetRequest(url));
    }
}
