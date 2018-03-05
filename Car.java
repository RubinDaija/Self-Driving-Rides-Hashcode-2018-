import java.util.ArrayList;

import static java.lang.Math.abs;

public class Car{
    int posx =0;
    int posy = 0;
    int steps = 0;
    boolean done = false;
    ArrayList<Integer> rides;

    public Car(){
        rides = new ArrayList<Integer>();
    }


    public int distance(int x, int y){
        if(steps == 0){
            return calculateDistance(x,y) - 1;
        }
        return calculateDistance(x,y);
    }

    public int calculateDistance(int x, int y){
        return abs(x - posx) + abs(y - posy);
    }

    public boolean getOnTime(int x, int y, int earlistArrival){
        int tmpSteps = steps + distance(x,y);
        return tmpSteps == earlistArrival;
    }
    public boolean doable(int x, int y, int latesttime){
        int tmpSteps = steps + distance(x,y);
        return tmpSteps <= latesttime;
    }
    public int chooseRide(int rides[][],int size){
        ArrayList<Possibility> possibilities = new ArrayList<Possibility>();
        for(int i = 0; i < size; i++){
            if(getOnTime(rides[i][1],rides[i][0],rides[i][4])){
                possibilities.add(new Possibility(rides[i][1],rides[i][0],rides[i][3],rides[i][2],rides[i][4],rides[i][5],rides[i][6]));
            }
        }
        if(possibilities.size() > 0){
            int max = 0;
            for (int p = 0; p < possibilities.size(); p++){
                if(possibilities.get(p).getDistance() < possibilities.get(max).getDistance()){
                    max = p;
                }
            }
            steps = distance(possibilities.get(max).getEndx(),possibilities.get(max).getEndy());
            posx = possibilities.get(max).getEndx();
            posy = possibilities.get(max).getEndy();
            this.rides.add(possibilities.get(max).getRideNumber());
            return possibilities.get(max).getRideNumber();

        }
        for(int i = 0; i < size; i++){
            if(doable(rides[i][3],rides[i][2],rides[i][5])){
                Possibility k = new Possibility(rides[i][1],rides[i][0],rides[i][3],rides[i][2],rides[i][4],rides[i][5],rides[i][6]);
                steps = distance(k.getEndx(),k.getEndy());
                posx = k.getEndx();
                posy = k.getEndy();
                this.rides.add(k.getRideNumber());
                return k.getRideNumber();
            }
        }

        done = true;
        return -1;

    }

    public boolean isDone(){
        return  done;
    }

}

