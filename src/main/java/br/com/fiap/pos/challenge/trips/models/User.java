package br.com.fiap.pos.challenge.trips.models;

import jakarta.persistence.*;

@Entity
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

    public Long getIdUser() {
        return this.idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}