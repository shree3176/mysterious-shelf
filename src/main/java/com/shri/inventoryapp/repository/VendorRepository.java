package com.shri.inventoryapp.repository;

import com.shri.inventoryapp.entity.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendorRepository extends JpaRepository<Vendor, Long> {
}
