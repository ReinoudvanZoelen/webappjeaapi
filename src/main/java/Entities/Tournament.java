package Entities;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
public class Tournament {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID Id;

    @NotEmpty(message = "Please enter a valid name for this tournament.")
    public String Name;

    @NotNull(message = "Please enter a valid date for this tournament.")
    public Date Date;

    @OneToMany
    public List<Match> Matches;
}
