# Section 1: Hello Struts

- [Step 1: Create the basic app](#step-1-create-the-basic-app)
- [Step 2: Add jetty plugin](#step-2-add-jetty-plugin)
- [Step 3: Update the index.jsp](#step-3-update-the-indexjsp)
- [Step 4: Add a new jsp](#step-4-add-a-new-jsp)
- [Step 5: Verify the jsp](#step-5-verify-the-jsp)
- [Step 6: Add Struts](#step-6-add-struts)
- [Step 7: Add log4j](#step-7-add-log4j)
- [Step 8: Update pom.xml](#step-8-update-pomxml)
- [Step 9: Update web.xml (add Struts 2 Servlet Filter)](#step-9-update-webxml-add-struts-2-servlet-filter)
- [Step 10: Add struts.xml](#step-10-add-strutsxml)
- [Step 11: Create Java Action](#step-11-create-java-action)
- [Step 12: Run the app with jetty](#step-12-run-the-app-with-jetty)
- [Step 13: Download tomcat](#step-13-download-tomcat)
- [Step 14: Install tomcat](#step-14-install-tomcat)
- [Step 15: Config tomcat](#step-15-config-tomcat)
- [Step 16: Package the app](#step-16-package-the-app)
- [Step 17: Deploy the app](#step-17-deploy-the-app)
- [Step 18: Start tomcat](#step-18-start-tomcat)
- [Step 19: Run the app with tomcat](#step-19-run-the-app-with-tomcat)

## Step 1: Create the basic app

```dos
01_01_init.bat
```

## Step 2: Add jetty plugin

pom.xml

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

jetty-maven-plugin versions: https://mvnrepository.com/artifact/org.eclipse.jetty/jetty-maven-plugin

`<version>9.4.7.v20170914</version>` works

Don't use `<version>11.0.17</version>`

## Step 3: Update the index.jsp

```jsp
<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" %>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Basic Struts 2 Application - Welcome</title>
  </head>
  <body>
    <h1>Welcome home!</h1>
  </body>
</html>
```

## Step 4: Add a new jsp

Create a new file `hello.jsp` under `src\main\webapp\WEB-INF` folder.

```jsp
<!DOCTYPE html>
<html>
  <head>
    <title>Hello World Struts 2</title>
  </head>
  <body>
    <h1>Hello, Struts 2 World!</h1>
  </body>
</html>
```

## Step 5: Verify the jsp

```dos
01_02_jetty.bat
```

## Step 6: Add Struts

pom.xml

```xml
    <dependency>
      <groupId>org.apache.struts</groupId>
      <artifactId>struts2-core</artifactId>
      <version>6.3.0.1</version>
    </dependency>
```

struts2-core versions: https://mvnrepository.com/artifact/org.apache.struts/struts2-core

## Step 7: Add log4j

pom.xml

```xml
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

log4j-core versions: https://mvnrepository.com/artifact/org.apache.logging.log4j/log4j-core

log4j-api versions: https://mvnrepository.com/artifact/org.apache.logging.log4j/log4j-api

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

## Step 8: Update pom.xml

```xml
    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    <maven.compiler.source>1.7</maven.compiler.source>
    <maven.compiler.target>1.7</maven.compiler.target>
```

-->

```xml
    <maven.compiler.source>1.8</maven.compiler.source>
    <maven.compiler.target>1.8</maven.compiler.target>
    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    <project.reporting.outputEncoding>UTF-8</project.reporting.outputEncoding>
    <java.version>1.8</java.version>
```

## Step 9: Update web.xml (add Struts 2 Servlet Filter)

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

## Step 10: Add struts.xml

Create a new file `struts.xml` in the `src\main\resources` folder.

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
        <action name="hello" class="com.sutek.course.kickstart.struts.HelloStrutsAction">
            <result>/hello.jsp</result>
        </action>
    </package>
</struts>
```

## Step 11: Create Java Action

Create a new folder `src\main\java\com\sutek\course\kickstart\struts`.

Create a new Java file `HelloStrutsAction.java` in the `src\main\java\com\sutek\course\kickstart\struts` folder.

```java
package com.sutek.course.kickstart.struts;

import com.opensymphony.xwork2.ActionSupport;

public class HelloStrutsAction extends ActionSupport {
    public String execute() {
        return SUCCESS;
    }
}
```

## Step 12: Run the app with jetty

```dos
01_02_jetty.bat
```

## Step 13: Download tomcat

Use tomcat v9.x (don't use v10.x)

https://tomcat.apache.org/download-90.cgi

v9.0.82 (zip)

https://dlcdn.apache.org/tomcat/tomcat-9/v9.0.82/bin/apache-tomcat-9.0.82.zip

## Step 14: Install tomcat

Extract the zip

## Step 15: Config tomcat

Update `apache-tomcat-9.0.82\conf\tomcat-users.xml`

```xml
<user username="admin" password="password" roles="manager-gui"/>
```

## Step 16: Package the app

```dos
01_04_package.bat
```

## Step 17: Deploy the app

```dos
01_05_deploy.bat
```

## Step 18: Start tomcat

```dos
01_06_tomcat.bat
```

## Step 19: Run the app with tomcat

http://localhost:8080/01-basic-struts/hello

http://localhost:8080/01-basic-struts/hello.action

http://localhost:8080/01-basic-struts/index

http://localhost:8080/01-basic-struts/index.action


[def]: #section-1-hello-struts