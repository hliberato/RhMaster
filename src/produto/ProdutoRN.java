package produto;

import java.util.List;

import util.DAOFactory;
import util.RNException;

public class ProdutoRN {

	private ProdutoDAO	produtoDAO;

	public ProdutoRN() {
		this.produtoDAO = DAOFactory.criarProdutoDAO();
	}

	public Produto carregar(Integer codigo) {
		return this.produtoDAO.carregar(codigo);
	}

	public void salvar(Produto usuario) {

		Integer codigo = usuario.getCodigo();
		if (codigo == null || codigo == 0) {
			this.produtoDAO.salvar(usuario);
		} else {
			this.produtoDAO.atualizar(usuario);
		}
	}

	public void excluir(Produto produto) throws RNException {
		
		this.produtoDAO.excluir(produto);
	}

	public List<Produto> listar() {
		return this.produtoDAO.listar();
	}
}