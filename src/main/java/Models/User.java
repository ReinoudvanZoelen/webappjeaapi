package Models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.UUID;

@Entity
@XmlRootElement(name = "User")
public class User {
    private UUID id;
    private String fullName;

    public User(){}

    @Id
    @XmlElement(name = "id")
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @XmlElement(name = "fullname")
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
