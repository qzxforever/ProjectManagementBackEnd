package org.bestsoft.controller;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.bestsoft.DTO.response.ProjectInfoResponse;
import org.bestsoft.jpa.entity.Inoutcome;
import org.bestsoft.jpa.entity.Project;
import org.bestsoft.jpa.entity.ProjectJob;
import org.bestsoft.jpa.service.InoutcomeService;
import org.bestsoft.jpa.service.ProjectJobService;
import org.bestsoft.jpa.service.ProjectService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/project")
@Slf4j
@CrossOrigin(origins = "*", maxAge = 3600)
public class ProjectController {
    @Resource
    private ProjectService projectService;
    @Resource
    private InoutcomeService inoutcomeService;
    @Resource
    private ProjectJobService projectJobService;

    @PostMapping()
    public Object saveProject(@RequestBody Project project, @RequestParam String customerIds) {
        return JSONObject.toJSON(projectService.saveProject(project, customerIds));
    }

    @DeleteMapping(value = "/{id}")
    public void deleteProjectById(@PathVariable("id") Long id) {
        projectService.deleteProjectById(id);
    }

    @PutMapping(value = "/{id}")
    public Object updateProject(@PathVariable("id") String id, @RequestBody Project project, @RequestParam String customerIds) {
        return JSONObject.toJSON(projectService.updateProject(project, customerIds));
    }
//    @RequiresRoles({"领导"})
    @GetMapping(value = "/{id}")
    public Object getProjectById(@PathVariable("id") Long id,
                                 @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                 @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        Project project = projectService.getProjectById(id);
        Page<Inoutcome> inoutcomePage = inoutcomeService.pageQueryInoutcomeByProjectId(project.getId(), pageNum, pageSize);
        Page<ProjectJob> projectJobPage = projectJobService.pageQueryProjectJobByProjectId(project.getId(), pageNum, pageSize);
        return JSONObject.toJSON(new ProjectInfoResponse(project, inoutcomePage.getContent(), projectJobPage.getContent()));
    }

    @GetMapping(value = "/list")
    public Object pageQueryProject(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                   @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        return JSONObject.toJSON(projectService.pageQueryProject(pageNum, pageSize));
    }

    @GetMapping(value = "/list/{name}")
    public Object pageQueryProjectByName(@PathVariable("name") String name,
                                         @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                         @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        return JSONObject.toJSON(projectService.pageQueryProjectByName(name, pageNum, pageSize));
    }
}
