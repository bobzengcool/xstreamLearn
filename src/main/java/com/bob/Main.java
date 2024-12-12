package com.bob;

import com.tran.HXXT1604;
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

    }
}