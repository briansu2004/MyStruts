<%@ page contentType="text/html;charset=UTF-8" %> <%@ taglib prefix="s"
uri="/struts-tags" %>

<!DOCTYPE html>
<html>
  <head>
    <title>Bookstore Home</title>
  </head>
  <body>
    <h1>Welcome to the Bookstore</h1>

    <p>
      <!-- Link to view the list of books -->
      <s:a action="viewBookList">View Book List</s:a>
    </p>

    <p>
      <!-- Add Book link -->
      <!-- <s:a action="addBook">
        <s:param name="bookId" value="0" />
        Add a new Book
      </s:a> -->
      <a href="addBook.jsp">Add a new Book</a>
    </p>
  </body>
</html>
