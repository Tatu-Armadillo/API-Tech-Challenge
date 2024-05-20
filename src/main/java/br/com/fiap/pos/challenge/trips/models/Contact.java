package br.com.fiap.pos.challenge.trips.models;

import jakarta.persistence.*;

@Entity
@Table(name = "contact")
public class Contact {

    @Id
    @Column(name = "id_contact")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idContact;

    @Column(name = "name")
    private String name;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;

    public Long getIdContact() {
        return this.idContact;
    }

    public void setIdContact(Long idContact) {
        this.idContact = idContact;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
