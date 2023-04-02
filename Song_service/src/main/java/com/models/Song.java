package com.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Duration;
import java.time.Year;

@Entity
@Data
@NoArgsConstructor
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    private Integer songId;
    @Column(nullable = false)
    @NotBlank
    private String name;
    private String artist;
    private String album;
    private String length;
    @NotNull
    private Integer resourceId;
    private Year year;

}
