package com.example.shop.test;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Setter
@Builder
@Table
public class TestEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String nonKey;

    public TestEntity(String nonKey) {
        this.nonKey = nonKey;
    }
}