package org.bestsoft.jpa.service;

import org.bestsoft.jpa.entity.Contact;
import org.bestsoft.jpa.repository.ContactRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ContactService {

    @Resource
    private ContactRepository rep;

    public Contact saveContact(Contact contact) {
        return rep.save(contact);
    }

    public void deleteContactById(Long id) {
        rep.deleteById(id);
    }

    public Contact updateContact(Contact contact) {
        return rep.saveAndFlush(contact);
    }

    public Contact getContactById(Long id) {
        return rep.findById(id).orElseGet(Contact::new);
    }

    public Page<Contact> pageQueryContact(Integer pageNum, Integer pageSize) {
        return rep.findAll(PageRequest.of(pageNum - 1, pageSize));
    }

    public Page<Contact> pageQueryContactByName(String name, Integer pageNum, Integer pageSize) {
        return rep.findAllByNameContains(name, PageRequest.of(pageNum - 1, pageSize));
    }

    public Page<Contact> pageQueryContactById(Long id, Integer pageNum, Integer pageSize) {
        return rep.findAllByCustomerId(id, PageRequest.of(pageNum - 1, pageSize));
    }

}
