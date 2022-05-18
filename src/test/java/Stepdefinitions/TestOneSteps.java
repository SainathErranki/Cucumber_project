package Stepdefinitions;

import static org.junit.Assert.assertEquals;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class TestOneSteps {

 @After("@CloseDriver")
  public void teardown() {
	System.out.println("########----Closedriver----#######");  
	  driver.close();
	  
  }
		WebDriver driver=null;
		
		@Before("@HomePage")
		@When("user is in Home Page") 
		public void user_is_in_home_page() throws InterruptedException{
			String path=System.getProperty("user.dir");
			 System.setProperty("webdriver.chrome.driver",path+"/src/test/resources/Drivers/chromedriver.exe"); 
			 driver=new ChromeDriver();
			   driver.get(path+"/Htmlpage/QEIndex.html");
			  try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			  driver.manage().window().maximize();
			  boolean HomescreenText=driver.findElement(By.xpath("//a[text()='Home ' ]")).
			  isDisplayed();
			  
			  assertEquals(true, HomescreenText);
			  
			  System.out.println("User is in Home Page"); 
			  }
		
	
	@Then("verify Email address and Password texts")
	public void verify_email_address_and_password_texts() {
		
		
		boolean flag=false;
        boolean DefaultEmailName=driver.findElement(By.xpath("//input[@id='inputEmail']")).isDisplayed();
        boolean DefaultPasswordName=driver.findElement(By.xpath("//input[@type='password']")).isDisplayed();
        if(DefaultEmailName==true && DefaultPasswordName==true) {
        	 flag=true;
        }
        assertEquals(true, flag);
        
	    System.out.println("Verifying the Email and Password defulat texts");
	}

	
	@And("Verify sign in button")
	public void verify_sign_in_button() {
		
		boolean signbutton=driver.findElement(By.xpath("//button[@type='submit']")).isDisplayed();
        assertEquals(true, signbutton);
	    System.out.println("Sign button should be available");
	    }
	@Then("Enter Email and Password texts")
	public void enter_email_and_password_texts() throws InterruptedException {
		driver.findElement(By.xpath("//input[@id='inputEmail']")).click();
		driver.findElement(By.xpath("//input[@id='inputEmail']")).sendKeys("sainath.erranki@gmail.com");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@type='password']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Erranki@431");
		
	    System.out.println("Email and Password Will be Entered"); 
	}
	
	@When("verify  listgroup values")
	public void verify_listgroup_values() throws InterruptedException {
		boolean flag=false;
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor)driver;  
       
		WebElement name=driver.findElement(By.xpath("//h1[text()='Test 2']"));
		js.executeScript("arguments[0].scrollIntoView();",name);
	   List<WebElement> list=driver.findElements(By.xpath("//li[@class='list-group-item justify-content-between']"));
	   int Number=list.size();
	   if(Number==3) {
		   flag=true;
		   
	   }
	   assertEquals(true, flag);
	}

	@Then("verify second list value name")
	public void verify_second_list_value_name() {
		boolean flag=false;
		List<WebElement> list=driver.findElements(By.xpath("//li[@class='list-group-item justify-content-between']"));
	       int Number=list.size();
		   String listitemname=list.get(1).getText();
		   if(listitemname.contains("List Item 2")) {
			   
			   flag=true;
			   
		   }
		   System.out.println("Verifying Second List value name");
		   assertEquals(true, flag);
	    }

	@Then("verify sccond list item badge value is {int}")
	public void verify_sccond_list_item_badge_value_is(Integer int1) {
		boolean flag=false;
		String Badgevalue=driver.findElement(By.xpath("//li[@class='list-group-item justify-content-between']/following::span[text()='6']")).getText();
	    if(Badgevalue.contains("6")) {
	    	flag=true;
	    	
	    }
	    System.out.println("Verifying Second list Bagge value");
	    assertEquals(true, flag);
	}
	
	
	@When("Default value is option1")
	public void default_value_is_option1() throws InterruptedException {
		boolean flag=false;
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor)driver;  
		WebElement name=driver.findElement(By.xpath("//h1[text()='Test 3']"));
		js.executeScript("arguments[0].scrollIntoView();",name);
		  
		String value=driver.findElement(By.xpath("//button[@id='dropdownMenuButton']")).getText();
		System.out.println("------------------------"+value);
	    if(value.contains("Option 1")) {
	    flag=true;
	    	
	    }
	    assertEquals(true, flag);
	}

	@Then("click on the dropdown and select option3")
	public void click_on_the_dropdown_and_select_option3() throws InterruptedException {
		boolean flag=false;
		driver.findElement(By.xpath("//button[@id='dropdownMenuButton']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='Option 3']")).click();
		Thread.sleep(2000);
		String value=driver.findElement(By.xpath("//button[@id='dropdownMenuButton']")).getText();
	    if(value.contains("Option 3")) {
	    flag=true;
	    	
	    }
	    assertEquals(true, flag);
	}
	@When("First button is enabled and Second button is disabled")
	public void first_button_is_enabled_and_second_button_is_disabled() throws InterruptedException {
		boolean flag=false;
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor)driver;  
     
		WebElement name=driver.findElement(By.xpath("//button[@class='btn btn-lg btn-primary']"));
		js.executeScript("arguments[0].scrollIntoView();",name);
		boolean Enabled=driver.findElement(By.xpath("//button[@class='btn btn-lg btn-primary']")).isEnabled();
		boolean disabled=driver.findElement(By.xpath("//button[@class='btn btn-lg btn-secondary']")).isEnabled();
		System.out.println("Enabled =" +Enabled+ "disabled ="+disabled);
		if (Enabled==true && disabled==false) {
			
			flag=true;
			
		}
		
		assertEquals(true, flag);
		System.out.println("First button is Enabled and Second button is disabled");

	    	}

	@When("Wait for button to displayed")
	public void wait_for_button_to_displayed() throws InterruptedException {
	
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor)driver;  
        
		WebElement name=driver.findElement(By.xpath("//button[@class='btn btn-lg btn-primary']"));
		js.executeScript("arguments[0].scrollIntoView();",name);
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='test5-button']")));
		
			
		
	  
	}

	@Then("click on the button")
	public void click_on_the_button() throws InterruptedException {
     driver.findElement(By.xpath("//button[@id='test5-button']")).click();
     Thread.sleep(2000);
           
	}

	@And("Verify Alert to display in screen")
	public void verify_alert_to_display_in_screen() {
		boolean flag=false;
		boolean temp=driver.findElement(By.xpath("//div[@id='test5-alert']")).isDisplayed();
		if(temp==true) {
			flag=true;
		}
		assertEquals(true, flag);
		System.out.println("Verifying Alret Message");
	    	}

	@Then("Verify button is disabled or not")
	public void verify_button_is_disabled_or_not() {
		boolean flag=false;
	    boolean value=driver.findElement(By.xpath("//button[@id='test5-button']")).isEnabled();
	    System.out.println("value---------"+value);
	    if(value==false) {
	    	flag=true;
	    }
	    assertEquals(true, flag);
	    
	}
	@When("Get any value in Tabular form:")
	public void get_any_value_in_tabular_form(DataTable dataTable) {
		
	    System.out.println("Getting any cell value");
	  
	    List<String> temp =dataTable.asList();
	    System.out.println("rows.size()------------"+temp.size());
	   
	    
	    for(int i=0; i<temp.size(); i++) { 
	    //for(int i: ) {
	    char Row=temp.get(i).charAt(1);
	    char Colloum=temp.get(i).charAt(3);
	    String Value=driver.findElement(By.xpath("//*[@id=\"test-6-div\"]/div/table/tbody/tr["+Row+"]/td["+Colloum+"]")).getText();
	   
	    System.out.println("Value-------"+Value);
	   }
	    }
	

