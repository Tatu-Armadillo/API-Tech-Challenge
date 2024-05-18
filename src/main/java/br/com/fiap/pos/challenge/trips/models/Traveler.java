package br.com.fiap.pos.challenge.trips.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "traveler")
public class Traveler {

    @Id
    @Column(name = "id_traveler")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTraveler;

    @Column(name = "image_link")
    private String imageLink;

    @Column(name = "image")
    private byte[] image;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "contact", referencedColumnName = "id_contact")
    private Contact contact;
   
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "users", referencedColumnName = "id_user")
    private User user;

}
