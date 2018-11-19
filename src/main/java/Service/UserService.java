package Service;
import java.util.List;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import com.mongodb.MongoClient;

import Exception.DocumentNotReconizedException;
import Exception.VoidDBException;
import Models.People;

public class UserService {
    private MongoClient client = new MongoClient("localhost", 27017);
    private Datastore datastore = new Morphia().createDatastore(client,"People");

    public People addPost (People people){
        datastore.save(people);
        return people;
    }

    public People getPost (String document) throws DocumentNotReconizedException {
        People people = datastore.find(People.class, "document", document).get();
        if(people != null){
            return people;
        }
        else{
            System.out.println("Document Not Found in Database");
            throw new DocumentNotReconizedException();
        }
    }

   public List<People> getAllPost() throws VoidDBException {
        List<People> list = datastore.find(People.class).asList();
        if (!list.isEmpty()){
            return list;
        }
        else{
            System.out.println("Empty Database");
            throw  new VoidDBException();
        }
    }
}