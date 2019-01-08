package com.antonydamico.controllers;

import com.antonydamico.models.Contact;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ContactController {



    @RequestMapping("/")
    public String listIndex(Model model) {
        List<Contact> contactList;
        return "index";
    }
}
