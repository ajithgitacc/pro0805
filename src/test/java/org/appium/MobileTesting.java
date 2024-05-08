package org.appium;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.PointerInput.Kind;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.appium.java_client.AppiumDriver;

public class MobileTesting {
	public static void main(String[] args) throws MalformedURLException {
		//To launch the app 
		DesiredCapabilities caps= new DesiredCapabilities();
		caps.setCapability("platformName", "Android");
		caps.setCapability("platformVersion", "14");
		caps.setCapability("deviceName", "oneplus");
		caps.setCapability("automationName", "uiAutomator2");
		caps.setCapability("packageName", "com.omr_branch");
		caps.setCapability("appActivity", "com.omr_branch.MainActivity");
		URL url= new URL("http://127.0.0.1:4723/");
		WebDriver driver= new AppiumDriver(url, caps);
		
		//code for swipe up 
		Dimension size = driver.manage().window().getSize();
		int width = size.getWidth();
		int height = size.getHeight();
		int centerX= width/2;
		int startY=(int) (height*0.70);
		int endY= (int) (height*0.30);
		PointerInput pointer= new PointerInput(Kind.TOUCH, "finger1");
		Sequence swipe= new Sequence(pointer, 1);
		swipe.addAction(pointer.createPointerMove(Duration.ofSeconds(0),PointerInput.Origin.viewport(), centerX, startY));
		swipe.addAction(pointer.createPointerDown(1));
		swipe.addAction(pointer.createPointerMove(Duration.ofSeconds(1),PointerInput.Origin.viewport(), centerX, endY));
		swipe.addAction(pointer.createPointerUp(1));
		List<Sequence> asList = Arrays.asList(swipe);
		RemoteWebDriver remote= (RemoteWebDriver)driver;
		remote.perform(asList);
		
		 
		
	}

}
