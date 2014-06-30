/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 *
 * @author Ildevana
 */
public class InicializadorBancoDados {
    private static final String dbName = "GerenciadorCadastroProvas";
    
    public static void inicializar() throws Exception {
        Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
    }
    
    public static void criarBd() throws Exception{
        Connection con = DriverManager.getConnection("jdbc:derby:"+dbName+";create=true");
        Statement sta = con.createStatement();
        String sqlProva = "CREATE TABLE PROVA("
                        + " ID_PROVA INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY,"
                        + " TIPO varchar(50) NOT NULL,"
                        + " NOME_PROF varchar (100) NOT NULL),"
                        + "QTD_QUESTOES INT NOT NULL";
        sta.execute(sqlProva);
        
        String sqlItemAval = "CREATE TABLE ITEMAVAL ("
                          + "ID_ITEM INTEGER PRIMARY KEY NOT NULL,"
                          + "ENUN varchar(100) NOT NULL),"
                          + "ID_ALTERNATIVAS INT NOT NULL,";
        sta.executeUpdate(sqlItemAval);
        
        String sqlAlternativas = "CREATE TABLE ALTERNATIVAS ("
                          + "ID_ALTERNATIVAS INTEGER PRIMARY KEY NOT NULL,"
                          + "ID_ITEM FK int NOT NULL,"
                          + "RESPCORRETA CHAR(5) NOT NULL";
        sta.executeUpdate(sqlAlternativas);
        
        String sqlCategoria = "CREATE TABLE CATEGORIA ("
                          + "ID_CAT INTEGER PRIMARY KEY NOT NULL,"
                          + "NOME_CAT varchar(100) NOT NULL),";
        sta.executeUpdate(sqlCategoria);
        
        String sqlResposta = "CREATE TABLE RESPOSTA ("
                          + "ID_RESP INTEGER PRIMARY KEY NOT NULL,"
                          + "ID_PROVA FK INTEGER NOT NULL),"
                          + "ID_ITEM FK INT NOT NULL,"
                          + "RESPOSTA_MARC CHAR(5) NOT NULL,"
                          + "COMENTARIO VARCHAR(100) NOT NULL";
        sta.executeUpdate(sqlResposta);
        
        
        String sqlProvaItemAval = "CREATE TABLE PROVAITEMAVAL("
                             + "ID_PROVA int NOT NULL,"
                             + "ID_ITEM int NOT NULL,"
                             + "ENUM varchar(100) NOT NULL,"
                             + "CONSTRAINT PK_PROVAITEMAVAL PRIMARY KEY (ID_PROVA,ID_ITEM),"
                             + "CONSTRAINT FK_PROVA FOREIGN KEY (ID_PROVA) REFERENCES PROVA(CODIGO),"
                             + "CONSTRAINT FK_ITEMAVAL FOREIGN KEY (ID_ITEM) REFERENCES ITEMAVAL(CODIGO))";
        sta.executeUpdate(sqlProvaItemAval);
        
        String sqlItemAvalCategoria = "CREATE TABLE ITEMAVALCATEGORIA("
                             + "ID_ITEM int NOT NULL,"
                             + "ID_CAT int NOT NULL,"
                             + "CONSTRAINT PK_ITEMAVALCATEGORIA PRIMARY KEY (ID_ITEM,ID_CAT),"
                             + "CONSTRAINT FK_ITEMAVAL FOREIGN KEY (ID_ITEM) REFERENCES ITEMAVAL(CODIGO),"
                             + "CONSTRAINT FK_CATEGORIA FOREIGN KEY (ID_CAT) REFERENCES CATEGORIA(CODIGO))";
        sta.executeUpdate(sqlItemAvalCategoria);
               
        sta.close();
        con.close();
    }
    
    public static Connection conectarBd() throws Exception{
        return DriverManager.getConnection("jdbc:derby:"+dbName);
    }
}
   

