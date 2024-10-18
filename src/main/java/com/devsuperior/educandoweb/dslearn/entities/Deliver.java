package com.devsuperior.educandoweb.dslearn.entities;

import com.devsuperior.educandoweb.dslearn.enums.DeliverStatus;
import jakarta.persistence.*;

import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "tb_deliver")
public class Deliver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String uri;

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant moment;
    private DeliverStatus status;
    private String feedback;
    private Integer correctCount;

    //usa JoinColumns pois enrollmente tem a chave composta
    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "offer_id"),
            @JoinColumn(name = "user_id")
    })
    private Enrollment enrollment;

    @ManyToOne
    @JoinColumn(name = "lesson_id")
    private Lesson lesson;


    public Deliver() {}

    public Deliver(Long id, String uri, Instant moment, DeliverStatus status, String feedback, Integer correctCount) {
        this.id = id;
        this.uri = uri;
        this.moment = moment;
        this.status = status;
        this.feedback = feedback;
        this.correctCount = correctCount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public Instant getMoment() {
        return moment;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
    }

    public DeliverStatus getStatus() {
        return status;
    }

    public void setStatus(DeliverStatus status) {
        this.status = status;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public Integer getCorrectCount() {
        return correctCount;
    }

    public void setCorrectCount(Integer correctCount) {
        this.correctCount = correctCount;
    }

    public Enrollment getEnrollment() {
        return enrollment;
    }

    public Lesson getLesson() {
        return lesson;
    }

    public void setEnrollment(Enrollment enrollment) {
        this.enrollment = enrollment;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Deliver deliver)) return false;
        return Objects.equals(getId(), deliver.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }
}
