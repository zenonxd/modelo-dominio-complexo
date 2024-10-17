package com.devsuperior.educandoweb.dslearn.entities.pk;

import com.devsuperior.educandoweb.dslearn.entities.Offer;
import com.devsuperior.educandoweb.dslearn.entities.User;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.util.Objects;

@Embeddable
public class EnrollmentPK {

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "offer_id")
    private Offer offer;

    public EnrollmentPK() {}

    public EnrollmentPK(User user, Offer offer) {
        this.user = user;
        this.offer = offer;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Offer getOffer() {
        return offer;
    }

    public void setOffer(Offer offer) {
        this.offer = offer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EnrollmentPK that)) return false;
        return Objects.equals(getUser(), that.getUser()) && Objects.equals(getOffer(), that.getOffer());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUser(), getOffer());
    }
}
