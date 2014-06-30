/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dados;

import Negocio.DAOException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

/**
 *
 * @author Ildevana
 */
public class GerenciadorBancoDados {

    private static final String dbName = "GerenciadorCadastroProvas";

    public static void inicializar() throws Exception {
        Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
    }

    public static void criarBd() throws Exception {
        Connection con = DriverManager.getConnection("jdbc:derby:" + dbName + ";create=true");
        Statement sta = con.createStatement();
        String sql;
        //FileReader fr = new FileReader("../../create.sql");
        String createFile;
        createFile = "/home/lasaro/Trabalho-Tecnicas/create.sql";
        sql = "";
        Scanner scanner = new Scanner(new FileReader(createFile));
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            sql = sql + line + "\n";
        }
        String[] split = sql.split(";");
        for (String s : split) {
            //System.out.println("'\n" + s + "'");
            if (!s.trim().equals("")) {
                sta.execute(s);
            }
        }

        sta.close();
        con.close();
    }

    public static Connection conectarBd() throws Exception {
        return DriverManager.getConnection("jdbc:derby:" + dbName);
    }

    public static int getSequenciaTabela(TabelaSequencia tab) throws DAOException {
        try {
            Connection con = conectarBd();
            String sql = "SELECT MAX(" + tab.getSQLField() + ") FROM " + tab.getSQLTable();
            PreparedStatement sta = con.prepareStatement(sql);
            ResultSet res = sta.executeQuery();
            int seq = 0;
            if (res.next()) {
                seq = res.getInt(1);
            }
            res.close();
            con.close();
            return seq+1;
        } catch (Exception ex) {
            throw new DAOException("Falha na busca. " + ex.getMessage());
        }
    }
}
