package org.bestsoft.controller.v1;

import org.bestsoft.jpa.entity.Project;
import org.bestsoft.jpa.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;


@RestController
@RequestMapping("/service")
@CrossOrigin(origins = "*", maxAge = 3600)
public class InfoServiceController {
    @Autowired
    @Resource
    private ProjectRepository rep;

    @RequestMapping(value = "/project", method = RequestMethod.GET)
    @ResponseBody
    public List<Project> getStatus() {
        return rep.findAll();
    }
}
