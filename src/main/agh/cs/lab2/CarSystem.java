package agh.cs.lab2;

/**
 * Created by student38 on 2017-10-13.
 */
public class CarSystem {
    public static void main(String[] args){
        RectangularMap map = new RectangularMap(5,5);
        Car car = new Car(map,2,2);
        map.place(car);
        MoveDirection [] dir = {MoveDirection.Forward,MoveDirection.Right, MoveDirection.Forward};
        map.run(dir);
        System.out.print(map.toString());
    }
}


