package web;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import produto.Produto;
import produto.ProdutoRN;
import util.RNException;
import util.Relatorio;

@ManagedBean(name="produtoBean")
@RequestScoped
public class ProdutoBean {

	private Produto produto = new Produto();
	private List<Produto> produtos;
	private String destinoSalvar;
	private Relatorio relatorio;

	public String novo() {
		this.destinoSalvar = "produtoSucesso";
		this.produto = new Produto();
		return "produto";
	}
	
	public String relatorio() throws Exception {
		ProdutoRN produtoRN = new ProdutoRN();
		this.produtos = produtoRN.listar();
		this.relatorio = new Relatorio();
		relatorio.imprimir(produtos);
		return "listagem";
	}
	
	public String listar(){
		this.getProdutos();
		return "listagem";
	}
	
	public String salvar() {
		FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Sucesso!",  "O produto: " + this.produto.getDescricao() + " foi salvo."));		

		ProdutoRN produtoRN = new ProdutoRN();
		produtoRN.salvar(this.produto);
		return "listagem";
	}
	
	public String editar(){
		return "produto";
	}
	
	public void excluir() throws RNException{
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("Excluído!",  "O produto: " + this.produto.getDescricao() + " foi excluído."));
		ProdutoRN produtoRN = new ProdutoRN();
		produtoRN.excluir(this.produto);
		this.produtos = null;
	}
	
	public List<Produto> getProdutos(){
		if (this.produtos == null){
			ProdutoRN produtoRN = new ProdutoRN();
			this.produtos = produtoRN.listar();
		}
		return this.produtos;
	}

	public Produto getProduto() {
		return this.produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public String getDestinoSalvar() {
		return destinoSalvar;
	}

	public void setDestinoSalvar(String destinoSalvar) {
		this.destinoSalvar = destinoSalvar;
	}

	public Relatorio getRelatorio() {
		return relatorio;
	}

	public void setRelatorio(Relatorio relatorio) {
		this.relatorio = relatorio;
	}
}