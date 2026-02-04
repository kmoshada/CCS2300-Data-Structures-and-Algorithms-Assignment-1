//This class contains Quick sort 

public class SortingAlgorithms{

  //partition methord(pivot=first element)

  public static int partition(int[] A, int lb, int ub){
      int pivot = A[lb]; //first element as pivot
      int start = lb;
      int end =ub;

      while (start < end ){
          while(A[start] <= pivot && start < ub){
              start++;
          }
          while (A[end] > pivot){
              end--;
          }
          if(start < end) {
            int temp = A[start];
            A [start]=A [end];
            A [end] = temp;

          }
      }
      //place pivot in correct position
           int temp = A[lb];
           A[lb] = A[end];
           A[end] = temp;

            return end;

  }
  //Quick sort method
  public static void quicksort(int[] A,int lb,int ub){
      if(lb < ub){
         int k= partition(A,lb,ub);

              quicksort(A,LB,k-1);//left side
              quicksort(A,k+1,ub);//right side

        }
   }
}
