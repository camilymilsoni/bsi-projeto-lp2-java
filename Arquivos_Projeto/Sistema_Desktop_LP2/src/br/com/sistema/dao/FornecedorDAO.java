package br.com.sistema.dao;

import java.sql.*;
import br.com.sistema.dto.FornecedorDTO;

public class FornecedorDAO {
	
    private ResultSet rs = null;
    private Statement stmt = null;
    private ConexaoDAO conexaoDAO;

    public FornecedorDAO() {
    	conexaoDAO = ConexaoDAO.getInstancia();
    }
    
    /**
     * Método utilizado para inserir um objeto fornecedorDTO no banco de dados
     *
     * @param fornecedorDTO, que vem da classe FornecedorCTR
     * @return Um boolean
     */
    public boolean inserirFornecedor(FornecedorDTO fornecedorDTO) {
    	Connection connection = null;
    	try {
    		connection = conexaoDAO.abrirConexao();
    		stmt = connection.createStatement();
            String comando = "Insert into fornecedor (nome_for, cnpj_for, "
                    + "tel_for ) values ( "
                    + "'" + fornecedorDTO.getNome_for()+ "', "
                    + "'" + fornecedorDTO.getCnpj_for()+ "', "
                    + "'" + fornecedorDTO.getTel_for()+ "')";
            
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
     * Método utilizado para alterar um objeto fornecedorDTO no banco de dados
     *
     * @param fornecedorDTO, que vem da classe FornecedorCTR
     * @return Um boolean
     */
    public boolean alterarFornecedor(FornecedorDTO fornecedorDTO) {
    	Connection connection = null;
    	try {
        	connection = conexaoDAO.abrirConexao();
    		stmt = connection.createStatement();
            String comando = "Update fornecedor set "
                    + "nome_for = '" + fornecedorDTO.getNome_for()+ "', "
                    + "cnpj_for = '" + fornecedorDTO.getCnpj_for()+ "', "
                    + "tel_for = '" + fornecedorDTO.getTel_for()+ "' "
                    + "where id_for = " + fornecedorDTO.getId_for();
                       
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
     * Método utilizado para excluir um objeto fornecedorDTO no banco de dados
     *
     * @param fornecedorDTO que vem da classe FornecedorCTR
     * @return Um boolean
     */
    public boolean excluirFornecedor(FornecedorDTO fornecedorDTO) {
    	Connection connection = null;
    	try {
    		connection = conexaoDAO.abrirConexao();
    		stmt = connection.createStatement();
            String comando = "Delete from fornecedor where id_for = " 
                             + fornecedorDTO.getId_for();

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
     * Método utilizado para consultar um objeto fornecedorDTO no banco de dados
     *
     * @param fornecedorDTO, que vem da classe FornecedorCTR
     * @param opcao, que vem da classe FornecedorCTR
     * @return Um ResultSet com os dados do fornecedor
     */
    public ResultSet consultarFornecedor(FornecedorDTO fornecedorDTO, int opcao) {
    	Connection connection = null;
    	try {
    		connection = conexaoDAO.abrirConexao();
    		stmt = connection.createStatement();
            String comando = "";
            switch (opcao){
                case 1:
                    comando = "Select f.id_for, f.nome_for "+
                              "from fornecedor f "+
                              "where f.nome_for like '" + fornecedorDTO.getNome_for()+ "%' " +
                              "order by f.nome_for";    
                break;
                case 2:
                    comando = "Select f.nome_for, f.cnpj_for, f.tel_for "+
                              "from fornecedor f " +
                              "where f.id_for = " + fornecedorDTO.getId_for();
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