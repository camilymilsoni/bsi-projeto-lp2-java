package br.com.sistema.ctr;

import br.com.sistema.dao.ConexaoDAO;
import br.com.sistema.dao.VendaDAO;
import br.com.sistema.dto.ClienteDTO;
import br.com.sistema.dto.VendaDTO;
import javax.swing.JTable;

public class VendaCTR {
    
	VendaDAO vendaDAO = new VendaDAO();
    private ConexaoDAO conexaoDAO;

    public VendaCTR() {
    	conexaoDAO = ConexaoDAO.getInstancia();
    }

    /**
     * Método utilizado para controlar o acesso ao método inserirVenda da
     * classe VendaDAO
     * @param vendaDTO, que vem da classe da página (VIEW) 
     * @param clienteDTO, que vem da classe da página (VIEW) 
     * @param produtos, que vem da classe da página (VIEW)
     * @return String contendo a mensagem
     */
    public String inserirVenda(VendaDTO vendaDTO, ClienteDTO clienteDTO, JTable produtos) {
        try {
            if (vendaDAO.inserirVenda(vendaDTO, clienteDTO, produtos)) {
                return "Venda Cadastrada com Sucesso!!!";
            } else {
                return "Venda NÃO Cadastrada!!!";
            }
        } 	
        catch (Exception e) {
        	e.printStackTrace();
            System.out.println(e.getMessage());
            return "Venda NÃO Cadastrada";
        }
    }
    
    /**
     * Método utilizado para controlar o acesso ao método CloseDB da classe
     * ConexaoDAO
     */
    public void CloseDB() {
    	conexaoDAO.fecharConexao();
    }
}