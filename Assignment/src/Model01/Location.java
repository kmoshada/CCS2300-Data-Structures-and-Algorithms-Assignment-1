import java.util.ArrayList;

public class Location {
    private String data;
    private ArrayList<Road> roads;

    public Location(String inData) {
        this.data = inData;
        this.roads = new ArrayList<Road>();
    }

    public void addRoad(Location endVertex,Integer weight){
        this.roads.add(new Road(this,endVertex,weight));
    }

    public void removeRoad(Location endVertex){
        this.roads.removeIf(road -> road.getEnd().equals(endVertex));
    }

    public String getData(){
        return this.data;
    }

    public ArrayList<Road>getRoads(){
        return this.roads;
    }

    public void print(boolean showWeight){
        String massage = "";

        if(this.roads.size()==0){
                System.out.print(this.data+"-->");
                return;
        }

        for(int i = 0; i < this.roads.size(); i++){
            if(i == 0){
                massage += this.roads.get(i).getStart().data+" --> ";
            }

            massage += this.roads.get(i).getEnd().data;

            if(showWeight){
                massage += "(" + this.roads.get(i).getWeight()+ ")";
            }

            if(i != this.roads.size()-1){
                massage += ",";
            }
        }
        System.out.println(massage);
    }

    public static void main(String[] args) {}

    
}
