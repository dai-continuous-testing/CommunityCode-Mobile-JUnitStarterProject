# CommunityCode Mobile: JUnit Starter Project
The JUnit Starter Project enables you to quickly run tests with minimal coding. The project itself compiles and can be run immediately.
## Setting Up the Project

To set up the project:
1. Clone the project by running the following:
   ```
   git clone https://github.com/ExperitestOfficial/CommunityCode-Mobile-JUnitStarterProject
   cd CommunityCode-Mobile-JUnitStarterProject
   ```   
1. Set up authentication by updating the following parameters in [cloud.properties](cloud.properties):
   * cloud.url - Url for the cloud the test would run in. For example, https://company.experitest.com/
   * cloud.accessKey -  Personal authentication. See [Obtaining Access Key](https://docs.digital.ai/bundle/TE/page/obtaining_access_key.html) to learn how to obtain an access key. 

## Running Tests

To run the tests in this project, run the following on the command line: 

Sequential:
```bash
./gradlew test
```

Parallel:
```bash
./gradlew test -PparallelTests
```

## Uploading the Application to the Cloud

The example tests in native_demo in this project use a demo application. 
To upload your own application to cloud:
1. Log in to the cloud using a browser.
1. In the left menu click Applications.
1. Click Upload.
1. Click the application file to upload.

In your tests, set *com.experitest.ExperiBank* (and activity if needed) to the desired capabilities for your application.

* For Android:
```
dc.setCapability(MobileCapabilityType.APP, "cloud:com.experitest.ExperiBank/.LoginActivity");
dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.experitest.ExperiBank");
dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".LoginActivity");
```
* For iOS:
```
dc.setCapability(MobileCapabilityType.APP, "cloud:com.experitest.ExperiBank");
dc.setCapability(IOSMobileCapabilityType.BUNDLE_ID, "com.experitest.ExperiBank");
```
For more ways to upload your application to the cloud, see [Native Applications Testing](https://docs.digital.ai/bundle/TE/page/native_applications_testing.html).

## Desired Capabilities

Continuous Cloud Testing expands Appium's capabilities and allows better control over the device and test. 
In these examples we use the desired capabilities to set the test name and choose devices to run on, as well as set the application as shown above.
See [Capabilities in Appium Based Tests](https://docs.digital.ai/bundle/TE/page/appium_oss_supported_capabilities.html) to learn how to customize the desired capabilities for your tests.

## Documentation
To find out more about Continuous Cloud Testing usage, features, and best practices, visit our online [documentation](https://docs.digital.ai/bundle/TE/page/test_execution_home.html). 

## Support
If you encounter an issue that is not covered here or in our online documentation, contact us at [support@digital.ai](mailto:support@digital.ai).