package tryMain;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

enum Levels
{
    TOP, MEDIEUM(10), BOTTOM(20, 30);
    int i, j;
    private Levels() {}
    private Levels(int i)
    {
        this.i = i;
    }
    private Levels(int i, int j)
    {
        this.i = i;
        this.j = j;
    }
}
public class MainClass
{
    public static void main(String[] args)
    {
        System.out.println(Levels.TOP.i);
        System.out.println(Levels.TOP.j);

        System.out.println(Levels.MEDIEUM.i);
        System.out.println(Levels.MEDIEUM.j);

        System.out.println(Levels.BOTTOM.i);
        System.out.println(Levels.BOTTOM.j);

        List<Integer> list  = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        Consumer<Integer> consumer = new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                if(integer > 3 && integer < 7)
                    System.out.print(integer);
            }
        };

        list.stream().forEach(consumer);

        Predicate<Integer> predicate2 = i -> i % 2 == 0;
        Predicate<Integer> predicate5 = i -> i % 5 == 0;

        System.out.println(list.stream().filter(Predicate.not((predicate2.or(predicate5)))).collect(Collectors.toList()));

    }
}