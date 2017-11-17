package agh.cs.lab2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student46 on 2017-10-27.
 */
public class RectangularMap extends AbstractWorldMap {
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

    @Override
    public boolean isOccupied(Position position){
        for (Car car : cars) if (position.equals(car.getPosition())) return true;
        return false;
    }

    public String toString(){
        MapVisualizer visualizer = new MapVisualizer();
        return visualizer.dump(this,new Position(0,0), new Position(5, 5));
    }
}
