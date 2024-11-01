package edu.icet.controller;

import edu.icet.dto.Customer;
import edu.icet.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService service;

    @GetMapping("/get-allCustomers")
    public List<Customer> getCustomer() {
        return service.getAll();
    }

    @PostMapping("/add-customer")
    @ResponseStatus(HttpStatus.CREATED)
    public void addCustomer(@RequestBody Customer customer) {
        service.addCustomer(customer);
    }

    @GetMapping("/search-by-id/{id}")
    public Customer getCustomer(@PathVariable Integer id) {
        return service.searchCustomer(id);
    }

    @DeleteMapping("/delete-by-id/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteCustomerById(@PathVariable Integer id) {
        service.deleteCustomer(id);
    }

    @PutMapping("/update-customer")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateCustomer(@RequestBody Customer customer) {
        service.updateCustomer(customer);
    }
}
