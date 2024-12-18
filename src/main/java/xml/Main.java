package xml;

import com.base.EaipHead;
import com.base.EaipReqBaseBody;
import com.base.EaipReqBaseHandle;
import com.thoughtworks.xstream.XStream;
import com.tran.HXXT4694Body;

public class Main {
    public static void main(String[] args) {
        ReqEaipMsg8901Body body8901 = new ReqEaipMsg8901Body();
        body8901.setHeadTranCode("8901");
        body8901.setHeadVersion("1.0");
        body8901.setBody8901("this is 8901body");

        ReqEaipMsg8901 reqEaipMsg8901 = new ReqEaipMsg8901(body8901);
        // 将对象序列化为报文
        String msg_str = reqEaipMsg8901.toXML();
        System.out.println("str_msg=" + msg_str);

        // 将报文反序列化为对象
        Class<?>[] classes = new Class[] {
                ReqEaipMsg8901.class,
                ReqEaipMsg8901Body.class
        };
        // xstream.processAnnotations(ReqEaipMsg8901.class);
        ReqEaipMsg8901 Msg8901vo = new ReqEaipMsg8901();
        ReqEaipMsg8901 vo = Msg8901vo.fromXml2oBJ(msg_str, ReqEaipMsg8901.class, classes);
        System.out.println("打印字段8901HEAD==" + vo.getHead().getMsgId());

        ReqEaipMsg8901Body tt = (ReqEaipMsg8901Body) vo.getObject();
        System.out.println("打印字段8901body==" + tt.getBody8901() + "  " + tt.getHeadTranCode());
    }
}