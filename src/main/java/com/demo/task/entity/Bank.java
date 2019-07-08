package com.demo.task.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Bank")
@Getter
@Setter
@ToString
public class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "money")
    private final Integer sum = 100000000;
    @OneToMany
    private List<User> userList;
}
