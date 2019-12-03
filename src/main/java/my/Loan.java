package my;

public class Loan {


    /*
     * 微粒贷：万3.5按日计息
     *
     * 百度金融：
     * 1.万5按日计息，目前6折=万3按日计息
     *
     * 2.等额本金还款，12期
     *
     */


    public static double dailyInterest(double principal, int period, double rate) {
        double perPeriodMoney = principal / period;
        double totalInterest = 0;
        for (int i = 0; i < period; i++) {
            double interest = principal * rate * 30;
            System.out.println("第" + (i + 1) + "期:" + (perPeriodMoney + interest) + "(本金：" + perPeriodMoney + "利息：" + interest + ")");
            principal -= perPeriodMoney;
            totalInterest += interest;
        }
        System.out.println("总利息：" + totalInterest);
        return totalInterest;
    }

    /**
     * 等额本金的还款方式
     *
     * @param principal    本金
     * @param period       期数
     * @param maxDeduction 每期最大抵扣
     * @param rate         日利率
     * @return
     */
    public static double equalPrincipal(double principal, int period, double maxDeduction, double rate) {
        double perPeriodMoney = principal / period;
        double totalInterest = 0;
        for (int i = 0; i < period; i++) {
            //利息,每月按照30天计算（31天暂时忽略不计）
            double interest = principal * rate * 30;
            interest = maxDeduction > interest ? 0 : (interest - maxDeduction);
            System.out.println("第" + (i + 1) + "期:" + (perPeriodMoney + interest) + "(本金：" + perPeriodMoney + "利息：" + interest + ")");
            principal -= perPeriodMoney;
            totalInterest += interest;
        }
        System.out.println("总利息：" + totalInterest);
        return totalInterest;
    }

    public static void main(String[] args) {
        equalPrincipal(5000, 12, 50, 0.0005);
        dailyInterest(6000, 4, 0.00035);
        dailyInterest(11000, 4, 0.0003);
    }
}
