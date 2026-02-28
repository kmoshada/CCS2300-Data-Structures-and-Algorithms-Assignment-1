# CCS2300 — Data Structures and Algorithms: Assignment 01

A console-based Java application that demonstrates core data structure and algorithm concepts through three interactive modules.

## Getting Started

### Prerequisites

- Java Development Kit (JDK) 8 or later

### Running the Application

Compile and run the entry point:

```bash
cd Assignment/src
javac MainApplication.java
java MainApplication
```

The main menu will present four options:

```
1. Smart City Route Planner  (Model 01)
2. Data Sorter & Searcher    (Model 02)
3. Performance Analyzer      (Model 03)
4. Exit
```

---

## Modules

### Model 01 — Smart City Route Planner - CIT-24-02-0125

An interactive **graph-based** city network tool that lets you build and explore a weighted, undirected road map.

| Feature | Description |
|---|---|
| Stage locations | Add location names to a **Binary Search Tree (BST)** staging area |
| Map to graph | Batch-transfer staged locations into the city graph |
| Add / Remove roads | Create or delete weighted connections between locations |
| Remove locations | Remove a location and all its associated roads |
| Display connections | Print the full adjacency list of the network |
| BFS traversal | Perform **Breadth-First Search** from any starting location |

**Key classes:** `Graph`, `Location`, `LocationBST`, `Road`, `RunnerModel01`

---

### Model 02 — Data Sorter & Searcher - CIT-24-02-0194

A sorting comparison tool that benchmarks three classic algorithms on a user-provided or randomly generated dataset.

| Feature | Description |
|---|---|
| Manual input | Enter numbers manually |
| Random generation | Generate a random integer dataset of any size |
| Sort & Compare | Run **Bubble Sort**, **Merge Sort**, and **Quick Sort**, then display a performance comparison table (time in ms) |
| Display dataset | View the current dataset |

**Key classes:** `DataSorter`, `SortAlgorithms`, `PerformanceResult`

---

### Model 03 — Performance Analyzer - CIT-24-02-0084

Benchmarks **Quick Sort** and **Binary Search** across multiple input sizes (100, 500, 1000) and presents the results in a tabular format (time in nanoseconds).

| Feature | Description |
|---|---|
| Data generation | Random arrays created by `DataGenerator` |
| Sorting benchmark | Measures Quick Sort execution time |
| Searching benchmark | Measures Binary Search execution time on the sorted array |

**Key classes:** `PerformanceAnalyzer`, `SortingAlgorithms`, `SearchingAlgorithms`, `DataGenerator`

---

## Project Structure

```
Assignment/
└── src/
    ├── MainApplication.java      # Entry point & main menu
    ├── RunnerModel01.java        # Runner for Model 01
    ├── TestMain.java             # Quick test runner
    │
    ├── Model01/                  # Smart City Route Planner
    │   ├── Graph.java            # Weighted undirected graph
    │   ├── Location.java         # Graph vertex (node)
    │   ├── LocationBST.java      # BST for staging locations
    │   └── Road.java             # Graph edge
    │
    ├── Model02/                  # Data Sorter & Searcher
    │   ├── DataSorter.java       # Menu, I/O, and comparison logic
    │   ├── SortAlgorithms.java   # Bubble, Merge, and Quick Sort
    │   └── PerformanceResult.java# Timing result record
    │
    └── Model03/                  # Performance Analyzer
        ├── PerformanceAnalyzer.java  # Benchmark runner
        ├── SortingAlgorithms.java    # Quick Sort implementation
        ├── SearchingAlgorithms.java  # Binary Search implementation
        └── DataGenerator.java        # Random array generator
```

## Algorithms & Data Structures Used

| Category | Implementations |
|---|---|
| **Graphs** | Adjacency list (weighted, undirected) |
| **Trees** | Binary Search Tree (BST) |
| **Traversals** | Breadth-First Search (BFS) |
| **Sorting** | Bubble Sort, Merge Sort, Quick Sort |
| **Searching** | Binary Search |
