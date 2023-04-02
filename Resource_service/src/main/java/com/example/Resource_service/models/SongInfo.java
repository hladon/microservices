package com.example.Resource_service.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class SongInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
    String fileKey;
}
