package com.antonydamico.controllers;

import com.antonydamico.dao.contacts.ContactDao;
import com.antonydamico.models.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/contacts")
public class ContactController {

    private ContactDao contactDao;

    @GetMapping("/list")
    public String listIndex(Model model) {
        List<Contact> contactList = contactDao.listContacts();
        model.addAttribute("contactList", contactList);
        return "contacts/index";
    }

    @GetMapping("/create")
    public String createContactForm(Model model) {
        model.addAttribute("contact", new Contact());
        return "contacts/create-contact-form";
    }

    @PostMapping("/create")
    public String createContactForm(@ModelAttribute("contact") Contact contact) {
        contactDao.createContact(contact);
        return "redirect:list";
    }

    @GetMapping("/update/{id}")
    public String updateContact(@PathVariable int id, Model model) {
        Contact contact = contactDao.getContactById(id);
        model.addAttribute(contact);
        return "contacts/edit-contact-form";
    }

    @PostMapping("/update")
    public String updateContact(@ModelAttribute("contact") Contact contact) {
        contactDao.updateContact(contact);
        return "redirect:list";
    }

    @GetMapping("/delete/{id}")
    public String deleteContact(@PathVariable int id) {
        System.out.println("hello");
        contactDao.deleteContact(id);
        return "redirect:list";
    }

    @Autowired
    public void setContactDao(ContactDao contactDao) {
        this.contactDao = contactDao;
    }
}
