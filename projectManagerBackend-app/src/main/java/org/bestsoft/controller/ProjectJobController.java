package org.bestsoft.controller;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.bestsoft.jpa.entity.ProjectJob;
import org.bestsoft.jpa.service.ProjectJobService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/projectJob")
@Slf4j
@CrossOrigin(origins = "*", maxAge = 3600)
public class ProjectJobController {
    @Resource
    private ProjectJobService projectJobService;

    @PostMapping()
    public Object saveProjectJob(@RequestBody ProjectJob projectJob) {
        return JSONObject.toJSON(projectJobService.saveProjectJob(projectJob));
    }

    @DeleteMapping(value = "/{id}")
    public void deleteProjectJobById(@PathVariable("id") Long id) {
        projectJobService.deleteProjectJobById(id);
    }

    @PutMapping(value = "/{id}")
    public Object updateProjectJob(@PathVariable("id") String id, @RequestBody ProjectJob projectJob) {
        return JSONObject.toJSON(projectJobService.updateProjectJob(projectJob));
    }

    @GetMapping(value = "/{id}")
    public Object getProjectJobById(@PathVariable("id") Long id) {
        return JSONObject.toJSON(projectJobService.getProjectJobById(id));
    }

    @GetMapping(value = "/list")
    public Object pageQueryProjectJob(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                   @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        return JSONObject.toJSON(projectJobService.pageQueryProjectJob(pageNum, pageSize));
    }

}
