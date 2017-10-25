package agh.cs.lab2;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by student34 on 2017-10-20.
 */
public class CarTest{
    @Test
    public void toStringTest(){

        assertEquals("(2,2) Polnoc", new Car(2,2).toString());
    }

    @Test
    public void moveTest(){
        Car car = new Car(2,2);
        car.move(MoveDirection.Forward);
        assertEquals("(2,3) Polnoc", car.toString() );
        car.move(MoveDirection.Right);
        assertEquals("(2,3) Wschod", car.toString());
    }
}