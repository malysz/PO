package agh.cs.lab2;

import java.util.List;

public class UnboundedMap implements IWorldMap {
    private int numOfHayStacks;
    List <Car> cars;
    List <HayStack> stacks;

    public UnboundedMap(int hayStacks) {
        this.numOfHayStacks = hayStacks;
    }

    @Override
    public boolean canMoveTo(Position position) {
        for(int i=0; i<cars.size(); i++)
            if(position.equals(cars.get(i).getPosition())) return false;
        for(int i=0; i<stacks.size(); i++)
            if(position.equals(stacks.get(i).getPosition())) return false;
        return true;
    }

    @Override
    public boolean place(Car car) {
        Position pos = car.getPosition();
        if(!this.isOccupied(pos)){
            this.cars.add(car);
            return true;
        }
        else return false;
    }

    public boolean place(HayStack stack) {
        Position pos = stack.getPosition();
        if(!this.isOccupied(pos)){
            this.stacks.add(stack);
            return true;
        }
        else return false;
    }

    @Override
    public void run(MoveDirection[] directions) {
        int n = cars.size();
        for(int i=0; i<directions.length; i++){
            cars.get(i%n).move(directions[i]);
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
        for(int i=0;i<cars.size();i++){
            if(cars.get(i).getPosition().equals(position)) return cars.get(i);
        }
        for(int i=0;i<stacks.size();i++){
            if(stacks.get(i).getPosition().equals(position)) return stacks.get(i);
        }
        return null;
    }

    public String toString(){
        return " ";
    }
}
