# \*.action

## In my struts2 app, why http://localhost:8080/basic-struts/index and http://localhost:8080/basic-struts/index.action have the same behaviors.

In a Struts 2 application, both `http://localhost:8080/basic-struts/index` and `http://localhost:8080/basic-struts/index.action` exhibit the same behavior because Struts 2 uses a default action extension strategy that allows for cleaner URLs without the need to include the ".action" extension.

This behavior is part of Struts 2's configuration and can be customized if needed. Here's how it works:

1. **Default Action Extension**: Struts 2, by default, uses the `.action` extension for actions. This means that when you access a URL like `http://localhost:8080/basic-struts/index`, Struts 2 automatically interprets it as if you had entered `http://localhost:8080/basic-struts/index.action`. The framework assumes that if you omit the extension, it should still map the request to the appropriate action.

2. **Clean URLs**: This feature is often referred to as clean URLs because it allows you to create URLs that look more user-friendly and don't expose the specific technology being used (e.g., ".action"). Clean URLs are often considered more aesthetically pleasing and easier to remember.

3. **Configuration**: To enable this behavior, Struts 2 typically includes a "wildcard" mapping in the `struts.xml` configuration file that captures requests with and without the `.action` extension. For example:

```xml
<action name="index" class="com.example.IndexAction">
    <result>/index.jsp</result>
</action>
```

With this configuration, both `http://localhost:8080/basic-struts/index` and `http://localhost:8080/basic-struts/index.action` will invoke the `IndexAction` when requested.

If you prefer to disable this behavior and force the inclusion of the `.action` extension in your URLs, you can customize your Struts 2 configuration by adjusting the URL mapping settings in your `struts.xml`. However, most developers find the default behavior of clean URLs to be more user-friendly.

<!-- ## How to change the default action extension from .action to .do ?
 -->
