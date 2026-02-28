import Model02.DataSorter;
import java.util.Scanner;

public class MainApplication {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                printMainMenu();
                String choice = scanner.nextLine();

                switch (choice) {
                    case "1":
                        // Smart City Planner (Model 01)
                        RunnerModel01.run(scanner);
                        break;
                    case "2":
                        // Data Sorter (Model 02)
                        DataSorter.run(scanner);
                        break;
                    case "3":
                        // Performance Analyzer (Model 03)
                        PerformanceAnalyzer.main(null);
                        break;
                    case "4":
                        System.out.println("Exiting the application. Goodbye!");
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        } catch (Exception e) {
            System.err.println("An unexpected error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void printMainMenu() {
        System.out.println("\n==============================================");
        System.out.println("        DSA ASSIGNMENT 01 MAIN MENU          ");
        System.out.println("==============================================");
        System.out.println("1. Smart City Route Planner (Model 01)");
        System.out.println("2. Data Sorter & Searcher (Model 02)");
        System.out.println("3. Performance Analyzer (Model 03)");
        System.out.println("4. Exit");
        System.out.println("----------------------------------------------");
        System.out.print("Please enter your choice (1-4): ");
    }
}
