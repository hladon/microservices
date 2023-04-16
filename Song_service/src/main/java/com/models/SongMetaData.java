package com.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Year;

@Entity
@Data
@NoArgsConstructor
public class SongMetaData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    private Integer songId;
    private String name;
    private String artist;
    private String album;
    private String length;
    private Integer resourceId;
    private Year year;

}
