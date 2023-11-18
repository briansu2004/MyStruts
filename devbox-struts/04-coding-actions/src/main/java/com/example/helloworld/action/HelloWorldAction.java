package main.java.com.example.helloworld.action;

import com.opensymphony.xwork2.ActionSupport;
import main.java.com.example.helloworld.model.MessageStore;

public class HelloWorldAction extends ActionSupport {
    private static int helloCount = 0;

    private MessageStore messageStore;

    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getHelloCount() {
        return helloCount;
    }

    public String execute() {
        helloCount++;
        
        messageStore = new MessageStore();

        if (userName != null) {
            messageStore.setMessage(messageStore.getMessage() + " " + userName);
        }

        return SUCCESS;
    }

    public MessageStore getMessageStore() {
        return messageStore;
    }
}
