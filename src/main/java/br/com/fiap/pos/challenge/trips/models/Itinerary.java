package br.com.fiap.pos.challenge.trips.models;

import java.math.BigDecimal;
import java.util.Set;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "itinerary")
public class Itinerary {

    @Id
    @Column(name = "id_itinerary")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idItinerary;

    @Column(name = "resume")
    private String resume;

    @Column(name = "money_quantity")
    private BigDecimal moneyQuantity;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "city", foreignKey = @ForeignKey(name = "fk_city_itinerary"))
    private City city;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "itinerary_reviews", joinColumns = @JoinColumn(name = "itinerary"), inverseJoinColumns = @JoinColumn(name = "destination"))
    private Set<Review> reviews;

}
