/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Equipes;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;
import java.text.ParseException;
/**
 *
 * @author alunocmc
 */
public class DAO_Equipes {
    // Desenvolver o CRUD relacionado a classe Equipes
    
    public void Cadastrar(Equipes eqp) throws ClassNotFoundException, SQLException, ParseException {
        Connection conexao = new Conexao().getConnection();
        PreparedStatement ps = conexao.prepareStatement("insert into equipes (idJogador,nome,num_jogadores, jgsinscritos) values(?,?,?,?)");
        ps.setInt(1,eqp.getIdJogador());
        ps.setString(2,eqp.getNome());
        ps.setInt(3, eqp.getNumJogadores());
        ps.setInt(4,eqp.getJgsInscritos());
        ps.execute();
    }
    
    public void pesquisar(Equipes eqp) throws SQLException, ClassNotFoundException {
        Connection conexao = new Conexao().getConnection();
        String sql = "SELECT * FROM equipes WHERE id = ?";
        PreparedStatement st = conexao.prepareStatement(sql);
        st.setInt(1, eqp.getIdEqp());
        ResultSet rs = st.executeQuery();
        while (rs.next()) {
            eqp.setIdJogador(rs.getInt(2));
            eqp.setNome(rs.getString(3));
            eqp.setNumJogadores(rs.getInt(4));
            eqp.setJgsInscritos(rs.getInt(5));
        }
    }
    
    public void Alterar(Equipes eqp) throws SQLException, ClassNotFoundException {
        String sql = "update equipes set idJogador=?, nome=?, num_jogadores=?, jgsinscritos=? where id = ?";
        Connection conexao = null;
        PreparedStatement st = null;      
        try {  
            conexao = new Conexao().getConnection();
            st = conexao.prepareStatement(sql);  
            st.setInt(1, eqp.getIdJogador());
            st.setString(2, eqp.getNome());
            st.setInt(3, eqp.getNumJogadores());
            st.setInt(4,eqp.getJgsInscritos());
            st.setInt(5, eqp.getIdEqp());
            st.executeUpdate();
        } catch(SQLException ex){
            System.out.println("Erro: "+ex.getMessage());
        }
    }
    
    public void Excluir(Equipes eqp) throws SQLException,ClassNotFoundException{
        String sql = "delete from equipes where id=?";
        PreparedStatement st = null;
        Connection con = null;
        con = new Conexao().getConnection();
        st = con.prepareStatement(sql);
        st.setInt(1,eqp.getIdEqp());
        st.execute();
    }
}
