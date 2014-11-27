package produto;

import java.util.List;

public interface ProdutoDAO {

	public void salvar(Produto usuario);

	public void atualizar(Produto usuario);

	public void excluir(Produto usuario);

	public Produto carregar(Integer codigo);

	public List<Produto> listar();
	
}
