package com.base;

import com.inter.processMessage;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamAlias;

public class EaipReqBase implements processMessage {

    @XStreamAlias("head")
    private EaipHead basehead;

    private String Version;
    private String TranCode;

    public EaipReqBase() {
        this.basehead = new EaipHead();
    }

    public EaipHead getBasehead() {
        return basehead;
    }

    public void setBasehead(EaipHead basehead) {
        this.basehead = basehead;
    }

    public String genXmlSendMsg() {

        XStream xstream = new XStream();

        // XStream xstream=new XStream(new DomDriver()); //直接用jaxp dom来解释
        // XStream xstream=new XStream(new DomDriver("utf-8")); //指定编码解析器,直接用jaxp dom来解释
        // 如果没有这句，xml中的根元素会是<包.类名>；或者说：注解根本就没生效，所以的元素名就是类的属性
        xstream.processAnnotations(this.getClass()); // 通过注解方式的，一定要有这句话

        return xstream.toXML(this);
    }

    public String sendMsg(String str) {

        return "hello" + str;
    }

    @Override
    public String afterReceive(String msg) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void afterSend() {
        // TODO Auto-generated method stub

    }

    @Override
    public void beforeReceive() {
        // TODO Auto-generated method stub

    }

    @Override
    public String beforeSend(String msg) {
        // TODO Auto-generated method stub
        return "before send " + msg;
    }

    public String getVersion() {
        return Version;
    }

    public void setVersion(String version) {
        Version = version;
    }

    public String getTranCode() {
        return TranCode;
    }

    public void setTranCode(String tranCode) {
        TranCode = tranCode;
    }

}