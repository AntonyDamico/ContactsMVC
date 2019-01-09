package com.antonydamico.dao.countries;

import com.antonydamico.models.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Controller;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class CountryDaoImpl implements CountryDao {

    private JdbcTemplate jdbcTemplate;

    private class CountryMapper implements RowMapper<Country> {
        @Override
        public Country mapRow(ResultSet resultSet, int i) throws SQLException {
            Country country = new Country();
            country.setId(resultSet.getInt("id"));
            country.setName(resultSet.getString("name"));
            country.setCode(resultSet.getString("code"));
            return country;
        }
    }

    @Override
    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Country> listCountries() {
        String query = "SELECT * FROM countries";
        return this.jdbcTemplate.query(query, new CountryMapper());
    }

    @Override
    public Country getCountryById(int id) {
        String query = "SELECT * FROM countries WHERE id = ?";
        return this.jdbcTemplate.queryForObject(query, new Object[]{id}, new CountryMapper());
    }

    @Override
    public void createCountry(Country country) {
        String query = "INSERT INTO countries (name, code) VALUES (?, ?)";
        this.jdbcTemplate.update(query, country.getName(), country.getCode());
    }

    @Override
    public void updateCountry(Country country) {
        String query = "UPDATE countries SET name = ?, code = ? WHERE id = ?";
        this.jdbcTemplate.update(query, country.getName(), country.getCode(), country.getId());
    }

    @Override
    public void deleteCountry(int id) {
        String query = "DELETE FROM countries WHERE id = ?";
        this.jdbcTemplate.update(query, id);
    }
}
