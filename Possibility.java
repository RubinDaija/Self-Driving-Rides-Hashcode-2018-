import static java.lang.Math.abs;

public class Possibility {
    int startx;
    int starty;
    int endx;
    int endy;
    int distance;
    int rideNumber;
    int earliestTime;
    int latestTime;

    public Possibility(int sx, int sy,int ax, int ay, int earliest, int latest,int rider){
        this.startx = sx;
        this.starty = sy;
        endx = ax;
        endy = ay;
        earliestTime = earliest;
        latestTime = latest;
        rideNumber = rider;
        distance = abs(startx - endx) + abs(starty - endy);
    }

    public int getStartx() {
        return startx;
    }

    public void setStartx(int startx) {
        this.startx = startx;
    }

    public int getStarty() {
        return starty;
    }

    public void setStarty(int starty) {
        this.starty = starty;
    }

    public int getEndx() {
        return endx;
    }

    public void setEndx(int endx) {
        this.endx = endx;
    }

    public int getEndy() {
        return endy;
    }

    public void setEndy(int endy) {
        this.endy = endy;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int getRideNumber() {
        return rideNumber;
    }

    public void setRideNumber(int rideNumber) {
        this.rideNumber = rideNumber;
    }

    public int getEarliestTime() {
        return earliestTime;
    }

    public void setEarliestTime(int earliestTime) {
        this.earliestTime = earliestTime;
    }

    public int getLatestTime() {
        return latestTime;
    }

    public void setLatestTime(int latestTime) {
        this.latestTime = latestTime;
    }
}
