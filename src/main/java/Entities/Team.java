package Entities;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;
import java.util.UUID;

@Entity
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID Id;

    @ManyToOne
    private Player Player_A;

    @ManyToOne
    private Player Player_B;

    @OneToMany
    private List<TeamScore> TeamScores;

    public Team() { }


    // GETTERS AND SETTERS
    @XmlElement(name = "id")
    public UUID getId() {
        return Id;
    }

    public void setId(UUID id) {
        Id = id;
    }

    @XmlElement(name = "player_a")
    public Player getPlayer_A() {
        return Player_A;
    }

    public void setPlayer_A(Player player_A) {
        Player_A = player_A;
    }

    @XmlElement(name = "player_b")
    public Player getPlayer_B() {
        return Player_B;
    }

    public void setPlayerB(Player player_B) {
        Player_B = Player_B;
    }
}
