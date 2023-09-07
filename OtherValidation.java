import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class OtherValidation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
      /*  String amount = null;
        while (true) {
            System.out.print("plz input your amount:");
            amount = scanner.nextLine();
            if (Integer.parseInt(amount) % 100 != 0) {
                System.out.println("error,amount需要被100整除");
            } else {
                System.out.println("amount is :" + amount);

                break;
            }
        }*/
        String price = null;
        while (true) {
            price = scanner.nextLine();
            if (!(price.matches("^[1-9]\\d{0,6}\\.\\d*") || price.matches("^[1-9]\\d{0,6}"))) {
                System.out.println("error,price is incorrect");
            } else {
                //抹零
                price = String.valueOf(Double.parseDouble(price) - (Double.parseDouble(price) * 100) % 1 / 100);
                //四舍五入
                price = String.valueOf((double) Math.round(Double.parseDouble(price) * 100) / 100);
                //BigDecimal方法
                BigDecimal value = BigDecimal.valueOf(Double.parseDouble(price));
                BigDecimal roundedValue = value.setScale(2, RoundingMode.HALF_UP);
                price = String.valueOf(roundedValue);
                System.out.println("price:" + price);


            }
        }


    }
}
