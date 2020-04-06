package com.shri.inventoryapp.service;

import com.shri.inventoryapp.entity.Vendor;
import com.shri.inventoryapp.repository.ProductRespository;
import com.shri.inventoryapp.repository.VendorRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/vendors")
@Slf4j
@RequiredArgsConstructor
public class VendorService {

    private final VendorRepository vendorRepository;

    public List<Vendor> findAll() {
        return vendorRepository.findAll();
    }

    public Optional<Vendor> findById(Long id) {
        return vendorRepository.findById(id);
    }

    public Vendor save(Vendor stock) {
        return vendorRepository.save(stock);
    }

    public void deleteById(Long id) {
        vendorRepository.deleteById(id);
    }
}
