package br.com.fiap.pos.challenge.trips.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
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

}
