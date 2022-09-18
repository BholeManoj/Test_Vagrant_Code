package Test_Vagrant.Code;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Base_Utility {
	public static WebDriver startup(String bname , String url)
	{
		WebDriver driver = null;
		if(bname.equalsIgnoreCase("ch") || bname.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
			driver= new ChromeDriver();
		}
		else if(bname.equalsIgnoreCase("edge") || bname.equalsIgnoreCase("edge"))
		{
			System.setProperty("webdriver.edge.driver", "./driver/msedgedriver.exe");
			driver= new EdgeDriver();
		}	
		else if(bname.equalsIgnoreCase("ff") || bname.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "./driver/geckodriver.exe");
			driver= new FirefoxDriver();
		}
		//maximize driver
		driver.manage().window().maximize();
		//invoke driver
		driver.get(url);
		//implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;
		
	}
	public Properties prop() throws Exception
	{
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("D://March_Batch//TestVagrant//Code//src//test//resources//Utility//Site_Data.properties");
		prop.load(fis);
		return prop;
	}
	public static ArrayList<String> site(String Country , String Release_date  )
	{
		 ArrayList<String> site = new ArrayList<String>();
		site.add(Country);
		site.add(Release_date);
		System.out.println(site);
		return site;
	}
	public  ArrayList<String> site_data(String bname , String url , String site) throws Exception
	{
		WebDriver driver = null;
		Base_Utility utility = new Base_Utility();
		driver = utility.startup(utility.prop().getProperty(bname) , utility.prop().getProperty(url));
		Wiki_IMDb_Main WebE = new Wiki_IMDb_Main(driver);
		ArrayList<String> info = WebE.switch_data(site);		
		System.out.println("list print" + info);
		//driver.close();
		return info;
		
	}
}
