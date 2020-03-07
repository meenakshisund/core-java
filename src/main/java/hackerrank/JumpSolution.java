package hackerrank;

public class JumpSolution {
    public static void main(String[] args) {
        //System.out.println(jumpSolution(3,3));
        System.out.println(jumpSolution(4,4));/*
        System.out.println(jumpSolution(5,5));
        System.out.println(jumpSolution(6,6));*/
    }

    private static int jumpSolution(int n, int k){
        int sum = 0;
        int max= 0;
        for(int j=1; j<=n; j++) {
            System.out.println("Running j for(Starting from---------) : "+j);
            sum = 0;
            for(int i=j; i<=n; i++) {
                if(sum<k) {
                    sum+= i;
                    if(sum==k)
                        sum-=i;
                    System.out.println("j: "+ j + " i: "+ i + " sum: "+ sum + " max : " + max);
                } else if(sum>k){
                    sum+=i;
                    System.out.println("j: "+ j + " i: "+ i + " sum: "+ sum + " max : " + max);
                }
            }
            if(sum>max) {
                max = sum;
                System.out.println("MAX VALUE SET : "+ max);
            }
            System.out.println("Running j for(Ending Here ---------) : "+j+"\n");
        }
        return max;
    }
}