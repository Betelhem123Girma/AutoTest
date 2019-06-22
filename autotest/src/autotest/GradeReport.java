package autotest;


import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author B
 */
public class GradeReport {
     public static void main(String[] args) throws InterruptedException, FileNotFoundException, UnsupportedEncodingException 
     {
         // Create a new instance of the Firefox driver
         System.setProperty("webdriver.chrome.driver", "C:\\Gecko\\chromedriver.exe");
         WebDriver driver;
         driver = new ChromeDriver();
         //Launch the some site
         driver.get("https://portal.aait.edu.et");
         // Print a Log In message to the screen
         //System.out.println("Successfully opened the website localhost");
         //String Title = driver.getTitle(); 
         //System.out.println("Page Title: "+Title); 
         //String CurrentUrl = driver.getCurrentUrl();
         //String PageSource = driver.getPageSource();
         //System.out.println("URL: "+CurrentUrl); 
         //System.out.println("Source Code: "+PageSource);
        
         driver.findElement(By.xpath(".//*[@id=\"UserName\"]")).sendKeys("Atr/4080/09");  
         driver.findElement(By.xpath(".//*[@id=\"Password\"]")).sendKeys("0075");  
         
          
        driver.findElement(By.xpath(".//*[@id=\"home\"]/div[2]/div[2]/form/div[4]/div/button")).click(); 
        String url="https://portal.aait.edu.et/Grade/GradeReport";
        driver.navigate().to(url);
        driver.navigate().refresh();
       String gradeReport= driver.findElement(By.xpath(".//html/body/div[2]/div/div[2]/div[1]/div/div/table")).getText(); 
       System.out.println(gradeReport);
    
           PrintWriter writer = new PrintWriter("C://Grade/grade.txt", "UTF-8");
           writer.println(gradeReport);
      
             writer.close();


        Thread.sleep(5000);
         driver.quit();
         

}
}

