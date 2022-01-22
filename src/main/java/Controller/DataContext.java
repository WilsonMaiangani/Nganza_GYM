/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;

import com.mysql.cj.Query;

import config.Conexao;
import model.Pessoa;

/**
 *
 * @author alifa
 */
public class DataContext {

  private Connection conexao = null;
  private PreparedStatement statement = null;
  private ResultSet resultSet = null;
  private String key = "", value = "";

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

        if (resultSet.next())
          check = true;

      }
    } catch (Exception e) {

    } finally {
      // Conexao.closeConnection(conexao);
      // conexao = null;
      statement = null;
    }
    return check;
  }

  public boolean Add(String tabela, Map<String, String> obj) {

    boolean check = false;

    try {

      if (conexao != null) {

        for (Map.Entry<String, String> item : obj.entrySet()) {
          key += item.getKey() + ',';
          value += item.getValue() + ',';
        }

        key = key.substring(0, key.length() - 1);
        value = value.substring(0, value.length() - 1);
        String query = "Insert into " + tabela + "(" + key + ") values (" + value + ");";
        statement = conexao.prepareStatement(query);
        // statement = conexao.prepareStatement("Insert into pessoa (nome, genero,
        // datanascimento, chave) values(1,masculino,2090-05-10,45685)");

        statement.executeUpdate();
        // statement = conexao.prepareStatement("SELECT * FROM usuario WHERE codigo = ?
        // and senha = ?");
        // statement.setString(1, codigo);
        // statement.setString(2, senha);

        // resultSet = statement.executeQuery();

        // if (resultSet.next()) check = true;

      }
    } catch (Exception e) {

    } finally {
      // Conexao.closeConnection(conexao);
      // conexao = null;
      statement = null;
    }
    return check;
  }

  // public boolean SalvarCliente(int id) {
  // boolean result = false;
  // if (conexao != null) {
  // statement = conexao.prepareStatement("insert into Pessoa (nome, genero,
  // chave) values(?,?,?)");
  // // statement.setInt(1, id);
  // }
  // return result;
  // }

  public boolean SalvarCliente(int id_) {
    boolean result = false;
    try {

      if (conexao != null) {
        statement = conexao.prepareStatement("insert into Cliente (IdPessoa) values(?)");
        statement.setInt(1, id_);

        if (statement.executeUpdate() > 0) {
          result = true;
          JOptionPane.showMessageDialog(null, "Dados Salvo com sucesso!");
        }
      }

    } catch (Exception e) {

    } finally {
      statement = null;
    }
    return result;
  }

  public int SalvarPessoa(Pessoa pessoa) {
    int id = 0;
    try {

      if (conexao != null) {
        statement = conexao.prepareStatement("insert into Pessoa (nome, genero, chave) values(?,?,?)");
        statement.setString(1, pessoa.getNome());
        statement.setString(2, pessoa.getGenero());
        statement.setString(3, pessoa.getChave());

        if (statement.executeUpdate() > 0) {
          statement = conexao.prepareStatement("select count(*) id  from pessoa;");
          resultSet = statement.executeQuery();

          if (resultSet.next()) {
            id = resultSet.getInt("id");
            SalvarCliente(id);
          }
        }
      }

    } catch (Exception e) {

    } finally {
      statement = null;
    }
    return id;
  }

  public List<Pessoa> GetListCliente() {
    List<Pessoa> dataPessoa = new ArrayList<>();
    try {

      if (conexao != null) {
        statement = conexao.prepareStatement(
            "select pessoa.Nome, pessoa.Genero, pessoa.Chave as BI from pessoa inner join cliente on pessoa.Id = cliente.IdPessoa;");
        resultSet = statement.executeQuery();
        
        
        while (resultSet.next()) {
          Pessoa pessoa = new Pessoa();
          pessoa.setNome(resultSet.getString("Nome"));
          pessoa.setChave(resultSet.getString("BI"));
          pessoa.setGenero(resultSet.getString("Genero"));    
          
          dataPessoa.add(pessoa);
        }

      }

    } catch (Exception e) {

    } finally {
      statement = null;
    }
    return dataPessoa;
  }

}
