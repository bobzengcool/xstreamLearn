package com.tran;

import com.base.EaipReqBase;
import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("service")
public class HXXT8901 extends EaipReqBase {

    String content;
    String fly;

    public HXXT8901() {
        setContent("hello content");
        setFly("i can fly");
        setTranCode("8901");
        setVersion("1.0");
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getFly() {
        return fly;
    }

    public void setFly(String fly) {
        this.fly = fly;
    }

}
