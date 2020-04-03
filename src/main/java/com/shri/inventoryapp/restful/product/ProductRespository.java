package com.shri.inventoryapp.restful.product;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRespository extends JpaRepository<Product, Long> {
}