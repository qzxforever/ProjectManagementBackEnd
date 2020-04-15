package org.bestsoft.controller;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.bestsoft.jpa.entity.Contact;
import org.bestsoft.jpa.service.ContactService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/contact")
@Slf4j
@CrossOrigin(origins = "*", maxAge = 3600)
public class ContactController {
    @Resource
    private ContactService contactService;

    @PostMapping()
    public Object saveContact(@RequestBody Contact contact) {
        return JSONObject.toJSON(contactService.saveContact(contact));
    }

    @DeleteMapping(value = "/{id}")
    public void deleteContactById(@PathVariable("id") Long id) {
        contactService.deleteContactById(id);
    }

    @PutMapping(value = "/{id}")
    public Object updateContact(@PathVariable("id") String id, @RequestBody Contact contact) {
        return JSONObject.toJSON(contactService.updateContact(contact));
    }

    @GetMapping(value = "/{id}")
    public Object getContactById(@PathVariable("id") Long id) {
        return JSONObject.toJSON(contactService.getContactById(id));
    }

    @GetMapping(value = "/list")
    public Object pageQueryContact(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                   @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        return JSONObject.toJSON(contactService.pageQueryContact(pageNum, pageSize));
    }

    @GetMapping(value = "/list/{name}")
    public Object pageQueryContactByName(@PathVariable("name") String name,
                                    @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                    @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        return JSONObject.toJSON(contactService.pageQueryContactByName(name, pageNum, pageSize));
    }
}
