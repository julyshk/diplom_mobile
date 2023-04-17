 package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.EmulatorConfig;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import static io.appium.java_client.remote.AutomationName.ANDROID_UIAUTOMATOR2;
import static io.appium.java_client.remote.MobilePlatform.ANDROID;
import static org.apache.commons.io.FileUtils.copyInputStreamToFile;

import javax.annotation.Nonnull;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

 public class LocalMobileDriver implements WebDriverProvider {

     public static URL getAppiumServerUrl() {
         EmulatorConfig emulatorConfig = ConfigFactory.create(EmulatorConfig.class);
         try {
             return new URL(emulatorConfig.appiumServer());
         } catch (MalformedURLException e) {
             throw new RuntimeException(e);
         }
     }

    // public static URL getAppiumServerUrl() {
       //  try {
       //      return new URL("http://localhost:4723/wd/hub");
        // } catch (MalformedURLException e) {
         //    throw new RuntimeException(e);
         //}
     //}

     @Nonnull
     @Override
     public WebDriver createDriver(@Nonnull Capabilities capabilities) {
         EmulatorConfig emulatorConfig = ConfigFactory.create(EmulatorConfig.class);
         UiAutomator2Options options = new UiAutomator2Options();
         options.merge(capabilities);

         options.setAutomationName(ANDROID_UIAUTOMATOR2)
                 .setPlatformName(ANDROID)
                 .setDeviceName(emulatorConfig.deviceName())
                 .setPlatformVersion(emulatorConfig.platformVersion())
                 .setApp(getApk().getAbsolutePath())
                 .setAppPackage(emulatorConfig.appPackage())
                 .setAppActivity(emulatorConfig.appActivity());

         return new AndroidDriver(getAppiumServerUrl(), options);
     }

     private File getApk() {
         return new File("src/test/resources/apps/ru.farpost.dromfilter_6.1.0_896.apk");
     }

 }
