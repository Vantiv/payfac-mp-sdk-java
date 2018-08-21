package com.mp.sdk;

import java.io.*;
import java.util.Properties;

public class Setup {

    private enum EnvironmentConfiguration {
        SANDBOX("sandbox", "https://www.testvantivcnp.com/sandbox/payfac"),
        PRELIVE("prelive", "https://services.vantivprelive.com"),
        POSTLIVE("postlive", "https://services.vantivpostlive.com"),
        PRODUCTION("production", "https://services.vantivcnp.com"),
        OTHER("other", "You will be asked for all the values");

        private final String key;
        private final String url;

        private EnvironmentConfiguration(final String key, final String online) {
            this.key = key;
            url = online;
        }

        public final String getKey() {
            return key;
        }

        public final String getUrl() {
            return url;
        }

        public static final EnvironmentConfiguration fromValue(final String value) {
            for(final EnvironmentConfiguration environmentConfiguration : EnvironmentConfiguration.values()) {
                if(environmentConfiguration.getKey().equals(value)) {
                    return environmentConfiguration;
                }
            }
            return null;
        }
    }

    public static void main(String[] args) throws IOException {

        File file = (new Configuration()).location();
        Properties config = new Properties();
        PrintStream configFile = new PrintStream(file);
        String userInput = "";


        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Welcome to the Merchant Provisioner PayFac Java SDK");

        System.out.print("Please input your presenter user name: ");
        config.put("username", input.readLine());

        System.out.print("Please input your presenter password: ");
        config.put("password", input.readLine());

        System.out.print("Please input your merchantId: ");
        config.put("merchantId", input.readLine());

       environmentConfig(userInput, input, config);

        System.out.print("\nPlease input the timeout: ");
        userInput = input.readLine();
        config.put("timeout", (userInput == null ? "" : "10000"));

        config.put("printXml", "false");
        config.put("neuterXml", "false");

        config.store(configFile, "");
        System.out.println("The payfac configuration file has been generated, the file is located at " + file.getAbsolutePath());

        configFile.close();
    }

    public static void environmentConfig(String userInput, BufferedReader input, Properties config) throws IOException {
        boolean badInput = false;
        do {
            if(badInput) {
                System.out.println("====== Invalid choice enetered ==========");
            }
            System.out.println("Please choose an environment from the following list (example: 'prelive'): ");
            for (final EnvironmentConfiguration environmentConfiguration : EnvironmentConfiguration.values()) {
                System.out.println(String.format("\t%s => %s", environmentConfiguration.getKey(), environmentConfiguration.getUrl()));
            }

            userInput = input.readLine();
            EnvironmentConfiguration selected = EnvironmentConfiguration.fromValue(userInput);

            if(selected == null) {
                badInput = true;
            }

            else if (EnvironmentConfiguration.OTHER.equals(selected)) {
                System.out.println("Please input the URL for online transactions (ex: https://www.testvantivcnp.com/sandbox/communicator/online): ");
                config.put("url", input.readLine());
                badInput = false;
            }
            else {
                config.put("url", selected.getUrl());
                badInput = false;
            }
        }
        while(badInput);
    }
}
