package com.devsuperior.educandoweb.dslearn.entities;

import com.devsuperior.educandoweb.dslearn.entities.pk.EnrollmentPK;
import jakarta.persistence.*;

import java.time.Instant;
import java.util.*;

@Entity
@Table(name = "tb_enrollment")
public class Enrollment {

    //tem que instanciar, pois foi uma classe
    //criada manualmente
    @EmbeddedId
    private EnrollmentPK id = new EnrollmentPK();

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant enrollMoment;

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant refundMoment;

    public boolean available;

    //essa matriz é regular? o aluno terá suporte?
    //ou será só de atualização?
    public boolean onlyUpdate;

    @ManyToMany(mappedBy = "enrollmentsDone")
    private Set<Lesson> lessonsDone = new HashSet<Lesson>();

    @OneToMany(mappedBy = "enrollment")
    private List<Deliver> deliveries = new ArrayList<>();

    public Enrollment() {}

    //no construtor, não passamos o id, ao invés disso,
    //passaremos o User e Offer e instanciaremos dentro do construtor
    public Enrollment(User user, Offer offer, Instant enrollMoment, Instant refundMoment, boolean available, boolean onlyUpdate) {
        id.setUser(user);
        id.setOffer(offer);
        this.enrollMoment = enrollMoment;
        this.refundMoment = refundMoment;
        this.available = available;
        this.onlyUpdate = onlyUpdate;
    }

    public User getStudent() {
        return id.getUser();
    }

    public void setStudent(User user) {
        id.setUser(user);
    }

    public Offer getOffer() {
        return id.getOffer();
    }

    public void setOffer(Offer offer) {
        id.setOffer(offer);
    }

    public Instant getEnrollMoment() {
        return enrollMoment;
    }

    public void setEnrollMoment(Instant enrollMoment) {
        this.enrollMoment = enrollMoment;
    }

    public Instant getRefundMoment() {
        return refundMoment;
    }

    public void setRefundMoment(Instant refundMoment) {
        this.refundMoment = refundMoment;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public boolean isOnlyUpdate() {
        return onlyUpdate;
    }

    public void setOnlyUpdate(boolean onlyUpdate) {
        this.onlyUpdate = onlyUpdate;
    }

    public EnrollmentPK getId() {
        return id;
    }

    public Set<Lesson> getLessonsDone() {
        return lessonsDone;
    }

    public List<Deliver> getDeliveries() {
        return deliveries;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Enrollment that)) return false;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }
}
