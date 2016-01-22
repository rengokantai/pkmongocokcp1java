import java.rmi.UnknownHostException;
import java.util.Collection;
import java.util.List;
import com.mongodb.Block;
import com.mongodb.DB;
import com.mongodb.client.FindIterable;
import org.bson.Document;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;


/**
 * Created by Hernan Y.Ke on 2016/1/22.
 */
public class Main {
    public static void main(String[] args) throws UnknownHostException{
        MongoClient client = new MongoClient("localhost",27017);
        MongoDatabase testDB = client.getDatabase("test");
        System.out.println("test first");
        MongoCollection collection = testDB.getCollection("person");
        collection.drop();
        System.out.println("");

        testDB.getCollection(collection.toString()).drop();
        //BasicDBObject person = new BasicDBObject("name","ke").append("age","10");

        collection.insertOne(new Document().append("name","ke").append("age",10));
        FindIterable<Document> fi = testDB.getCollection("test").find();
        fi.forEach(new Block<Document>() {
            public void apply(final Document document) {
                System.out.println(document);
            }
        });
        MongoCollection<Document> col = client.getDatabase("test").getCollection("person");
        System.out.println(col.find().iterator().next());

        //person = testDB.getCollection(collection.toString()).find();


    }
}


