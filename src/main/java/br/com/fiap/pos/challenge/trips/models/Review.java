package br.com.fiap.pos.challenge.trips.models;

import java.time.LocalDateTime;
import java.util.Set;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "news")
public class Review {

    @Id
    @Column(name = "id_news")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idNews;

    @Column(name = "title")
    private String title;

    @Column(name = "text")
    private String text;

    @Column(name = "date_time")
    private LocalDateTime dateTime;

    @Column(name = "image_link")
    private String imageLink;

    @Column(name = "image")
    private byte[] image;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "itinerary_reviews", joinColumns = @JoinColumn(name = "reviews"), inverseJoinColumns = @JoinColumn(name = "destination"))
    private Set<Itinerary> itineraris;

}
