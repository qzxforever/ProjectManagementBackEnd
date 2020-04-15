package org.bestsoft.jpa.service;

import org.bestsoft.jpa.entity.ProjectCustomer;
import org.bestsoft.jpa.repository.ProjectCustomerRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ProjectCustomerService {

    @Resource
    private ProjectCustomerRepository rep;

    public ProjectCustomer saveProjectCustomer(ProjectCustomer projectCustomer) {
        return rep.save(projectCustomer);
    }

    public void deleteProjectCustomerById(Long id) {
        rep.deleteById(id);
    }

    public ProjectCustomer updateProjectCustomer(ProjectCustomer projectCustomer) {
        return rep.saveAndFlush(projectCustomer);
    }

    public ProjectCustomer getProjectCustomerById(Long id) {
        return rep.findById(id).orElseGet(ProjectCustomer::new);
    }

    public List<ProjectCustomer> getProjectCustomerByProjectId(Long projectId) {
        return rep.findAllByProjectId(projectId);
    }

    public List<ProjectCustomer> deleteProjectCustomersByProjectId(Long projectId) {
        return rep.deleteProjectCustomersByProjectId(projectId);
    }
    public Page<ProjectCustomer> getProjectCustomerByCustomerId(Long customerId, Integer pageNum, Integer pageSize) {
        return rep.findAllByCustomerId(customerId, PageRequest.of(pageNum - 1, pageSize));
    }
}
