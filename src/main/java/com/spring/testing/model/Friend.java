package com.spring.testing.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "friends")
public class Friend {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "friend_name")
    private String name;

    @Column(name = "friend_number")
    private String number;

    @Column(name = "friend_nationality")
    private String nationality;

}
