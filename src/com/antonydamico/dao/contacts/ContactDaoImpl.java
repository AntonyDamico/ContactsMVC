package com.antonydamico.dao.contacts;

import com.antonydamico.models.Contact;
import com.antonydamico.models.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ContactDaoImpl implements ContactDao {

    private JdbcTemplate jdbcTemplate;

    private class ContactMapper implements RowMapper<Contact> {
        @Override
        public Contact mapRow(ResultSet resultSet, int i) throws SQLException {
            Contact contact = new Contact();
            contact.setId(resultSet.getInt("id"));
            contact.setFirstName(resultSet.getString("first_name"));
            contact.setLastName(resultSet.getString("last_name"));
            contact.setEmail(resultSet.getString("email"));
            contact.setCountry(new Country(resultSet.getString("code")));
            return contact;
        }
    }

    @Override
    public Contact getContactById(Integer id) {
        String query = "SELECT contacts.id, contacts.first_name, contacts.last_name, contacts.email, countries.code FROM contacts " +
                "INNER JOIN countries ON contacts.country = countries.id " +
                "WHERE contacts.id = ?";
        return this.jdbcTemplate.queryForObject(query, new Object[]{id}, new ContactMapper());
    }

    @Override
    public List<Contact> listContacts() {
        String query = "SELECT contacts.id, contacts.first_name, contacts.last_name, contacts.email, countries.code FROM contacts " +
                "INNER JOIN countries ON contacts.country = countries.id";
        return this.jdbcTemplate.query(query, new ContactMapper());
    }

    @Override
    public void createContact(Contact contact) {
        System.out.println("country id: " + contact.getCountry().getId());
        String query = "INSERT INTO contacts (first_name, last_name, email, country) VALUES (?, ?, ?, ?)";
        this.jdbcTemplate.update(query,
                contact.getFirstName(), contact.getLastName(),
                contact.getEmail(), contact.getCountry().getId()
        );
    }

    @Override
    public void updateContact(Contact contact) {
        String query = "UPDATE contacts SET first_name=?, last_name=?, email=?, country=? where id=?";
        this.jdbcTemplate.update(query,
                contact.getFirstName(), contact.getLastName(),
                contact.getEmail(), contact.getCountry().getCode(), contact.getId()
        );
    }

    @Override
    public void deleteContact(Integer id) {
        String query = "DELETE FROM contacts WHERE id = ?";
        this.jdbcTemplate.update(query, id);
    }

    @Override
    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
}
