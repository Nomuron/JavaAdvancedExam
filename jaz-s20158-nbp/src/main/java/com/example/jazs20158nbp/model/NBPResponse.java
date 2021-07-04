package com.example.jazs20158nbp.model;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "nbp_response")
public class NBPResponse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "ID of course of the gold request", required = true, value = "ID of course of the gold request", example = "1")
    private Long id;
    @Enumerated(EnumType.STRING)
    @ApiModelProperty(notes = "Chosen metal to check course", required = true, value = "Chosen metal to check course", example = "Zloto")
    private Metal metal;
    @ApiModelProperty(notes = "Date from which day you want to check course of metal", required = true,
            value = "Date from which day you want to check course of metal", example = "2021-01-01")
    private LocalDate startDate;
    @ApiModelProperty(notes = "Date to which day you want to check course of metal", required = true,
            value = "Date to which day you want to check course of metal", example = "2021-01-02")
    private LocalDate endDate;
    @ApiModelProperty(notes = "Counted course of price of metal", required = true, value = "Counted course of price of metal", example = "6.45")
    private double course;
    @ApiModelProperty(notes = "Date of request", required = true, value = "Date of request", example = "2021-02-01")
    private LocalDateTime requestDate;

    public NBPResponse() {
    }

    public NBPResponse(Metal metal, LocalDate startDate, LocalDate endDate, double course, LocalDateTime requestDate) {
        this.metal = metal;
        this.startDate = startDate;
        this.endDate = endDate;
        this.course = course;
        this.requestDate = requestDate;
    }

    public NBPResponse(Long id, Metal metal, LocalDate startDate, LocalDate endDate, double course, LocalDateTime requestDate) {
        this.id = id;
        this.metal = metal;
        this.startDate = startDate;
        this.endDate = endDate;
        this.course = course;
        this.requestDate = requestDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Metal getMetal() {
        return metal;
    }

    public void setMetal(Metal metal) {
        this.metal = metal;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public double getCourse() {
        return course;
    }

    public void setCourse(double course) {
        this.course = course;
    }

    public LocalDateTime getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(LocalDateTime requestDate) {
        this.requestDate = requestDate;
    }
}
