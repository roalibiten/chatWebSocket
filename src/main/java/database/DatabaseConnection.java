package database;



import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class DatabaseConnection {
	
	public MongoDatabase db;
	
	public DatabaseConnection() {
		
		 MongoClient client = MongoClients.create("mongodb+srv://roali:RoaliBiten@cluster0.rdbwv.mongodb.net/myFirstDatabase?retryWrites=true&w=majority");

	         db = client.getDatabase("webChatApp");
	         
	         

	        //MongoCollection col = db.getCollection("messages");

	        //Document sampleDoc = new Document("_id", "1").append("name", "John Smith");

	        //col.insertOne(sampleDoc);
	
	}
	
			
}
