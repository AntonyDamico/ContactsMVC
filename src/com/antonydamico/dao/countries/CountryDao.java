package com.antonydamico.dao.countries;

import com.antonydamico.models.Country;

import javax.sql.DataSource;
import java.util.List;

public interface CountryDao {

    void setDataSource(DataSource dataSource);

    List<Country> listCountries();

    Country getCountryById(int id);

    void createCountry(Country country);

    void updateCountry(Country country);

    void deleteCountry(int id);

    List<Country> getCountriesStats();
}
