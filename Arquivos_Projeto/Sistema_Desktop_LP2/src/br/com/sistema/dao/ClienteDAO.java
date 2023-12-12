package br.com.sistema.dao;

import java.sql.*;
import br.com.sistema.dto.ClienteDTO;

public class ClienteDAO {
	
    private ResultSet rs = null;
    private Statement stmt = null;
    private ConexaoDAO conexaoDAO;
    
    public ClienteDAO() {
    	conexaoDAO = ConexaoDAO.getInstancia();
    }
    
    /**
     * Método utilizado para inserir um objeto clienteDTO no banco de dados
     *
     * @param clienteDTO, que vem da classe ClienteCTR
     * @return Um boolean
     */
    public boolean inserirCliente(ClienteDTO clienteDTO) {
    	Connection connection = null;
    	try {
    		connection = conexaoDAO.abrirConexao();
    		stmt = connection.createStatement();
            String comando = "Insert into cliente (nome_cli, logradouro_cli, numero_cli, "
                    + "bairro_cli, cidade_cli, estado_cli, cep_cli, cpf_cli, rg_cli) values ( "
                    + "'" + clienteDTO.getNome_cli() + "', "
                    + "'" + clienteDTO.getLogradouro_cli()+ "', "
                    + clienteDTO.getNumero_cli()+ ", "
                    + "'" + clienteDTO.getBairro_cli()+ "', "
                    + "'" + clienteDTO.getCidade_cli()+ "', "
                    + "'" + clienteDTO.getEstado_cli()+ "', "
                    + "'" + clienteDTO.getCep_cli()+ "', "
                    + "'" + clienteDTO.getCpf_cli()+ "', "
                    + "'" + clienteDTO.getRg_cli()+ "') ";
                       
            stmt.execute(comando.toUpperCase());
            connection.commit();
            stmt.close();
            return true;
        } 
        catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        } 
        finally {
            conexaoDAO.fecharConexao();
        }
    }
      
    /**
     * Método utilizado para alterar um objeto clienteDTO no banco de dados
     *
     * @param clienteDTO, que vem da classe ClienteCTR
     * @return Um boolean
     */
    public boolean alterarCliente(ClienteDTO clienteDTO) {
    	Connection connection = null;
    	try {
    		connection = conexaoDAO.abrirConexao();
    		stmt = connection.createStatement();
            String comando = "Update cliente set "
                    + "nome_cli = '" + clienteDTO.getNome_cli()+ "', "
                    + "logradouro_cli = '" + clienteDTO.getLogradouro_cli()+ "', "
                    + "numero_cli = " + clienteDTO.getNumero_cli()+ ", "
                    + "bairro_cli = '" + clienteDTO.getBairro_cli()+ "', "
                    + "cidade_cli = '" + clienteDTO.getCidade_cli()+ "', "
                    + "estado_cli = '" + clienteDTO.getEstado_cli()+ "', "
                    + "cep_cli = '" + clienteDTO.getCep_cli()+ "', "
                    + "cpf_cli = '" + clienteDTO.getCpf_cli()+ "', "
                    + "rg_cli = '" + clienteDTO.getRg_cli()+ "' "
                    + "where id_cli = " + clienteDTO.getId_cli();
                       
            stmt.execute(comando.toUpperCase());
            connection.commit();
            stmt.close();
            return true;
        } 
        catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        } 
        finally {
        	conexaoDAO.fecharConexao();
        }
    }
    
    /**
     * Método utilizado para excluir um objeto clienteDTO no banco de dados
     *
     * @param clienteDTO que vem da classe ClienteCTR
     * @return Um boolean
     */
    public boolean excluirCliente(ClienteDTO clienteDTO) {
    	Connection connection = null;
        try {
        	connection = conexaoDAO.abrirConexao();
    		stmt = connection.createStatement();
            String comando = "Delete from cliente where id_cli = " 
                             + clienteDTO.getId_cli();

            stmt.execute(comando);
            connection.commit();
            stmt.close();
            return true;
        } 
        catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        } 
        finally {
        	conexaoDAO.fecharConexao();
        }
    }   
    
    /**
     * Método utilizado para consultar um objeto clienteDTO no banco de dados
     *
     * @param clienteDTO, que vem da classe ClienteCTR
     * @param opcao, que vem da classe ClienteCTR
     * @return Um ResultSet com os dados do cliente
     */
    public ResultSet consultarCliente(ClienteDTO clienteDTO, int opcao) {
    	Connection connection = null;
    	try {
    		connection = conexaoDAO.abrirConexao();
    		stmt = connection.createStatement();
            String comando = "";
            switch (opcao){
                case 1:
                    comando = "Select c.* "+
                              "from cliente c "+
                              "where nome_cli like '" + clienteDTO.getNome_cli()+ "%' " +
                              "order by c.nome_cli";    
                break;
                case 2:
                    comando = "Select c.* "+
                              "from cliente c " +
                              "where c.id_cli = " + clienteDTO.getId_cli();
                break;
                case 3:
                    comando = "Select c.id_cli, c.nome_cli "+
                              "from cliente c ";
                break;
                
            }
            rs = stmt.executeQuery(comando.toUpperCase());
            return rs;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return rs;
        }
    }
}