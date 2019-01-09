package com.antonydamico.dao.countries;

import com.antonydamico.models.Country;

import javax.sql.DataSource;
import java.util.List;

public interface CountryDao {

    void setDataSource(DataSource dataSource);

    List<Country> listCountries();

    Country getCountryById(int id);
}
