package br.com.fiap.pos.challenge.trips.models;

import java.time.LocalDateTime;
import java.util.Set;

import jakarta.persistence.*;

@Entity
@Table(name = "reviews")
public class Review {

    @Id
    @Column(name = "id_reviews")
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
    @JoinTable(name = "itinerary_reviews", joinColumns = @JoinColumn(name = "reviews"), inverseJoinColumns = @JoinColumn(name = "itinerary"))
    private Set<Itinerary> itineraris;

    public Long getIdNews() {
        return this.idNews;
    }

    public void setIdNews(Long idNews) {
        this.idNews = idNews;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDateTime getDateTime() {
        return this.dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getImageLink() {
        return this.imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    public byte[] getImage() {
        return this.image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public Set<Itinerary> getItineraris() {
        return this.itineraris;
    }

    public void setItineraris(Set<Itinerary> itineraris) {
        this.itineraris = itineraris;
    }
}
