package br.com.fiap.pos.challenge.trips.models;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Table(name = "comments")
public class Comments {

    @Id
    @Column(name = "id_comments")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idComments;

    @Column(name = "text")
    private String text;

    @Column(name = "date_time")
    private LocalDateTime dateTime;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "traveler", foreignKey = @ForeignKey(name = "fk_traveler_comments"))
    private Traveler traveler;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "review", foreignKey = @ForeignKey(name = "fk_reviews_comments"))
    private Review review;

    public Long getIdComments() {
        return this.idComments;
    }

    public void setIdComments(Long idComments) {
        this.idComments = idComments;
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

    public Traveler getTraveler() {
        return this.traveler;
    }

    public void setTraveler(Traveler traveler) {
        this.traveler = traveler;
    }

    public Review getReview() {
        return this.review;
    }

    public void setReview(Review review) {
        this.review = review;
    }
}
