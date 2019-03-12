package Entities;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;
import java.util.UUID;

@Entity(name = "tbl_Match")
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID Id;

    @Positive(message = "Please enter a valid tablenumber for your match. Table numbers start at 1.")
    private int SittingTableNumber;

    @OneToMany
    @Size(min = 2, max = 2, message = "Please enter valid teamscores for your match. Teamscores must be a list with exactly two of TeamScore.")
    private List<TeamScore> TeamScores;

    @ManyToOne
    @JoinColumn
    private Tournament Tournament;

    @Min(1)
    private int RoundNumber;

    public Match() {
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
    public int getSittingTableNumber() {
        return SittingTableNumber;
    }

    public void setSittingTableNumber(int sittingTableNumber) {
        SittingTableNumber = sittingTableNumber;
    }

    @XmlElement
    public List<TeamScore> getTeamScores() {
        return TeamScores;
    }

    public void setTeamScores(List<TeamScore> teamScores) {
        TeamScores = teamScores;
    }

    @XmlElement
    public Tournament getTournament() {
        return Tournament;
    }

    public void setTournament(Tournament tournament) {
        Tournament = tournament;
    }

    @XmlElement
    public int getRoundNumber() {
        return RoundNumber;
    }

    public void setRoundNumber(int roundNumber) {
        RoundNumber = roundNumber;
    }
}

