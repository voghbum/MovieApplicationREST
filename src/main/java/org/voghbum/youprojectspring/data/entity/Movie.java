package org.voghbum.youprojectspring.data.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movie_id")
    public long        id;

    @Column(nullable = false)
    public String      name;
    @Column(name = "scene_time", nullable = false)
    public LocalDate   sceneTime;
    @Column(nullable = false)
    public long        rating;
    @Column(nullable = false)
    public BigDecimal  cost;
    @Column(nullable = false)
    public float       imdb;

    @ManyToMany(mappedBy = "movies", fetch = FetchType.LAZY)
    public Set<Director> directors = new HashSet<>();

    public Movie() {}

    public Movie(long m_id, String m_name, LocalDate m_sceneTime, long m_rating, BigDecimal m_cost, float m_imdb) {
        this.id = m_id;
        this.name = m_name;
        this.sceneTime = m_sceneTime;
        this.rating = m_rating;
        this.cost = m_cost;
        this.imdb = m_imdb;
    }

    @Override
    public String toString() {
        return String.format("Movie id: %d, name: %s, scene time: %s, rating: %d, cost:%s, imdb: %f",
                id, name, sceneTime, rating, cost, imdb);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getSceneTime() {
        return sceneTime;
    }

    public void setSceneTime(LocalDate sceneTime) {
        this.sceneTime = sceneTime;
    }

    public long getRating() {
        return rating;
    }

    public void setRating(long rating) {
        this.rating = rating;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public float getImdb() {
        return imdb;
    }

    public void setImdb(float imdb) {
        this.imdb = imdb;
    }
}
