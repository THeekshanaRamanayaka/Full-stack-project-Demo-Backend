package edu.icet.service.impl;

import edu.icet.dto.Customer;
import edu.icet.entity.CustomerEntity;
import edu.icet.repository.CustomerRepository;
import edu.icet.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository repository;
    private final ModelMapper mapper;

    @Override
    public List<Customer> getAll() {
        List<Customer> customerList = new ArrayList<>();
        repository.findAll().forEach(customerEntity -> {
            customerList.add(mapper.map(customerEntity, Customer.class));
        });
        return customerList;
    }

    @Override
    public void addCustomer(Customer customer) {
        repository.save(mapper.map(customer, CustomerEntity.class));
    }

    @Override
    public Customer searchCustomer(Integer id) {
        return mapper.map(repository.findById(id), Customer.class);
    }

    @Override
    public void updateCustomer(Customer customer) {
        repository.save(mapper.map(customer, CustomerEntity.class));
    }

    @Override
    public void deleteCustomer(Integer id) {
        repository.deleteById(id);
    }
}
