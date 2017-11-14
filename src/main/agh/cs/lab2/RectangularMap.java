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
        if(position.smaller(high) && position.larger(low))
            if(this.isOccupied(position)) return false;
        return true;
    }

    public void run(MoveDirection[] directions){
        int n = cars.size();
        for(int i=0; i<directions.length; i++){
            cars.get(i%n).move(directions[i]);
        }
    }

    @Override
    public boolean isOccupied(Position position){
        for(int i=0;i<cars.size();i++)
            if(position.equals(cars.get(i).getPosition())) return true;
        return false;
    }

    @Override
    public boolean place(Car car){
        Position pos = car.getPosition();
        for(int i=0; i<cars.size(); i++)
            if(cars.get(i).getPosition() == pos) return false;
        cars.add(car);
        return true;
    }

    @Override
    public Object objectAt(Position position){
        for(int i=0;i<cars.size();i++){
            if(cars.get(i).getPosition().equals(position)) return cars.get(i);
        }
        return null;
    }

    public String toString(){
        MapVisualizer visualizer = new MapVisualizer();
        return visualizer.dump(this,new Position(0,0), new Position(5, 5));
    }
}
