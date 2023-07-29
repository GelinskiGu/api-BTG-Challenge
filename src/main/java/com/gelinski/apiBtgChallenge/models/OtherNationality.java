package com.gelinski.apiBtgChallenge.models;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "other_nationality")
public class OtherNationality implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(optional = false)
    @JoinColumn(name = "client_id", nullable = false, referencedColumnName = "id")
    private ClientEntity client;

    @Column(name = "otherNationalityCountry", nullable = false, length = 50)
    private String otherNationalityCountry;

    public OtherNationality() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ClientEntity getClient() {
        return client;
    }

    public void setClient(ClientEntity client) {
        this.client = client;
    }

    public String getOtherNationalityCountry() {
        return otherNationalityCountry;
    }

    public void setOtherNationalityCountry(String otherNationalityCountry) {
        this.otherNationalityCountry = otherNationalityCountry;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OtherNationality that = (OtherNationality) o;
        return Objects.equals(id, that.id) && Objects.equals(client, that.client) && Objects.equals(otherNationalityCountry, that.otherNationalityCountry);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, client, otherNationalityCountry);
    }
}
