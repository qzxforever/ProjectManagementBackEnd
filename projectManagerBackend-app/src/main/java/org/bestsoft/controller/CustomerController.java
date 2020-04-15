package org.bestsoft.controller;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.bestsoft.jpa.entity.Customer;
import org.bestsoft.jpa.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/customer")
@Slf4j
@CrossOrigin(origins = "*", maxAge = 3600)
public class CustomerController {
    @Resource
    private CustomerService customerService;

    @PostMapping()
    public Object saveCustomer(@RequestBody Customer customer) {
        return JSONObject.toJSON(customerService.saveCustomer(customer));
    }

    @DeleteMapping(value = "/{id}")
    public void deleteCustomerById(@PathVariable("id") Long id) {
        customerService.deleteCustomerById(id);
    }

    @PutMapping(value = "/{id}")
    public Object updateCustomer(@PathVariable("id") String id, @RequestBody Customer customer) {
        return JSONObject.toJSON(customerService.updateCustomer(customer));
    }

    @GetMapping(value = "/{id}")
    public Object getCustomerById(@PathVariable("id") Long id) {
        return JSONObject.toJSON(customerService.getCustomerById(id));
    }

    @GetMapping(value = "/list")
    public Object pageQueryCustomer(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                    @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        return JSONObject.toJSON(customerService.pageQueryCustomer(pageNum, pageSize));
    }

    @GetMapping(value = "/list/{name}")
    public Object pageQueryCustomerByName(@PathVariable("name") String name,
                                          @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                          @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        return JSONObject.toJSON(customerService.pageQueryCustomerByName(name, pageNum, pageSize));
    }
}
