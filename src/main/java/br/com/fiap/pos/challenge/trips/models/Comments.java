package br.com.fiap.pos.challenge.trips.models;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
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

}
