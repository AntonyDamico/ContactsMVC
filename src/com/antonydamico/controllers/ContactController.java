package com.antonydamico.controllers;

import com.antonydamico.dao.contacts.ContactDao;
import com.antonydamico.models.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ContactController {

    private ContactDao contactDao;

    @RequestMapping("/")
    public String listIndex(Model model) {
        List<Contact> contactList = contactDao.listContacts();
        model.addAttribute("contactList", contactList);
        return "index";
    }

    @GetMapping("/add")
    public String addContact(Model model) {
        model.addAttribute("contact", new Contact());
        return "create-contact-form";
    }

    @PostMapping("/create")
    public String createContact(@ModelAttribute("contact") Contact contact) {
        contactDao.createContact(contact);
        return "redirect:";
    }

    @Autowired
    public void setContactDao(ContactDao contactDao) {
        this.contactDao = contactDao;
    }
}
