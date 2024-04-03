package com.customer.customerManagement.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.customer.customerManagement.exception.CustomerNotFoundException;
import com.customer.customerManagement.model.Customer;

@Service
public class CustomerService {

    private List<Customer> customers = new ArrayList<>();
    private long nextCustomerId = 1;

    public Customer addCustomer(Customer customer) {
        customer.setCustomer_ID(nextCustomerId++);
        customers.add(customer);
        return customer;
    }

    public List<Customer> getAllCustomers() {
        return customers;
    }

    public Customer getCustomerById(long customer_ID) {
        for (Customer customer : customers) {
            if (customer.getCustomer_ID() == customer_ID) {
                return customer;
            }
        }
        return null;
    }

    public boolean updateCustomerDetails(long customer_ID, Customer updatedCustomer) {
        for (Customer customer : customers) {
            if (customer.getCustomer_ID() == customer_ID) {
                customer.setFirst_name(updatedCustomer.getFirst_name());
                customer.setLast_name(updatedCustomer.getLast_name());
                customer.setDob(updatedCustomer.getDob());
                customer.setAddress(updatedCustomer.getAddress());
                customer.setPhone(updatedCustomer.getPhone());
                return true;
            }
        }
        throw new CustomerNotFoundException("Customer does not exist");
    }

    public void deleteCustomer(long customer_ID) {
        customers.removeIf(customer -> customer.getCustomer_ID() == customer_ID);
    }
}
