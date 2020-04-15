package org.bestsoft.DTO.response;

import lombok.Data;
import org.bestsoft.jpa.entity.Contact;
import org.bestsoft.jpa.entity.Customer;
import org.springframework.data.domain.Page;

@Data
public class CustomerResponse {
    private Customer customer;
    private Page<Contact> contactPage;

    public CustomerResponse(Customer customer, Page<Contact> contactPage) {
        this.customer = customer;
        this.contactPage = contactPage;
    }
}
