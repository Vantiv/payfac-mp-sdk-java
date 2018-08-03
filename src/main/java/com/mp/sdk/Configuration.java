package com.mp.sdk;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Configuration {

    private static final String PAYFAC_SDK_CONFIG = ".payfac_SDK_config.properties";

    public File location() {
        File file = new File(System.getProperty("user.home") + File.separator + PAYFAC_SDK_CONFIG);
        if(System.getProperty("java.specification.version").equals("1.4")) {
            if(System.getProperty("MP_CONFIG_DIR") != null) {
                file = new File(System.getProperty("MP_CONFIG_DIR") + File.separator + PAYFAC_SDK_CONFIG);
            }
        }
        else {
            if(System.getenv("MP_CONFIG_DIR") != null) {
                if(System.getenv("MP_CONFIG_DIR").equals("classpath:" + PAYFAC_SDK_CONFIG)) {
                    if (getClass().getClassLoader().getResource(PAYFAC_SDK_CONFIG) != null) {
                        String filePath = getClass().getClassLoader().getResource(PAYFAC_SDK_CONFIG).getPath();
                        file = new File(filePath);
                    }
                }
                else {
                    file = new File(System.getenv("MP_CONFIG_DIR") + File.separator + PAYFAC_SDK_CONFIG);
                }
            }
        }
        return file;
    }

    public Properties getProperties() {

        Properties properties;
        FileInputStream fileInputStream = null;
        try {
            properties = new Properties();
            fileInputStream = new FileInputStream((new Configuration()).location());
            properties.load(fileInputStream);
            return properties;
        } catch (FileNotFoundException e) {
            throw new PayFacException("Configuration file not found." +
                    " If you are not using the .payfac_SDK_config.properties file," +
                    " If you are using .payfac_SDK_config.properties, you can generate one using java -jar payfac-mp-sdk-java-x.xx.jar", e);
        } catch (IOException e) {
            throw new PayFacException("Configuration file could not be loaded.  Check to see if the user running this has permission to access the file", e);
        } finally {
            if (fileInputStream != null){
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    throw new PayFacException("Configuration FileInputStream could not be closed.", e);
                }
            }
        }
    }
}
