/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Partidas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

/**
 *
 * @author alunocmc
 */
public class DAO_Partidas {
    // Desenvolver o CRUD relacionado a classe Partidas
    public void Cadastrar(Partidas ptd) throws ClassNotFoundException, SQLException, ParseException {
        Connection conexao = new Conexao().getConnection();
        PreparedStatement ps = conexao.prepareStatement("insert into partidas (idJogo,idEqp) values(?,?)");
        ps.setInt(1,ptd.getIdJogo());
        ps.setInt(2,ptd.getIdEqp());
        ps.execute();
    }
    
    public void buscarId(Partidas ptd) throws SQLException, ClassNotFoundException {
        Connection conexao = new Conexao().getConnection();
        String sql = "SELECT * FROM partidas WHERE idPtd = ?";
        PreparedStatement st = conexao.prepareStatement(sql);
        st.setInt(1, ptd.getIdPtd());
        ResultSet rs = st.executeQuery();
        while (rs.next()) {
            ptd.setIdJogo(rs.getInt(2));
            ptd.setIdEqp(rs.getInt(3));
        }
    }
    
    public void Alterar(Partidas ptd) throws SQLException, ClassNotFoundException {
        String sql = "update partidas set idJogo=?, idEqp=? where idPtd = ?";
        PreparedStatement st = null;
        Connection conexao = null;
        try {
            conexao = new Conexao().getConnection();
            st = conexao.prepareStatement(sql);
            st.setInt(1, ptd.getIdJogo());
            st.setInt(2, ptd.getIdEqp());
            st.setInt(3, ptd.getIdPtd());
            st.executeUpdate();
        } catch(ClassNotFoundException|SQLException ex){
            System.out.println("Erro: "+ex.getMessage());
        }
    }
    
    public void Excluir(Partidas ptd) throws SQLException,ClassNotFoundException{
        String sql = "delete from partidas where idPtd=?";
        PreparedStatement st = null;
        Connection con = null;
        con = new Conexao().getConnection();
        st = con.prepareStatement(sql);
        st.setInt(1,ptd.getIdPtd());
        st.execute();
    } 
}
