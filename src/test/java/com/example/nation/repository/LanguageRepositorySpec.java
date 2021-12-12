package com.example.nation.repository;

import com.example.nation.models.entities.LanguagesEntity;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LanguageRepositorySpec {
    
    @Autowired
    private LanguageRepository languageRepository;
    
    @Before
    public void setUp() throws Exception {
        LanguagesEntity language1= new LanguagesEntity();
        LanguagesEntity language2= new LanguagesEntity();
        //save Country, verify has ID value after save
        assertNull(language1.getLanguageId());
        assertNull(language2.getLanguageId());//null before save
        this.languageRepository.save(language1);
        this.languageRepository.save(language2);
        assertNotNull(language1.getLanguageId());
        assertNotNull(language2.getLanguageId());
    }
    @Test
    public void testFetchData(){
        /*Test data retrieval*/
        LanguagesEntity languageA = languageRepository.findByLanguage("Greek");
        assertNotNull(languageA);
        assertEquals("Greek", languageA.getLanguage());
        /*Get all products, list should only have two*/
        Iterable<LanguagesEntity> languages = languageRepository.findAll();
        int count = 0;
        for(LanguagesEntity p : languages){
            count++;
        }
        assertEquals(count, 2);
    }
}