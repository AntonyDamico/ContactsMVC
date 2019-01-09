package com.antonydamico.controllers;

import com.antonydamico.dao.contacts.ContactDao;
import com.antonydamico.dao.countries.CountryDao;
import com.antonydamico.models.Contact;
import com.antonydamico.models.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/contacts")
public class ContactController {

    private ContactDao contactDao;
    private CountryDao countryDao;

    @GetMapping("/list")
    public String listIndex(Model model) {
        List<Contact> contactList = contactDao.listContacts();
        model.addAttribute("contactList", contactList);
        return "contacts/index";
    }

    @GetMapping("/create")
    public String createContactForm(Model model) {
        List<Country> countries = this.countryDao.listCountries();
        model.addAttribute("contact", new Contact());
        model.addAttribute("countries", countries);
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
        List<Country> countries = this.countryDao.listCountries();
        model.addAttribute(contact);
        model.addAttribute("countries", countries);
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

    @Autowired
    public void setCountryDao(CountryDao countryDao) {
        this.countryDao = countryDao;
    }
}
