package br.com.fiap.pos.challenge.trips.models;

import jakarta.persistence.*;

@Entity
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

    public Long getIdTraveler() {
        return this.idTraveler;
    }

    public void setIdTraveler(Long idTraveler) {
        this.idTraveler = idTraveler;
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

    public Contact getContact() {
        return this.contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
