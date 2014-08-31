import java.net.UnknownHostException;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

public class Test1 {

	public static void main(String[] args) throws UnknownHostException {

		MongoClient mongoClient = new MongoClient();

		mongoClient.getDB("SomeDatabase").getCollection("coll").drop();

		mongoClient.getDB("SomeDatabase").getCollection("coll")
				.insert(new BasicDBObject("field", "value"));

		DBObject keyDoc = new BasicDBObject("key1", "value1");

		mongoClient.getDB("SomeDatabase").getCollection("coll").insert(keyDoc);

		DBObject complexObject = new BasicDBObject("name", "Ramesh").append(
				"age", "???").append(
				"address",
				new BasicDBObject("street", "chinanna rooms").append(
						"house numbwe", 124 - 65));

		mongoClient.getDB("SomeDatabase").getCollection("coll")
				.insert(complexObject);

		Student stu = new Student();
		stu.setId(35);
		stu.setName("Ramesh");

		mongoClient.getDB("SomeDatabase").getCollection("coll")
				.insert(PojoToDBObjectParser.toDBObject(stu));

		
		DBObject obj = mongoClient.getDB("SomeDatabase").getCollection("coll").find(new BasicDBObject("_id",35)).one();
		System.out.println(obj);
		
		
		
	}

}
