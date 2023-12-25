<%@ page contentType="text/html;charset=UTF-8" %> <%@ taglib prefix="s"
uri="/struts-tags" %>
<html>
  <head>
    <title>View Book Details</title>
  </head>
  <body>
    <h2>Book Details</h2>

    <p>Book ID: <s:property value="book.bookId" /></p>
    <p>Book Name: <s:property value="book.bookName" /></p>
    <p>ISBN: <s:property value="book.isbn" /></p>
    <p>Price: <s:property value="book.price" /></p>

    <!-- Update Book link -->
    <s:a action="updateBook">
      <s:param name="bookId" value="%{book.bookId}" />
      Update this Book
    </s:a>
  </body>
</html>
