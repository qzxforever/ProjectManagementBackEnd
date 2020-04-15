package org.bestsoft.jpa.service;

import org.bestsoft.jpa.entity.Customer;
import org.bestsoft.jpa.repository.ContactRepository;
import org.bestsoft.jpa.repository.CustomerRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class CustomerService {

    @Resource
    private CustomerRepository rep;
    @Resource
    private ContactRepository repContact;

    public Customer saveCustomer(Customer customer) {
        return rep.save(customer);
    }

    public void deleteCustomerById(Long id) {
        rep.deleteById(id);
    }

    public Customer updateCustomer(Customer customer) {
        return rep.saveAndFlush(customer);
    }

    public Customer getCustomerById(Long id) {
        return rep.findById(id).orElseGet(Customer::new);
    }

    public Page<Customer> pageQueryCustomer(Integer pageNum, Integer pageSize) {
        return rep.findAll(PageRequest.of(pageNum - 1, pageSize));
    }

    public Page<Customer> pageQueryCustomerByName(String name, Integer pageNum, Integer pageSize) {
        return rep.findAllByNameContains(name, PageRequest.of(pageNum - 1, pageSize));
    }
}
