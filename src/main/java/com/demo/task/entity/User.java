package com.demo.task.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "person")
@Getter@Setter
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "person name")
    private String name;
    @Column(name = "money")
    private Integer sum;

    @ManyToOne
    private Bank bank;

    public Integer setSum(Integer sum) {
       return this.sum = sum;
    }
}
