package agh.cs.lab2;

import java.util.LinkedList;
import java.util.List;

public class UnboundedMap extends AbstractWorldMap {
    private int numOfHayStacks;
    List <HayStack> stacks = new LinkedList<>();

    public UnboundedMap(int hayStacks) {
        this.numOfHayStacks = hayStacks;
    }

    public boolean place(HayStack stack) {
        Position pos = stack.getPosition();
        if(!this.isOccupied(pos)){
            this.stacks.add(stack);
            return true;
        } else {
            throw new IllegalArgumentException(pos.toString()+" jest zajeta");
            //return false;
        }
    }

    @Override
    public boolean isOccupied(Position position) {
        for (Car car : this.cars) {
            if (position.equals(car.getPosition())) {
                return true;
            }
        }
        for (HayStack stack : this.stacks) {
            if (position.equals(stack.getPosition())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Object objectAt(Position position) {
        for (Car car : cars) {
            if (car.getPosition().equals(position)) return car;
        }
        for (HayStack stack : stacks) {
            if (stack.getPosition().equals(position)) return stack;
        }
        return null;
    }

    public String toString(){
        Position min = cars.get(0).getPosition();
        Position max = cars.get(0).getPosition();
        Position tmp;
        for(Car car : cars){
            tmp = car.getPosition();
            if(tmp.smaller(min)) min = tmp;
            if(tmp.larger(max)) max = tmp;
        }
        for(HayStack stack : stacks){
            tmp = stack.getPosition();
            if(tmp.smaller(min)) min = tmp;
            if(tmp.larger(max)) max = tmp;
        }
        MapVisualizer visualizer = new MapVisualizer();
        return visualizer.dump(this,min, max);
    }
}
