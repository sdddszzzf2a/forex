package com.wu.forexapi.repository;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.bson.Document;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoException;
import com.mongodb.ServerApi;
import com.mongodb.ServerApiVersion;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

@SpringBootTest
public class MongoClientConnectionTest {

	@Value("${spring.data.mongodb.uri}")
	private String connectionString;
	
	@Test
	public void testConnection() {
		String connectionString = this.connectionString;
		assertDoesNotThrow(() -> {
			pingMongoDb(connectionString);
		});
	}

	private void pingMongoDb(String connectionString) {
//		String connectionString = "mongodb+srv://admin:CzZ9FCeVnzCZuzRW@cluster0.01i2ylt.mongodb.net/DailyForex?retryWrites=true&w=majority";
        ServerApi serverApi = ServerApi.builder()
                .version(ServerApiVersion.V1)
                .build();
        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(new ConnectionString(connectionString))
                .serverApi(serverApi)
                .build();
        // Create a new client and connect to the server
        MongoClient mongoClient = MongoClients.create(settings);
        // Send a ping to confirm a successful connection
        MongoDatabase database = mongoClient.getDatabase("admin");
        database.runCommand(new Document("ping", 1));
        System.out.println("Pinged your deployment. You successfully connected to MongoDB!");
        mongoClient.close();       
	}
}
