/*
---------------------------------------------------------------------------------------
🖼️ MySQL Image Retriever (Java)
---------------------------------------------------------------------------------------

This Java program connects to a MySQL database, retrieves an image stored as binary
data (`BLOB`) from a table, and saves it as a `.png` file in a specified folder.

---------------------------------------------------------------------------------------
📌 Features

- ✅ JDBC connection to MySQL
- ✅ Prompts user for `image_id`
- ✅ Automatically saves the image without overwriting existing files
- ✅ Stores each new image as `image1.png`, `image2.png`, etc.

---------------------------------------------------------------------------------------
🧾 Requirements

- Java 8 or above
- MySQL Server
- MySQL JDBC Driver (Connector/J): https://dev.mysql.com/downloads/connector/j/
- MySQL table structure:

  CREATE TABLE image_table (
      id INT PRIMARY KEY AUTO_INCREMENT,
      data LONGBLOB
  );

---------------------------------------------------------------------------------------
🛠️ Setup Instructions

1. Install MySQL and create a database named `image`.

2. Create `image_table` as shown above.

3. Insert an image into the table using a separate Java program or tool.

4. Download and add `mysql-connector-java-8.x.x.jar` to your classpath.

5. Update the Java code with your DB password and output folder path.

6. Compile and run:
   javac -cp .;mysql-connector-java-8.x.x.jar h.java
   java -cp .;mysql-connector-java-8.x.x.jar h

---------------------------------------------------------------------------------------
📂 Output

Images are saved as:
- image1.png
- image2.png
- ...

At the location:
A:\Wallpaper\Wallpaper#\

---------------------------------------------------------------------------------------
📋 Sample Output

Driver loaded successfully.
Connection established successfully.
Enter image id: 3
✅ Image saved to: A:\Wallpaper\Wallpaper#\image3.png

---------------------------------------------------------------------------------------
📞 Support

- Ensure MySQL server is running.
- JDBC driver must be in the classpath.
- Folder path must exist and be writable.

---------------------------------------------------------------------------------------
*/
