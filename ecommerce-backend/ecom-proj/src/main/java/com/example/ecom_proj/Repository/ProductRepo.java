package com.example.ecom_proj.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.ecom_proj.Model.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product,Integer> {


    @Query("SELECT p FROM Product p WHERE " +
    "LOWER(COALESCE(p.name, '')) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
    "LOWER(COALESCE(p.description, '')) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
    "LOWER(COALESCE(p.brand, '')) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<Product> searchProducts(String keyword);



}
