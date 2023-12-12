package br.com.sistema.ctr;

import java.sql.ResultSet;
import br.com.sistema.dao.ConexaoDAO;
import br.com.sistema.dao.FornecedorDAO;
import br.com.sistema.dto.FornecedorDTO;

public class FornecedorCTR {
    
    FornecedorDAO fornecedorDAO = new FornecedorDAO();
    private ConexaoDAO conexaoDAO;
    
    public FornecedorCTR() {
    	conexaoDAO = ConexaoDAO.getInstancia();
    }
    
    /**
     * Método utilizado para controlar o acesso ao método inserirFornecedor da
     * classe FornecedorDAO
     *
     * @param fornecedorDTO, que vem da classe da página (VIEW) 
     * @return String contendo a mensagem
     */
    public String inserirFornecedor(FornecedorDTO fornecedorDTO) {
        try {
            if (fornecedorDAO.inserirFornecedor(fornecedorDTO)) {
                return "Fornecedor Cadastrado com Sucesso!!!";
            } else {
                return "Fornecedor NÃO Cadastrado!!!";
            }
        } 	
        catch (Exception e) {
            System.out.println(e.getMessage());
            return "Fornecedor NÃO Cadastrado";
        }
    }    
    
    /**
     * Método utilizado para controlar o acesso ao método alterarFornecedor da
     * classe FornecedorDAO
     *
     * @param fornecedorDTO, que vem da classe da página (VIEW) 
     * @return String contendo a mensagem
     */
    public String alterarFornecedor(FornecedorDTO fornecedorDTO) {
        try {

            if (fornecedorDAO.alterarFornecedor(fornecedorDTO)) {
                return "Fornecedor Alterado com Sucesso!!!";
            } else {
                return "Fornecedor NÃO Alterado!!!";
            }
        } 
        catch (Exception e) {
            System.out.println(e.getMessage());
            return "Fornecedor NÃO Alterado!!!";
        }
    }

    
    /**
     * Método utilizado para controlar o acesso ao método excluirFornecedor da
     * classe FornecedorDAO
     *
     * @param fornecedorDTO que vem da classe da página (VIEW)
     * @return String contendo a mensagem
     */
    public String excluirFornecedor(FornecedorDTO fornecedorDTO) {
        try {
            if (fornecedorDAO.excluirFornecedor(fornecedorDTO)) {
                return "Fornecedor Excluído com Sucesso!!!";
            } else {
                return "Fornecedor NÃO Excluído!!!";
            }
        } 
        catch (Exception e) {
            System.out.println(e.getMessage());
            return "Fornecedor NÃO Excluído!!!";
        }
    }

    
    /**
     * Método utilizado para controlar o acesso ao método consultarFornecedor da
     * classe FornecedorDAO
     *
     * @param fornecedorDTO que vem da classe da página (VIEW)
     * @param opcao que vem da classe da página (VIEW)
     * @return ResultSet com os dados do fornecedor
     */
    public ResultSet consultarFornecedor(FornecedorDTO fornecedorDTO, int opcao) {
        ResultSet rs = null;
        rs = fornecedorDAO.consultarFornecedor(fornecedorDTO, opcao);
        return rs;
    }   
    
    /**
     * Método utilizado para fechar o banco de dados
     */
    public void CloseDB() {
    	conexaoDAO.fecharConexao();
    }   
}