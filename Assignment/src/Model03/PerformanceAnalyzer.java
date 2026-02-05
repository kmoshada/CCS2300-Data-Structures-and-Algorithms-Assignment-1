//this class runs module3 performance testing 
public class PerformanceAnalyzer{
  public static void main (String[] args){

      int[] sizes = {100,500,1000,5000,10000};

      System.out.println("-----------------------------------------------------------------------------");
      System.out.println("Size\tSort Time (ns)\t\tSearch Time(ns)");
      System.out.println("-----------------------------------------------------------------------------");

      for (int size : sizes) {
          //generate random data 
          int[] arr = DataGenerator.generateArray(size);

          int key = arr[size/2];

          //mesure quick sort time
          long startSort=System.nanoTime();
          SortingAlgorithms.quicksort (arr,0,arr.length -1);
          long endSort = System.nanoTime();
          long sortTime = endSort - startSort;

          //mesure binary search time
          long startSearch=System.nanoTime();
          SearchingAlgorithms.binarySearch(arr,key);
          long endSearch = System.nanoTime();
          long searchTime = endSearch - startSearch;

          System.out.println(size + "\t" + sortTime + "\t\t" + searchTime);


      }
       System.out.println("-----------------------------------------------------------------------------");
  }
}