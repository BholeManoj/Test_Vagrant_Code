package Test_Vagrant.Code;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Wiki_IMDb_Test
{
	Base_Utility bu;
	WebDriver driver;
	private Wiki_IMDb_Test obj ;
	private ArrayList<String> wiki;
	private ArrayList<String> imdb;
	@BeforeMethod
	public void open()
	{
		bu = new Base_Utility();
		obj = new Wiki_IMDb_Test();	
	}
	@Test
	public void result() throws Exception
	{
		/*Please Enter 1.Browser_Name
		 * 						2.URL Name
		 * 						3.Web_Element Name*/

		wiki = bu.site_data("ch", "wiki", "wiki");
		imdb =  bu.site_data( "ch","imdb", "imdb");
		//Condition Check 
		Assert.assertEquals(wiki, imdb, "Sorry Both site data not match");
	}
}
