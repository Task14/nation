package com.example.nation.repository;

import com.example.nation.models.entities.CountryStatsEntity;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CountryStatsRepositorySpec {
    
    @Autowired
    private CountryStatsRepository countryStatsRepository;
    
    @Before
    public void setUp() throws Exception {
        CountryStatsEntity countryStats1= new CountryStatsEntity();
        CountryStatsEntity countryStats2= new CountryStatsEntity();
        //save Country, verify has ID value after save
        assertNull(countryStats1.getCountryId());
        assertNull(countryStats2.getCountryId());//null before save
        this.countryStatsRepository.save(countryStats1);
        this.countryStatsRepository.save(countryStats2);
        assertNotNull(countryStats1.getCountryId());
        assertNotNull(countryStats2.getCountryId());
    }
    @Test
    public void testFetchData(){
        /*Test data retrieval*/
        List<CountryStatsEntity> countryStatsA = countryStatsRepository.findByCountryId(1);
        assertNotNull(countryStatsA);
        assertEquals(2, countryStatsA.size());
        /*Get all products, list should only have two*/
        Iterable<CountryStatsEntity> countryStats = countryStatsRepository.findAll();
        int count = 0;
        for(CountryStatsEntity p : countryStats){
            count++;
        }
        assertEquals(count, 2);
    }
}