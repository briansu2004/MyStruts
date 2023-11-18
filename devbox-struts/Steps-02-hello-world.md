# Section 1: Hello Struts

- [Step 1: Create the basic Struts app](#step-1-create-the-basic-struts-app)
  - [Initialize](#initialize)
  - [Update the pom.xml](#update-the-pomxml)
  - [log4j](#log4j)
  - [web.xml](#webxml)
- [Step 2: Create The Model Class MessageStore.java](#step-2-create-the-model-class-messagestorejava)
- [Step 3: Create The Action Class HelloWorldAction.java](#step-3-create-the-action-class-helloworldactionjava)
- [Step 4: Create The View HelloWorld.jsp](#step-4-create-the-view-helloworldjsp)
- [Step 5: Add The Struts Configuration in struts.xml](#step-5-add-the-struts-configuration-in-strutsxml)
- [Step 6: Create The URL Action](#step-6-create-the-url-action)
- [Step 7: Run the app with jetty](#step-7-run-the-app-with-jetty)

## Step 1: Create the basic Struts app

### Initialize

```dos
02_01_init.bat
```

### Update the pom.xml

properties

```xml
    <maven.compiler.source>1.8</maven.compiler.source>
    <maven.compiler.target>1.8</maven.compiler.target>
    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    <project.reporting.outputEncoding>UTF-8</project.reporting.outputEncoding>
    <java.version>1.8</java.version>
```

dependencies

```xml
    <dependency>
      <groupId>org.apache.struts</groupId>
      <artifactId>struts2-core</artifactId>
      <version>6.3.0.1</version>
    </dependency>
    <dependency>
      <groupId>org.apache.logging.log4j</groupId>
      <artifactId>log4j-core</artifactId>
      <version>2.21.1</version>
    </dependency>
    <dependency>
      <groupId>org.apache.logging.log4j</groupId>
      <artifactId>log4j-api</artifactId>
      <version>2.21.1</version>
    </dependency>
```

jetty plugin

```xml
       <plugin>
          <groupId>org.eclipse.jetty</groupId>
          <artifactId>jetty-maven-plugin</artifactId>
          <version>10.0.17</version>
          <configuration>
            <webApp>
              <contextPath>/${build.finalName}</contextPath>
            </webApp>
            <stopKey>CTRL+C</stopKey>
            <stopPort>8999</stopPort>
            <scanIntervalSeconds>10</scanIntervalSeconds>
            <scanTargets>
              <scanTarget>src/main/webapp/WEB-INF/web.xml</scanTarget>
            </scanTargets>
          </configuration>
        </plugin>
```

### log4j

Create a new folder `src\main\resources`.

Create a new file `log4j2.xml` in the `src\main\resources` folder.

```xml
<?xml version="1.0" encoding="UTF-8"?>
<Configuration>
    <Appenders>
        <Console name="STDOUT" target="SYSTEM_OUT">
            <PatternLayout pattern="%d %-5p [%t] %C{2} (%F:%L) - %m%n"/>
        </Console>
    </Appenders>
    <Loggers>
        <Logger name="com.opensymphony.xwork2" level="debug"/>
        <Logger name="org.apache.struts2" level="debug"/>
        <Root level="warn">
            <AppenderRef ref="STDOUT"/>
        </Root>
    </Loggers>
</Configuration>
```

### web.xml

in the `src\main\webapp\WEB-INF` folder

```xml
<?xml version="1.0" encoding="UTF-8"?>
<web-app id="WebApp_ID" version="2.4"
  xmlns="http://java.sun.com/xml/ns/j2ee"
  xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://java.sun.com/xml/ns/j2ee http://java.sun.com/xml/ns/j2ee/web-app_2_4.xsd">
  <display-name>Basic Struts2</display-name>

  <filter>
    <filter-name>struts2</filter-name>
    <filter-class>org.apache.struts2.dispatcher.filter.StrutsPrepareAndExecuteFilter</filter-class>
  </filter>

  <filter-mapping>
    <filter-name>struts2</filter-name>
    <url-pattern>/*</url-pattern>
  </filter-mapping>

  <welcome-file-list>
    <welcome-file>index</welcome-file>
  </welcome-file-list>
</web-app>
```

## Step 2: Create The Model Class MessageStore.java

Create the `MessageStore` class in `src/main/java`.

```java
package com.example.helloworld.model;

public class MessageStore {
    private String message;

    public MessageStore() {
        message = "Hello Struts User";
    }

    public String getMessage() {
        return message;
    }
}
```

## Step 3: Create The Action Class HelloWorldAction.java

```java
package com.example.helloworld.action;

import com.example.helloworld.model.MessageStore;
import com.opensymphony.xwork2.ActionSupport;

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
```

## Step 4: Create The View HelloWorld.jsp

Create `HelloWorld.jsp` in the `src/main/webapp` folder.

```html
<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" %> <%@ taglib prefix="s" uri="/struts-tags" %>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Hello World!</title>
  </head>
  <body>
    <h2><s:property value="messageStore.message" /></h2>
  </body>
</html>
```

## Step 5: Add The Struts Configuration in struts.xml

Edit the `struts.xml` file (in the `src/main/resources` folder) to add the action mapping.

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE struts PUBLIC
		"-//Apache Software Foundation//DTD Struts Configuration 2.5//EN"
		"http://struts.apache.org/dtds/struts-2.5.dtd">
<struts>
    <constant name="struts.devMode" value="true" />

    <package name="basicstruts2" extends="struts-default">
        <action name="index">
            <result>/index.jsp</result>
        </action>

        <action name="hello" class="com.example.helloworld.action.HelloWorldAction" method="execute">
            <result name="success">/HelloWorld.jsp</result>
        </action>
    </package>
</struts>
```

## Step 6: Create The URL Action

Edit `index.jsp` (in the `src/main/webapp` folder)

```jsp
<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Basic Struts 2 Application - Welcome</title>
    </head>
    <body>
        <h1>Welcome To Struts 2!</h1>
        <p><a href="<s:url action='hello'/>">Hello World</a></p>
    </body>
</html>
```

## Step 7: Run the app with jetty

```dos
02_02_jetty.bat
```

http://localhost:8080/02-helloworld/index.action

http://localhost:8080/02-helloworld/hello.action
