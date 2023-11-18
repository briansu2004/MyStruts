package main.java.com.example.helloworld.action;

import com.opensymphony.xwork2.ActionSupport;
import main.java.com.example.helloworld.model.MessageStore;

public class HelloWorldAction extends ActionSupport {
    private MessageStore messageStore;

    private static int helloCount = 0;

    public int getHelloCount() {
        return helloCount;
    }

    public String execute() {
        helloCount++;
        
        messageStore = new MessageStore();

        return SUCCESS;
    }

    public MessageStore getMessageStore() {
        return messageStore;
    }
}
