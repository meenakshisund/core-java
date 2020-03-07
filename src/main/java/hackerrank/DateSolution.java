package hackerrank;

public class DateSolution {
    public static void main(String[] args) {
        System.out.println(processDateString("27th Sep 1987"));
    }

    enum MonthEnum {
        Jan("01"), Feb("02"), Mar("03"), Apr("04"),
        May("05"), Jun("06"), Jul("07"), Aug("08"),
        Sep("09"), Oct("10"), Nov("11"), Dec("12");

        String number;
        MonthEnum(String number){
            this.number = number;
        }
    }

    private static String processDate(String dateValue){
        dateValue = dateValue.replaceAll("[^0-9]", "");
        return dateValue;
    }

    private static String processDateString(String dateString) {
        String[] split = dateString.split(" ");
        StringBuilder sb = new StringBuilder(split[2]);
        sb.append("-");
        sb.append(MonthEnum.valueOf(split[1]).number);
        sb.append("-");
        sb.append(processDate(split[0]));
        return sb.toString();
    }
}