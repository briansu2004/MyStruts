<%@ page contentType="text/html;charset=UTF-8" %> <%@ taglib prefix="s"
uri="/struts-tags" %>

<!DOCTYPE html>
<html>
  <head>
    <title>Book List</title>
  </head>
  <body>
    <h2>Book List</h2>

    <table border="1">
      <tr>
        <th>Book ID</th>
        <th>Book Name</th>
        <th>ISBN</th>
        <th>Price</th>
        <th>Details</th>
      </tr>
      <s:iterator value="bookList" var="book">
        <tr>
          <td><s:property value="bookId" /></td>
          <td><s:property value="bookName" /></td>
          <td><s:property value="isbn" /></td>
          <td><s:property value="price" /></td>
          <td>
            <s:url var="viewBookUrl" action="viewBook">
              <s:param name="bookId" value="%{bookId}" />
            </s:url>
            <s:a href="%{viewBookUrl}">View Details</s:a>
          </td>
        </tr>
      </s:iterator>
    </table>

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
