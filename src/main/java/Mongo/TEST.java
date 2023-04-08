package Mongo;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.bson.Document;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;




public class TEST {
	
	 WebDriver driver;
	MongoCollection<Document> webCollection;
	
	@BeforeSuite
	public void ConnectMongoDB() {
		  Logger mongoLogger =Logger.getLogger("Org.mongodb.driver");
		  // MongoClient Connection
		  MongoClient mongoClient=MongoClients.create("mongodb://localhost:27017");
		  // use/ Ctreate DataBase
		  MongoDatabase database=mongoClient.getDatabase("Shiv");
		  //Create/use Collection
		  webCollection=database.getCollection("Auto");
	}

	@BeforeTest
	public void setUp() {
	 driver= new ChromeDriver();
	}
	
	
	@Test
	public void m1() {
		driver.get("https://www.google.com/");
		String URL=driver.getCurrentUrl();
		String title= driver.getTitle();
		Document d1=new Document();
	    d1.append("URL", URL);
	    d1.append("title",title);
	    List<Document>docslist=new ArrayList<Document>();
	    docslist.add(d1);
	    webCollection.insertMany(docslist);
	    

	}
}
