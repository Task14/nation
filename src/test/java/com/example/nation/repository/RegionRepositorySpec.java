package com.example.nation.repository;

import com.example.nation.models.entities.RegionsEntity;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RegionRepositorySpec {
    
    @Autowired
    private RegionRepository regionRepository;
    
    @Before
    public void setUp() throws Exception {
        RegionsEntity region1= new RegionsEntity();
        RegionsEntity region2= new RegionsEntity();
        //save Country, verify has ID value after save
        assertNull(region1.getRegionId());
        assertNull(region2.getRegionId());//null before save
        this.regionRepository.save(region1);
        this.regionRepository.save(region2);
        assertNotNull(region1.getRegionId());
        assertNotNull(region2.getRegionId());
    }
    @Test
    public void testFetchData(){
        /*Test data retrieval*/
        RegionsEntity regionA = regionRepository.findByName("RegionA");
        assertNotNull(regionA);
        assertEquals("RegionA", regionA.getName());
        /*Get all products, list should only have two*/
        Iterable<RegionsEntity> regions = regionRepository.findAll();
        int count = 0;
        for(RegionsEntity p : regions){
            count++;
        }
        assertEquals(count, 2);
    }
}