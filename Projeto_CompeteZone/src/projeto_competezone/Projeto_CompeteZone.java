package projeto_competezone;

import Controller.DAO_Equipes;
import Controller.DAO_Usuario;
import Model.Equipes;
import Model.Usuario;
import View.Tela;
import java.sql.SQLException;
import java.text.ParseException;

public class Projeto_CompeteZone {

    public static void main(String[] args) throws SQLException, ClassNotFoundException, ParseException {
        Tela telaPrincipal = new Tela();
        
        telaPrincipal.setVisible(true);
        
        /*Equipes e = new Equipes();
        DAO_Equipes de= new DAO_Equipes();
        
        e.setIdJogador(7);
        e.setNome("TalonGaming");
        e.setNumJogadores(5);
        e.setJgsInscritos(1);
        
        de.Cadastrar(e);
        */
        
        //Usuario u = new Usuario();
        //DAO_Usuario du = new DAO_Usuario();
        
        //u.setId(7);
        //u.setNome("Jose");
        //u.setUsername("agsdfjdsa");
        //u.setAno_nasc("2004-09-15");
        //u.setEmail("FOdasse");
        
        //du.Alterar(u);
    }
    
}
