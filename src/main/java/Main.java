import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by ${DPudov} on 30.10.2016.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Введите дату в формате DD.MM.YYYY");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String date = reader.readLine();
            Pattern pattern = Pattern.compile("^\\d\\d.\\d\\d.\\d\\d\\d\\d$");
            Matcher matcher = pattern.matcher(date);
            if (matcher.matches()) {

                int day = date.charAt(1) != '0' ? Integer.valueOf(date.substring(0, 2)) : Integer.valueOf(date.charAt(2));
                System.out.printf("Day %d \n", day);
                int month = date.charAt(4) != '0' ? Integer.valueOf(date.substring(3, 5)) : Integer.valueOf(date.charAt(5));
                System.out.printf("Month %d\n", month);
                int year = Integer.valueOf(date.substring(6, 10));
                System.out.printf("Year %d\n", year);
                int monthCode = -1;
                int yearCode = -1;
                int centuryCode = -1;
                switch ((year / 100) % 4) {
                    case 0:
                        centuryCode = 6;
                        break;
                    case 1:
                        centuryCode = 4;
                        break;
                    case 2:
                        centuryCode = 2;
                        break;
                    case 3:
                        centuryCode = 0;
                        break;
                }
                switch (month) {
                    case 1:
                        monthCode = 1;
                        break;
                    case 2:
                        monthCode = 4;
                        break;
                    case 3:
                        monthCode = 4;
                        break;
                    case 4:
                        monthCode = 0;
                        break;
                    case 5:
                        monthCode = 2;
                        break;
                    case 6:
                        monthCode = 5;
                        break;
                    case 7:
                        monthCode = 0;
                        break;
                    case 8:
                        monthCode = 3;
                        break;
                    case 9:
                        monthCode = 6;
                        break;
                    case 10:
                        monthCode = 1;
                        break;
                    case 11:
                        monthCode = 4;
                        break;
                    case 12:
                        monthCode = 6;
                        break;
                }
                yearCode = (centuryCode + year % 100 + (year % 100) / 4) % 7;
                if (monthCode != -1 && yearCode != -1 && centuryCode != -1) {
                    int weekDay = day + monthCode + yearCode;
                    if (isLeap(year) && month <= 2) {
                        weekDay--;
                    }
                    weekDay %= 7;
                    switch (weekDay) {
                        case 0:
                            System.out.println("Saturday");
                            break;
                        case 1:
                            System.out.println("Sunday");
                            break;
                        case 2:
                            System.out.println("Monday");
                            break;
                        case 3:
                            System.out.println("Tuesday");
                            break;
                        case 4:
                            System.out.println("Wednesday");
                            break;
                        case 5:
                            System.out.println("Thursday");
                            break;
                        case 6:
                            System.out.println("Friday");
                            break;
                    }
                } else {
                    System.out.println("Input error");
                }
            } else {
                System.out.println("Input error");
            }
        } catch (IOException e) {
            System.out.println("Input Error");
        }
    }

    private static boolean isLeap(int year) {
        return ((year % 4 == 0 && year % 100 != 0)) || ((year % 400) == 0);
    }
}
