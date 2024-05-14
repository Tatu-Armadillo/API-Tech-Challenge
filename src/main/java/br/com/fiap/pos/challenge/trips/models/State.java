package br.com.fiap.pos.challenge.trips.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "state")
public class State {

    @Id
    @Column(name = "id_state")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idState;

    @Column(name = "uf_code")
    private String ufCode;

    @Column(name = "name")
    private String name;

    @Column(name = "uf")
    private String uf;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "country", foreignKey = @ForeignKey(name = "fk_country_state"))
    private Country country;

}
