package com.example.nation.repository;

import com.example.nation.models.entities.VipsEntity;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class VipRepositorySpec {
    
    @Autowired
    private VipRepository vipRepository;
    
    @Before
    public void setUp() throws Exception {
        VipsEntity Vip1= new VipsEntity();
        VipsEntity Vip2= new VipsEntity();
        //save Vip, verify has ID value after save
        assertNull(Vip1.getVipId());
        assertNull(Vip2.getVipId());//null before save
        this.vipRepository.save(Vip1);
        this.vipRepository.save(Vip2);
        assertNotNull(Vip1.getVipId());
        assertNotNull(Vip2.getVipId());
    }
    @Test
    public void testFetchData(){
        /*Test data retrieval*/
        VipsEntity VipA = vipRepository.findByName("Bob");
        assertNotNull(VipA);
        assertEquals("Bob", VipA.getName());
        /*Get all products, list should only have two*/
        Iterable<VipsEntity> Vips = vipRepository.findAll();
        int count = 0;
        for(VipsEntity p : Vips){
            count++;
        }
        assertEquals(count, 2);
    }
}