package xml;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamAlias;

public class ReqEaipMsgBaseVo {

    @XStreamAlias("msg_head")
    private Head head;
    @XStreamAlias("msg_body")
    private Object object;

    public ReqEaipMsgBaseVo() {
    }

    public ReqEaipMsgBaseVo(Object object) {
        this.object = object;
        Head h = new Head();
        h.setMsgId("123456789");
        this.head = h; // 这里简单初始化一个头示例，实际按需求完善
    }

    public Head getHead() {
        return head;
    }

    public void setHead(Head head) {
        this.head = head;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public String toXML() {
        XStream xstream = new XStream();
        xstream.autodetectAnnotations(true);
        xstream.processAnnotations(this.getClass());
        // xstream.aliasSystemAttribute(null, "class");加上这一句之后，反序列化会有问题

        // xstream.alias("ReqEaipMsgBase", this.getClass());
        return xstream.toXML(this);
    }

    public <T> T fromXml2oBJ(String msg, Class<T> typeClass, Class<?>[] classes) {
        XStream xstream = new XStream();
        xstream.autodetectAnnotations(true);
        xstream.processAnnotations(this.getClass());
        xstream.allowTypes(classes);

        return typeClass.cast(xstream.fromXML(msg));
    }
}

class Head {
    // 这里简单定义一些头的属性示例，实际按具体eaip请求报文头完善
    private String msgId;

    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }
}
