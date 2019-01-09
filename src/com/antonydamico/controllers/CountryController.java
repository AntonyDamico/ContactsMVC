package com.antonydamico.controllers;

import com.antonydamico.dao.countries.CountryDao;
import com.antonydamico.models.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("countries")
public class CountryController {

    private CountryDao countryDao;

    @GetMapping("/list")
    public String listCountries(Model model) {
        List<Country> countries = countryDao.listCountries();
        model.addAttribute("countries", countries);
        return "countries/index";
    }

    @GetMapping("/create")
    public String createCountries(Model model) {
        model.addAttribute("country", new Country());
        return  "countries/create-form";
    }

    @PostMapping("/create")
    public String createCountries(@ModelAttribute("country") Country country) {
        this.countryDao.createCountry(country);
        return "redirect:list";
    }

    @GetMapping("/update/{id}")
    public String updateCountry(@PathVariable int id, Model model) {
        Country country = countryDao.getCountryById(id);
        model.addAttribute("country", country);
        return "countries/update-form";
    }

    @PostMapping("/update")
    public String updateCountry(@ModelAttribute("country") Country country){
        this.countryDao.updateCountry(country);
        return "redirect:list";
    }

    @GetMapping("/delete/{id}")
    public String deleteCountry(@PathVariable int id) {
        this.countryDao.deleteCountry(id);
        return "redirect:list";
    }

    @GetMapping("/stats")
    public String countryStats(Model model) {
        List<Country> countriesStats = countryDao.getCountriesStats();
        model.addAttribute("stats", countriesStats);
        return "country-stats";
    }

    @Autowired
    public void setCountryDao(CountryDao countryDao) {
        this.countryDao = countryDao;
    }
}
