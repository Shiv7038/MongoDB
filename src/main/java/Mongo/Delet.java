package Mongo;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;
import org.openqa.selenium.WebDriver;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;

public class Delet {
	 WebDriver driver;
	MongoCollection<Document> webCollection;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Delet d= new Delet();
		d.m1();
	}

	public void m1() {
		 MongoClient mongoClient=MongoClients.create("mongodb://localhost:27017");
		  // use/ Ctreate DataBase
		  MongoDatabase database=mongoClient.getDatabase("Shiv1");
		  //Create/use Collection
		  webCollection=database.getCollection("auto");
		  
		  Document d1=new Document();
		    d1.append("URL", "Hii");
		    d1.append("title","Akshay");
		    List<Document>docslist=new ArrayList<Document>();
		    docslist.add(d1);
		    webCollection.insertMany(docslist);
		    
		 // Construct a query to identify the document you want to update
		    Bson filter = Filters.eq("URL", "Hii");

		    // Create an update object that specifies the changes you want to make to the document
		    Bson update = Updates.set("title", "Shiv");
//
//		    // Call the updateOne method on the collection, passing in the filter and update objects as parameters
		    webCollection.updateOne(filter, update);
//		    
//		    //Delete particular field 
//		    Bson filter1 = Filters.eq("_id", new ObjectId("6430cb1ced4d363b5c536626"));
//	        Bson update1 = Updates.unset("URL");
//	        UpdateResult result1 = webCollection.updateOne(filter1, update1);
//	        System.out.println("Modified " + result1.getModifiedCount() + " documents.");
//		    
//		    //Delete Document
//		   Bson filter2 = Filters.eq("_id", new ObjectId("6430cb1ced4d363b5c536626"));
//	       DeleteResult result = webCollection.deleteOne(filter2);
//	       System.out.println("Deleted " + result.getDeletedCount() + " documents.");
//		    
//		    //Delete collection
//		   webCollection.drop();
//		    
//		  // Get the database and delete it
//	        database.drop();
//		    System.out.println("Delete data base");
//	        
//	        // Close the connection
//	        mongoClient.close();
	}
}
