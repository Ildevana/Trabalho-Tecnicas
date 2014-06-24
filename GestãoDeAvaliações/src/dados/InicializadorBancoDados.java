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

    public static void criarBd() throws Exception {
        Connection con = DriverManager.getConnection("jdbc:derby:" + dbName + ";create=true");
        Statement sta = con.createStatement();
        String sql;
        //-- -----------------------------------------------------
        //-- Table ITEMAVAL
        //-- -----------------------------------------------------
        sql = "CREATE  TABLE ITEMAVAL ("
                + "  ID_ITEMAVAL NUMERIC(7) NOT NULL ,"
                + "  ENUN VARCHAR(100) NOT NULL ,"
                + "  COMENTARIO VARCHAR(100) ,"
                + "  PRIMARY KEY (ID_ITEMAVAL) )";
        sta.execute(sql);

        //-- -----------------------------------------------------
        //-- Table PROVA
        //-- -----------------------------------------------------
        sql = "CREATE  TABLE PROVA ("
                + "  ID_PROVA NUMERIC(7) NOT NULL ,"
                + "  TIPO VARCHAR(1) NOT NULL ,"
                + "  NOME_PROF VARCHAR(50) NOT NULL ,"
                + "  QT_QUESTOES NUMERIC(7) NOT NULL ,"
                + "  PRIMARY KEY (ID_PROVA) )";
        sta.execute(sql);

        //-- -----------------------------------------------------
        //-- Table ALTERNATIVAS
        //-- -----------------------------------------------------
        sql = "CREATE  TABLE ALTERNATIVAS ("
                + "  ID_ITEMAVAL NUMERIC(7) NOT NULL ,"
                + "  SQ_ALTERNATIVA NUMERIC(7) NOT NULL ,"
                + "  TEXTO VARCHAR(100) NOT NULL ,"
                + "  CORRETA VARCHAR(1) NOT NULL ,"
                + "  PRIMARY KEY (ID_ITEMAVAL, SQ_ALTERNATIVA) ,"
                + "  CONSTRAINT fk_ALTERNATIVAS_1"
                + "    FOREIGN KEY (ID_ITEMAVAL )"
                + "    REFERENCES ITEMAVAL (ID_ITEMAVAL )"
                + "    ON DELETE NO ACTION"
                + "    ON UPDATE NO ACTION)";
        sta.execute(sql);

        sql = "CREATE INDEX fk_ALTERNATIVAS_1 ON ALTERNATIVAS (ID_ITEMAVAL ASC)";
        sta.execute(sql);

        //-- -----------------------------------------------------
        //-- Table CATEGORIA
        //-- -----------------------------------------------------
        sql = "CREATE  TABLE CATEGORIA ("
                + "  ID_CATEGORIA NUMERIC(7) NOT NULL ,"
                + "  NOME_CAT VARCHAR(45) NOT NULL ,"
                + "  PRIMARY KEY (ID_CATEGORIA) )";
        sta.execute(sql);

        //-- -----------------------------------------------------
        //-- Table ITEMAVAL_CATEGORIA
        //-- -----------------------------------------------------
        sql = "CREATE  TABLE ITEMAVAL_CATEGORIA ("
                + "  ID_ITEMAVAL NUMERIC(7) NOT NULL ,"
                + "  ID_CATEGORIA NUMERIC(7) NOT NULL ,"
                + "  PRIMARY KEY (ID_ITEMAVAL, ID_CATEGORIA) ,"
                + "  CONSTRAINT fk_ITEMAVAL_CATEGORIA_1"
                + "    FOREIGN KEY (ID_ITEMAVAL )"
                + "    REFERENCES ITEMAVAL (ID_ITEMAVAL )"
                + "    ON DELETE NO ACTION"
                + "    ON UPDATE NO ACTION,"
                + "  CONSTRAINT fk_ITEMAVAL_CATEGORIA_2"
                + "    FOREIGN KEY (ID_CATEGORIA )"
                + "    REFERENCES CATEGORIA (ID_CATEGORIA )"
                + "    ON DELETE NO ACTION"
                + "    ON UPDATE NO ACTION)";
        sta.execute(sql);

        sql = "CREATE INDEX fk_ITEMAVAL_CATEGORIA_1 ON ITEMAVAL_CATEGORIA (ID_ITEMAVAL ASC)";
        sta.execute(sql);

        sql = "CREATE INDEX fk_ITEMAVAL_CATEGORIA_2 ON ITEMAVAL_CATEGORIA (ID_CATEGORIA ASC)";
        sta.execute(sql);

        //-- -----------------------------------------------------
        //-- Table PROVA_CATEGORIA
        //-- -----------------------------------------------------
        sql = "CREATE  TABLE PROVA_CATEGORIA ("
                + "  ID_CATEGORIA NUMERIC(7) NOT NULL ,"
                + "  ID_PROVA NUMERIC(7) NOT NULL ,"
                + "  PRIMARY KEY (ID_CATEGORIA, ID_PROVA) ,"
                + "  CONSTRAINT fk_PROVA_CATEGORIA_1"
                + "    FOREIGN KEY (ID_CATEGORIA )"
                + "    REFERENCES CATEGORIA (ID_CATEGORIA )"
                + "    ON DELETE NO ACTION"
                + "    ON UPDATE NO ACTION,"
                + "  CONSTRAINT fk_PROVA_CATEGORIA_2"
                + "    FOREIGN KEY (ID_PROVA )"
                + "    REFERENCES PROVA (ID_PROVA )"
                + "    ON DELETE NO ACTION"
                + "    ON UPDATE NO ACTION)";
        sta.execute(sql);

        sql = "CREATE INDEX fk_PROVA_CATEGORIA_1 ON PROVA_CATEGORIA (ID_CATEGORIA ASC)";
        sta.execute(sql);

        sql = "CREATE INDEX fk_PROVA_CATEGORIA_2 ON PROVA_CATEGORIA (ID_PROVA ASC)";
        sta.execute(sql);

        //-- -----------------------------------------------------
        //-- Table RESPOSTAS
        //-- -----------------------------------------------------
        /*sql = "CREATE  TABLE RESPOSTAS ("
                + "  ID_PROVA NUMERIC(7) NOT NULL ,"
                + "  ID_ITEMAVAL NUMERIC(7) NOT NULL ,"
                + "  ALTERNATIVA_MARCADA NUMERIC(7) NOT NULL ,"
                + "  COMENTARIO VARCHAR(100) ,"
                + "  PRIMARY KEY (ID_PROVA, ID_ITEMAVAL) ,"
                + "  CONSTRAINT fk_RESPOSTAS_1"
                + "    FOREIGN KEY (ID_PROVA)"
                + "    REFERENCES PROVA_CATEGORIA (ID_PROVA)"
                + "    ON DELETE NO ACTION"
                + "    ON UPDATE NO ACTION,"
                + "  CONSTRAINT fk_RESPOSTAS_2"
                + "    FOREIGN KEY (ID_ITEMAVAL )"
                + "    REFERENCES PROVA_CATEGORIA (ID_ITEMAVAL )"
                + "    ON DELETE NO ACTION"
                + "    ON UPDATE NO ACTION)";
        //*/
        sql = "CREATE  TABLE RESPOSTAS ("
                + "  ID_PROVA NUMERIC(7) NOT NULL ,"
                + "  ID_ITEMAVAL NUMERIC(7) NOT NULL ,"
                + "  ALTERNATIVA_MARCADA NUMERIC(7) NOT NULL ,"
                + "  PRIMARY KEY (ID_PROVA, ID_ITEMAVAL) ,"
                + "  CONSTRAINT fk_RESPOSTAS_1"
                + "    FOREIGN KEY (ID_PROVA)"
                + "    REFERENCES PROVA (ID_PROVA)"
                + "    ON DELETE NO ACTION"
                + "    ON UPDATE NO ACTION,"
                + "  CONSTRAINT fk_RESPOSTAS_2"
                + "    FOREIGN KEY (ID_ITEMAVAL )"
                + "    REFERENCES ITEMAVAL (ID_ITEMAVAL )"
                + "    ON DELETE NO ACTION"
                + "    ON UPDATE NO ACTION)";
        sta.execute(sql);

        sql = "CREATE INDEX fk_RESPOSTAS_1 ON RESPOSTAS (ID_PROVA ASC)";
        sta.execute(sql);
        sql = "CREATE INDEX fk_RESPOSTAS_2 ON RESPOSTAS (ID_ITEMAVAL ASC)";
        sta.execute(sql);
        
        sta.close();
        con.close();
    }

    public static Connection conectarBd() throws Exception {
        return DriverManager.getConnection("jdbc:derby:" + dbName);
    }
}
