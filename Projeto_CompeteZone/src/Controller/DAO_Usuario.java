/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Usuario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
/**
 *
 * @author alunocmc
 */
public class DAO_Usuario {
    // Desenvolver o CRUD relacionado a classe Usuario
    public void Cadastrar(Usuario user) throws ClassNotFoundException, SQLException, ParseException {
        Connection conexao = new Conexao().getConnection();
        PreparedStatement ps = conexao.prepareStatement("insert into jogadores (nome,username,ano_nasc, email) values(?,?,?,?)");
        ps.setString(1,user.getNome());
        ps.setString(2,user.getUsername());
        ps.setString(3, user.getAno_nasc());
        ps.setString(4,user.getEmail());
        ps.execute();
    }
    
    public void pesquisar(Usuario user) throws SQLException, ClassNotFoundException {
        Connection conexao = new Conexao().getConnection();
        String sql = "SELECT * FROM jogadores WHERE id = ?";
        PreparedStatement st = conexao.prepareStatement(sql);
        st.setInt(1, user.getId());
        ResultSet rs = st.executeQuery();
        while (rs.next()) {
            user.setNome(rs.getString(2));
            user.setUsername(rs.getString(3));
            user.setAno_nasc(rs.getString(4));
            user.setEmail(rs.getString(5));
        }
    }
    
    public void Alterar(Usuario user) throws SQLException, ClassNotFoundException {
        String sql = "update jogadores set nome=?, username=?, ano_nasc=?, email=? where id = ?";
        Connection conexao = null;
        PreparedStatement st = null;      
        try {  
            conexao = new Conexao().getConnection();
            st = conexao.prepareStatement(sql);  
            st.setString(1, user.getNome());
            st.setString(2, user.getUsername());
            st.setString(3, user.getAno_nasc());
            st.setString(4, user.getEmail());
            st.setInt(5, user.getId());
            st.executeUpdate();
        } catch(SQLException ex){
            System.out.println("Erro: "+ex.getMessage());
        }
    }
    
    public void Excluir(Usuario user) throws SQLException,ClassNotFoundException{
        String sql = "delete from jogadores where id=?";
        PreparedStatement st = null;
        Connection con = null;
        con = new Conexao().getConnection();
        st = con.prepareStatement(sql);
        st.setInt(1,user.getId());
        st.execute();
    }
}
