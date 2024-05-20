package br.com.fiap.pos.challenge.trips.models;

import jakarta.persistence.*;

@Entity
@Table(name = "country")
public class Country {

    @Id
    @Column(name = "id_country")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCountry;

    @Column(name = "portuguese_name")
    private String portugueseName;

    @Column(name = "english_name")
    private String englishName;

    @Column(name = "image_link")
    private String imageLink;

    @Column(name = "image")
    private byte[] image;

    public Country() { }

    public Country(String portugueseName, String englishName, String imageLink) {
        this.portugueseName = portugueseName;
        this.englishName = englishName;
        this.imageLink = imageLink;
    }

    public Long getIdCountry() {
        return this.idCountry;
    }

    public void setIdCountry(Long idCountry) {
        this.idCountry = idCountry;
    }

    public String getPortugueseName() {
        return this.portugueseName;
    }

    public void setPortugueseName(String portugueseName) {
        this.portugueseName = portugueseName;
    }

    public String getEnglishName() {
        return this.englishName;
    }

    public void setEnglishName(String englishName) {
        this.englishName = englishName;
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

}
