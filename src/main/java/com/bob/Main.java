package com.bob;

import com.base.EaipHead;
import com.base.EaipReqBaseBody;
import com.base.EaipReqBaseHandle;
import com.tran.HXXT1604;
import com.tran.HXXT4694Body;
import com.tran.HXXT8901;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        HXXT1604 vo = new HXXT1604();
        vo.setVersion("H01");
        vo.setTranCode("1064");
        vo.setContent("this is a test");

        String str = vo.beforeSend("hello every one");

        String resp = vo.sendMsg(str);
        System.out.println(resp);

        String msg = vo.genXmlSendMsg();
        System.out.println("msg=----------------------\n" + msg);

        HXXT8901 vo8901 = new HXXT8901();
        vo8901.getBasehead().setHeadTranCode("8901");
        String msg8901 = vo8901.genXmlSendMsg();
        System.out.println("8901msg=-------------------\n" + msg8901);
        System.out.println("-------------------------------------------");

        HXXT4694Body body4694 = new HXXT4694Body();
        body4694.setJydm("4694");
        body4694.setJyrq("20241216");
        body4694.setJysm("测试通过注解生辰xml报文");
        EaipReqBaseHandle handle = new EaipReqBaseHandle(body4694);
        String msg4694 = handle.genXmlSendMsg();
        System.out.println("4694的报文为--->" + msg4694);

        Class<?>[] classes = new Class[] {
                EaipHead.class,
                HXXT4694Body.class,
                EaipReqBaseHandle.class,
                EaipReqBaseBody.class,
        };
        HXXT4694Body de4694 = (HXXT4694Body) handle.deSerMsg(msg4694, classes);

        System.out.println("报文反序列化后获取对象jysm=" + de4694.getJysm());
    }
}