package agh.cs.lab2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

abstract class AbstractWorldMap implements IWorldMap{
    List <Car> cars = new LinkedList<>();

    @Override
    public boolean canMoveTo(Position position){
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
        for (Car car : cars) if (position.equals(car.getPosition())) return true;
        return false;
    }

    @Override
    public boolean place(Car car) {
        Position pos = car.getPosition();
        if (!this.isOccupied(pos)) {
            this.cars.add(car);
            return true;
        } else {
            throw new IllegalArgumentException(pos.toString()+" jest zajeta");
            //return false;
        }
    }

    @Override
    public Object objectAt(Position position){
        for (Car car : cars) {
            if (car.getPosition().equals(position)) return car;
        }
        return null;
    }
}
