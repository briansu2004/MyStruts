# Section 5: Processing Forms

- [Step 1: Create the basic Struts app](#step-1-create-the-basic-struts-app)
- [Step 2: Update pom.xml](#step-2-update-pomxml)
- [Step 3: Add a new Model](#step-3-add-a-new-model)
- [Step 4: Add a new View jsp for register](#step-4-add-a-new-view-jsp-for-register)
- [Step 5: Add a new Action Controller](#step-5-add-a-new-action-controller)
- [Step 6: Add 3 new View jsp pages for 3 kinds of results](#step-6-add-3-new-view-jsp-pages-for-3-kinds-of-results)
- [Step 7: Create action mapping](#step-7-create-action-mapping)
- [Step 8: Create a link to register.jsp](#step-8-create-a-link-to-registerjsp)
- [Step 9: Run the app with jetty](#step-9-run-the-app-with-jetty)

## Step 1: Create the basic Struts app

- Copy `04-coding-actions` to `05-processing-forms`
- Replace `04-coding-actions` to `05-processing-forms` in `pom.xml`

## Step 2: Update pom.xml

```xml
  <properties>
    <struts2.version>2.5.26</struts2.version> <!-- don't use 6.x -->

  <dependencies>
    <dependency>
      <groupId>org.apache.struts</groupId>
      <artifactId>struts2-core</artifactId>
      <version>${struts2.version}</version>
    </dependency>
```

## Step 3: Add a new Model

`Person.java`

```java
package com.example.helloworld.model;

public class Person {
    private String firstName;
    private String lastName;
    private String email;
    private String age; // using int will cause some issues on the validation
}
```

Create getters, setters, toString() etc.

## Step 4: Add a new View jsp for register

`register.jsp`

```jsp
<%@ taglib prefix="s" uri="/struts-tags" %> 
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Register</title>
  </head>
  <body>
    <h1>Register for a prize by completing this form.</h1>

    <s:form action="register" style="font-weight: bold; font-size: 30px; margin: 20px;">
      <s:textfield name="personBean.firstName" label="First name" style="margin: 10px;" />
      <s:textfield name="personBean.lastName" label="Last name" style="margin: 10px;" />
      <s:textfield name="personBean.email" label="Email" style="margin: 10px;" />
      <s:textfield name="personBean.age" label="Age" style="margin: 10px;" />
      <s:submit style="font-size: 30px; margin: 10px;" />
    </s:form>
  </body>
</html>
```

## Step 5: Add a new Action Controller

`Register.java`

```java

package com.example.helloworld.action;

import com.opensymphony.xwork2.ActionSupport;
import com.example.helloworld.model.Person;

public class Register extends ActionSupport {
    private static final long serialVersionUID = 1L;

    private Person personBean;

    public String execute() throws Exception {
        try {
            // Perform validation
            if (!isValidAge()) {
                addActionError("Age must be a valid number.");
                return "invalid";
            }

            // Happy path
            return SUCCESS;
        } catch (Exception ex) {
            // Unhappy path
            addActionError("An error occurred: " + ex.getMessage());

            // Return "error" result
            return ERROR;
        }
    }

    private boolean isValidAge() {
        try {
            // Parse the age from the String representation
            Integer.parseInt(personBean.getAge());
            // Additional validation logic if needed
            return true;
        } catch (NumberFormatException e) {
            // If parsing fails, it's not a valid number
            return false;
        }
    }

    public Person getPersonBean() {
        return personBean;
    }

    public void setPersonBean(Person person) {
        personBean = person;
    }
}
```

## Step 6: Add 3 new View jsp pages for 3 kinds of results

`done.jsp`

```jsp
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Registration Successful</title>
  </head>
  <body>
    <h3>Thank you for registering for a prize.</h3>

    <p>Your registration information: <s:property value="personBean" /> </p>

    <p><a href="<s:url action='index' />" >Return to home page</a>.</p>
  </body>
</html>
```

`invalid.jsp`

```jsp
<%@ taglib prefix="s" uri="/struts-tags" %> 
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Invalid input</title>
  </head>
  <body>
    <p style="font-weight: bold; font-size: 30px; color: red; margin: 20px">
      Invalid - please check your input.
    </p>

    <p><a href="<s:url action='index' />">Return to home page</a>.</p>
  </body>
</html>
```

`error.jsp`

```jsp
<%@ taglib prefix="s" uri="/struts-tags" %> 
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Error</title>
  </head>
  <body>
    <p style="font-weight: bold; font-size: 30px; color: red; margin: 20px">
      Error
    </p>

    <p><a href="<s:url action='index' />">Return to home page</a>.</p>
  </body>
</html>
```

## Step 7: Create action mapping

`struts.xml`

```xml
        <action name="register" class="com.example.helloworld.action.Register" method="execute">
            <result name="success">/done.jsp</result>
            <result name="invalid">/invalid.jsp</result>
            <result name="error">/error.jsp</result>
        </action>
```

## Step 8: Create a link to register.jsp

`index.jsp`

```jsp
    <p style="font-weight: bold; font-size: 40px; margin: 60px">
      <a href="register.jsp">Please register</a> for our prize drawing.
    </p>
```

## Step 9: Run the app with jetty

```dos
05_jetty.bat
```

<http://localhost:8080/04-coding-actions/index.action>

<http://localhost:8080/04-coding-actions/register.jsp>
