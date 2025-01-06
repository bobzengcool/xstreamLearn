package xml;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

class Test {
    public void test1() {
        ReqEaipMsg8901Body body8901 = new ReqEaipMsg8901Body();
        body8901.setHeadTranCode("8901");
        body8901.setHeadVersion("1.0");
        body8901.setBody8901("this is 8901body");

        // ReqEaipMsg8901 reqEaipMsg8901 = new ReqEaipMsg8901(body8901);
        // 将对象序列化为报文
        // String msg_str = reqEaipMsg8901.toXML();
        // System.out.println("str_msg=" + msg_str);

        // // 将报文反序列化为对象
        // Class<?>[] classes = new Class[] {
        // ReqEaipMsg8901.class,
        // ReqEaipMsg8901Body.class
        // };
        // // xstream.processAnnotations(ReqEaipMsg8901.class);
        // ReqEaipMsg8901 Msg8901vo = new ReqEaipMsg8901();
        // ReqEaipMsg8901 vo = Msg8901vo.fromXml2oBJ(msg_str, ReqEaipMsg8901.class,
        // classes);
        // System.out.println("打印字段8901HEAD==" + vo.getHead().getMsgId());

        // ReqEaipMsg8901Body tt = (ReqEaipMsg8901Body) vo.getObject();
        // System.out.println("打印字段8901body==" + tt.getBody8901() + " " +
        // tt.getHeadTranCode());
    }

    public void test2() {
        List<String> stringList = new ArrayList<>();

        // 向列表中添加元素
        stringList.add("apple");
        stringList.add("banana");
        stringList.add("cherry");

        ReqEaipMsg8901Body body8901 = new ReqEaipMsg8901Body();
        body8901.setHeadTranCode("8901");
        body8901.setHeadVersion("1.0");
        body8901.setBody8901("this is 8901body");
        body8901.setList(stringList);
        body8901.setTestString("testString");

        ReqEaipMsg8901 reqEaipMsg8901 = new ReqEaipMsg8901(body8901);

        reqEaipMsg8901.getHead().setMsgId("TTTTT");
        reqEaipMsg8901.getHead().setHeadTranCode("hhh");
        reqEaipMsg8901.getHead().setHeadVersion("vvvv");
        // 将报文反序列化为对象
        Class<?>[] classes = new Class[] {
                ReqEaipMsg8901.class
        };

        // Validator validator =
        // Validation.buildDefaultValidatorFactory().getValidator();
        // Set<ConstraintViolation<ReqEaipMsg8901>> violations =
        // validator.validate(reqEaipMsg8901);
        // System.out.println("xxxxxxxxxxxxxxxxxxxxxx55=" + violations.size());

        String msg_str = XmlMsgTool.objectToXml(reqEaipMsg8901, classes);
        System.out.println("============对象转化为报文后为=======================\n" + msg_str);

        ReqEaipMsg8901 vo = XmlMsgTool.xmlToObject(msg_str, ReqEaipMsg8901.class, classes);
        System.out.println("打印字段8901HEAD==" + vo.getHead().getMsgId());

        ReqEaipMsg8901Body tt = (ReqEaipMsg8901Body) vo.getObject();
        System.out.println("打印字段8901body==" + tt.getBody8901() + "  " + tt.getHeadTranCode());

        Gson gson = new Gson();
        String json = gson.toJson(vo);

        System.out.println("生辰的json===================\n" + json);

    }
}

public class Main {
    public static void main(String[] args) {
        new Test().test2();
    }
}