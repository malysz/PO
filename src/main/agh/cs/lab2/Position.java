package agh.cs.lab2;

public class Position{
    public  final int x;
    public final int y;

    public Position(int x,int y){
        this.x=x;
        this.y=y;
    }

    public String toString(){
        String pos=new String();
        pos="("+this.x+","+this.y+")";
        return pos;
    }

    public boolean smaller(Position other){
        if(x<=other.x && y<=other.y) return true;
        else return false;
    }

    public boolean larger(Position other){
        if(x>=other.x && y>=other.y) return true;
        else return false;
    }

    public Position add(Position pos2){
        Position newPos=new Position(this.x+pos2.x,this.y+pos2.y);
        return newPos;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }

    public boolean equals(Object other){
        if(this==other)
            return true;
        if(!(other instanceof Position))
            return false;
        Position that = (Position) other;
        if(this.x==that.x && this.y==that.y)
            return true;
        else return false;

    }
}
