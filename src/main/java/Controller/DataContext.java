/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.sql.*;

import config.Conexao;

/**
 *
 * @author alifa
 */
public class DataContext {

 private Connection conexao = null;
 private PreparedStatement statement = null;
 private ResultSet resultSet = null;

 public DataContext() {
  conexao = Conexao.getConnection();
 }

 public boolean Login(String codigo, String senha) {

  boolean check = false;

  try {

   if (conexao != null) {

    statement = conexao.prepareStatement("SELECT * FROM usuario WHERE codigo = ? and senha = ?");
    statement.setString(1, codigo);
    statement.setString(2, senha);

    resultSet = statement.executeQuery();

    if (resultSet.next()) check = true;

   }
  } catch (Exception e) {

  }
  finally
  {
   // Conexao.closeConnection(conexao);
   // conexao = null;
   statement = null;
  }
  return check;
 }

}
