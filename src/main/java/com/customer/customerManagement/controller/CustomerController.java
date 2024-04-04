package com.customer.customerManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.customer.customerManagement.exception.CustomerNotFoundException;
import com.customer.customerManagement.model.Customer;
import com.customer.customerManagement.service.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping
    public ResponseEntity<String> addCustomer(@RequestBody Customer customer) {
        Customer customerCreated = customerService.addCustomer(customer);
        Long customerId = customerCreated.getCustomer_ID();
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Customer created successfully. Customer ID=" + customerId);
    }

    @GetMapping
    public String apiCheck() {
       return "Api working successfully";
    }

    @GetMapping("/{customer_ID}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable long customer_ID) {
        Customer customer = customerService.getCustomerById(customer_ID);
        if (customer != null) {
            return ResponseEntity.ok(customer);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{customer_ID}")
    public ResponseEntity<String> updateCustomerDetails(@PathVariable long customer_ID,
                                                        @RequestBody Customer updatedCustomer) {
        try {
            customerService.updateCustomerDetails(customer_ID, updatedCustomer);
            return ResponseEntity.status(HttpStatus.CREATED).body("Customer updated successfully");
        } catch (CustomerNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Customer does not exist");
        }
    }

    @DeleteMapping("/{customer_ID}")
    public ResponseEntity<String> deleteCustomer(@PathVariable long customer_ID) {
        customerService.deleteCustomer(customer_ID);
        return ResponseEntity.ok("Customer deleted successfully");
    }
}
