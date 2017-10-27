package agh.cs.lab2;

/**
 * Created by student34 on 2017-10-20.
 */
public class Car {
    private Position position;
    private MapDirection direction;
    private IWorldMap worldMap;

    public Car(IWorldMap map){
        this.worldMap = map;
    }

    public Car(IWorldMap map, int x, int y){
        this.worldMap = map;
        this.position = new Position(x,y);
        this.direction = MapDirection.North;
    }

    public Car(int x, int y){
        Position pos = new Position(2,2);
        this.position=pos;
        this.direction=MapDirection.North;
    }
    public String toString(){
        String info = new String();
        info = position.toString()+" "+direction.toString();
        return info;
    }

    public Position getPosition(){
        return this.position;
    }

    public void move(MoveDirection direction){
        Position low = new Position(0,0);
        Position high = new Position(4,4);
        Position pos2 = new Position(0,0);
        switch(direction){
            case Backward:
                switch (this.direction) {
                    case North:
                        pos2 = new Position(0, -1);
                        break;
                    case South:
                        pos2 = new Position(0, 1);
                        break;
                    case West:
                        pos2 = new Position(1, 0);
                        break;
                    case East:
                        pos2 = new Position(-1, 0);
                        break;
                }
                if (this.position.add(pos2).larger(low) && this.position.add(pos2).smaller(high))
                    this.position=this.position.add(pos2);
                break;
            case Right:
                this.direction=this.direction.next();
                break;
            case Left:
                this.direction=this.direction.previous();
                break;
            case Forward:
                switch (this.direction) {
                    case North:
                        pos2 = new Position(0, 1);
                        break;
                    case South:
                        pos2 = new Position(0, -1);
                        break;
                    case West:
                        pos2 = new Position(-1, 0);;
                        break;
                    case East:
                        pos2 = new Position(1, 0);
                        break;
                }
                if (this.position.add(pos2).larger(low) && this.position.add(pos2).smaller(high))
                    this.position=this.position.add(pos2);
                break;
        }
    }
}
