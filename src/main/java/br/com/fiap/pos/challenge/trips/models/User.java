package br.com.fiap.pos.challenge.trips.models;

import jakarta.persistence.*;
import lombok.Data;

//comment test
@Entity
@Data
@Table(name = "users")
public class User  {

    @Id
    @Column(name = "id_user")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUser;

    @Column(name = "user_name")
    private String username;

    @Column(name = "password")
    private String password;


}