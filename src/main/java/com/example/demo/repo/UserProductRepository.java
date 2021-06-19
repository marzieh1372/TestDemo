package com.example.demo.repo;

import com.example.demo.model.UserProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserProductRepository extends JpaRepository<UserProduct,Long> {
}
