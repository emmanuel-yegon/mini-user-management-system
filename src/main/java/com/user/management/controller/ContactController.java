package com.user.management.controller;

import com.user.management.model.Contact;
import com.user.management.service.ContactService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ContactController {

    private ContactService contactService;

    public ContactController(ContactService contactService) {
        super();
        this.contactService = contactService;
    }

    @GetMapping("/contacts")
    public String listAll(Model model) {
        model.addAttribute("contacts", contactService.listAll());
        return "contacts";
    }

    @GetMapping("/contacts/new")
    public String createContactForm(Model model) {

        // student object to hold student form data
        Contact contact = new Contact();
        model.addAttribute("contact", contact);
        return "create_contact";
    }

    @PostMapping("/contacts")
    public String saveContact(@ModelAttribute("student") Contact contact) {
        contactService.saveContact(contact);
        return "redirect:/contacts";
    }

    @GetMapping("/contacts/edit/{id}")
    public String editContactForm(@PathVariable Integer id, Model model) {
        model.addAttribute("contact", contactService.getContactById(id));
        return "edit_contact";
    }

    @PostMapping("/contacts/{id}")
    public String updateContact(@PathVariable Integer id, @ModelAttribute("contact") Contact contact,
                                Model model) {

        //get contact from database by id
        Contact existingContact = contactService.getContactById(id);
        existingContact.setId(id);
        existingContact.setName(contact.getName());
        existingContact.setPhoneNumber(contact.getPhoneNumber());
        existingContact.setAddress(contact.getAddress());
        existingContact.setEmail(contact.getEmail());
        existingContact.setRole(contact.getRole());

        contactService.updateContact(existingContact);
        return "redirect:/contacts";

    }

    @GetMapping("/contacts/{id}")
    public String deleteContact(@PathVariable Integer id) {
        contactService.deleteContactById(id);
        return "redirect:/contacts";
    }

    @GetMapping("/")
    public String home() {
        return "home";
    }


}
