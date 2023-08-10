package com.user.management.service.impl;

import com.user.management.model.Contact;
import com.user.management.repository.ContactRepository;
import com.user.management.service.ContactService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactServiceImpl implements ContactService {

    private ContactRepository contactRepository;

    public ContactServiceImpl(ContactRepository contactRepository) {
        super();
        this.contactRepository = contactRepository;
    }

    @Override
    public List<Contact> listAll() {
        return contactRepository.findAll();
    }

    @Override
    public Contact saveContact(Contact contact) {
        return contactRepository.save(contact);
    }

    @Override
    public Contact getContactById(Integer id) {
        return contactRepository.findById(id).get();
    }

    @Override
    public Contact updateContact(Contact contact) {
        return contactRepository.save(contact);
    }

    @Override
    public void deleteContactById(Integer id) {
        contactRepository.deleteById(id);
    }
}
