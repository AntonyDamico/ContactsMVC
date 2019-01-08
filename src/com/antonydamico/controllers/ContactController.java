package com.antonydamico.controllers;

import com.antonydamico.dao.contacts.ContactDao;
import com.antonydamico.models.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    @Autowired
    public void setContactDao(ContactDao contactDao) {
        this.contactDao = contactDao;
    }
}
