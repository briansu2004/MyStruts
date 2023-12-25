<%@ page contentType="text/html;charset=UTF-8" %>
<html>
  <head>
    <title>Add New Book</title>
  </head>
  <body>
    <h2>Add New Book</h2>
    <form action="addBook.action" method="post">
      <label for="bookName">Book Name:</label>
      <input type="text" id="bookName" name="book.bookName" value="test book" required /><br />

      <label for="ISBN">ISBN:</label>
      <input type="text" id="ISBN" name="book.isbn" value="12784" required /><br />

      <label for="price">Price:</label>
      <input type="text" id="price" name="book.price" value="10.00" required /><br />

      <input type="submit" value="Add Book" />
    </form>
  </body>
</html>
