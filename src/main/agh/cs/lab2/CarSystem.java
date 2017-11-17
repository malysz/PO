package agh.cs.lab2;

/**
 * Created by student38 on 2017-10-13.
 */
public class CarSystem {
    public static void main(String[] args){
        RectangularMap map = new RectangularMap(5,5);
        String[] arg = {"f", "f", "r", "f", "l"};
        MoveDirection [] dir = new MoveDirection[arg.length];
        Car car = new Car(map,2,2);
        map.place(car);
        try{
            dir = OptionsParser.parse(arg);
            new IllegalArgumentException(arg+" Niewlasciwe argumenty");
        } catch(IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }


        map.run(dir);
        System.out.print(map.toString());
    }
}


