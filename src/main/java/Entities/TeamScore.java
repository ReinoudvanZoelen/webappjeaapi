package Entities;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class TeamScore {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID Id;

    @ManyToOne
    public Team Team;
    public int Score;
}
