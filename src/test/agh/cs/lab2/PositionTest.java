package agh.cs.lab2;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by student38 on 2017-10-13.
 */
public class PositionTest {
    @Test
    public void toStringTest(){

        assertEquals("(1,2)", new Position(1,2).toString());
    }

    @Test
    public void smallerTest(){
        assertTrue(new Position(1,2).smaller(new Position(5,6)));
    }

    @Test
    public void largerTest(){
        assertFalse(new Position(1,2).larger(new Position(5,6)));
    }

    @Test
    public void addTest(){
        assertEquals(new Position(3,1),new Position(2,2).add(new Position(1,-1)));
    }
}
