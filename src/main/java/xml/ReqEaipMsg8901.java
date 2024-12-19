package xml;

import com.google.gson.annotations.SerializedName;
import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("service")
public class ReqEaipMsg8901 {

    @XStreamAlias("msg_head")
    private Head head;
    @XStreamAlias("msg_body")
    @SerializedName("body")
    private ReqEaipMsg8901Body object;

    public ReqEaipMsg8901(ReqEaipMsg8901Body t) {
        this.object = t;
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

    public void setObject(ReqEaipMsg8901Body object) {
        this.object = object;
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
