[![Build Status](https://travis-ci.org/Vantiv/payfac-mp-sdk-java.svg?branch=13.x)](https://travis-ci.org/Vantiv/payfac-mp-sdk-java)
[![codecov](https://codecov.io/gh/Vantiv/payfac-mp-sdk-java/branch/13.x/graph/badge.svg)](https://codecov.io/gh/Vantiv/payfac-mp-sdk-java)
[ ![Release](https://api.bintray.com/packages/vantivcnp/maven/payfac-mp-sdk-java/images/download.svg) ](https://bintray.com/vantivcnp/maven/payfac-mp-sdk-java/_latestVersion) 
![Github All Releases](https://img.shields.io/github/downloads/vantiv/payfac-mp-sdk-java/total.svg)
[![GitHub](https://img.shields.io/github/license/vantiv/payfac-mp-sdk-java.svg)](https://github.com/Vantiv/payfac-mp-sdk-java/13.x/LICENSE) 
[![GitHub issues](https://img.shields.io/github/issues/vantiv/payfac-mp-sdk-java.svg)](https://github.com/Vantiv/payfac-mp-sdk-java/issues)

# payfac-mp-sdk-java

The PayFac Merchant Provisioner SDK is a Java implementation of the [Worldpay](https://developer.vantiv.com/community/ecommerce) PayFac Merchant Provisioner API. This SDK was created to make it as easy as possible to perform operations that allows you to create and update Legal Entities and Sub-merchants, as well as retrieve information about existing Legal Entities and Sub-merchants in near real-time. This SDK utilizes the HTTPS protocol to securely connect to Worldpay. Using the SDK requires coordination with the Vantiv eCommerce team in order to be provided with credentials for accessing our systems.

Each Java SDK release supports all of the functionality present in the associated PayFac Merchant Provisioner API version (e.g., SDK v13.0.0 supports API v13.0.0). Please see our [documentation](https://developer.vantiv.com/community/ecommerce/pages/documentation) for PayFac Merchant Provisioner API to get more details on what operations are supported.

This SDK is implemented to support the Java programming language and is created by Worldpay. Its intended use is for PayFac API operations with Worldpay.


## Getting Started

These instructions will help you get started with using the SDK.

### Prerequisites

None.


### Setup

1. Add JCenter repository to your Maven or Gradle build:
	1. For Maven, please read instructions at: https://bintray.com/bintray/jcenter
	2. For Gradle, add `jcenter()` to your `repositories { ... }`
2. Add the dependency
    1. For Maven:
        ```xml
            <dependency>
              <groupId>com.worldpay</groupId>
              <artifactId>payfac-mp-sdk-java</artifactId>
              <version>13.0.0</version>
              <type>pom</type>
            </dependency>
        ```

    2. For Gradle:
        ```groovy
            compile 'com.worldpay:payfac-mp-sdk-java:13.0.0'
        ```
3. Create your configuration file with one of the following
    * Run `java -jar /path/to/payfac-mp-sdk-java-X.X.X.jar` and answer the questions, or
    * Add a file `.payfac_SDK_config.properties` to your home directory with the correct properties in it

### Configuration
List of configuration parameters along with their values can be found [here](https://gist.github.com/VantivSDK/8b7dd606230ec65b36eba457df4443de).


## Usage example

```java
import com.mp.sdk.ApprovedMccResponse;
import com.mp.sdk.Communication;
import com.mp.sdk.Configuration;
import com.mp.sdk.PayFacMcc;

public class SamplePayFacRequest {

  public static void main(String[] args) {

    PayFacMcc payFacMcc = new PayFacMcc();
    ApprovedMccResponse response = payFacMcc.getMcc();
    
    // Display result
    System.out.println("Mcc: " + response.getApprovedMccs());
  }
}
```
## Built With

* [Gradle](https://gradle.org/) - The build tool
* [Maven](https://maven.apache.org/) - Dependency Management

## Versioning
For the versions available, see the [tags on this repository](https://github.com/vantiv/payfac-mp-sdk-java/tags). 

## Changelog
For the list of changes, check out the [changelog](https://github.com/Vantiv/payfac-mp-sdk-java/blob/13.x/CHANGELOG.md)

## Authors

* [**Ayush Agarwal**](https://github.com/ayush17agarwal)
* [**Chen Chang**](https://github.com/cc6980312)

See also the list of [contributors](https://github.com/vantiv/payfac-mp-sdk-java/contributors) who participated in this project.

## License
This project is licensed under the MIT License - see the [LICENSE](https://github.com/Vantiv/payfac-mp-sdk-java/blob/13.x/LICENSE.md) file for details

## Examples
More examples can be found in [Functional and Unit Tests](https://github.com/Vantiv/payfac-mp-sdk-java/tree/13.x/src/test/java/com/mp/sdk)

## Support
Please contact [Vantiv eCommerce](https://developer.vantiv.com/community/ecommerce) to receive valid merchant credentials in order to run tests successfully or if you require assistance in any way.  Support can also be reached at sdksupport@Vantiv.com
