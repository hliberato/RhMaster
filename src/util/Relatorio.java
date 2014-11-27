package util;

import java.util.List;
 
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import produto.Produto;
 
public class Relatorio{
	private String path; //Caminho base
	
	private String pathToReportPackage; // Caminho para o package onde estão armazenados os relatorios Jarper
	
	//Recupera os caminhos para que a classe possa encontrar os relatórios
	public Relatorio() {
		/*this.path = this.getClass().getClassLoader().getResource("").getPath();
		this.pathToReportPackage = this.path + "util/";
		System.out.println(path);*/
		this.pathToReportPackage = "C:/Users/Meus Documentos/Dropbox" +
				"/Estudos Java/EstudosJavaWorkspace/.metadata/.plugins" +
				"/org.eclipse.wst.server.core/tmp0/wtpwebapps/RhMaster/WEB-INF/classes/util/";
	}
	
	
	//Imprime/gera uma lista de produtos
	public void imprimir(List<Produto> produtos) throws Exception{
		JasperReport report = JasperCompileManager.compileReport(this.getPathToReportPackage() + "produto.jrxml");
		
		JasperPrint print = JasperFillManager.fillReport(report, null, new JRBeanCollectionDataSource(produtos));
 
		JasperExportManager.exportReportToPdfFile(print, "c:/Relatorio_de_Produtos.pdf");		
	}
 
	public String getPathToReportPackage() {
		return this.pathToReportPackage;
	}
	
	public String getPath() {
		return this.path;
	}
}