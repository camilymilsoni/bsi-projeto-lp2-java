package br.com.sistema.ctr;

import java.sql.ResultSet;
import br.com.sistema.dao.ClienteDAO;
import br.com.sistema.dao.ConexaoDAO;
import br.com.sistema.dto.ClienteDTO;

public class ClienteCTR {
    
    ClienteDAO clienteDAO = new ClienteDAO();
    private ConexaoDAO conexaoDAO;

    public ClienteCTR() {
    	conexaoDAO = ConexaoDAO.getInstancia();
    }
    
    /**
     * Método utilizado para controlar o acesso ao método inserirCliente da
     * classe ClienteAO
     *
     * @param clienteDTO, que vem da classe da página (VIEW) 
     * @return String contendo a mensagem
     */
    public String inserirCliente(ClienteDTO clienteDTO) {
        try {
            if (clienteDAO.inserirCliente(clienteDTO)) {
                return "Cliente Cadastrado com Sucesso!!!";
            } else {
                return "Cliente NÃO Cadastrado!!!";
            }
        } 
        catch (Exception e) {
            System.out.println(e.getMessage());
            return "Cliente NÃO Cadastrado";
        }
    }
    
    
    /**
     * Método utilizado para controlar o acesso ao método alterarCliente da
     * classe ClienteDAO
     *
     * @param clienteDTO, que vem da classe da página (VIEW) 
     * @return String contendo a mensagem
     */
    public String alterarCliente(ClienteDTO clienteDTO) {
        try {
            if (clienteDAO.alterarCliente(clienteDTO)) {
                return "Cliente Alterado com Sucesso!!!";
            } else {
                return "Cliente NÃO Alterado!!!";
            }
        } 
        catch (Exception e) {
            System.out.println(e.getMessage());
            return "Cliente NÃO Alterado!!!";
        }
    }

    
    /**
     * Método utilizado para controlar o acesso ao método excluirCliente da
     * classe ClienteDAO
     *
     * @param clienteDTO que vem da classe da página (VIEW)
     * @return String contendo a mensagem
     */
    public String excluirCliente(ClienteDTO clienteDTO) {
        try {
            if (clienteDAO.excluirCliente(clienteDTO)) {
                return "Cliente Excluído com Sucesso!!!";
            } else {
                return "Cliente NÃO Excluído!!!";
            }
        } 
        catch (Exception e) {
            System.out.println(e.getMessage());
            return "Cliente NÃO Excluído!!!";
        }
    }

    
    /**
     * Método utilizado para controlar o acesso ao método consultarCliente da
     * classe ClienteDAO
     *
     * @param clienteDTO que vem da classe da página (VIEW)
     * @param opcao que vem da classe da página (VIEW)
     * @return ResultSet com os dados do cliente
     */
    public ResultSet consultarCliente(ClienteDTO clienteDTO, int opcao) {
        ResultSet rs = null;
        rs = clienteDAO.consultarCliente(clienteDTO, opcao);
        return rs;
    }
    
    
    /**
     * Método utilizado para fechar o banco de dados
     */
    public void CloseDB() {
    	conexaoDAO.fecharConexao();
    }   
}