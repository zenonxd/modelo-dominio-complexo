package com.devsuperior.educandoweb.dslearn.entities;

import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name = "tb_notification")
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String text;

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant moment;
    private Boolean read;
    private String route;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Notification() {}

    public Notification(Long id, String text, Instant moment, Boolean read, String route) {
        this.id = id;
        this.text = text;
        this.moment = moment;
        this.read = read;
        this.route = route;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Instant getMoment() {
        return moment;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
    }

    public Boolean getRead() {
        return read;
    }

    public void setRead(Boolean read) {
        this.read = read;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public User getUser() {
        return user;
    }
}
