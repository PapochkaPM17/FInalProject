package com.kuznetsov.auction.repository;

import com.kuznetsov.auction.model.Lot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LotRepository extends JpaRepository<Lot, Long> {
}
