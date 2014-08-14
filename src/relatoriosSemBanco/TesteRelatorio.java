/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package relatoriosSemBanco;

import br.com.smap.persistencia.ConnectionFactory;
import br.com.smap.view.MenuPrincipal;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JExcelApiExporter;
import net.sf.jasperreports.engine.export.JRCsvExporter;
import net.sf.jasperreports.engine.export.JRHtmlExporter;
import net.sf.jasperreports.engine.export.JRRtfExporter;
import net.sf.jasperreports.engine.export.oasis.JROdtExporter;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Ederson
 */
public class TesteRelatorio {

    public void arrayDataSource() throws JRException {
        /*
         //        Qual a função do projeto?? E o CasoTeste
         String pathJasperReports = projeto.getReport() + "\\" + casoTeste.getJasperReport() + ".jrxml";
         JasperReport report = JasperCompileManager.compileReport(pathJasperReports);
         //gera um clone do mapa, pois o JasperReport adiciona informações no mapa passado por parâmetro
         Map<String, Object> parametersJasper = cloneParametersMap(casoTeste.getParametersReport());
         //        Qual a funcionalidade do Map<>?
         //aqui está a solução para não utilizaer o banco de dados e sim o JRMapArrayDataSource que permite
         //enviar uma coleção relacionada aos dados a serem exibidos
         JasperFillManager.fillReport(report, parametersJasper, new JRMapArrayDataSource(new Object[]{"A", "B"}));

         JasperPrint jpGenerate = JasperFillManager.fillReport(report, parametersJasper);
         */
    }

    public void exibirRelatorioComJDBC() throws FileNotFoundException, JRException {		
        
        Connection conn = null;

		try {
			 //cria a conexão com o banco de dados
			Class.forName("com.mysql.jdbc.Driver");
			String db = "jdbc:mysql://localhost:3306/statistic_medic";
			conn = DriverManager.getConnection(db,"root","");

			System.out.println("Gerando relatório...");

			HashMap<String, Integer> parameterMap = 
						new HashMap<String, Integer>( );
			 //o Nome do parâmetro e o valor é passado ao HashMap
			parameterMap.put("PAR_PEDID", 10248);

		    String path = "src/br/com/relatoriocombanco/";
		    File file = new File(path);
		    file = file.getAbsoluteFile( );
			
		    String repStr2 = file.getPath( );
		    System.out.println(repStr2);
			
			 //pega o caminho físico até o arquivo .jasper
			String arquivo = "/src/br/com/relatoriocombanco/RelatorioSmapJDBC.jasper";


			
			 //chama fillReport
			JasperPrint jp = JasperFillManager.fillReport(arquivo, null, conn);
			
			//exporta para o formato ODT do OpenOffice.org Writer
			JROdtExporter odtExporter = new JROdtExporter();
			odtExporter.setParameter(JRExporterParameter. 
					JASPER_PRINT, jp);
			odtExporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME,
					path + "/relatorio.odt");
			odtExporter.setParameter(JRExporterParameter.JASPER_PRINT, jp);
			odtExporter.setParameter(JRExporterParameter.OFFSET_X, new Integer(0)); 
			odtExporter.setParameter(JRExporterParameter.OFFSET_Y, new Integer(0)); 
			odtExporter.setParameter(JRExporterParameter.CHARACTER_ENCODING, "UTF-8"); 
		
			odtExporter.exportReport();
			
			
			//exporta para o formato RTF
			JRRtfExporter rtfExporter = new JRRtfExporter();
			rtfExporter.setParameter(JRExporterParameter. 
					JASPER_PRINT, jp);
			rtfExporter.setParameter(
			JRExporterParameter.OUTPUT_FILE_NAME,
					path + "/relatorio.rtf");
			rtfExporter.exportReport();

			
			//exporta para o formato XLS
			JExcelApiExporter xlsExporter = new JExcelApiExporter();
			xlsExporter.setParameter(JRExporterParameter. 
					JASPER_PRINT, jp);
			xlsExporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME,
					path + "/relatorio.xls"); 
			xlsExporter.exportReport();

			//exporta para o formato HTML
			JRHtmlExporter htmlExporter = new JRHtmlExporter();
			htmlExporter.setParameter(JRExporterParameter. 
					JASPER_PRINT, jp);
			htmlExporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME,
					path + "/relatorio.html");
			htmlExporter.exportReport();

			
			
			//exporta para o formato CSV
			JRCsvExporter csvExporter = new JRCsvExporter();
			csvExporter.setParameter(JRExporterParameter. 
					JASPER_PRINT, jp);
			csvExporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME,
					path + "/relatorio.csv");
			csvExporter.exportReport();

			
			

			 //exibe o relatório com viewReport
			JasperViewer.viewReport(jp, false);
            
		} catch (SQLException ex) {
            ex.printStackTrace();
		} catch (ClassNotFoundException ex) {
            ex.printStackTrace();
		} catch (JRException e) {
            e.printStackTrace();
		} finally {
            try {
                if (!conn.isClosed()) {
                    conn.close();
                }
                System.out.println("Finalizado!");
            } catch (SQLException ex) {}
		}
    }

    public void exibirsemJDBCRelatorio() throws FileNotFoundException, JRException {
        try {

//        String caminhoReJasper = "RelatorioSmap.jrxml";
            String caminhoReJasper = "C:\\Users\\Ederson\\Documents\\NetBeansProjects\\SMAP-Statistic Meta-Analisys of Pearson\\src\\relatorios\\RelatorioSmap.jrxml";
            MenuPrincipal mp = new MenuPrincipal();

            JasperReport jasper = JasperCompileManager.compileReport(new FileInputStream(caminhoReJasper));

            List listaMantel = mp.getListaMantel();

            InputStream reJasper = getClass().getResourceAsStream(caminhoReJasper);

            System.err.println("listaMantel" + listaMantel);

            JRBeanCollectionDataSource ds = new JRBeanCollectionDataSource(listaMantel);

            Map<String, Object> parametros = new HashMap<String, Object>();
            parametros.put("TITULO_REL", "seu titulo do relatório");

            JasperPrint impressao = null;

            //impressao = JasperFillManager.fillReport(reJasper, parametros, ds);
            impressao = JasperFillManager.fillReport(jasper, parametros, ds);
            JasperViewer viewer = new JasperViewer(impressao, true);
            viewer.setVisible(true);
        } catch (JRException ex) {
            JOptionPane.showMessageDialog(null, "Erro na Impressão do do Relatorio: \n" + ex.getMessage());
        }
    }

    
}
