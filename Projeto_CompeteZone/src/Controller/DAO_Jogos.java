/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Jogos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

/**
 *
 * @author alunocmc
 */
public class DAO_Jogos {
    // Desenvolver o CRUD relacionado a classe Jogos
    public void Cadastrar(Jogos jgs) throws ClassNotFoundException, SQLException, ParseException {
        Connection conexao = new Conexao().getConnection();
        PreparedStatement ps = conexao.prepareStatement("insert into jogos (nome,categoria,numPlayers) values(?,?,?)");
        ps.setString(1,jgs.getNome());
        ps.setString(2,jgs.getCategoria());
        ps.setFloat(3,jgs.getNumPlayers());
        ps.execute();
    }
    
    public void buscarId(Jogos jgs) throws SQLException, ClassNotFoundException {
        Connection conexao = new Conexao().getConnection();
        String sql = "SELECT * FROM jogos WHERE idJogo = ?";
        PreparedStatement st = conexao.prepareStatement(sql);
        st.setInt(1, jgs.getIdJogo());
        ResultSet rs = st.executeQuery();
        while (rs.next()) {
            jgs.setNome(rs.getString(2));
            jgs.setCategoria(rs.getString(3));
            jgs.setNumPlayers(rs.getFloat(4));
        }
    }
    
    public void Alterar(Jogos jgs) throws SQLException, ClassNotFoundException {
        String sql = "update jogos set nome=?, categoria=?, cumPlayers=? where idJogo = ?";
        PreparedStatement st = null;
        Connection conexao = null;
        try {
            conexao = new Conexao().getConnection();
            st = conexao.prepareStatement(sql);
            st.setInt(1, jgs.getIdJogo());
            st.setString(2, jgs.getNome());
            st.setString(3, jgs.getCategoria());
            st.setFloat(4, jgs.getNumPlayers());
            st.executeUpdate();
        } catch(ClassNotFoundException|SQLException ex){
            System.out.println("Erro: "+ex.getMessage());
        }
    }
    
    public void Excluir(Jogos jgs) throws SQLException,ClassNotFoundException{
        String sql = "delete from jogos where id=?";
        PreparedStatement st = null;
        Connection con = null;
        con = new Conexao().getConnection();
        st = con.prepareStatement(sql);
        st.setInt(1,jgs.getIdJogo());
        st.execute();
    }
}
