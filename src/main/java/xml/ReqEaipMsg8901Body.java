package xml;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;

// @XStreamAlias("msg_body")
public class ReqEaipMsg8901Body extends HXZ03BaseVo {
    // 这里可以添加8901报文体特有的属性和方法，暂时为空示例
    private String body8901;

    @XStreamAlias("sdo")
    // @XStreamImplicit(itemFieldName = "myElement")
    List<String> list;

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public String getBody8901() {
        return body8901;
    }

    public void setBody8901(String body8901) {
        this.body8901 = body8901;
    }
}
