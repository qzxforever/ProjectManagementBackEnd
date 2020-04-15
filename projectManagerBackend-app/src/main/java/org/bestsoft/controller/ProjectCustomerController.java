package org.bestsoft.controller;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.bestsoft.jpa.entity.ProjectCustomer;
import org.bestsoft.jpa.service.ProjectCustomerService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/projectCustomer")
@Slf4j
@CrossOrigin(origins = "*", maxAge = 3600)
public class ProjectCustomerController {
    @Resource
    private ProjectCustomerService projectCustomerService;

    @PostMapping()
    public Object saveProjectCustomer(@RequestBody ProjectCustomer projectCustomer) {
        return JSONObject.toJSON(projectCustomerService.saveProjectCustomer(projectCustomer));
    }

    @DeleteMapping(value = "/{id}")
    public void deleteProjectCustomerById(@PathVariable("id") Long id) {
        projectCustomerService.deleteProjectCustomerById(id);
    }

    @PutMapping(value = "/{id}")
    public Object updateProjectCustomer(@PathVariable("id") String id, @RequestBody ProjectCustomer projectCustomer) {
        return JSONObject.toJSON(projectCustomerService.updateProjectCustomer(projectCustomer));
    }

    @GetMapping(value = "/{id}")
    public Object getProjectCustomerById(@PathVariable("id") Long id) {
        return JSONObject.toJSON(projectCustomerService.getProjectCustomerById(id));
    }

}
