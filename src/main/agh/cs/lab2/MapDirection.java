package agh.cs.lab2;

/**
 * Created by student34 on 2017-10-20.
 */
enum MapDirection{
    North, South, West, East;

    public String toString(){
        String dir=new String();
        switch (this){
            case North:
                dir="Polnoc";
                break;
            case South:
                dir="Poludnie";
                break;
            case West:
                dir="Zachod";
                break;
            case East:
                dir="Wschod";
                break;
        }
        return dir;
    }

    public MapDirection next(){
        switch(this){
            case North:
                return East;
            case South:
                return West;
            case West:
                return North;
            case East:
                return South;
            default:
                return null;
        }
    }

    public MapDirection previous(){
        switch(this){
            case North:
                return West;
            case South:
                return East;
            case West:
                return South;
            case East:
                return North;
            default:
                return null;
        }
    }
}

