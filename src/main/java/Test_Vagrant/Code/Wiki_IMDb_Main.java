package Test_Vagrant.Code;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Wiki_IMDb_Main {
	WebDriver driver;
	Wiki_IMDb_Main(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindAll(
			{ 
				@FindBy(xpath = "(//td[@class='infobox-data'])[10]") 
				,@FindBy(xpath = "(//td[@class='infobox-data'])[12]")
			} )
	List<WebElement> wiki;
	@FindAll(
			{ 
				@FindBy(xpath = "(//td[contains(@class,'__date')])[6]"),
				@FindBy(xpath = "//a[contains(text(),'India')]") 
			} )
	List<WebElement> IMDb;
	
	public  ArrayList<String> switch_data(String site_name)
	{
		ArrayList<String>Info = new ArrayList<String> ();
		switch(site_name) 
		{
		case "wiki":
			Info.add(wiki.get(0).getText());
			Info.add(wiki.get(1).getText());
			break;
		case "imdb":
			Info.add(IMDb.get(0).getText());
			Info.add(IMDb.get(1).getText());
			break;
		default:
			System.out.println("done ");
		}
		return Info;
	}
}

