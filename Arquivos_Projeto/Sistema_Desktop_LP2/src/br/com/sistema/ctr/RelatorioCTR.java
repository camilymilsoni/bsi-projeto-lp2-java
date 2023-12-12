package br.com.sistema.ctr;

import java.io.File;
import java.sql.Connection;
import java.util.HashMap;
import br.com.sistema.dao.ConexaoDAO;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

public class RelatorioCTR {

    public void gerarRelatorio(String nomeRelatorio) {
        Connection connection = ConexaoDAO.getInstancia().abrirConexao();

        try {
            JasperReport jasperReport = compilarRelatorio(nomeRelatorio + ".jrxml");
            JasperPrint jasperPrint = preencherRelatorio(jasperReport, connection);
            exibirRelatorio(jasperPrint);
            exportarRelatorioParaPDF(jasperPrint, "relatorio" + nomeRelatorio + ".pdf");
        } catch (JRException e) {
            e.printStackTrace();
        } finally {
            ConexaoDAO.getInstancia().fecharConexao();
        }
    }

    private JasperReport compilarRelatorio(String nomeRelatorio) throws JRException {
        String pathAbsolutoParcial = construirCaminhoRelatorio(nomeRelatorio);
        return JasperCompileManager.compileReport(pathAbsolutoParcial);
    }

    private String construirCaminhoRelatorio(String nomeRelatorio) {
        File file = new File("RelatorioCTR.java");
        String pathAbsoluto = file.getAbsolutePath();
        String pathAbsolutoParcial = pathAbsoluto;
        int lastIndex = pathAbsoluto.lastIndexOf(File.separator);
        if (lastIndex != -1) {
            pathAbsolutoParcial = pathAbsoluto.substring(0, lastIndex);
        }
        pathAbsolutoParcial += File.separator + "relatorios" + File.separator + nomeRelatorio;
        return pathAbsolutoParcial;
    }

    private JasperPrint preencherRelatorio(JasperReport jasperReport, Connection connection) throws JRException {
        return JasperFillManager.fillReport(jasperReport, new HashMap<>(), connection);
    }

    private void exibirRelatorio(JasperPrint jasperPrint) {
        JasperViewer jasperViewer = new JasperViewer(jasperPrint, false);
        jasperViewer.setVisible(true);
    }

    private void exportarRelatorioParaPDF(JasperPrint jasperPrint, String nomeArquivo) throws JRException {
        String diretorioBase = System.getProperty("user.dir"); 
        String diretorioRelatorios = File.separator + "relatorios" + File.separator;
        String caminhoCompleto = diretorioBase + diretorioRelatorios + nomeArquivo;

        try {
            JasperExportManager.exportReportToPdfFile(jasperPrint, caminhoCompleto);
        } catch (JRException e) {
            e.printStackTrace();
            System.err.println("Erro ao exportar relatório para PDF: " + e.getMessage());
        }
    }
}