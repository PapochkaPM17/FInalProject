package com.kuznetsov.auction.controller;

import com.kuznetsov.auction.model.Lot;
import com.kuznetsov.auction.service.LotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lots")
public class LotRestController {

    @Autowired
    private LotService lotService;

    @GetMapping
    public ResponseEntity<List<Lot>> getAllLots() {
        List<Lot> lots = this.lotService.findAll();
        if(lots.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(lots, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Lot> getLot(@PathVariable("id") Long id) {
        if(id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Lot lot = this.lotService.findById(id);
        if(lot == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(lot, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Lot> createLot(@RequestBody Lot lot) {
        HttpHeaders httpHeaders = new HttpHeaders();

        if(lot == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        this.lotService.createLot(lot);
        return new ResponseEntity<>(lot, httpHeaders, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Lot> updateLot(@RequestBody Lot lot) {
        HttpHeaders httpHeaders = new HttpHeaders();

        if(lot == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        this.lotService.updateLot(lot);
        return new ResponseEntity<>(lot, httpHeaders, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Lot> deleteLot(@PathVariable("id") Long id) {
        Lot lot = this.lotService.findById(id);
        if(lot == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        this.lotService.deleteLot(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
