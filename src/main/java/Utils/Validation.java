package Utils;

import Models.People;
import Models.ReturnError;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class Validation {
    public List<ReturnError> validationRequirePost(People people){
        List<ReturnError> retList = new ArrayList<>();

        if(people.getDocument() == null){
            ReturnError ret = new ReturnError();
            ret.setCode("002");
            ret.setMessage("Document not informed");
            retList.add(ret);
        }
        else if(people.getDocument().isEmpty() || !StringUtils.isNumeric(people.getDocument())){
            ReturnError ret = new ReturnError();
            ret.setCode("003");
            ret.setMessage("Invalid Document");
            retList.add(ret);
        }

        if(people.getName() == null){
            ReturnError ret = new ReturnError();
            ret.setCode("004");
            ret.setMessage("Name not informed");
            retList.add(ret);
        }
        else if(people.getName().isEmpty()){
            ReturnError ret = new ReturnError();
            ret.setCode("005");
            ret.setMessage("Invalid Name");
            retList.add(ret);
        }

        if(people.getAge() == null){
            ReturnError ret = new ReturnError();
            ret.setCode("006");
            ret.setMessage("Age not informed");
            retList.add(ret);
        }
        else if(people.getAge().isEmpty() || !StringUtils.isNumeric(people.getAge())){
            ReturnError ret = new ReturnError();
            ret.setCode("007");
            ret.setMessage("Invalid Age");
            retList.add(ret);
        }
        return retList;
    }
}