package xml;

import org.hibernate.validator.constraints.NotBlank;

import com.thoughtworks.xstream.annotations.XStreamAlias;

public class HXZ03BaseVo {
    @NotBlank
    @XStreamAlias("version")
    private String HeadVersion;
    @NotBlank
    @XStreamAlias("trancode")
    private String HeadTranCode;

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
