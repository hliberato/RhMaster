package util;

import produto.ProdutoDAO;
import produto.ProdutoDAOHibernate;

public class DAOFactory {

	public static ProdutoDAO criarProdutoDAO() {
		ProdutoDAOHibernate produtoDAO = new ProdutoDAOHibernate();
		produtoDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return produtoDAO;
	}
}