/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autotest;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author hp-
 */
public class UnreadEmail {

    /**
     * @param args the command line arguments
     */
     public static void main(String[] args) throws InterruptedException, FileNotFoundException, UnsupportedEncodingException 
     {
         // Create a new instance of the Firefox driver
         System.setProperty("webdriver.chrome.driver", "C:\\Gecko\\chromedriver.exe");
         WebDriver driver;
         driver = new ChromeDriver();
         //Launch the some site
         driver.get("https://gmail.com");
         // Print a Log In message to the screen
         //System.out.println("Successfully opened the website localhost");
         //String Title = driver.getTitle(); 
         //System.out.println("Page Title: "+Title); 
         //String CurrentUrl = driver.getCurrentUrl();
         //String PageSource = driver.getPageSource();
         //System.out.println("URL: "+CurrentUrl); 
         //System.out.println("Source Code: "+PageSource);
        WebDriverWait wait=new WebDriverWait(driver,20);
         driver.findElement(By.xpath(".//*[@id=\"identifierId\"]")).sendKeys("betelhemgg4@gmail.com");  
          driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
// Go back to Home Page  
        driver.findElement(By.xpath(".//*[@id=\"identifierNext\"]/span/span")).click(); 
         driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

         WebElement password=driver.findElement(By.xpath(".//*[@id=\"password\"]/div[1]/div/div[1]/input"));          
// Go back to Home Page 
          wait.until(ExpectedConditions.elementToBeClickable(password));
          password.sendKeys("cheaperby12");
        driver.findElement(By.xpath(".//*[@id=\"passwordNext\"]/span")).click(); 
         //Wait for 5 Sec 
         System.out.println("*************************************");
          driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
   
    PrintWriter writer = new PrintWriter("C://Email/Unread Email.txt", "UTF-8");
  
 
  List<WebElement> mailsObj=driver.findElements(By.xpath("//*[@class='zF']"));
 for(int i=0;i<mailsObj.size();i++){
  String unread=mailsObj.get(i).getText();
  System.out.println(unread);
        writer.append(unread+'\n');
       // writer.println(unread);
        
       
 
 }    // Close the driver
 writer.close();
          Thread.sleep(500000000);
           System.out.println("total no of unread mails are "+mailsObj.size());
        driver.quit();  
     }   
    
}

