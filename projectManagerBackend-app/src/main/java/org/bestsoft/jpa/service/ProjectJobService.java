package org.bestsoft.jpa.service;

import org.bestsoft.jpa.entity.ProjectJob;
import org.bestsoft.jpa.repository.ProjectJobRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ProjectJobService {

    @Resource
    private ProjectJobRepository rep;

    public ProjectJob saveProjectJob(ProjectJob projectJob) {
        return rep.save(projectJob);
    }

    public void deleteProjectJobById(Long id) {
        rep.deleteById(id);
    }

    public ProjectJob updateProjectJob(ProjectJob projectJob) {
        return rep.saveAndFlush(projectJob);
    }

    public ProjectJob getProjectJobById(Long id) {
        return rep.findById(id).orElseGet(ProjectJob::new);
    }

    public Page<ProjectJob> pageQueryProjectJob(Integer pageNum, Integer pageSize) {
        return rep.findAll(PageRequest.of(pageNum - 1, pageSize));
    }

	public Page<ProjectJob> pageQueryProjectJobByProjectId(Long projectId, Integer pageNum, Integer pageSize) {
		return rep.findAllByProjectId(projectId, PageRequest.of(pageNum - 1, pageSize));
	}

}
