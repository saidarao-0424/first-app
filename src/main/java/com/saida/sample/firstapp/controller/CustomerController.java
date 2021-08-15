package com.saida.sample.firstapp.controller;

import com.saida.sample.firstapp.model.Customer;
import com.saida.sample.firstapp.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class CustomerController extends AbstractController<Customer> implements CustomerApi {

    @Autowired
    CustomerService service;

    @Override
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        Customer dbCustomer = service.createCustomer(customer);
        return this.created(toCustomerUri(dbCustomer.getId()), customer);
    }

    private URI toCustomerUri(Integer id) {
        return toUri("/api/customers/find/{id}", id);
    }

    @Override
    public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer, Integer id) {
        Customer dbCustomer = service.updateCustomer(customer,id);
        return this.created(toCustomerUri(dbCustomer.getId()), customer);
    }

    @Override
    public ResponseEntity<Void> deleteCustomer(@PathVariable Integer id) {
        service.deleteCustomer(id);
        return this.noContent(toCustomerUri(id));
    }

    @Override
    public Customer getCustomer(@PathVariable Integer id) {
        Optional<Customer> customer = service.findCustomer(id);
        if (customer.isPresent())
            return customer.get();
        throw new ResourceNotFoundException("Customer not found");
    }

    @Override
    public ResponseEntity<List<Customer>> listCustomer() {
        List<Customer> customers = service.findAllCustomers();
        return this.ok(customers);
    }
}
