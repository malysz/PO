package agh.cs.lab2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student46 on 2017-10-27.
 */
public class RectangularMap implements IWorldMap {
    public final int width;
    public final int height;
    List<Car> cars = new ArrayList<>();

    public RectangularMap(int width, int height){
        this.width=width;
        this.height=height;
    }

    @Override
    public boolean canMoveTo(Position position){
        Position low = new Position(0,0);
        Position high = new Position(width,height);
        if(position.smaller(high) && position.larger(low)) return true;
        else return false;
    }

    @Override
    public void run(MoveDirection[] directions){
        int n = cars.size();
        for(int i=0; i<directions.length; i++){
            cars.get(i%n).move(directions[i]);
        }
    }

    @Override
    public boolean isOccupied(Position position){
        for(int i=0;i<cars.size();i++){
            Position pos = cars.get(i).getPosition();
            if(pos == position) return false;
        }
        return true;
    }

    @Override
    public boolean place(Car car){

    }

    @Override
    public Object objectAt(Position position){
        for(int i=0;i<cars.size();i++){
            Position pos = cars.get(i).getPosition();
            if(pos == position) return cars.get(i);
        }
        return null;
    }
}
