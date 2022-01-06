/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package config;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alifa
 */
public class Conexao {

 private static Connection conexao = null;
 private static final String driver = "com.mysql.jdbc.Driver";
 private static final String url = "jdbc:mysql://localhost:3306/nganzagym";
 private static final String user = "root";
 private static final String password = "";

 public static Connection getConnection() {

  try {

   Class.forName(driver);

   return conexao = DriverManager.getConnection(url, user, password);

  } catch (Exception e) {
   return null;
  }

 }

 public static void closeConnection(Connection con) {
  try {
   if (con != null) {
    con.close();
   }
  } catch (SQLException ex) {
   Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null,
     ex);
  }
 }

}
