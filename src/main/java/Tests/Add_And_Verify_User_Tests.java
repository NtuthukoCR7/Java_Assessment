package Tests;
import Test_Functionality.Add_New_User_To_User_Table;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;

import java.io.FileInputStream;
import java.io.IOException;

public class Add_And_Verify_User_Tests {

    private WebDriver driver;
    private static String dir = System.getProperty("user.dir");
    private static final String Chromedriver = dir + "/src/main/java/Test_Drivers/chromedriver.exe";
    private static final String excel = dir + "/src/main/java/TestData/TestData.xlsx";
    @BeforeTest(description = "Setup for test")
    public void setup_test()
    {
        System.setProperty("webdriver.chrome.driver", Chromedriver);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.setExperimentalOption("useAutomationExtension", false);
        driver = new ChromeDriver(options);
        driver.get("http://www.way2automation.com/angularjs-protractor/webtables/");

    }
    @Test(description = "Add the user to table")
    public void Add_First_User() throws IOException {

        Add_New_User_To_User_Table add_user= PageFactory.initElements(driver, Add_New_User_To_User_Table.class);
        FileInputStream fis = new FileInputStream(excel);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheetAt(0);
        String first_name = sheet.getRow(1).getCell(0).getStringCellValue();
        String last_name = sheet.getRow(1).getCell(1).getStringCellValue();
        String user_name = sheet.getRow(1).getCell(2).getStringCellValue();
        String pass_word = sheet.getRow(1).getCell(3).getStringCellValue();
        String email = sheet.getRow(1).getCell(4).getStringCellValue();
        String cellphone = sheet.getRow(1).getCell(5).getStringCellValue();

        add_user.Click_Add_New_User_Button();
        add_user.Add_First_Name(first_name);
        add_user.Add_Last_Name(last_name);
        add_user.Add_UserName(user_name);
        add_user.Add_Password(pass_word);
        add_user.Add_Customer();
        add_user.Select_Role("Admin");
        add_user.Add_Email(email);
        add_user.Add_Mobile_Phone(cellphone);
        add_user.Click_Button_Save();
    }
    @Test(priority = 2,description = "Verify that user is added correctly to the table")
    public void Verify_First_User() throws IOException, InterruptedException {
        FileInputStream fis = new FileInputStream(excel);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheetAt(0);
        Add_New_User_To_User_Table add_user= PageFactory.initElements(driver,Add_New_User_To_User_Table.class);
        String first_name = sheet.getRow(1).getCell(0).getStringCellValue();
        String last_name = sheet.getRow(1).getCell(1).getStringCellValue();
        add_user.Verify_Added_User(first_name,last_name);

    }
    @AfterTest(description = "This method will quit the driver after all the test")
    public void Exit_Test()
    {
        driver.quit();
    }
}