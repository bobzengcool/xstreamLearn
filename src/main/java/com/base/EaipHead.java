package com.base;

import com.thoughtworks.xstream.annotations.XStreamAlias;

public class EaipHead {
    @XStreamAlias("version")
    private String HeadVersion;
    @XStreamAlias("trancode")
    private String HeadTranCode;

    public EaipHead() {
        setHeadTranCode("headCode");
        setHeadVersion("headVersion");
    }

    public String getHeadVersion() {
        return HeadVersion;
    }

    public void setHeadVersion(String headVersion) {
        HeadVersion = headVersion;
    }

    public String getHeadTranCode() {
        return HeadTranCode;
    }

    public void setHeadTranCode(String headTranCode) {
        HeadTranCode = headTranCode;
    }

}
