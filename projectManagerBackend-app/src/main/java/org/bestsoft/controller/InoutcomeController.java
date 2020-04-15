package org.bestsoft.controller;

import com.alibaba.excel.EasyExcel;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.bestsoft.easyExcel.PersonalTransactionDataListener;
import org.bestsoft.easyExcel.PublicTransactionDataListener;
import org.bestsoft.jpa.entity.Inoutcome;
import org.bestsoft.jpa.entity.excel.PersonalTransaction;
import org.bestsoft.jpa.entity.excel.PublicTransaction;
import org.bestsoft.jpa.service.InoutcomeService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/inoutcome")
@Slf4j
@CrossOrigin(origins = "*", maxAge = 3600)
public class InoutcomeController {
    @Resource
    private InoutcomeService inoutcomeService;

    @PostMapping()
    public Object saveInoutcome(@RequestBody Inoutcome inoutcome) {
        return JSONObject.toJSON(inoutcomeService.saveInoutcome(inoutcome));
    }

    @DeleteMapping(value = "/{id}")
    public void deleteInoutcomeById(@PathVariable("id") Long id) {
        inoutcomeService.deleteInoutcomeById(id);
    }

    @PutMapping(value = "/{id}")
    public Object updateInoutcome(@PathVariable("id") String id, @RequestBody Inoutcome inoutcome) {
        return JSONObject.toJSON(inoutcomeService.updateInoutcome(inoutcome));
    }

    @GetMapping(value = "/{id}")
    public Object getInoutcomeById(@PathVariable("id") Long id) {
        return JSONObject.toJSON(inoutcomeService.getInoutcomeById(id));
    }

    @GetMapping(value = "/list")
    public Object pageQueryInoutcome(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                     @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        return JSONObject.toJSON(inoutcomeService.pageQueryInoutcome(pageNum, pageSize));
    }

    @PostMapping(value = "/savePersonalTransaction")
    public void savePersonalTransaction(@RequestParam String path) {
        PersonalTransactionDataListener personalTransactionDataListener = new PersonalTransactionDataListener();
        EasyExcel.read(path, PersonalTransaction.class,  personalTransactionDataListener).sheet().doRead();
        inoutcomeService.batchSaveInoutcome(personalTransactionDataListener.getInoutcomeList());
    }

    @PostMapping(value = "/savePublicTransaction")
    public void savePublicTransaction(@RequestParam String path) { //d://对公账户明细(1).xlsx
        PublicTransactionDataListener publicTransactionDataListener = new PublicTransactionDataListener();
        EasyExcel.read(path, PublicTransaction.class,  publicTransactionDataListener).sheet().headRowNumber(5).doRead();
        inoutcomeService.batchSaveInoutcome(publicTransactionDataListener.getInoutcomeList());
    }

}
