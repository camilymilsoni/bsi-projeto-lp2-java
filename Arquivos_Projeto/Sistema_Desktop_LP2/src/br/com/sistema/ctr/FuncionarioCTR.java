package br.com.sistema.ctr;

import java.sql.ResultSet;
import br.com.sistema.dao.ConexaoDAO;
import br.com.sistema.dao.FuncionarioDAO;
import br.com.sistema.dto.FuncionarioDTO;

public class FuncionarioCTR {
    
    FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
    private ConexaoDAO conexaoDAO;

    public FuncionarioCTR() {
    	conexaoDAO = ConexaoDAO.getInstancia();
    }
    
    /**
     * Método utilizado para controlar o acesso ao método inserirFuncionario da
     * classe FuncionarioAO
     *
     * @param funcionarioDTO, que vem da classe da página (VIEW) 
     * @return String contendo a mensagem
     */
    public String inserirFuncionario(FuncionarioDTO funcionarioDTO) {
        try {
            if (funcionarioDAO.inserirFuncionario(funcionarioDTO)) {
                return "Funcionário Cadastrado com Sucesso!!!";
            } else {
                return "Funcinário NÃO Cadastrado!!!";
            }
        } 
        catch (Exception e) {
            System.out.println(e.getMessage());
            return "Funcionario NÃO Cadastrado";
        }
    } 
    
    /**
     * Método utilizado para controlar o acesso ao método alterarFuncionario da
     * classe FuncionarioDAO
     *
     * @param funcionarioDTO, que vem da classe da página (VIEW) 
     * @return String contendo a mensagem
     */
    public String alterarFuncionario(FuncionarioDTO funcionarioDTO) {
        try {
            if (funcionarioDAO.alterarFuncionario(funcionarioDTO)) {
                return "Funcionário Alterado com Sucesso!!!";
            } else {
                return "Funcionário NÃO Alterado!!!";
            }
        } 
        catch (Exception e) {
            System.out.println(e.getMessage());
            return "Funcionário NÃO Alterado!!!";
        }
    }
    
    /**
     * Método utilizado para controlar o acesso ao método excluirFuncionario da
     * classe FuncionarioDAO
     *
     * @param funcionarioDTO que vem da classe da página (VIEW)
     * @return String contendo a mensagem
     */
    public String excluirFuncionario(FuncionarioDTO funcionarioDTO) {
        try {
            if (funcionarioDAO.excluirFuncionario(funcionarioDTO)) {
                return "Funcionário Excluído com Sucesso!!!";
            } else {
                return "Funcionário NÃO Excluído!!!";
            }
        } 
        catch (Exception e) {
            System.out.println(e.getMessage());
            return "Funcionário NÃO Excluído!!!";
        }
    }
    
    /**
     * Método utilizado para controlar o acesso ao método consultarFuncionario da
     * classe FuncionarioDAO
     *
     * @param funcionarioDTO que vem da classe da página (VIEW)
     * @param opcao que vem da classe da página (VIEW)
     * @return ResultSet com os dados do funcionario
     */
    public ResultSet consultarFuncionario(FuncionarioDTO funcionarioDTO, int opcao) {
        ResultSet rs = null;
        rs = funcionarioDAO.consultarFuncionario(funcionarioDTO, opcao);
        return rs;
    } 
    
    /**
     * Método utilizado para controlar o acesso ao método logarFuncionario da
     * classe FuncionarioDAO
     *
     * @param funcionarioDTO, opcao que vem da classe da página (VIEW)
     * @return int com os dados do usuario
     */
    public String logarFuncionario(FuncionarioDTO funcionarioDTO) {
        
        return funcionarioDAO.logarFuncionario(funcionarioDTO);

    } 
    
    /**
     * Método utilizado para fechar o banco de dados
     */
    public void CloseDB() {
    	conexaoDAO.fecharConexao();
    }  
}