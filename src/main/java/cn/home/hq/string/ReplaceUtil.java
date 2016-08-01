package cn.home.hq.string;

/**
 * Created by yanou on 16/1/20.
 */
public class ReplaceUtil {

    /**
     * <p>Description: main</p>
     * @param args
     * @author haihong.qhh
     * @date 2016-01-20 上午10:02:39
     */
    public static void main(String[] args) {
        String from = "http://ie.admin.taobao.org/mckinley/auction/ie/ie_order_detail.htm?order_id=112820160653&cos=create_ticket_order&from_id=crmbd";
        String toUrl = from.replaceFirst("ie.admin.taobao.org", "crm.trip.taobao.org");
        System.out.println(toUrl);
    }

}
