package hackerrank;

public class StarSolution {
    public static void main(String[] args) {
        int value = 5;

        for (int i = 1; i <= value; i++) {
            boolean flag = false;
            for (int j = 1; j <= i; j++) {
                int diff = value-i;
                while(diff>0 && !flag){
                    System.out.print(" ");
                    diff--;
                }
                flag = true;
                   System.out.print(i + " "); // change value to i for 1,22,333,4444,55555
                // System.out.print(j + " "); // change value to i for 1,12,123,1234,12345
            }
            System.out.println();
        }
        printTriagle(5);

    }
    public static void printTriagle(int n)
    {
        // outer loop to handle number of rows
        //  n in this case
        for (int i=0; i<n; i++)
        {

            // inner loop to handle number spaces
            // values changing acc. to requirement
            for (int j=n-i; j>1; j--)
            {
                // printing spaces
                System.out.print(" ");
            }

            //  inner loop to handle number of columns
            //  values changing acc. to outer loop
            for (int j=0; j<=i; j++ )
            {
                // printing stars
                System.out.print("* ");
            }

            // ending line after each row
            System.out.println();
        }
    }
}