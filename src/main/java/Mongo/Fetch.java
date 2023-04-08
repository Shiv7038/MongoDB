package Mongo;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

import java.util.List;

import org.bson.Document;
import org.bson.types.ObjectId;

public class Fetch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

        // Connect to the database
        MongoClient mongoClient=MongoClients.create("mongodb://localhost:27017");
        MongoDatabase database = mongoClient.getDatabase("Shiv");
        MongoCollection<Document> collection = database.getCollection("Auto");

        // Fetch data from the collection
        for (Document doc : collection.find()) {
            System.out.println(doc.toJson());
        }
        // Fetch a particular document from the collection
        Document query = new Document("_id", new ObjectId("642fddd8670ced20335ea109"));
        Document doc = collection.find(Filters.eq("_id", new ObjectId("642fddd8670ced20335ea109"))).first();
       // System.out.println(doc.toJson());
        
        // Fetch specific data from the document
        String id = doc.getObjectId("_id").toString();// Get ObectId and convert that in ToString
        //String name = doc.getString("name");
         String URL = doc.getString("URL");  // To fetch String value from the Document
        //Document address = doc.get("address", Document.class);
System.out.println(id);
System.out.println(URL);

// Query the collection and fetch the array data
Document query1 = new Document("_id", "documentId");
Document projection = new Document("arrayField", 1);
Document result = collection.find(query1).projection(projection).first();
Object[] arrayData = ((List<Object>) result.get("arrayField")).toArray();

// Process the array data
for (Object data : arrayData) {
    System.out.println(data.toString());
}
        // Close the connection
        mongoClient.close();
    }
	}


