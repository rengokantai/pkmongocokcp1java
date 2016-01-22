import com.mongodb.Block;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import javax.print.Doc;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by Hernan Y.Ke on 2016/1/22.
 */

public class ReplSetOper {
    public static void main(String[] args) {
        MongoClient client = new MongoClient(Arrays.asList(new ServerAddress("localhost",27000),new ServerAddress("localhost",27001),new ServerAddress("localhost",27002)));
        MongoDatabase DB = client.getDatabase("test");
        MongoCollection<Document> coll = DB.getCollection("person");
        coll.drop();
        Document dc1 = new Document("_id",1).append("name","Ke");
        Document dc2 = new Document("_id",2).append("name","Ek");
        coll.insertOne(dc1);
        coll.insertOne(dc2);
        FindIterable<Document> s= coll.find();
        for(Document d:s) {
            System.out.println(d.toJson());
        }
        client.close();

    }
}
