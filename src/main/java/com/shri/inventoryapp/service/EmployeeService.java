package com.shri.inventoryapp.service;

import com.shri.inventoryapp.entity.Employee;
import com.shri.inventoryapp.entity.Product;
import com.shri.inventoryapp.repository.EmployeeRepository;
import com.shri.inventoryapp.repository.ProductRespository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    public Optional<Employee> findById(Long id) {
        return employeeRepository.findById(id);
    }

    public Employee save(Employee stock) {
        return employeeRepository.save(stock);
    }

    public void deleteById(Long id) {
        employeeRepository.deleteById(id);
    }
}
