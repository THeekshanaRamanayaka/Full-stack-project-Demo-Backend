package edu.icet.service;

import edu.icet.dto.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> getAll();
    void addCustomer(Customer customer);
    Customer searchCustomer(Integer id);
    void updateCustomer(Customer customer);
    void deleteCustomer(Integer id);
}
