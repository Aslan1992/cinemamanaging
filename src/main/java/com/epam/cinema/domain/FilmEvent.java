package com.epam.cinema.domain;

import com.epam.cinema.domain.util.LocalDateConverter;
import com.epam.cinema.domain.util.LocalTimeConverter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "filmevent")
public class FilmEvent {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "day")
    @Convert(converter = LocalDateConverter.class)
    private LocalDate day;

    @Column(name = "time")
    @Convert(converter = LocalTimeConverter.class)
    private LocalTime time;

    @Column(name = "film_info_id")
    private Long filmInfoId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDay() {
        return day;
    }

    public void setDay(LocalDate day) {
        this.day = day;
    }

    public Long getFilmInfoId() {
        return filmInfoId;
    }

    public void setFilmInfoId(Long filmInfoId) {
        this.filmInfoId = filmInfoId;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }
}
