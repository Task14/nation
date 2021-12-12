package com.example.nation.repository;

import com.example.nation.models.entities.RegionAreasEntity;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RegionAreaRepositorySpec {
    
    @Autowired
    private RegionAreaRepository regionAreaRepository;
    
    @Before
    public void setUp() throws Exception {
        RegionAreasEntity regionArea1= new RegionAreasEntity();
        RegionAreasEntity regionArea2= new RegionAreasEntity();
        //save Country, verify has ID value after save
        assertNull(regionArea1.getRegionName());
        assertNull(regionArea2.getRegionName());//null before save
        this.regionAreaRepository.save(regionArea1);
        this.regionAreaRepository.save(regionArea2);
        assertNotNull(regionArea1.getRegionName());
        assertNotNull(regionArea2.getRegionName());
    }
    @Test
    public void testFetchData(){
        /*Test data retrieval*/
        RegionAreasEntity regionAreaA = regionAreaRepository.findByRegionName("AreaA");
        assertNotNull(regionAreaA);
        assertEquals("AreaA", regionAreaA.getRegionName());
        /*Get all products, list should only have two*/
        Iterable<RegionAreasEntity> regionAreas = regionAreaRepository.findAll();
        int count = 0;
        for(RegionAreasEntity p : regionAreas){
            count++;
        }
        assertEquals(count, 2);
    }
}