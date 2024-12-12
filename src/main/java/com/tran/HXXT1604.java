package com.tran;

import com.base.*;
import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("service")
public class HXXT1604 extends EaipReqBase {
    String content;

    public HXXT1604() {
        this.getBasehead().setHeadTranCode("1604");
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
