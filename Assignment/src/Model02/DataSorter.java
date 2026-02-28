package Model02;

import java.util.*;

public class DataSorter {


    public static void run(Scanner sc) {

        int[] dataset = null;

        while (true) {
            System.out.println("\n===== MODULE 2 : DATA SORTER =====");
            System.out.println("");
            System.out.println("1. Enter numbers manually");
            System.out.println("2. Generate random dataset");
            System.out.println("3. Run Sorting Algorithms & Compare");
            System.out.println("4. Display current dataset");
            System.out.println("0. Back to Main Menu");
            System.out.println("");
            System.out.println("==================================");
            System.out.print("Choose option: ");
            

            int choice;

            if (sc.hasNextInt()) {
                choice = sc.nextInt();
            } else {
                System.out.println("Invalid input! Please enter a number.");
                sc.next();
                continue;
            }

            switch (choice) {

                case 1:
                    dataset = manualInput(sc);
                    break;

                case 2:
                    dataset = randomGenerate(sc);
                    System.out.println("Generated dataset: ");
                    System.out.println(Arrays.toString(dataset));
                    break;

                case 3:
                    if (dataset == null) {
                        System.out.println("Please create dataset first!");
                    } else {
                        runAllAndCompare(dataset);
                    }
                    break;

                case 4:
                    if (dataset == null)
                        System.out.println("No dataset available.");
                    else
                        System.out.println(Arrays.toString(dataset));
                    break;

                case 0:
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }


    // ================= MANUAL INPUT =================

    private static int[] manualInput(Scanner sc) {
        System.out.print("How many numbers? ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            arr[i] = sc.nextInt();
        }

        return arr;
    }


    // ================= RANDOM GENERATE =================

    private static int[] randomGenerate(Scanner sc) {

        System.out.print("Enter dataset size: ");
        int n = sc.nextInt();

        Random rand = new Random();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = rand.nextInt(1000); // 0-999
        }

        System.out.println("Random dataset generated.");
        return arr;
    }


    // ================= RUN ALL SORTS =================

    private static void runAllAndCompare(int[] dataset) {

        int n = dataset.length;

        int[] arr1 = Arrays.copyOf(dataset, n);
        int[] arr2 = Arrays.copyOf(dataset, n);
        int[] arr3 = Arrays.copyOf(dataset, n);

        List<PerformanceResult> results = new ArrayList<>();

        results.add(timeSort("Bubble Sort", arr1, SortAlgorithms::bubbleSort));
        results.add(timeSort("Merge Sort", arr2, SortAlgorithms::mergeSort));
        results.add(timeSort("Quick Sort", arr3, SortAlgorithms::quickSort));

        System.out.println("\nSorted Output (Quick Sort result):");
        System.out.println(Arrays.toString(arr3));

        System.out.println("\n===== PERFORMANCE COMPARISON =====");
        System.out.printf("%-15s %-10s %-10s%n", "Algorithm", "Size", "Time(ms)");

        for (PerformanceResult r : results) {
            System.out.printf("%-15s %-10d %-10.4f%n",
                    r.algorithm, r.n, r.timeMs);
        }
    }


    // ================= TIME MEASUREMENT =================

    private static PerformanceResult timeSort(
            String name,
            int[] arr,
            SortRunner runner) {

        long start = System.nanoTime();
        runner.run(arr);
        long end = System.nanoTime();

        double timeMs = (end - start) / 1_000_000.0;

        return new PerformanceResult(name, arr.length, timeMs);
    }

    @FunctionalInterface
    interface SortRunner {
        void run(int[] arr);
    }
    
}
