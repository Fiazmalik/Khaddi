package Autotest.Khaddi;
import org.testng.annotations.Test;


import org.testng.annotations.BeforeMethod;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import methods.Excel_methods;

public class RegistrationTest {
	Excel_methods method=new Excel_methods();
	WebDriver driver=null;
	String F_name="";
	String Last_name="";
	String DOB="";
	String gender="";
	String email_address="";
	String password="";
	String Confrm_password="";
	String Actuall="";
	String Expected="";
	String random_email=method.randomEmail();
	/* Scene 
	 * 
	 */
	@Test(priority=1)
	public void validateallgood_male() throws Exception {
		String random_email=method.randomEmail();
		method.setCellData("Khaddi Smoke", 4, 1, random_email);            //setCellData(String sheetName, int colNum, int rowNum, String str)
		dataFromExcel("Khaddi Smoke",1);                                   //dataFromExcel(String SheetName,int i)
		sendtoWebsite();
		Actuall=driver.findElement(By.xpath("//div[text()='Thank you for registering with Khaadi.']")).getText();
		Assert.assertEquals(Actuall, Expected);
		method.setCellData("Khaddi Smoke", 8, 1, Actuall);               //setCellData(String sheetName, int colNum, int rowNum, String str)
		method.setCellData("Khaddi Smoke", 9, 1, "Pass");				//setCellData(String sheetName, int colNum, int rowNum, String str)

	}
	@Test(priority=1)
	public void validateallgood_Female() throws Exception
	{
		String random_email=method.randomEmail();
		method.setCellData("Khaddi Smoke", 4, 2, random_email);        //setCellData(String sheetName, int colNum, int rowNum, String str)
		dataFromExcel("Khaddi Smoke",2);                               //dataFromExcel(String SheetName,int i)
		sendtoWebsite();
		Actuall=driver.findElement(By.xpath("//div[text()='Thank you for registering with Khaadi.']")).getText();
		Assert.assertEquals(Actuall, Expected);
		method.setCellData("Khaddi Smoke", 8, 2, Actuall);            //setCellData(String sheetName, int colNum, int rowNum, String str)
		method.setCellData("Khaddi Smoke", 9, 2, "Pass");            //setCellData(String sheetName, int colNum, int rowNum, String str)

	}
	@Test(priority=2)
	public void validate_If_First_name_isEmpty() throws Exception {

		dataFromExcel("Khaddi Sanity",1);                               //dataFromExcel(String SheetName,int i)
		sendtoWebsite(); 
		Thread.sleep(3000);
		Actuall=driver.findElement(By.xpath("//input[@id='firstname']")).getAttribute("aria-describedby");
		Assert.assertEquals(Actuall, Expected);
		method.setCellData("Khaddi Sanity", 8, 1, Actuall);          //setCellData(String sheetName, int colNum, int rowNum, String str)
		method.setCellData("Khaddi Sanity", 9, 1, "Pass");          //setCellData(String sheetName, int colNum, int rowNum, String str)
	}

	@Test(priority=3)
	public void validate_If_Last_name_isEmpty() throws Exception {

		dataFromExcel("Khaddi Sanity",2);                              //dataFromExcel(String SheetName,int i)
		sendtoWebsite();
		Thread.sleep(3000);
		Actuall=driver.findElement(By.xpath("//input[@id='lastname']")).getAttribute("aria-describedby");
		Assert.assertEquals(Actuall, Expected);
		method.setCellData("Khaddi Sanity", 8, 2, Actuall);          //setCellData(String sheetName, int colNum, int rowNum, String str)
		method.setCellData("Khaddi Sanity", 9, 2, "Pass");          //setCellData(String sheetName, int colNum, int rowNum, String str)
	}

	@Test(priority=4)
	public void validate_If_Email_isEmpty() throws Exception {

		dataFromExcel("Khaddi Sanity",3);                               //dataFromExcel(String SheetName,int i)
		sendtoWebsite();
		Thread.sleep(3000);
		Actuall=driver.findElement(By.xpath("//input[@id='email_address']")).getAttribute("aria-describedby");
		Assert.assertEquals(Actuall, Expected);
		method.setCellData("Khaddi Sanity", 8, 3, Actuall);          //setCellData(String sheetName, int colNum, int rowNum, String str)
		method.setCellData("Khaddi Sanity", 9, 3, "Pass");          //setCellData(String sheetName, int colNum, int rowNum, String str)
	}

