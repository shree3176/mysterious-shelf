package com.shri.inventoryapp.api;

import com.shri.inventoryapp.entity.Vendor;
import com.shri.inventoryapp.service.VendorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/vendors")
@Slf4j
@RequiredArgsConstructor
public class VendorAPI {

    private final VendorService vendorService;

    @GetMapping
    public ResponseEntity<List<Vendor>> findAll() {
        return ResponseEntity.ok(vendorService.findAll());
    }

    @PostMapping("/product")
    public ResponseEntity create(@Validated @RequestBody Vendor product) {
        Vendor savedStudent = vendorService.save(product);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedStudent.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vendor> findById(@PathVariable Long id) {
        Optional<Vendor> stock = vendorService.findById(id);
        if (!stock.isPresent()) {
            System.out.println("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(stock.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Vendor> update(@PathVariable Long id, @Validated @RequestBody Vendor product) {
        if (!vendorService.findById(id).isPresent()) {
            System.out.println("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(vendorService.save(product));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        if (!vendorService.findById(id).isPresent()) {
            System.out.println("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }

        vendorService.deleteById(id);

        return ResponseEntity.ok().build();
    }
}
