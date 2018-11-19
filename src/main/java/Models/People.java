package Models;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

@Entity
public class People {
    @Id
    private String id;
    private String document;
    private String name;
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