package com.antonydamico.dao;

import com.antonydamico.mappers.ContactMapper;
import com.antonydamico.models.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class ContactDaoImpl {

    private JdbcTemplate jdbcTemplate;

    public Contact getContactById(Integer id) {
        String query = "SELECT * FROM contacts WHERE id=?";
        return this.jdbcTemplate.queryForObject(query, new Object[]{id}, new ContactMapper());
    }


    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
