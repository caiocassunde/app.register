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

    public String addPost (People person){
        datastore.save(person);
        String ret = "Customer successfully joined";
        return ret;
    }

    public People getId (String document) throws DocumentNotReconizedException {
        People person = datastore.find(People.class, "document", document).get();
        if(person != null){
            return person;
        }
        else{
            System.out.println("Document Not Found in Database");
            throw new DocumentNotReconizedException();
        }
    }

   public List<People> getAll() throws VoidDBException {
        List<People> list = datastore.find(People.class).asList();
        if (!list.isEmpty()){
            return list;
        }
        else{
            System.out.println("Empty Database");
            throw  new VoidDBException();
        }
    }

    public String deleteId (String document) throws DocumentNotReconizedException {
        People person = this.getId(document);
        if(person != null){
            datastore.delete(person);
            String ret = "customer successfully deleted";
            return ret;
        }
        else{
            System.out.println("Document Not Found in Database");
            throw new DocumentNotReconizedException();
        }
    }
}