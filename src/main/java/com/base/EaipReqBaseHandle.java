package com.base;

import com.inter.processMessage;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.tran.HXXT4694Body;

@XStreamAlias("service")
public class EaipReqBaseHandle implements processMessage {

    @XStreamAlias("head")
    private EaipHead basehead;

    @XStreamAlias("body")
    private Object obj;

    private String Version;
    private String TranCode;

    public EaipReqBaseHandle(Object obj) {
        this.basehead = new EaipHead();
        this.obj = obj;
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
        xstream.aliasSystemAttribute(null, "class");// 这个设置能够将body节点上的class=“”相关信息取消掉

        return xstream.toXML(this);
    }

    public Object deSerMsg(String msg, Class<?>[] classes) {
        XStream xstream = new XStream();
        // for (int i = 0; i <= node.length; i++) {
        // Object objtmp = node[i];
        // xstream.alias(objtmp.getClass().getSimpleName(), objtmp.getClass());
        // xstream.processAnnotations(getClass());
        // xstream.allowTypes(objtmp.getClass());
        // }

        xstream.allowTypes(classes);
        xstream.autodetectAnnotations(true);
        // xstream.ignoreUnknownElements();
        xstream.alias("service", this.getClass());
        xstream.alias("body", HXXT4694Body.class);

        return xstream.fromXML(msg);
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