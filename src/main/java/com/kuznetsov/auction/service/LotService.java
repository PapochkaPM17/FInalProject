package com.kuznetsov.auction.service;

import com.kuznetsov.auction.model.Lot;
import com.kuznetsov.auction.repository.LotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LotService {

    private final LotRepository lotRepository;

    @Autowired
    public LotService(LotRepository lotRepository) {
        this.lotRepository = lotRepository;
    }

    public Lot createLot(Lot lot) { return lotRepository.save(lot); }

    public List<Lot> findAll() {
        return lotRepository.findAll();
    }

    public Lot findById(Long id) { return lotRepository.findById(id).orElse(null); }

    public Lot updateLot(Lot lot) { return lotRepository.save(lot); }

    public void deleteLot(Long id) { lotRepository.deleteById(id); }
}
