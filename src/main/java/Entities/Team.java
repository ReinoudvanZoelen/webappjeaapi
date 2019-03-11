package Entities;

import javax.persistence.*;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;
import java.util.UUID;

@Entity
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID Id;

    @ManyToMany
    @Size(min = 2, max = 2, message = "Please enter valid players for this team. A Team consists of exactly two players.")
    private List<Player> Players;

    @OneToMany
    private List<TeamScore> TeamScores;

    public Team() { }

    // Getters and Setters
    @XmlElement
    public UUID getId() {
        return Id;
    }

    public void setId(UUID id) {
        Id = id;
    }

    @XmlElement
    public List<Player> getPlayers() {
        return Players;
    }

    public void setPlayers(List<Player> players) {
        Players = players;
    }

    @XmlElement
    public List<TeamScore> getTeamScores() {
        return TeamScores;
    }

    public void setTeamScores(List<TeamScore> teamScores) {
        TeamScores = teamScores;
    }
}
