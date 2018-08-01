package com.mp.sdk;

import javax.xml.bind.JAXBException;
import java.io.StringReader;
import java.io.StringWriter;

public class XMLConverters {

    public static ApprovedMccResponse generateMccResponse(String xmlResponse) {

        return (ApprovedMccResponse) responseUnmarshaller(xmlResponse);
    }

    public static LegalEntityAgreementCreateResponse generateAgreementCreateResponse(String xmlResponse) {

        return (LegalEntityAgreementCreateResponse) responseUnmarshaller(xmlResponse);

    }

    public static LegalEntityAgreementRetrievalResponse generateAgreementRetrievalResponse(String xmlResponse) {

        return (LegalEntityAgreementRetrievalResponse) responseUnmarshaller(xmlResponse);
    }

    public static LegalEntityCreateResponse generateCreateResponse(String xmlResponse) {

        return (LegalEntityCreateResponse) responseUnmarshaller(xmlResponse);
    }

    public static LegalEntityPrincipalCreateResponse generateLegalEntityPrincipalCreateResponse(String xmlResponse) {

        return (LegalEntityPrincipalCreateResponse) responseUnmarshaller(xmlResponse);
    }

    public static LegalEntityPrincipalDeleteResponse generateLegalEntityPrincipalDeleteResponse(String xmlResponse) {

        return (LegalEntityPrincipalDeleteResponse) responseUnmarshaller(xmlResponse);
    }

    public static LegalEntityResponse generateLegalEntityResponse(String xmlResponse) {

        return (LegalEntityResponse) responseUnmarshaller(xmlResponse);
    }

    public static LegalEntityRetrievalResponse generateRetrievalResponse(String xmlResponse) {

        return (LegalEntityRetrievalResponse) responseUnmarshaller(xmlResponse);
    }

    public static PrincipalCreateResponse generatePrincipalCreateResponse(String xmlResponse) {

        return (PrincipalCreateResponse) responseUnmarshaller(xmlResponse);
    }

    public static PrincipalDeleteResponse generatePrincipalDeleteResponse(String xmlResponse) {

        return (PrincipalDeleteResponse) responseUnmarshaller(xmlResponse);
    }

    public static Response generateResponse(String xmlResponse) {

        return (Response) responseUnmarshaller(xmlResponse);
    }

    public static SubMerchantCreateResponse generateSubMerchantCreateResponse(String xmlResponse) {

        return (SubMerchantCreateResponse) responseUnmarshaller(xmlResponse);
    }

    public static SubMerchantRetrievalResponse generateSubMerchantRetrievalResponse(String xmlResponse) {

        return (SubMerchantRetrievalResponse) responseUnmarshaller(xmlResponse);
    }

    public static ErrorResponse generateErrorResponse(String xmlResponse) {

        return (ErrorResponse) responseUnmarshaller(xmlResponse);
    }

    public static String generateAgreementCreateRequest(LegalEntityAgreementCreateRequest request) {

        return requestMarshaller(request);
    }

    public static String generateLegalEntityCreateRequest(LegalEntityCreateRequest request) {

        return requestMarshaller(request);
    }

    public static String generatePrincipalCreateRequest(LegalEntityPrincipalCreateRequest request) {

        return requestMarshaller(request);
    }

    public static String generateUpdateRequest(LegalEntityUpdateRequest request) {

        return requestMarshaller(request);
    }

    public static String generateSubMerchantCreateRequest(SubMerchantCreateRequest request) {

        return requestMarshaller(request);
    }

    public static String generateSubMerchantUpdateRequest(SubMerchantUpdateRequest request) {

        return requestMarshaller(request);
    }

    private static String requestMarshaller(Object request) {
        StringWriter sw = new StringWriter();

        try {
            CnpContext.getJAXBContext().createMarshaller().marshal(request, sw);
        }
        catch (JAXBException ex) {
            throw new PayFacException("Error validating xml data against the schema", ex);
        }

        return sw.toString();
    }

    private static Object responseUnmarshaller(String xml) {

        Object response;

        try {
            response = CnpContext.getJAXBContext().createUnmarshaller().unmarshal(new StringReader(xml));
        }
        catch (JAXBException ex) {
            throw new PayFacException("Error validating xml data against the schema", ex);
        }

        return response;
    }
}
