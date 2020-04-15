package org.bestsoft.jpa.service;

import org.bestsoft.jpa.entity.Inoutcome;
import org.bestsoft.jpa.repository.InoutcomeRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class InoutcomeService {

    @Resource
    private InoutcomeRepository rep;

    public Inoutcome saveInoutcome(Inoutcome inoutcome) {
        return rep.save(inoutcome);
    }

    public List<Inoutcome> batchSaveInoutcome(List<Inoutcome> inoutcomeList) {
        return rep.saveAll(inoutcomeList);
    }

    public void deleteInoutcomeById(Long id) {
        rep.deleteById(id);
    }

    public Inoutcome updateInoutcome(Inoutcome inoutcome) {
        return rep.saveAndFlush(inoutcome);
    }

    public Inoutcome getInoutcomeById(Long id) {
        return rep.findById(id).orElseGet(Inoutcome::new);
    }

    public Page<Inoutcome> pageQueryInoutcome(Integer pageNum, Integer pageSize) {
        return rep.findAll(PageRequest.of(pageNum - 1, pageSize));
    }

	public Page<Inoutcome> pageQueryInoutcomeByProjectId(Long projectId, Integer pageNum, Integer pageSize) {
		return rep.findAllByProjectId(projectId, PageRequest.of(pageNum - 1, pageSize));
	}
}
