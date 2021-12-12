package com.example.nation.repository;

import com.example.nation.models.entities.ContinentsEntity;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ContinentRepositorySpec {
    
    @Autowired
    private ContinentRepository continentRepository;
    
    @Before
    public void setUp() throws Exception {
        ContinentsEntity ContinentsEntity1= new ContinentsEntity();
        ContinentsEntity ContinentsEntity2= new ContinentsEntity();
        //save Country, verify has ID value after save
        assertNull(ContinentsEntity1.getContinentId());
        assertNull(ContinentsEntity2.getContinentId());//null before save
        this.continentRepository.save(ContinentsEntity1);
        this.continentRepository.save(ContinentsEntity2);
        assertNotNull(ContinentsEntity1.getContinentId());
        assertNotNull(ContinentsEntity2.getContinentId());
    }
    @Test
    public void testFetchData(){
        /*Test data retrieval*/
        ContinentsEntity ContinentsEntityA = continentRepository.findByName("ContinentsEntityA");
        assertNotNull(ContinentsEntityA);
        assertEquals("ContinentsEntityA", ContinentsEntityA.getName());
        /*Get all products, list should only have two*/
        Iterable<ContinentsEntity> ContinentsEntitys = continentRepository.findAll();
        int count = 0;
        for(ContinentsEntity p : ContinentsEntitys){
            count++;
        }
        assertEquals(count, 2);
    }
}