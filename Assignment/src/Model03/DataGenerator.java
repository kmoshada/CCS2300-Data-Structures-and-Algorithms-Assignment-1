import java.util.Random;

//This class generates random arrays
public class DataGenerator{
    public static int [] generateArray(int size){

        Random random = new Random();
        int[] arr =new int[size];

        for (int i=0 ; i <size; i++){
            arr[i] = random.nextInt(10000);
        }
        return arr;
        
    }

}