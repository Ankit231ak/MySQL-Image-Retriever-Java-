import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.*;
import java.util.Scanner;

public class h {
    public static void main(String[] args) throws ClassNotFoundException {
        String url = "jdbc:mysql://localhost:3306/image";
        String username = "root";
        String password = "******";
        String folder_path = "A:\\Wallpaper\\Wallpaper#\\";
        String query = "SELECT data FROM image_table WHERE id = ?";

        // Load JDBC driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); 
            System.out.println("Driver loaded successfully.");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver not found: " + e.getMessage());
            return;
        }

        try (
            Connection con = DriverManager.getConnection(url, username, password);
            PreparedStatement pstmt = con.prepareStatement(query)
        ) {
            Scanner sc = new Scanner(System.in);

            System.out.println("Connection established successfully.");
            System.out.print("Enter image id: ");
            int n = sc.nextInt();
            pstmt.setInt(1, n); 

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    byte[] image_data = rs.getBytes("data");

                    int count = 1;
                    String outputPath;
                    File file;
                    do {
                        outputPath = folder_path + "image" + count + ".png";
                        file = new File(outputPath);
                        count++;
                    } while (file.exists());

                    try (OutputStream os = new FileOutputStream(file)) {
                        os.write(image_data);
                        System.out.println("✅ Image saved to: " + outputPath);
                        sc.close();
                    }
                } else {
                    System.out.println("❌ No image found with that ID.");
                }
            }

        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("File write error: " + e.getMessage());
        }
    }
}
