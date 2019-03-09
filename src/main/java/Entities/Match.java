package Entities;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID Id;

    public int SittingTableNumber;

    @OneToOne
    public TeamScore TeamScore_A;

    @OneToOne
    public TeamScore TeamScore_B;

    @ManyToOne
    public Tournament Tournament;
}

