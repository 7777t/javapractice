import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DateSorting {
    public static void main(String[] args) {
        // 创建日期列表
        List<LocalDate> dates = new ArrayList<>();
        dates.add(LocalDate.parse("2023-08-15"));
        dates.add(LocalDate.parse("2022-12-31"));
        dates.add(LocalDate.parse("2023-01-15"));
////////////////////////////////////////////////
        // 对日期列表进行降序排序
        Collections.sort(dates, Collections.reverseOrder());

        // 输出排序后的日期列表
        for (LocalDate date : dates) {
            System.out.println(date);
        }
////////////////////////////////////////////
        // 使用ArrayList.sort进行日期排序
        dates.sort((date1, date2) -> date2.compareTo(date1)); // 降序排序

        // 输出排序后的日期列表
        for (LocalDate date : dates) {
            System.out.println(date);
        }
    }
}
