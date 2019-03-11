package Entities;

import javax.persistence.*;
import javax.validation.constraints.PositiveOrZero;
import javax.xml.bind.annotation.XmlElement;
import java.util.UUID;

@Entity
public class TeamScore {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID Id;

    @ManyToOne
    public Team Team;

    @ManyToOne
    public Match Match;

    @PositiveOrZero(message = "Please enter a valid score for this teamscore. The score must be at least 0.")
    public int Score;

    // Getters and Setters
    @XmlElement
    public UUID getId() {
        return Id;
    }

    public void setId(UUID id) {
        Id = id;
    }

    @XmlElement
    public Team getTeam() {
        return Team;
    }

    public void setTeam(Team team) {
        Team = team;
    }

    @XmlElement
    public Match getMatch() {
        return Match;
    }

    public void setMatch(Match match) {
        Match = match;
    }

    @XmlElement
    public int getScore() {
        return Score;
    }

    public void setScore(int score) {
        Score = score;
    }
}
