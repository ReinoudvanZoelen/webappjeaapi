package Entities;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class Tournament {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID Id;
    public String Name;
    public Date Date;

    @OneToMany
    public List<Match> Matches;
}
