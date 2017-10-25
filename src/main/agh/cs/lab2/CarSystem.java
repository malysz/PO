package agh.cs.lab2;

/**
 * Created by student38 on 2017-10-13.
 */
public class CarSystem {
    public static void main(String[] args){
        /*Position position1 = new Position(1,2);
        System.out.println(position1);
        Position position2 = new Position(-2,1);
        System.out.println(position2);
        System.out.println(position1.add(position2));*/
        Car car = new Car(2,2);
        String a = new String();
        a=car.toString();
        System.out.println(a);
        car.move(MoveDirection.Right);
        car.move(MoveDirection.Forward);
        car.move(MoveDirection.Forward);
        car.move(MoveDirection.Forward);
        car.move(MoveDirection.Backward);
        a=car.toString();
        System.out.println(a);
    }
}


