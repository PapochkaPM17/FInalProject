package com.kuznetsov.auction.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "lots")
public class Lot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "start_price")
    private float startPrice;

    @Column(name = "min_bet")
    private float minBet;

    @Column(name = "current_price")
    private float currentPrice;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;
}
