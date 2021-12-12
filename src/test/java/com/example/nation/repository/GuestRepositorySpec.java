package com.example.nation.repository;

import com.example.nation.models.entities.GuestsEntity;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GuestRepositorySpec {
    
    @Autowired
    private GuestRepository guestRepository;
    
    @Before
    public void setUp() throws Exception {
        GuestsEntity guest1= new GuestsEntity();
        GuestsEntity guest2= new GuestsEntity();
        //save Country, verify has ID value after save
        assertNull(guest1.getGuestId());
        assertNull(guest2.getGuestId());//null before save
        this.guestRepository.save(guest1);
        this.guestRepository.save(guest2);
        assertNotNull(guest1.getGuestId());
        assertNotNull(guest2.getGuestId());
    }
    @Test
    public void testFetchData(){
        /*Test data retrieval*/
        GuestsEntity guestA = guestRepository.findByName("Bob");
        assertNotNull(guestA);
        assertEquals("Bob", guestA.getName());
        /*Get all products, list should only have two*/
        Iterable<GuestsEntity> guests = guestRepository.findAll();
        int count = 0;
        for(GuestsEntity p : guests){
            count++;
        }
        assertEquals(count, 2);
    }
}