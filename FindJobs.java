import java.io.BufferedReader;
import java.io.InputStreamReader;

public class FindJobs {

    public static void viewJobMatrix(int jobMatrix[][]) {
        System.out.print("\n\t");
        for (int i = 0; i < jobMatrix[0].length; i++) {
            System.out.print("\t\tJob " + (i+1));
        }
        System.out.println();
        for (int i = 0; i < jobMatrix.length; i++) {
            System.out.print("Person " + (i+1) + " :\t");
            for (int j = 0; j < jobMatrix[0].length; j++) {
                System.out.print(jobMatrix[i][j] + "\t\t\t");
            }
            System.out.println();
        }
    }

    public static void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    public static void findSmallestCountJobs(int A[], int S, int E, int jobMatrix[][], int minCost[]) {
        if(S == E) {
//            Show All Possible case (Sample Space)
//            System.out.print("( ");
//            for (int i = 0; i < E; i++) {
//                System.out.print(A[i] + ", ");
//            }
//            System.out.println(")");
            int sum = 0;
            for (int i = 0; i < E; i++) {
                sum += jobMatrix[i][A[i]];
            }
            if(sum < minCost[0]) {
                minCost[0] = sum;
            }
        }
        else {
            for (int i = S; i < E; i++) {
                swap(A, S, i);
                findSmallestCountJobs(A, S + 1, E, jobMatrix, minCost);
                swap(A, S, i);
            }
        }
    }

    public static void main(String[] args) throws Exception {

        // Input Section
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Input number of people : ");
        int amountOfPeople = Integer.parseInt(reader.readLine());
        System.out.print("Input number of jobs : ");
        int amountOfJobs = Integer.parseInt(reader.readLine());
        int jobMatrix[][] = new int[amountOfPeople][amountOfJobs];
        for (int i = 0; i < amountOfPeople; i++) {
            System.out.println("------------------------------------------------");
            System.out.println("[ Person " + (i+1) + " ]");
            for (int j = 0; j < amountOfJobs; j++) {
                System.out.print("Job " + (j+1) + " : ");
                jobMatrix[i][j] = Integer.parseInt(reader.readLine());
            }
        }

        // View Section
        viewJobMatrix(jobMatrix);

        // Process Section
        int A[] = new int[amountOfPeople];
        for (int i = 0; i < A.length; i++) {
            A[i] = i + 1;
        }
        int minCost[] = {Integer.MAX_VALUE};
        findSmallestCountJobs(A, 0, A.length - 1, jobMatrix, minCost);
        System.out.println("Minimum Cost is : " + minCost[0]);


    }
}
