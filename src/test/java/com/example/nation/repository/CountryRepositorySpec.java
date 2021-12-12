package com.example.nation.repository;

import com.example.nation.models.entities.CountriesEntity;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CountryRepositorySpec {
    
    @Autowired
    private CountryRepository countryRepository;
    
    @Before
    public void setUp() throws Exception {
        CountriesEntity country1= new CountriesEntity();
        CountriesEntity country2= new CountriesEntity();
        //save Country, verify has ID value after save
        assertNull(country1.getCountryId());
        assertNull(country2.getCountryId());//null before save
        this.countryRepository.save(country1);
        this.countryRepository.save(country2);
        assertNotNull(country1.getCountryId());
        assertNotNull(country2.getCountryId());
    }
    @Test
    public void testFetchData(){
        /*Test data retrieval*/
        CountriesEntity countryA = countryRepository.findByName("Greece");
        assertNotNull(countryA);
        assertEquals("Greece", countryA.getName());
        /*Get all products, list should only have two*/
        Iterable<CountriesEntity> countries = countryRepository.findAll();
        int count = 0;
        for(CountriesEntity p : countries){
            count++;
        }
        assertEquals(count, 2);
    }
}