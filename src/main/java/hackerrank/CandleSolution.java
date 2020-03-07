package hackerrank;

public class CandleSolution {
    public static void main(String[] args) {
        System.out.println(candleSolution(10, 2, 5));
        System.out.println(candleSolution(6, 2, 2));
        System.out.println(candleSolution(12, 3, 4));
        System.out.println(candleSolution(12, 4, 3));
        System.out.println(candleSolution(12, 6, 3));
    }
    private static int candleSolution(int amount, int perPiecePrice, int residueCandleCount){
//BUYING SET
        int q = amount/perPiecePrice;
        int r = 0;
        int sum = q;
//INTERMEDIATE SETS
        while(q>=residueCandleCount){
            q = q/residueCandleCount;
            r = q%residueCandleCount;
            sum = sum + q;
        }
//LAST SET
        int finalSet = q + r;
        boolean finalSetEnabled = false;
        if(finalSet>=residueCandleCount){
            sum+=q;
            finalSetEnabled = true;
            q = q/residueCandleCount;
        }
//RESULT FORMATION
        int result;
        if(finalSetEnabled)
            result = sum + q;
        else
            result = sum;
        return result;
    }
}
