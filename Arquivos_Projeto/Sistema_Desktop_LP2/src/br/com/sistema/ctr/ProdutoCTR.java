package br.com.sistema.ctr;

import java.sql.ResultSet;
import br.com.sistema.dao.ConexaoDAO;
import br.com.sistema.dao.ProdutoDAO;
import br.com.sistema.dto.FornecedorDTO;
import br.com.sistema.dto.ProdutoDTO;

public class ProdutoCTR {
    
    ProdutoDAO produtoDAO = new ProdutoDAO();
    private ConexaoDAO conexaoDAO;
    
    public ProdutoCTR() {
    	conexaoDAO = ConexaoDAO.getInstancia();
    }
  
    /**
     * Método utilizado para controlar o acesso ao método inserirProduto da
     * classe ProdutoDAO
     * @param produtoDTO, que vem da classe sa página (VIEW)
     * @param fornecedorDTO, que vem da classe da página (VIEW) 
     * @return String contendo a mensagem
     */
    public String inserirProduto(ProdutoDTO produtoDTO, FornecedorDTO fornecedorDTO) {
        try {
            if (produtoDAO.inserirProduto(produtoDTO, fornecedorDTO)) {
                return "Produto Cadastrado com Sucesso!!!";
            } else {
                return "Produto NÃO Cadastrado!!!";
            }
        } 		
        catch (Exception e) {
            System.out.println(e.getMessage());
            return "Produto NÃO Cadastrado";
        }
    }
    
    /**
     * Método utilizado para controlar o acesso ao método alterarProduto da
     * classe ProdutoDAO
     * @param produtoDTO, que vem da classe da página (VIEW)
     * @param fornecedorDTO, que vem da classe da página (VIEW) 
     * @return String contendo a mensagem
     */
    public String alterarProduto(ProdutoDTO produtoDTO, FornecedorDTO fornecedorDTO) {
        try {
            if (produtoDAO.alterarProduto(produtoDTO, fornecedorDTO)) {
                return "Produto Alterado com Sucesso!!!";
            } else {
                return "Produto NÃO Alterado!!!";
            }
        } 
        catch (Exception e) {
            System.out.println(e.getMessage());
            return "Produto NÃO Alterado!!!";
        }
    }
    
    /**
     * Método utilizado para controlar o acesso ao método excluirProduto da
     * classe ProdutoDAO
     * @param produtoDTO que vem da classe da página (VIEW)
     * @return String contendo a mensagem
     */
    public String excluirProduto(ProdutoDTO produtoDTO) {
        try {
            if (produtoDAO.excluirProduto(produtoDTO)) {
                return "Produto Excluído com Sucesso!!!";
            } else {
                return "Produto NÃO Excluído!!!";
            }
        } 
        catch (Exception e) {
            System.out.println(e.getMessage());
            return "Produto NÃO Excluído!!!";
        }
    }
    
    /**
     * Método utilizado para controlar o acesso ao método consultarProduto da
     * classe ProdutoDAO
     * @param produtoDTO que vem da classe da página (VIEW)
     * @param opcao que vem da classe da página (VIEW)
     * @return ResultSet com os dados do produto e fornecedor
     */
    public ResultSet consultarProduto(ProdutoDTO produtoDTO, int opcao) {
        ResultSet rs = null;
        rs = produtoDAO.consultarProduto(produtoDTO, opcao);
        return rs;
    }
    
    /**
     * Método utilizado para fechar o banco de dados
     */
    public void CloseDB() {
    	conexaoDAO.fecharConexao();
    }        
}