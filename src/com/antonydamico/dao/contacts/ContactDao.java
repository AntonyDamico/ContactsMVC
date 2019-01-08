package com.antonydamico.dao.contacts;

import com.antonydamico.models.Contact;

import javax.sql.DataSource;
import java.util.List;

public interface ContactDao {

    void setDataSource(DataSource dataSource);

    Contact getContactById(Integer id);

    List<Contact> listContacts();
}