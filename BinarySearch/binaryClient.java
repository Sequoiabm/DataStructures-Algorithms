
// Import random library 
import java.util.Random;
import java.util.HashSet;
import java.util.Set;


public class binaryClient {

    public static double runExperiment(int N, int T) {
        // Step 1: Initialize an array to store the results of each trial
        int trials[] = new int[T];
        // Step 2: Create an instance of the Random class to generate random numbers
        Random random = new Random();
        


        for(int i = 0; i < T; i++){

            // Step 3: Generate two arrays of N random six-digit integers
            int arr1[] = new int[N];
            int arr2[] = new int[N];

            for(int j = 0; j < N; j++){
                arr1[j] = 100000 + random.nextInt(900000);
                arr2[j] = 100000 + random.nextInt(900000);
            }

            Set<Integer> setForArr2 = new HashSet<>();
            for(int value : arr2){
                setForArr2.add(value);
            }

            // Step 4: Count the number of common values between the two arrays
            int commonValues = 0;
            for(int value1 : arr1){
                if(setForArr2.contains(value1)){
                    commonValues++;
                }
            }
            
            // Step 5: Append the count to the array of results
            trials[i] = commonValues;
        }

        // Step 6: Calculate the average of the results
        double sum = 0;
        for(int commonValues : trials) {
            sum += commonValues;
        }
        // Step 7: Return the average
        return sum / T;


    }

    public static void main(String[] args){

        // Step 8: Define an array of N values for which you want to run the experiment
        int NValues[] = {1000, 10000, 100000, 1000000};
        // Step 9: Define the number of trials (T)
        int T = 3;

        System.out.println("N\t Average common values: ");

        for(int N: NValues){
            // Step 10: Call the runExperiment method with N and T as arguments
            double avgCommonValues = runExperiment(N, T);
            // Step 11: Print the results in a table format
            System.out.printf("%d\t%.2f\n", N, avgCommonValues);


        }
    }
   
}
