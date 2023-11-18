package main.java.com.example.helloworld.action;

import com.opensymphony.xwork2.ActionSupport;
import main.java.com.example.helloworld.model.MessageStore;

public class HelloWorldAction extends ActionSupport {
    private MessageStore messageStore;

    public String execute() {
        messageStore = new MessageStore();

        return SUCCESS;
    }

    public MessageStore getMessageStore() {
        return messageStore;
    }
}
