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

        if(people.getEmail() == null){
            ReturnError ret = new ReturnError();
            ret.setCode("006");
            ret.setMessage("E-Mail not informed");
            retList.add(ret);
        }
        else if(people.getEmail().isEmpty()){
            ReturnError ret = new ReturnError();
            ret.setCode("007");
            ret.setMessage("Invalid E-mail");
            retList.add(ret);
        }

        if(people.getAdress() == null){
            ReturnError ret = new ReturnError();
            ret.setCode("008");
            ret.setMessage("Adress not informed");
            retList.add(ret);
        }
        else if(people.getAdress().isEmpty()){
            ReturnError ret = new ReturnError();
            ret.setCode("009");
            ret.setMessage("Invalid Adress");
            retList.add(ret);
        }

        if(people.getState() == null){
            ReturnError ret = new ReturnError();
            ret.setCode("010");
            ret.setMessage("State not informed");
            retList.add(ret);
        }
        else if(people.getState().isEmpty()){
            ReturnError ret = new ReturnError();
            ret.setCode("011");
            ret.setMessage("Invalid State");
            retList.add(ret);
        }

        if(people.getCep() == null){
            ReturnError ret = new ReturnError();
            ret.setCode("012");
            ret.setMessage("CEP not informed");
            retList.add(ret);
        }
        else if(people.getCep().isEmpty() || !StringUtils.isNumeric(people.getCep())){
            ReturnError ret = new ReturnError();
            ret.setCode("013");
            ret.setMessage("Invalid CEP");
            retList.add(ret);
        }

        return retList;
    }
}