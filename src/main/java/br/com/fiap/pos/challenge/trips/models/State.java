package br.com.fiap.pos.challenge.trips.models;

import jakarta.persistence.*;

@Entity
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

    public Long getIdState() {
        return this.idState;
    }

    public void setIdState(Long idState) {
        this.idState = idState;
    }

    public String getUfCode() {
        return this.ufCode;
    }

    public void setUfCode(String ufCode) {
        this.ufCode = ufCode;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUf() {
        return this.uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public Country getCountry() {
        return this.country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
