package org.example;

import static com.mongodb.client.model.Filters.eq;
import com.mongodb.client.*;
import org.bson.Document;
import javax.lang.model.element.Name;
import java.util.ArrayList;
import java.util.List;

public class QuickStart {
    public static void main( String[] args ) {

        // Replace the placeholder with your MongoDB deployment's connection string
        String uri = "mongodb://localhost:27017";
        Document doc = null;
        try (MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("mydb");
            MongoCollection<Document> collection = database.getCollection("Manmohan");

            // Use find() to get all documents, or add filters for specific queries
//            try (MongoCursor<Document> cursor = collection.find().cursor()) {
//                while (cursor.hasNext()) {
//                    doc = cursor.next();
//                    System.out.println(doc.toJson()); // Print each document as JSON
//                }
//            }
             try(MongoCursor cursor = collection.find().iterator()) {
                while (cursor.hasNext()){
                    System.out.println(cursor.next());
                }
            }
        }
        if (doc != null) {
            System.out.println(doc.toJson());
        } else {
            System.out.println("No matching documents found.");
        }
    }
    }