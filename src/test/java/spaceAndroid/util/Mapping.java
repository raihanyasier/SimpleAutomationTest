package spaceAndroid.util;

import org.openqa.selenium.By;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by raihan on 6/28/16.
 */
public class Mapping {
    Properties prop;

    public Mapping(String filePath){
        prop = new Properties();
        try{
            FileInputStream fis = new FileInputStream(filePath);
            prop.load(fis);
            fis.close();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    public By getLocator(String element) throws Exception{
        String locator = prop.getProperty(element);

        String locType = locator.split(":")[0];
        String locVal = locator.split(":")[1];

        if (locType.toLowerCase().equals("id"))
            return By.id(locVal);
        else if (locType.toLowerCase().equals("name"))
            return By.name(locVal);
        else  if ((locType.toLowerCase().equals("classname")) || (locType.toLowerCase().equals("class")))
            return By.className(locVal);
        else if ((locType.toLowerCase().equals("tagname")) || (locType.toLowerCase().equals("tag")))
            return By.tagName(locVal);
        else if ((locType.toLowerCase().equals("linktext")) || (locType.toLowerCase().equals("link")))
            return By.linkText(locVal);
        else if (locType.toLowerCase().equals("partiallinktext"))
            return By.partialLinkText(locVal);
        else if ((locType.toLowerCase().equals("cssselector")) || (locType.toLowerCase().equals("css")))
            return By.cssSelector(locVal);
        else if (locType.toLowerCase().equals("xpath"))
            return By.xpath(locVal);
        else
            throw new Exception("Unknown locator type '" + locType + "'");
    }
}