@Then("Verify the postion of value in tabular form")
public void verify_the_postion_of_value_in_tabular_form() {
      boolean flag=false;
	  String Row="2";
	  String Coloum="2";
	  String value=driver.findElement(By.xpath("//*[@id=\"test-6-div\"]/div/table/tbody/tr["+Row+"]/td["+Coloum+"]")).getText();
	  if(value.equalsIgnoreCase("Carswell")) {
		  
		  flag=true;
	}
		
		 assertEquals(true, flag);
		 System.out.println("Gettings 2,2 cell value");
	    	}

	@Then("Verify Ventosanzap cell value")
	public void verify_ventosanzap_cell_value() {
		boolean flag=false;
		
		WebElement table = driver.findElement(By.xpath("//*[@id=\"test-6-div\"]/div/table"));
        
        List<WebElement> rws = table.findElements(By.tagName("tr"));
        int rows_cnt = rws.size();
        System.out.println(rows_cnt);
       
		for (int i = 0;i < rows_cnt; i++) {
	         List<WebElement> cols = rws.get(i).findElements(By.tagName("td"));
	         int cols_cnt = cols.size();
	         for (int j = 0;j < cols_cnt; j++) {
	         if(cols.get(j).getText().contains("Ventosanzap")) {
	        	 System.out.println("Cell Value"+i+" "+j);
	        	 if(i==3 && j==2) {
	        		 flag=true;
	        	 }
	        	 
	         }
	         
	         }
		}
		
		assertEquals(true, flag);
		System.out.println("Getting cell value of Ventosanzap");
	}


}