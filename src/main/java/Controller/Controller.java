package Controller;

import static spark.Spark.get;
import static spark.Spark.post;

import java.util.List;

import com.google.gson.Gson;
import com.mongodb.MongoClient;

import Exception.DocumentNotReconizedException;
import Exception.VoidDBException;
import Models.People;
import Models.ReturnError;
import Service.UserService;
import Utils.Validation;

public class Controller {
    private static UserService userservice = new UserService();

    public static void main(String[] args) {

        final Gson gson = new Gson();

        try {
            MongoClient client = new MongoClient();
        }
        catch(Exception e) {
            System.out.println("Error connecting to database");
            ReturnError ret = new ReturnError();
            ret.setCode("001");
            ret.setMessage("Error connecting to database");
        }

        try {
            post("/registrer", (req, res) -> {
                res.type("application/json");
                People person = gson.fromJson(req.body(), People.class);
                Validation validation = new Validation();
                List<ReturnError> list = validation.validationRequirePost(person);
                if (list.isEmpty()){
                    return userservice.addPost(person);
                }
                else{
                    return list;
                }

            }, gson::toJson);

            get("/registrer/:document", (req, res) -> {
                res.type("application/json");
               try {
                    People person = userservice.getPost(req.params("document"));
                    return person;
               } catch (DocumentNotReconizedException e) {
                    e.printStackTrace();
                    ReturnError ret = new ReturnError();
                    ret.setCode("101");
                    ret.setMessage("Document Not Found in Database");
                    return ret;
               }
            }, gson::toJson);

            get("/registrer", (req, res) -> {
                res.type("application/json");
                try {
                    if(req.queryParams().isEmpty()){
                        return userservice.getAllPost();
                    }
                    else{
                        if(req.queryParams().size() > 1){
                            ReturnError ret = new ReturnError();
                            ret.setCode("102");
                            ret.setMessage("Number invalid of Query Parameters");
                            return ret;
                        }else {
                            if (!req.queryParams().contains("document")) {
                                ReturnError ret = new ReturnError();
                                ret.setCode("103");
                                ret.setMessage("Query Parameter not recognized");
                                return ret;
                            } else{
                                People people = userservice.getPost(req.queryParams("document"));
                                return people;
                            }
                        }
                    }
                } catch (VoidDBException e) {
                    e.printStackTrace();
                    ReturnError ret = new ReturnError();
                    ret.setCode("104");
                    ret.setMessage("Empty Database");
                    return ret;
                } catch (DocumentNotReconizedException e) {
                    e.printStackTrace();
                    ReturnError ret = new ReturnError();
                    ret.setCode("105");
                    ret.setMessage("Document Not Found in Database");
                    return ret;
                }
            }, gson::toJson);
        } catch (Exception e){
            ReturnError ret = new ReturnError();
            ret.setCode("500");
            ret.setMessage("Unexpected error");
        }
    }
}