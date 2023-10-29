# Struts 2 app typical folder structure

A typical folder structure for a Struts 2 web application might look like this:

```lua
my-struts-app/
|-- src/
|   |-- main/
|       |-- java/
|       |   |-- com/
|       |       |-- myapp/
|       |           |-- actions/
|       |           |   |-- MyAction.java
|       |           |-- model/
|       |           |   |-- MyModel.java
|       |-- resources/
|       |   |-- myapp/
|       |       |-- validation.xml
|       |       |-- struts.xml
|       |-- webapp/
|           |-- WEB-INF/
|           |   |-- lib/
|           |   |-- web.xml
|           |-- jsp/
|               |-- mypage.jsp
|-- target/
|-- pom.xml
```

Here's an explanation of each directory and its purpose:

- **src/main/java:** This is where you place your Java source code. In a Struts 2 application, you typically have packages like `com.myapp.actions` for your action classes and `com.myapp.model` for your model classes.

- **src/main/resources:** This directory is used for configuration files. In a Struts 2 application, you'll have files like `struts.xml` for your Struts configuration and `validation.xml` for validation rules.

- **src/main/webapp:** This is where your web resources are placed. It contains the WEB-INF directory for web configuration files and other resources such as JSP files. Your JSP files can be located in the `jsp` directory or any other directory structure that you prefer.

- **WEB-INF/lib:** This is where you put your project's dependencies, such as Struts 2 libraries and any other third-party libraries your application might need.

- **WEB-INF/web.xml:** This is the deployment descriptor for your web application.

- **target:** This directory is automatically created by Maven (or your build tool) to store compiled classes and packaged artifacts.

- **pom.xml:** This is the Maven Project Object Model file that describes your project's dependencies, build settings, and other configuration.

Remember that this is just a typical structure, and you can adjust it to suit your specific project needs. The key to organizing your Struts 2 project effectively is to follow good design principles and keep related files and components in their respective directories.
