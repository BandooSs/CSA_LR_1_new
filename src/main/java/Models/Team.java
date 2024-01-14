package Models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Table(name = "team")
@Entity
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_team;

    @Column(name = "first_name")
    private String first_name;

    @Column(name = "city_name")
    private String city_name;


}
