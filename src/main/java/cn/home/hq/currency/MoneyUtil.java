package cn.home.hq.currency;

import com.taobao.util.Money;

import static java.lang.System.out;

/**
 * Created by yanou on 16/1/27.
 */
public class MoneyUtil {

    public static void main(String[] args) {
        Money refundAmountMoney1 = new Money(121800/100, 1218%100);
        out.println("��ӡ���1��"+refundAmountMoney1.toString());
        Money refundAmountMoney2 = new Money(121800/100, 1218%100);
        out.println("��ӡ���2��"+refundAmountMoney2.toString());
    }

}