	@Test(priority=5)
	public void validate_If_confirm_password_isEmpty() throws Exception {

		dataFromExcel("Khaddi Sanity",4);                              //dataFromExcel(String SheetName,int i)
		sendtoWebsite();
		Thread.sleep(3000);
		Actuall=driver.findElement(By.xpath("//input[@id='password-confirmation']")).getAttribute("aria-describedby");
		Assert.assertEquals(Actuall, Expected);
		method.setCellData("Khaddi Sanity", 8, 4, Actuall);          //setCellData(String sheetName, int colNum, int rowNum, String str)
		method.setCellData("Khaddi Sanity", 9, 4, "Pass");          //setCellData(String sheetName, int colNum, int rowNum, String str)
	}

	@Test(priority=6)
	public void validate_If_password_isEmpty() throws Exception {

		dataFromExcel("Khaddi Sanity",5);                              //dataFromExcel(String SheetName,int i)
		sendtoWebsite();
		Thread.sleep(3000);
		Actuall=driver.findElement(By.xpath("//input[@id='password']")).getAttribute("aria-describedby");
		Assert.assertEquals(Actuall, Expected);
		method.setCellData("Khaddi Sanity", 8, 5, Actuall);          //setCellData(String sheetName, int colNum, int rowNum, String str)
		method.setCellData("Khaddi Sanity", 9, 5, "Pass");          //setCellData(String sheetName, int colNum, int rowNum, String str)
	}
	@Test(priority=7)
	public void validate_If_password_Match_confrm_one() throws Exception {

		dataFromExcel("Khaddi Sanity",6);                              //dataFromExcel(String SheetName,int i)
		sendtoWebsite();
		Thread.sleep(3000);
		Actuall=driver.findElement(By.xpath("//input[@id='password-confirmation']")).getAttribute("aria-describedby");
		Assert.assertEquals(Actuall, Expected);
		method.setCellData("Khaddi Sanity", 8, 6, Actuall);         //setCellData(String sheetName, int colNum, int rowNum, String str)
		method.setCellData("Khaddi Sanity", 9, 6, "Pass");         //setCellData(String sheetName, int colNum, int rowNum, String str)
	}

	@Test(priority=8)
	public void validate_If_password_isToo_short() throws Exception {

		dataFromExcel("Khaddi Sanity",7);                              //dataFromExcel(String SheetName,int i)
		sendtoWebsite();
		Thread.sleep(3000);
		Actuall=driver.findElement(By.xpath("//div[@id='password-strength-meter']")).getText();
		System.out.println("Actuall error is "+Actuall);
		Assert.assertEquals(Actuall, Expected);
		method.setCellData("Khaddi Sanity", 8, 7, Actuall);         //setCellData(String sheetName, int colNum, int rowNum, String str)
		method.setCellData("Khaddi Sanity", 9, 7, "Pass");         //setCellData(String sheetName, int colNum, int rowNum, String str)
	}
	@Test(priority=9)
	public void validate_If_Email_is_formatted() throws Exception {

		dataFromExcel("Khaddi Sanity",8);                              //dataFromExcel(String SheetName,int i)
		sendtoWebsite();
		Thread.sleep(3000);
		Actuall=driver.findElement(By.xpath("//input[@id='email_address']")).getAttribute("aria-describedby");
		System.out.println("Actuall error is "+Actuall);
		Assert.assertEquals(Actuall, Expected);
		method.setCellData("Khaddi Sanity", 8, 8, Actuall);         //setCellData(String sheetName, int colNum, int rowNum, String str)
		method.setCellData("Khaddi Sanity", 9, 8, "Pass");         //setCellData(String sheetName, int colNum, int rowNum, String str)
	}
	@Test(priority=10)
	public void validate_If_Gender_is_Entered() throws Exception {
		String random_email=method.randomEmail();
		method.setCellData("Khaddi Sanity", 4, 9, random_email);        //setCellData(String sheetName, int colNum, int rowNum, String str)
		dataFromExcel("Khaddi Sanity",9);                              //dataFromExcel(String SheetName,int i)
		sendtoWebsite();
		Thread.sleep(3000);
		Actuall="Gender error";
		System.out.println("Actuall error is "+Actuall);
		Actuall=driver.findElement(By.xpath("//div[text()='Thank you for registering with Khaadi.']")).getText();
		Assert.assertNotEquals(Actuall, Expected, "The test passes ");
		method.setCellData("Khaddi Sanity", 8, 9, Actuall);         //setCellData(String sheetName, int colNum, int rowNum, String str)
		method.setCellData("Khaddi Sanity", 9, 9, "Fail");			//setCellData(String sheetName, int colNum, int rowNum, String str)
		}
	@Test(priority=11)
	public void validate_If_date_is_Formatted() throws Exception {
		dataFromExcel("Khaddi Sanity",10);                              //dataFromExcel(String SheetName,int i)
		sendtoWebsite();
		Thread.sleep(3000);
		Actuall=driver.findElement(By.xpath("//input[@id='dob']")).getAttribute("aria-describedby");
		System.out.println("Actuall error is "+Actuall);
		Assert.assertEquals(Actuall, Expected);
		method.setCellData("Khaddi Sanity", 8, 10, Actuall);         //setCellData(String sheetName, int colNum, int rowNum, String str)
		method.setCellData("Khaddi Sanity", 9, 10, "Pass");         //setCellData(String sheetName, int colNum, int rowNum, String str)
	}
	@Test(priority=12)
	public void validate_If_date_is_Entered() throws Exception {
		String random_email=method.randomEmail();
		method.setCellData("Khaddi Sanity", 4, 11, random_email);         //setCellData(String sheetName, int colNum, int rowNum, String str)
		dataFromExcel("Khaddi Sanity",11);                              //dataFromExcel(String SheetName,int i)
		sendtoWebsite();
		Thread.sleep(3000);
		Actuall=driver.findElement(By.xpath("//div[text()='Thank you for registering with Khaadi.']")).getText();
		System.out.println("Actuall error is "+Actuall);
		Assert.assertNotEquals(Actuall, Expected, "The test passes ");
		method.setCellData("Khaddi Sanity", 8, 11, Actuall);         //setCellData(String sheetName, int colNum, int rowNum, String str)
		method.setCellData("Khaddi Sanity", 9, 11, "Fail");			//setCellData(String sheetName, int colNum, int rowNum, String str)
	}

