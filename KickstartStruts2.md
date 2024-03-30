# Kickstart a Struts app

- [Step 1. Prerequisites](#step-1-prerequisites)
- [Step 2. Create a Java Project](#step-2-create-a-java-project)
- [Step 3. Update pom.xml - add Struts Dependencies](#step-3-update-pomxml---add-struts-dependencies)
- [Step 4. Struts Configuration](#step-4-struts-configuration)
- [Step 5. Create Actions](#step-5-create-actions)
- [Step 6. Create JSP View](#step-6-create-jsp-view)
- [Step 7. Build a war file](#step-7-build-a-war-file)
- [Step 8. Download the tomcat](#step-8-download-the-tomcat)
- [Step 9. Install the tomcat server](#step-9-install-the-tomcat-server)
- [Step 10. Configure the tomcat server](#step-10-configure-the-tomcat-server)
- [Step 11. Start the tomcat server](#step-11-start-the-tomcat-server)
- [Step 12. Verify the tomcat server](#step-12-verify-the-tomcat-server)
- [Step 13. Deployment the war to tomcat](#step-13-deployment-the-war-to-tomcat)
- [Step 14. Run the Struts app](#step-14-run-the-struts-app)

Kickstarting a Struts application involves setting up the Struts framework, creating a basic project structure, configuring it, and developing your application. Struts is a framework for building Java web applications. Here's a step-by-step guide to get you started:

High level:

- Basic app
- Add jetty plugin
- Add a new jsp
- Verify the jsp
- Add Struts
- Add log4j
- Update web.xml
- Add struts.xml
- Create Java Action
- Create JSP View
- Run the app with jetty
- Download tomcat
- Config tomcat
- Start tomcat
- Package the app
- Deploy the app
- Run the app with tomcat

## Step 1. Prerequisites

- Java Development Kit (JDK)
- Apache Maven or another build tool for managing dependencies (optional but recommended)
- A web server like Apache Tomcat or Jetty
- An IDE

## Step 2. Create a Java Project

You can create a project directory for your Struts application. You can use your IDE or a build tool like Maven to create a project structure.

Here's how to do it with Maven:

```bash
mvn archetype:generate -DgroupId=com.example -DartifactId=my-struts-app -DarchetypeArtifactId=maven-archetype-webapp
```

This will create a basic web application structure.

## Step 3. Update pom.xml - add Struts Dependencies

Struts

jetty plugin

log4j

1.7 -> 1.8

Open the `pom.xml` file and add Struts dependencies:

```xml
    <dependency>
      <groupId>org.apache.struts</groupId>
      <artifactId>struts2-core</artifactId>
      <version>6.3.0.1</version>
    </dependency>
```

```xml
  <build>
    <plugins>
      <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-war-plugin</artifactId>
        <version>3.4.0</version>
        <configuration>
          <source>1.8</source>
          <target>1.8</target>
        </configuration>
      </plugin>
      <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-compiler-plugin</artifactId>
        <version>3.8.1</version>
        <configuration>
          <source>1.8</source>
          <target>1.8</target>
        </configuration>
      </plugin>
    </plugins>
    <finalName>my-struts-app</finalName>
  </build>
```

Then, run `mvn clean install` to download the dependencies.

## Step 4. Struts Configuration

Create a Struts configuration file named `struts.xml` in the `src/main/resources` directory. This file defines your actions and their mappings.

Example `struts.xml`:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE struts PUBLIC "-//Apache Software Foundation//DTD Struts Configuration 2.5//EN" "http://struts.apache.org/dtds/struts-2.5.dtd">
<struts>
    <package name="default" extends="struts-default">
        <action name="hello" class="com.example.HelloAction">
            <result>/hello.jsp</result>
        </action>
    </package>
</struts>
```

## Step 5. Create Actions

Create a new foldser `src/main/java/com/example` folder and create a new Java class `HelloAction.java` there. that will serve as your action. In this example, the action is named `HelloAction`:

```java
package com.example;

import com.opensymphony.xwork2.ActionSupport;

public class HelloAction extends ActionSupport {
    public String execute() throws Exception {
        return SUCCESS;
    }
}
```

## Step 6. Create JSP View

<!--
Update the `index.jsp` JSP pagein the `src/main/webapp` directory to display the result.
-->

Create a JSP page (e.g., `hello.jsp`) in the `src/main/webapp` directory to display the result.

Example `hello.jsp`:

```jsp
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Hello World</title>
</head>
<body>
    <h1>Hello, Struts!</h1>
</body>
</html>
```

## Step 7. Build a war file

```bash
mvn clean package
```

A war file `my-struts-app.war` will be created in the `target` folder.

## Step 8. Download the tomcat

<https://tomcat.apache.org/>

<https://tomcat.apache.org/download-10.cgi>

64-bit Windows zip

<https://dlcdn.apache.org/tomcat/tomcat-10/v10.1.15/bin/apache-tomcat-10.1.15-windows-x64.zip>

## Step 9. Install the tomcat server

<!-- Don't download tomcat v10.x for Struts 2 apps-->

`C:\Apps\apache-tomcat-9.0.82`

## Step 10. Configure the tomcat server

```text
401 Unauthorized

You are not authorized to view this page. If you have not changed any configuration files, please examine the file conf/tomcat-users.xml in your installation. That file must contain the credentials to let you use this webapp.

For example, to add the manager-gui role to a user named tomcat with a password of s3cret, add the following to the config file listed above.

<role rolename="manager-gui"/>
<user username="tomcat" password="s3cret" roles="manager-gui"/>

Note that for Tomcat 7 onwards, the roles required to use the manager application were changed from the single manager role to the following four roles. You will need to assign the role(s) required for the functionality you wish to access.

manager-gui - allows access to the HTML GUI and the status pages
manager-script - allows access to the text interface and the status pages
manager-jmx - allows access to the JMX proxy and the status pages
manager-status - allows access to the status pages only

The HTML interface is protected against CSRF but the text and JMX interfaces are not. To maintain the CSRF protection:

Users with the manager-gui role should not be granted either the manager-script or manager-jmx roles.
If the text or jmx interfaces are accessed through a browser (e.g. for testing since these interfaces are intended for tools not humans) then the browser must be closed afterwards to terminate the session.

For more information - please see the Manager App How-To.
http://localhost:8080/docs/manager-howto.html
```

C:\Apps\apache-tomcat-10.1.15\conf\tomcat-users.xml

```xml

```

## Step 11. Start the tomcat server

```dos
cd C:\Apps\apache-tomcat-10.1.15\bin
call startup.bat
```

```dos
C:\CodeUdemy\udemy-kickstart-struts>cd C:\Apps\apache-tomcat-10.1.15\bin

C:\Apps\apache-tomcat-10.1.15\bin>call startup.bat
Using CATALINA_BASE:   "C:\Apps\apache-tomcat-10.1.15"
Using CATALINA_HOME:   "C:\Apps\apache-tomcat-10.1.15"
Using CATALINA_TMPDIR: "C:\Apps\apache-tomcat-10.1.15\temp"
Using JRE_HOME:        "C:\Program Files\Microsoft\jdk-17.0.3.7-hotspot"
Using CLASSPATH:       "C:\Apps\apache-tomcat-10.1.15\bin\bootstrap.jar;C:\Apps\apache-tomcat-10.1.15\bin\tomcat-juli.jar"
Using CATALINA_OPTS:   ""
C:\Apps\apache-tomcat-10.1.15\bin>
```

## Step 12. Verify the tomcat server

Access the Tomcat server at `http://localhost:8080/`

## Step 13. Deployment the war to tomcat

<!-- Deploy your application by copying the WAR file generated by your build tool (e.g., Maven) to your web server's deployment directory. If you're using Tomcat, this directory is typically located at `webapps`. -->

```dos
copy C:\CodeUdemy\udemy-kickstart-struts\my-struts-app\target\my-struts-app.war C:\Apps\apache-tomcat-10.1.15\webapps\
```

```text
28-Oct-2023 22:57:01.083 INFO [main] org.apache.catalina.startup.Catalina.load Server initialization in [853] milliseconds
28-Oct-2023 22:57:01.160 INFO [main] org.apache.catalina.core.StandardService.startInternal Starting service [Catalina]
28-Oct-2023 22:57:01.161 INFO [main] org.apache.catalina.core.StandardEngine.startInternal Starting Servlet engine: [Apache Tomcat/10.1.15]
28-Oct-2023 22:57:01.181 INFO [main] org.apache.catalina.startup.HostConfig.deployDirectory Deploying web application directory [C:\Apps\apache-tomcat-10.1.15\webapps\docs]
28-Oct-2023 22:57:01.759 WARNING [main] org.apache.catalina.util.SessionIdGeneratorBase.createSecureRandom Creation of SecureRandom instance for session ID generation using [SHA1PRNG] took [170] milliseconds.
28-Oct-2023 22:57:01.834 INFO [main] org.apache.catalina.startup.HostConfig.deployDirectory Deployment of web application directory [C:\Apps\apache-tomcat-10.1.15\webapps\docs] has finished in [652] ms
28-Oct-2023 22:57:01.835 INFO [main] org.apache.catalina.startup.HostConfig.deployDirectory Deploying web application directory [C:\Apps\apache-tomcat-10.1.15\webapps\examples]
28-Oct-2023 22:57:03.017 INFO [main] org.apache.catalina.startup.HostConfig.deployDirectory Deployment of web application directory [C:\Apps\apache-tomcat-10.1.15\webapps\examples] has finished in [1,182] ms
28-Oct-2023 22:57:03.018 INFO [main] org.apache.catalina.startup.HostConfig.deployDirectory Deploying web application directory [C:\Apps\apache-tomcat-10.1.15\webapps\host-manager]
28-Oct-2023 22:57:03.137 INFO [main] org.apache.catalina.startup.HostConfig.deployDirectory Deployment of web application directory [C:\Apps\apache-tomcat-10.1.15\webapps\host-manager] has finished in [119] ms
28-Oct-2023 22:57:03.138 INFO [main] org.apache.catalina.startup.HostConfig.deployDirectory Deploying web application directory [C:\Apps\apache-tomcat-10.1.15\webapps\manager]
28-Oct-2023 22:57:03.249 INFO [main] org.apache.catalina.startup.HostConfig.deployDirectory Deployment of web application directory [C:\Apps\apache-tomcat-10.1.15\webapps\manager] has finished in [112] ms
28-Oct-2023 22:57:03.250 INFO [main] org.apache.catalina.startup.HostConfig.deployDirectory Deploying web application directory [C:\Apps\apache-tomcat-10.1.15\webapps\ROOT]
28-Oct-2023 22:57:03.347 INFO [main] org.apache.catalina.startup.HostConfig.deployDirectory Deployment of web application directory [C:\Apps\apache-tomcat-10.1.15\webapps\ROOT] has finished in [97] ms
28-Oct-2023 22:57:03.356 INFO [main] org.apache.coyote.AbstractProtocol.start Starting ProtocolHandler ["http-nio-8080"]
28-Oct-2023 22:57:03.578 INFO [main] org.apache.catalina.startup.Catalina.start Server startup in [2495] milliseconds
28-Oct-2023 23:01:13.915 INFO [Catalina-utility-1] org.apache.catalina.startup.HostConfig.deployWAR Deploying web application archive [C:\Apps\apache-tomcat-10.1.15\webapps\my-struts-app.war]
28-Oct-2023 23:01:16.401 INFO [Catalina-utility-1] org.apache.jasper.servlet.TldScanner.scanJars At least one JAR was scanned for TLDs yet contained no TLDs. Enable debug logging for this logger for a complete list of JARs that were scanned but no TLDs were found in them. Skipping unneeded JARs during scanning can improve startup time and JSP compilation time.
28-Oct-2023 23:01:16.413 INFO [Catalina-utility-1] org.apache.catalina.startup.HostConfig.deployWAR Deployment of web application archive [C:\Apps\apache-tomcat-10.1.15\webapps\my-struts-app.war] has finished in [2,497] ms
```

## Step 14. Run the Struts app

Access the Struts application at `http://localhost:8080/my-struts-app/hello`.

You've now kickstarted a basic Struts application. You can extend it by adding more actions, views, and business logic as needed. Be sure to consult the Struts documentation for more advanced configurations and features.
