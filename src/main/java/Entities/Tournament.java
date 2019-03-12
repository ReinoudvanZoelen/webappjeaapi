package Entities;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.xml.bind.annotation.XmlElement;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity(name = "tbl_Tournament")
public class Tournament {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID Id;

    @NotEmpty(message = "Please enter a valid name for this tournament.")
    private String Name;

    @NotNull(message = "Please enter a valid date for this tournament.")
    private Date Date;

    @OneToMany
    private List<Match> Matches;

    @PositiveOrZero
    private int NumberOfPlayers;

    public Tournament() {
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
    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    @XmlElement
    public java.util.Date getDate() {
        return Date;
    }

    public void setDate(java.util.Date date) {
        Date = date;
    }

    @XmlElement
    public List<Match> getMatches() {
        return Matches;
    }

    public void setMatches(List<Match> matches) {
        Matches = matches;
    }

    @XmlElement
    public int getNumberOfPlayers() {
        return NumberOfPlayers;
    }

    public void setNumberOfPlayers(int numberOfPlayers) {
        NumberOfPlayers = numberOfPlayers;
    }
}
