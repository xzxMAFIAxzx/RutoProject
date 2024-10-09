package com.company.dao.inter;

import com.company.entity.Country;


import java.util.List;

public interface CountryDaoInter {
    public List<Country> getAllCountry( String nationality,String birthplace);
    public Country getById (int id);
    boolean updateCountry (Country con);
    boolean removeCountry(int id);
}
