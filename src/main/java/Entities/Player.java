package Entities;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;
import java.util.UUID;

@Entity(name = "tbl_Player")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID Id;

    @NotEmpty(message = "Please enter a valid name for this player.")
    private String FullName;

    @Email(message = "Please enter a valid email address for this player.")
    private String EmailAddress;

    @NotEmpty
    @Size(min = 8, message = "Please enter a valid password for this player. A password must be at least 8 characters long.")
    private String Password;

    @ManyToMany(mappedBy = "Players")
    private List<Team> Teams;

    public Player() {
    }

    public Player(@NotEmpty(message = "Please enter a valid name for this player.") String fullName, @Email(message = "Please enter a valid email address for this player.") String emailAddress, @NotEmpty @Size(min = 8, message = "Please enter a valid password for this player. A password must be at least 8 characters long.") String password) {
        FullName = fullName;
        EmailAddress = emailAddress;
        Password = password;
    }

    // Getters and Setters
    @XmlElement
    public UUID getId() {
        return Id;
    }

    public void setId(UUID id) {
        Id = id;
    }

    @XmlElement
    public String getFullName() {
        return FullName;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }

    @XmlElement
    public String getEmailAddress() {
        return EmailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        EmailAddress = emailAddress;
    }

    @XmlElement
    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    @XmlElement
    public List<Team> getTeams() {
        return Teams;
    }

    public void setTeams(List<Team> teams) {
        Teams = teams;
    }
}
