import java.util.Scanner;

public class RunnerModel01 {


    // Made fields static to be accessible by new helper methods
    private static final Graph cityNetwork = new Graph(false, true); // Undirected, Weighted
    private static final LocationBST pendingLocations = new LocationBST();

    public static void main(String[] args) {
        // Use try-with-resources for robust scanner handling
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                printMenu();
                String choice = scanner.nextLine();

                switch (choice) {
                    case "1":
                        stageLocation(scanner);
                        break;
                    case "2":
                        mapStagedLocations();
                        break;
                    case "3":
                        addRoad(scanner);
                        break;
                    case "4":
                        removeLocation(scanner);
                        break;
                    case "5":
                        removeRoad(scanner);
                        break;
                    case "6":
                        displayAllConnections();
                        break;
                    case "7":
                        performBfsTraversal(scanner);
                        break;
                    case "8":
                        System.out.println("Exiting Smart City Planner...");
                        return;
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            }
        }
    }

    private static void printMenu() {
        System.out.println("\n--- Smart City Route Planner ---");
        System.out.println("Options for Undirected, Weighted Traveller:");
        System.out.println("------------------------------------");
        System.out.println("1. Stage a Location (Add to BST)");
        System.out.println("2. Map Staged Locations to City Graph");
        System.out.println("3. Add a Road (Connection)");
        System.out.println("4. Remove a Location");
        System.out.println("5. Remove a Road");
        System.out.println("6. Display All Connections");
        System.out.println("7. Network Traversal (BFS Route Listing)");
        System.out.println("8. Exit");
        System.out.println("------------------------------------");
        System.out.print("Choose an option: ");
    }

    private static void stageLocation(Scanner scanner) {
        System.out.print("Enter location name: ");
        String locName = scanner.nextLine();
        if (!locName.trim().isEmpty()) {
            pendingLocations.insert(locName);
            System.out.println("'" + locName + "' has been staged.");
        } else {
            System.out.println("Invalid input: Location name cannot be empty.");
        }
    }

    private static void mapStagedLocations() {
        pendingLocations.mapToGraph(cityNetwork);
        System.out.println("Staged locations have been mapped to the city graph.");
    }

    private static Location getLocationFromUser(Scanner scanner, String prompt) {
        System.out.print(prompt);
        String locationName = scanner.nextLine();
        return cityNetwork.getLocationByValue(locationName);
    }

    private static void addRoad(Scanner scanner) {
        Location start = getLocationFromUser(scanner, "Enter start location: ");
        if (start == null) {
            System.out.println("Error: Start location not found in the graph. Please map it first.");
            return;
        }

        Location end = getLocationFromUser(scanner, "Enter end location: ");
        if (end == null) {
            System.out.println("Error: End location not found in the graph. Please map it first.");
            return;
        }

        System.out.print("Enter distance/weight (integer): ");
        try {
            int weight = Integer.parseInt(scanner.nextLine());
            cityNetwork.addRoad(start, end, weight);
            System.out.println("Road added successfully between '" + start.getValue() + "' and '" + end.getValue() + "'!");
        } catch (NumberFormatException e) {
            System.out.println("Error: Weight must be a valid integer.");
        }
    }

    private static void removeLocation(Scanner scanner) {
        Location toRemove = getLocationFromUser(scanner, "Enter location to remove: ");
        if (toRemove != null) {
            String locName = toRemove.getValue();
            cityNetwork.removeLocation(toRemove);
            System.out.println("Location '" + locName + "' and its associated roads have been removed.");
        } else {
            System.out.println("Error: Location not found.");
        }
    }

    private static void removeRoad(Scanner scanner) {
        Location rStart = getLocationFromUser(scanner, "Enter start location of the road: ");
        if (rStart == null) {
            System.out.println("Error: Start location not found. Cannot remove road.");
            return;
        }
        Location rEnd = getLocationFromUser(scanner, "Enter end location of the road: ");
        if (rEnd == null) {
            System.out.println("Error: End location not found. Cannot remove road.");
            return;
        }
        // Typo corrected: 'removeRoades' to 'removeRoad' (assuming this is the method in Graph)
        cityNetwork.removeRoad(rStart, rEnd);
        System.out.println("Road between '" + rStart.getValue() + "' and '" + rEnd.getValue() + "' removed.");
    }

    private static void displayAllConnections() {
        System.out.println("\nCity Network Connections:");
        cityNetwork.print();
    }

    private static void performBfsTraversal(Scanner scanner) {
        Location startNode = getLocationFromUser(scanner, "Enter starting location for traversal: ");
        if (startNode != null) {
            // Method name corrected to follow Java conventions: 'TraversalBSF' to 'traverseBFS'
            // (assuming this is the method in the Graph class)
            cityNetwork.traverseBFS(startNode.getValue());
        } else {
            System.out.println("Error: Cannot perform traversal. Starting location not found.");
        }
    }
}