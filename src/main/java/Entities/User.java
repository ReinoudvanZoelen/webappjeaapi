package Entities;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import java.util.UUID;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID Id;
    private String FullName;
    @Column(unique = true)
    private String EmailAddress;
    private String HashedPassword;
    private String Salt;

    public User() {}

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

    @XmlElement(name = "hashedpassword")
    public String getHashedPassword() {
        return HashedPassword;
    }

    public void setHashedPassword(String hashedPassword) {
        HashedPassword = hashedPassword;
    }

    @XmlElement(name = "salt")
    public String getSalt() {
        return Salt;
    }

    public void setSalt(String salt) {
        Salt = salt;
    }
}
