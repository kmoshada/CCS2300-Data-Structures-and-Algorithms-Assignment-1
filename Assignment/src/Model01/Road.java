public class Road {
    private Location start;
    private Location end;
    private Integer weight;

    public Road(Location startV, Location endV , Integer inputWeight){
        this.start = startV;
        this.end = endV;
        this.weight = inputWeight;
    }

    public Location getStart(){
        return this.start;
    }

    public Location getEnd(){
        return this.end;
    }

    public Integer getWeight(){
        return this.weight;
    }

}
