package com.antonydamico.dao.contacts;

import com.antonydamico.models.Contact;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

public interface ContactDao {

    void setDataSource(DataSource dataSource);

    Contact getContactById(Integer id);

    List<Contact> listContacts();

    void createContact(Contact contact);

    void updateContact(Contact contact);

    void deleteContact(Integer contactId);
}
