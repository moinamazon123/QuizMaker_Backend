package com.quizApp.utility;


import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Retrieve Image from MySQL Database Table using Java
 * @author Ramesh Fadatare
 *
 */
public class ImageReader {

    //public static void main(String[] args) {
public void  getImage(){
        String url = "jdbc:mysql://localhost:3306/quizmaker?useSSL=false";
        String user = "root";
        String password = "moin";

        String query = "SELECT pic_byte FROM quizmaker.image_table LIMIT 1";

        try (Connection con = DriverManager.getConnection(url, user, password);
             PreparedStatement pst = con.prepareStatement(query);
             ResultSet result = pst.executeQuery()) {

            if (result.next()) {

                String fileName = "uploads/image.png";

                try (FileOutputStream fos = new FileOutputStream(fileName)) {

                    Blob blob = result.getBlob("pic_byte");
                    int len = (int) blob.length();

                    byte[] buf = blob.getBytes(1, len);

                    fos.write(buf, 0, len);

                } catch (IOException ex) {

                    Logger lgr = Logger.getLogger(ImageReader.class.getName());
                    lgr.log(Level.SEVERE, ex.getMessage(), ex);
                }
            }
        } catch (SQLException ex) {

            Logger lgr = Logger.getLogger(ImageReader.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
    }
}