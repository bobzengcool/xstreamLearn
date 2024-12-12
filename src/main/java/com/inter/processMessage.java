package com.inter;

public interface processMessage {
    public String beforeSend(String msg);

    public void afterSend();

    public void beforeReceive();

    public String afterReceive(String msg);

    public String sendMsg(String msg);
}
