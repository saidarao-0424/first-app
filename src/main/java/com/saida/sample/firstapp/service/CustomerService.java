package com.saida.sample.firstapp.service;

import com.saida.sample.firstapp.model.Customer;
import com.saida.sample.firstapp.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository repository;

    public Customer createCustomer(Customer customer) {
        return repository.save(customer);
    }

    public Customer updateCustomer(Customer customer) {
        return repository.save(customer);
    }

    public void deleteCustomer(Integer id) {
        repository.deleteById(id);
    }

    public Optional<Customer> findCustomer(Integer id) {
        return repository.findById(id);
    }

    public List<Customer> findAllCustomers() {
        List<Customer> customers = new ArrayList<>();
        repository.findAll().iterator().forEachRemaining(customer -> customers.add(customer));
        return customers;
    }
}
