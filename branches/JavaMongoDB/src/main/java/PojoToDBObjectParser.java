import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

//specific to a particular object
public class PojoToDBObjectParser {

	public static DBObject toDBObject(Student stu) {
		
		
		DBObject obj =  new BasicDBObject("_id", stu.getId()).append("name", stu.getName());
		return obj;
	}
}
