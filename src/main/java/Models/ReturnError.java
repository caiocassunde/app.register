package Models;


import com.fasterxml.jackson.annotation.JsonProperty;

public class ReturnError {
    @JsonProperty("code")
    private String code;
    @JsonProperty("message")
    private String message;
    
    @JsonProperty("code")
    public String getCode() {
        return code;
    }
    @JsonProperty("code")
    public void setCode(String codigo) {
        this.code = codigo;
    }
    @JsonProperty("message")
    public String getMessage() {
        return message;
    }
    @JsonProperty("message")
    public void setMessage(String message) {
        this.message = message;
    }
}