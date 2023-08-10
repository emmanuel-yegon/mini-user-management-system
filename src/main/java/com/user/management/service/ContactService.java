package com.user.management.service;

import com.user.management.model.Contact;

import java.util.List;

public interface ContactService {
    List<Contact> listAll();

    Contact saveContact(Contact contact);

    Contact getContactById(Integer id);

    Contact updateContact(Contact contact);

    void deleteContactById(Integer id);

}
