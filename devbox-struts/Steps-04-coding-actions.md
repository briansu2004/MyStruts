# Section 4: Coding Actions

- [Step 1: Create the basic Struts app](#step-1-create-the-basic-struts-app)
- [Step 2: Update MessageStore and HelloWorldAction](#step-2-update-messagestore-and-helloworldaction)
- [Step 3: Run the app with jetty](#step-3-run-the-app-with-jetty)

## Step 1: Create the basic Struts app

- Copy `03-using-tags` to `04-coding-actions`
- Replace `03-using-tags` (or `02-helloworld`) to `04-coding-actions` in `pom.xml`

## Step 2: Update MessageStore and HelloWorldAction

Update `MessageStore.java`

```java
    public void setMessage(String message) {
        this.message = message;
    }
```

Update `HelloWorldAction.java`

```java
private String userName;

public String getUserName() {
    return userName;
}

public void setUserName(String userName) {
    this.userName = userName;
}

if (userName != null) {
    messageStore.setMessage(messageStore.getMessage() + " " + userName);
}
```

## Step 3: Run the app with jetty

```dos
04_jetty.bat
```

<http://localhost:8080/04-coding-actions/index.action>

<http://localhost:8080/04-coding-actions/hello.action>

<http://localhost:8080/04-coding-actions/hello.action?userName=Brian>
