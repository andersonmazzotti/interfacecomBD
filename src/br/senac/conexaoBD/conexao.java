/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.conexaoBD;
import java.sql.*;


/**
 *
 * @author anderson.mazzotti
 */
public class conexao {
    
    public static Connection Conector(){
        Connection Conexao = null;
        String driver="com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/senac";
        String user = "root";
        String password = "123qwe@";
        
       
        try {
        
            Class.forName(driver);
            Conexao = DriverManager.getConnection(url, user, password);
            return Conexao;
            
            
        } catch (Exception e) {
            System.out.println(e);
            return null;
            
        }
        
    }
}
