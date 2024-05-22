package br.com.fiap.pos.challenge.trips.models;

import java.math.BigDecimal;
import java.util.Set;

import jakarta.persistence.*;

@Entity
@Table(name = "itinerary")
public class Itinerary {

    @Id
    @Column(name = "id_itinerary")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idItinerary;

    @Column(name = "resume")
    private String resume;
    
    @Column(name = "shared")
    private boolean shared;

    @Column(name = "money_quantity")
    private BigDecimal moneyQuantity;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "city", foreignKey = @ForeignKey(name = "fk_city_itinerary"))
    private City city;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "itinerary_reviews", joinColumns = @JoinColumn(name = "itinerary"), inverseJoinColumns = @JoinColumn(name = "destination"))
    private Set<Review> reviews;

    public Long getIdItinerary() {
        return this.idItinerary;
    }

    public void setIdItinerary(Long idItinerary) {
        this.idItinerary = idItinerary;
    }

    public String getResume() {
        return this.resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public boolean isShared() {
        return shared;
    }

    public void setShared(boolean shared) {
        this.shared = shared;
    }

    public BigDecimal getMoneyQuantity() {
        return this.moneyQuantity;
    }

    public void setMoneyQuantity(BigDecimal moneyQuantity) {
        this.moneyQuantity = moneyQuantity;
    }

    public City getCity() {
        return this.city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Set<Review> getReviews() {
        return this.reviews;
    }

    public void setReviews(Set<Review> reviews) {
        this.reviews = reviews;
    }
}
