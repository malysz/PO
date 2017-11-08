package agh.cs.lab2;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class RectangularMapTest {
    @Test
    public void canMoveToTest(){
        Position p = new Position(2,3);
        RectangularMap map = new RectangularMap(4,4);
        assertTrue(map.canMoveTo(p));
    }
}
