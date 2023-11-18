# Section 3: Using Tags

- [Step 1: Create the basic Struts app](#step-1-create-the-basic-struts-app)
- [Step 2: url tag with param](#step-2-url-tag-with-param)
- [Step 3: Run the app with jetty](#step-3-run-the-app-with-jetty)
- [Step 4: Struts 2 Form Tag](#step-4-struts-2-form-tag)
- [Step 5: Run the app with jetty](#step-5-run-the-app-with-jetty)
- [Step 6: Struts 2 property tag](#step-6-struts-2-property-tag)
- [Step 7: Run the app with jetty](#step-7-run-the-app-with-jetty)

## Step 1: Create the basic Struts app

- Copy `02-helloworld` to `03-using-tags`
- Replace `02-helloworld` to `03-using-tags` in `pom.xml

## Step 2: url tag with param

Update `index.jsp`

```jsp
<s:url action="hello" var="helloLink">
  <s:param name="userName">Brian Su</s:param>
</s:url>

<p><a href="${helloLink}">Hello Brian Su</a></p>
```

## Step 3: Run the app with jetty

```dos
03_01_jetty.bat
```

http://localhost:8080/03-using-tags/index.action

## Step 4: Struts 2 Form Tag

Update `index.jsp`

```jsp
<p>Get your own personal hello by filling out and submitting this form.</p>

<s:form action="hello">
  <s:textfield name="userName" label="Your name" />
  <s:submit value="Submit" />
</s:form>
```

## Step 5: Run the app with jetty

```dos
c
```

http://localhost:8080/03-using-tags/index

## Step 6: Struts 2 property tag

Update `HelloWorldAction.java`

```java
private static int helloCount = 0;

public int getHelloCount() {
    return helloCount;
}
```

```java
helloCount++;
```

Update `MessageStore.java`

```java
public String toString() {
    return message + " (from toString)";
}
```

Update `HelloWorld.jsp`

```jsp
    <p>I've said hello <s:property value="helloCount" /> times!</p>

    <p><s:property value="messageStore" /></p>
```

## Step 7: Run the app with jetty

```dos
03_01_jetty.bat
```

http://localhost:8080/03-using-tags/index
