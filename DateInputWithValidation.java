import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class DateInputWithValidation {
    public static void main(String[] args) {
        validateAndProcessDateInput();
    }

    public static void validateAndProcessDateInput() {
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");

        Date trade_time = null;

        while (true) {
            System.out.println("请输入日期和时间（格式：yyyy-MM-dd HH:mm）：");
            String dateStr = scanner.nextLine();

            try {
                trade_time = sdf.parse(dateStr);

                Date currentDate = new Date();

                if (trade_time.before(currentDate)) {
                    int hour = trade_time.getHours();

                    if (hour >= 9 && hour <= 15) {
                        // 检查是否是周末
                        int dayOfWeek = getDayOfWeek(trade_time);

                        if (dayOfWeek == 1 || dayOfWeek == 7) {
                            System.out.println("输入的日期时间是周末，请重新输入。");
                        } else {
                            System.out.println("输入的日期时间在工作时间范围内。");
                            break;
                        }
                    } else {
                        System.out.println("输入的日期时间不在工作时间范围内，请重新输入。");
                    }
                } else {
                    System.out.println("输入的日期时间为将来，请输入过去的日期时间。");
                }
            } catch (ParseException e) {
                System.out.println("输入的日期时间无效，请按格式输入（yyyy-MM-dd HH:mm）。");
            }
        }

        System.out.println("输入的日期时间为：" + sdf.format(trade_time));
    }

    public static int getDayOfWeek(Date date) {
        // 获取日期的星期，1 表示星期天，2 表示星期一，以此类推
        SimpleDateFormat sdf = new SimpleDateFormat("u");
        return Integer.parseInt(sdf.format(date));
    }
}

