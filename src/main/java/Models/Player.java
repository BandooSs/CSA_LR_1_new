package Models;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Table(name = "player")
@Entity
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_player;

    @Column(name = "first_name")
    private String first_name;

    @Column(name = "last_name")
    private String last_name;

    @Column(name = "id_team")
    private long id_team;
}
