package agh.cs.lab2;

/**
 * Created by student46 on 2017-10-27.
 */
public class RectangularMap implements IWorldMap {
    public final int width;
    public final int height;
    public int[][] map;

    public RectangularMap(int width, int height){
        this.width=width;
        this.height=height;
        this.map = new int[width][height];
    }

    @Override
    public boolean canMoveTo(Position position){
        Position low = new Position(0,0);
        Position high = new Position(4,4);
        if(position.smaller(high) && position.larger(low)) return true;
        else return false;
    }

    @Override
    public void run(MoveDirection[] directions){

    }

    @Override
    public boolean isOccupied(Position position){
        if(this.map[position.x][position.y] != 0) return true;
        else return false;
    }

    @Override
    public boolean place(Car car){
        Position pos=car.getPosition();
        if(this.isOccupied(pos)==false) return true;
        else return false;
    }
}
