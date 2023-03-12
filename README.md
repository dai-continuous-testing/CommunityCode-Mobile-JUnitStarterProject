# CommunityCode-Mobile-JUnitStarterProject
Start Writing tests with Continuous Testing Cloud and Java JUnit
### Clone The Sample Project

Clone the sample project from [CommunityCode-Mobile-JUnitStarterProject](https://github.com/ExperitestOfficial/CommunityCode-Mobile-JUnitStarterProject) repository and navigate to the code directory as shown below:

```bash
git clone https://github.com/ExperitestOfficial/CommunityCode-Mobile-JUnitStarterProject
cd CommunityCode-Mobile-JUnitStarterProject
```


### Set Up Authentication

Update [cloud.properties](cloud.properties):
* **cloud.url** is the url for the cloud the test would run in, e.g - https://company.experitest.com/
* **cloud.accessKey** is your personal authentication. [See here](https://docs.experitest.com/pages/viewpage.action?pageId=52593435) on how to obtain an access key 

### Run Tests

To run the tests in this project, execute to following command line: 

```bash
./gradlew test
```

### Upload Application to the Cloud

The example tests in this project are using a demo application. 
To upload your own application to cloud, log in to the cloud using a browser, choose *Applications* in the left hand menu, click on *upload*, and choose the application file you want to upload.

In you tests, change *com.experitest.ExperiBank* (and activity if needed) in desired capabilities to you application, in the following lines:

* For android:
```java
dc.setCapability(MobileCapabilityType.APP, "cloud:com.experitest.ExperiBank/.LoginActivity");
dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.experitest.ExperiBank");
dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".LoginActivity");
```
* For iOS:
```java
dc.setCapability(IOSMobileCapabilityType.BUNDLE_ID, "com.experitest.ExperiBank");
dc.setCapability(IOSMobileCapabilityType.BUNDLE_ID, "com.experitest.ExperiBank");
```
for more ways to upload your application to the cloud, [see here](https://docs.experitest.com/display/TE/Native+Applications+Testing).

### Desired Capabilities

Continuous Testing expands Appium's capabilities and allows better control over the device and test. 
In the provided examples we have used the desired capabilities to set the test name and choose devices to run on, as well as set the application as shown above.
[See here](https://docs.experitest.com/display/TE/Capabilties+in+Appium+Based+Tests) how to customise desired capabilities for you tests.

### Documentation
To find out more about CT usage, features and best practices, visit our [Documentation](https://docs.experitest.com/display/TE/Test+Execution+Home) 

### Support
