package Entities;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;
import java.util.UUID;

@Entity
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID Id;
    private String FullName;
    private String EmailAddress;
    private String Password;
    @OneToMany
    private List<Team> Teams;

    public Player() {}

    @XmlElement(name = "id")
    public UUID getId() {
        return Id;
    }

    public void setId(UUID id) {
        Id = id;
    }

    @XmlElement(name = "fullname")
    public String getFullName() {
        return FullName;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }

    @XmlElement(name = "emailaddress")
    public String getEmailAddress() {
        return EmailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        EmailAddress = emailAddress;
    }

    @XmlElement(name = "password")
    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }


}
