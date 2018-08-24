package com.mp.sdk;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

/**
 * A factory that encapsulates singleton instances of a Cnp JAXB Context and ObjectFactory.
 * @author stephenhall
 *
 */
public class CnpContext {

    private static JAXBContext jaxbContext;

    private static final ObjectFactory objectFactory = initObjectFactory();

    private static JAXBContext initJAXBContext() {
        try {
            return newInstance();
        } catch (JAXBException e) {
            throw new PayFacException("Unable to load jaxb dependencies.  Perhaps a classpath issue?", e);
        }
    }

    private static ObjectFactory initObjectFactory() {
        return new ObjectFactory();
    }

    public static JAXBContext getJAXBContext() {
        if (jaxbContext == null) {
            jaxbContext = initJAXBContext();
        }
        return jaxbContext;
    }

    public static ObjectFactory getObjectFactory() {
        return objectFactory;
    }

    private static JAXBContext newInstance() throws JAXBException {
        return JAXBContext.newInstance("com.mp.sdk");
    }

}