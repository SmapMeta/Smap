package br.com.relatoriocombanco;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import java.util.HashMap;
import java.util.Locale;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.*;

public class RelatorioJDBC {

    private Connection con;
    private String relatorio = ("src/br/com/relatoriocombanco/RelatorioSmapJDBC.jasper");

    public RelatorioJDBC() {
        try {
            String url = "jdbc:mysql://localhost:3306/statistic_medic";
            String usuario = "root";
            String senha = "";

            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, usuario, senha);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT\n" +
"     mantel.`id` AS N,\n" +
"     mantel.`autor` AS Autor,\n" +
"     mantel.`dor` AS Dor,\n" +
"     mantel.`limiteSuperior` AS Limite_Superior,\n" +
"    mantel.`limiteInferior` AS limite_Inferior,\n" +
"     mantel.`valorPesoPorcento` AS valorPesoPorcento\n" +
"\n" +
" \n" +
"FROM\n" +
"     `mantel` mantel");
        } catch (Exception event) {
            JOptionPane.showMessageDialog(null, "conexão não estabelecida"
                    + " verificar se o banco esta ativo", "Mensagem do Programa", JOptionPane.ERROR_MESSAGE);
        }

    }

    public void exibirRelatorio() throws SQLException {

        try {
            JasperReport jr = (JasperReport) JRLoader.loadObject(relatorio);
            HashMap map = new HashMap();
            JasperPrint rel = JasperFillManager.fillReport(jr, null, con);
            JasperViewer jv = new JasperViewer(rel,false);
            jv.toFront();
            jv.setVisible(true);
            
        } catch (JRException erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro.getMessage());
        }
    }

}
