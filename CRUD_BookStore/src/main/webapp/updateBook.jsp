<%@ page contentType="text/html;charset=UTF-8" %>
<html>
  <head>
    <title>Update Book Details</title>
  </head>
  <body>
    <h2>Update Book Details</h2>
    <form action="updateBook.action" method="post">
      <label for="bookName">Book Name:</label>
      <input
        type="text"
        id="bookName"
        name="book.bookName"
        value="${book.bookName}"
        required
      /><br />

      <label for="ISBN">ISBN:</label>
      <input
        type="text"
        id="ISBN"
        name="book.isbn"
        value="${book.isbn}"
        required
      /><br />

      <label for="price">Price:</label>
      <input
        type="text"
        id="price"
        name="book.price"
        value="${book.price}"
        required
      /><br />

      <input type="hidden" name="book.bookId" value="${book.bookId}" />

      <input type="submit" value="Update Book" />
    </form>
  </body>
</html>
