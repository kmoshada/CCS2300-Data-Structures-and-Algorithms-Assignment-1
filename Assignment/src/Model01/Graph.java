import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Graph {

    private ArrayList<Location> locations;
    private boolean isDirected;
    private boolean isWeighted;

    public Graph(boolean isDirected, boolean isWeighted) {
        this.locations  = new ArrayList<Location>();
        this.isDirected = isDirected;
        this.isWeighted = isWeighted;
    }

    public Location addLocation(String data){
        Location newLocation = new Location(data);
        this.locations.add(newLocation);
        return newLocation;
    }

    public void addRoad(Location location1,Location location2,Integer weight){
        if (!this.isWeighted){
            weight = null;
        }
        location1.addRoad(location2, weight);

        if (!this.isDirected){
            location2.addRoad(location1, weight);
        }
    }

    public void removeRoad(Location location1,Location location2){
        location1.removeRoad(location2);
        if (!this.isDirected){
            location2.removeRoad(location1);
        }
    }

/*     public void removeLocation(Location location0){
        this.locations.remove(location0);
    } */
    public void removeLocation(Location locationToRemove) {
        if (locationToRemove == null) return;
        
        for (Location loc : this.locations) {
            loc.removeRoad(locationToRemove);
        }
        
        this.locations.remove(locationToRemove);
    }

    public ArrayList<Location> getLocations(){
        return this.locations;
    }

    public boolean isWeighted(){
        return this.isWeighted;
    }

    public boolean isDirected(){
        return this.isDirected;
    }

    public Location getLocationByValue(String value){
        for (Location l: this.locations){
            if (l.getData().equals(value)){
                return l;
            }
        }
        return null;
    }

    public void print(){
        for(Location v: this.locations){
            v.print(isWeighted);
        }
    }

    public void traverseBFS(String startLocationName) {
        Location startNode = getLocationByValue(startLocationName);
        if (startNode == null) {
            System.out.println("Location not found.");
            return;
        }

        Queue<Location> queue = new LinkedList<>();
        HashSet<Location> visited = new HashSet<>();

        queue.add(startNode);
        visited.add(startNode);

        System.out.print("Network Traversal (BFS) starting from " + startLocationName + ": ");
        
        while (!queue.isEmpty()) {
            Location current = queue.poll();
            System.out.print(current.getData() + " ");

            for (Road road : current.getRoads()) {
                Location neighbor = road.getEnd();
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
        System.out.println();
    }

/*     public static void main(String[] args) throws Exception {
        Graph cityNetwork = new Graph(false, true);
        
        Location city01 = cityNetwork.addLocation("Galle");
        Location city02 = cityNetwork.addLocation("Ambalangoda");

        cityNetwork.addRoad(city01, city02, 100);

        cityNetwork.print();

    } */
}
