package com.flyingfish.controller;

import com.flyingfish.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("customer")
public class CustomerController {
    @Autowired
    private CustomerRepository repository;

    @GetMapping("/clear")
    public boolean clear() {
        repository.clear();
        return true;
    }
}
