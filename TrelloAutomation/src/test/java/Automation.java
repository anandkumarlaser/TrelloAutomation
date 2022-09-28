import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Automation {
WebDriver driver;
WebDriverWait wait;
String username = System.getProperty("user.name");

@BeforeClass
public void beforeclass() {
	String username = System.getProperty("user.name");
	System.setProperty("webdriver.chrome.driver",
			"C:\\Users\\" + username + "\\Downloads\\chromedriver\\chromedriver.exe");
    driver=new ChromeDriver();
    wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	
}
@Test (priority=0)
public void login() {
	
	driver.navigate().to("https://www.trello.com/login");
	driver.manage().window().maximize();

	//email-id 
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user")));
	WebElement email_field = driver.findElement(By.id("user"));
	email_field.sendKeys("anandkumarlaser@gmail.com",Keys.ENTER);
	
	//password
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("css-wxvfrp")));
	WebElement password_field = driver.findElement(By.className("css-wxvfrp"));	
	password_field.sendKeys("Testing@123",Keys.ENTER);
}

@Test (priority=1)
public void createBoardandList() {
	//clicking on create board button
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("mod-add")));
	WebElement create_board_button = driver.findElement(By.className("mod-add"));	
	create_board_button.click();
	
	//Entering board name
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("nch-textfield__input")));
	WebElement board_title_field = driver.findElement(By.className("nch-textfield__input"));	
	board_title_field.sendKeys("Full Creative",Keys.ENTER);
	
	//Adding list 1
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("icon-add")));
	WebElement add_list_btn = driver.findElement(By.className("icon-add"));
	add_list_btn.click();
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("list-name-input")));
	WebElement list_name_field1 = driver.findElement(By.className("list-name-input"));
	list_name_field1.sendKeys("ListA",Keys.ENTER);
	
	//Adding card for list 1	
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("js-add-a-card")));
	WebElement create_card_btn1 = driver.findElement(By.className("js-add-a-card"));
	create_card_btn1.click();
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("js-card-title")));
	WebElement card_field1 = driver.findElement(By.className("js-card-title"));
	card_field1.sendKeys("Card1",Keys.ENTER);
	
	//Adding List 2
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("list-name-input")));
	WebElement list_name_field2 = driver.findElement(By.className("list-name-input"));
	list_name_field2.sendKeys("ListB",Keys.ENTER);
}

@Test (priority=2)
   public void dragdrop()  {
	Actions builder = new Actions(driver);
	
	//drag element
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("list-card-title")));
	WebElement from = driver.findElement(By.className("list-card-title"));
	 
	//drop element
	WebElement to = driver.findElements(By.className("js-add-a-card")).get(1);	 
	
	Action dragAndDrop = builder.clickAndHold(from)
			.moveToElement(to)
			.release(to)
			.build();
	
	dragAndDrop.perform();
   }

@Test (priority=3)
	public void coordinatesandlogout() {
	
	//getting coordinates of the moved card
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("js-card-name")));
	WebElement moved_card = driver.findElement(By.className("js-card-name"));
	Point point = moved_card.getLocation();
	System.out.println("X Coordinate: "+point.x);
	System.out.println("Y Coordinate: "+point.y);
	
	//clicking profile icon
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("p6oJr7SHjK+vLr")));	
	WebElement profile_icon = driver.findElement(By.className("p6oJr7SHjK+vLr"));
	profile_icon.click();
	
	//clicking log out button
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("R2Zt2qKgQJtkYY")));	
	WebElement logout_btn = driver.findElements(By.className("R2Zt2qKgQJtkYY")).get(7);	
	logout_btn.click();	
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("css-19r5em7")));	
	WebElement logout_btn2 = driver.findElement(By.className("css-19r5em7"));
	logout_btn2.click();	
	}}

