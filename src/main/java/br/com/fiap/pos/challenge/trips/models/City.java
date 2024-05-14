package br.com.fiap.pos.challenge.trips.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "city")
public class City {

    @Id
    @Column(name = "id_city")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCity;

    @Column(name = "ibge_code")
    private String ibgeCode;

    @Column(name = "name")
    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "state", foreignKey = @ForeignKey(name = "fk_state_city"))
    private State state;

}
