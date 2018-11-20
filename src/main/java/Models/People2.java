package Models;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

//Classe criada para substituir as classes People e Validation (Em Desenvolvimento)
@Entity
public class People2 {
    @Id
    private String id;

    @NotNull(message = "Document not informed")
    @Pattern(regexp = "^[0-9]*$", message = "Invalid Document")
    @Size(min=1, max =14, message = "Invalid Document")
    private String document;

    @NotNull(message = "Name not informed")
    @Pattern(regexp = "^[a-zA-Z0-9\\s]*$", message = "Invalid Name")
    @Size(min=1, message = "Invalid Name")
    private String name;

    @NotNull(message = "Age not informed")
    @Pattern(regexp = "^[0-9]*$", message = "Invalid Age")
    @Size(min=1, max = 3, message = "Invalid Age")
    private String age;

    public String getId() {
        return id;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getName() {
        return name;
    }

    public void setName(String nome) {
        this.name = nome;
    }

    public String getAge() {
        return age;
    }

    public void setIdade(String age) {
        this.age = age;
    }
}