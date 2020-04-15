package org.bestsoft.jpa.service;

import org.assertj.core.util.Lists;
import org.bestsoft.jpa.entity.Customer;
import org.bestsoft.jpa.entity.Project;
import org.bestsoft.jpa.repository.CustomerRepository;
import org.bestsoft.jpa.repository.ProjectRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ProjectService {

    @Resource
    private ProjectRepository rep;

    @Resource
    private CustomerRepository repCustomer;

    public Project saveProject(Project project, String customerIds) {
        List<Customer> customerList = Lists.newArrayList();
        for (String customerId : customerIds.split(",")) {
            customerList.add(repCustomer.findById(Long.valueOf(customerId)).get());
        }
        project.setCustomerList(customerList);
        return rep.save(project);
    }

    public void deleteProjectById(Long id) {
        rep.deleteById(id);
    }

    public Project updateProject(Project project, String customerIds) {
        List<Customer> customerList = Lists.newArrayList();
        for (String customerId : customerIds.split(",")) {
            customerList.add(repCustomer.findById(Long.valueOf(customerId)).get());
        }
        project.setCustomerList(customerList);
        return rep.saveAndFlush(project);
    }

    public Project getProjectById(Long id) {
        return rep.findById(id).orElseGet(Project::new);
    }

    public Page<Project> pageQueryProject(Integer pageNum, Integer pageSize) {
        return rep.findAll(PageRequest.of(pageNum - 1, pageSize));
    }

    public Page<Project> pageQueryProjectByName(String name, Integer pageNum, Integer pageSize) {
        return rep.findAllByNameContains(name, PageRequest.of(pageNum - 1, pageSize));
    }

}
