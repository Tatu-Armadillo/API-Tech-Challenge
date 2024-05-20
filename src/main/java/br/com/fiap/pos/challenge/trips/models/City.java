package br.com.fiap.pos.challenge.trips.models;

import jakarta.persistence.*;

@Entity
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

    public Long getIdCity() {
        return this.idCity;
    }

    public void setIdCity(Long idCity) {
        this.idCity = idCity;
    }

    public String getIbgeCode() {
        return this.ibgeCode;
    }

    public void setIbgeCode(String ibgeCode) {
        this.ibgeCode = ibgeCode;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public State getState() {
        return this.state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