	@BeforeMethod
	public void beforeMethod() throws Exception {
		method.methods();
		System.setProperty("webdriver.chrome.driver", "E:\\chromedriver.exe");
		driver= new ChromeDriver();		
		driver.manage().window().maximize();
		driver.get("https://www.khaadi.com/pk");
		driver.findElement(By.xpath("//a[text()='My Account']")).click();

		Thread.sleep(10000);
	}

	@AfterMethod
	public void afterMethod() {
		driver.close();
	}

	public void dataFromExcel(String SheetName,int i) throws Exception           //Data reading from Excelfile
	{
		F_name=method.getCellData(SheetName, "First name", i);
		Last_name=method.getCellData(SheetName, "Last name", i);
		DOB=method.getCellData(SheetName, "Date of Birth", i);
		gender=method.getCellData(SheetName, "Gender", i);
		email_address=method.getCellData(SheetName, "Email", i);
		password=method.getCellData(SheetName, "Password", i);
		Confrm_password=method.getCellData(SheetName, "Confirm Password", i);
		Expected=method.getCellData(SheetName, "Expected result", i);
	}
	public void sendtoWebsite() throws Exception {                            //Function of sending data to website
		driver.findElement(By.xpath("//input[@id='firstname']")).sendKeys(F_name);
		Thread.sleep(3000);

		driver.findElement(By.xpath("//input[@id='lastname']")).sendKeys(Last_name);	
		Thread.sleep(3000);

		driver.findElement(By.xpath("//input[@id='dob']")).sendKeys(DOB);		
		Thread.sleep(3000);

		driver.findElement(By.xpath("//span[text()='Select Date']")).click();		
		Thread.sleep(5000);

		WebElement gender_drp= driver.findElement(By.xpath("//div[@class='control']/span"));
		gender_drp.click();
		Thread.sleep(3000);
		WebElement drop=driver.findElement(By.xpath("//div[@class='drop-list']"));

		List<WebElement> list=drop.findElements(By.tagName("li"));
		Thread.sleep(3000);
		for(int i=1;i<=2;i++) {

			if(list.get(i).getText().equalsIgnoreCase(gender)){
				System.out.println(list.get(i).getText());
				list.get(i).click();
				break;
			}
		}
		driver.findElement(By.xpath("//input[@id='email_address']")).sendKeys(email_address);	
		Thread.sleep(3000);

		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);		
		Thread.sleep(3000);

		driver.findElement(By.xpath("//input[@id='password-confirmation']")).sendKeys(Confrm_password);	
		Thread.sleep(3000);

		driver.findElement(By.xpath("//button[@type='submit' and @title='Create an Account']")).click();
		Thread.sleep(10000);

	}
}
