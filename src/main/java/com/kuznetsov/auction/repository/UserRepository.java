package com.kuznetsov.auction.repository;

import com.kuznetsov.auction.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
