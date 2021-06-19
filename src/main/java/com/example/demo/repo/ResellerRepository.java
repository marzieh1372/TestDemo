package com.example.demo.repo;

import com.example.demo.model.Reseller;
import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResellerRepository extends JpaRepository<Reseller,String> {
    User findByCode(String code);
}
