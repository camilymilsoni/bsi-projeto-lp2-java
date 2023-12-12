package br.com.sistema.dao;

import java.sql.*;
import br.com.sistema.dto.FuncionarioDTO;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class FuncionarioDAO {
    
    private ResultSet rs = null;
    private Statement stmt = null;
    private ConexaoDAO conexaoDAO;
	
    public FuncionarioDAO() {
    	conexaoDAO = ConexaoDAO.getInstancia();
    }
    
    /**
     * Método utilizado para inserir um objeto funcionarioDTO no banco de dados
     *
     * @param funcionarioDTO, que vem da classe FuncionarioCTR
     * @return Um boolean
     */
    public boolean inserirFuncionario(FuncionarioDTO funcionarioDTO) {
    	Connection connection = null;
    	try {
    		connection = conexaoDAO.abrirConexao();
    		stmt = connection.createStatement();
            String comando = "Insert into funcionario (nome_fun, cpf_fun, "
                    + "login_fun, senha_fun, tipo_fun) values ( "
                    + "'" + funcionarioDTO.getNome_fun().toUpperCase() + "', "
                    + "'" + funcionarioDTO.getCpf_fun() + "', "
                    + "'" + funcionarioDTO.getLogin_fun() + "', "
                    + "'" + criptografar(funcionarioDTO.getSenha_fun()) + "', "
                    + "'" + funcionarioDTO.getTipo_fun().toUpperCase() + "') ";
            
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
     * Método utilizado para alterar um objeto funcionarioDTO no banco de dados
     *
     * @param funcionarioDTO, que vem da classe FuncionarioCTR
     * @return Um boolean
     */
    public boolean alterarFuncionario(FuncionarioDTO funcionarioDTO) {
    	Connection connection = null;
    	try {
    		connection = conexaoDAO.abrirConexao();
    		stmt = connection.createStatement();
            String comando = "";
            comando = "Update funcionario set "
                    + "nome_fun = '" + funcionarioDTO.getNome_fun().toUpperCase() + "', "
                    + "cpf_fun = '" + funcionarioDTO.getCpf_fun() + "', "
                    + "login_fun = '" + funcionarioDTO.getLogin_fun() + "', ";
                    
            if(funcionarioDTO.getSenha_fun() != null){
                comando += "senha_fun = '" + criptografar(funcionarioDTO.getSenha_fun()) + "', ";
            }
            
            comando += "tipo_fun = '" + funcionarioDTO.getTipo_fun().toUpperCase() + "' "
                    + "where id_fun = " + funcionarioDTO.getId_fun();
            
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
     * Método utilizado para excluir um objeto funcionarioDTO no banco de dados
     *
     * @param funcionarioDTO que vem da classe FuncionarioCTR
     * @return Um boolean
     */
    public boolean excluirFuncionario(FuncionarioDTO funcionarioDTO) {
    	Connection connection = null;
    	try {
    		connection = conexaoDAO.abrirConexao();
    		stmt = connection.createStatement();
            String comando = "Delete from funcionario where id_fun = " 
                             + funcionarioDTO.getId_fun();

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
     * Método utilizado para consultar um objeto funcionarioDTO no banco de dados
     *
     * @param funcionarioDTO, que vem da classe FuncionarioCTR
     * @param opcao, que vem da classe FuncionarioCTR
     * @return Um ResultSet com os dados do funcionario
     */
    public ResultSet consultarFuncionario(FuncionarioDTO funcionarioDTO, int opcao) {
    	Connection connection = null;
    	try {
    		connection = conexaoDAO.abrirConexao();
    		stmt = connection.createStatement();
            String comando = "";
            switch (opcao){
                case 1:
                    comando = "Select f.* "+
                              "from funcionario f "+
                              "where nome_fun like '" + funcionarioDTO.getNome_fun()+ "%' " +
                              "order by f.nome_fun";    
                break;
                case 2:
                    comando = "Select f.* "+
                              "from funcionario f " +
                              "where f.id_fun = " + funcionarioDTO.getId_fun();
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
    
    /**
     * Método utilizado para logar um objeto FuncionarioDTO no sistema
     *
     * @param funcionarioDTO, opcao que vem da classe FuncionarioCTR
     * @return Um String com o tipo do funcionário "ADMINISTRADOR" | "COMUM"
     */
    public String logarFuncionario(FuncionarioDTO funcionarioDTO) {
    	Connection connection = null;
    	try {
    		connection = conexaoDAO.abrirConexao();
    		stmt = connection.createStatement();
            String comando = "Select f.tipo_fun " +
                             "from funcionario f " + 
                             "where f.login_fun = '" + funcionarioDTO.getLogin_fun()+ "'" +
                             " and f.senha_fun = '" + criptografar(funcionarioDTO.getSenha_fun()) + "'";

            rs = null;
            rs = stmt.executeQuery(comando);
            if(rs.next()){
                return rs.getString("tipo_fun");
            }
            else{
                return "";
            }
                
        } 
        catch (Exception e) {
            System.out.println(e.getMessage());
            return "";
        }
        finally{
        	conexaoDAO.fecharConexao();
        }
    }
    
///////////// código para criptografia //////////////////    
    private static MessageDigest md = null;

    static {
        try {
            md = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException ex) {
            ex.printStackTrace();
        }
    }

    private static char[] hexCodes(byte[] text) {
        char[] hexOutput = new char[text.length * 2];
        for (int i = 0; i < text.length; i++) {
            String hex = Integer.toHexString(0xff & text[i]);
            if (hex.length() == 1) {
                hexOutput[i * 2] = '0';
                hexOutput[i * 2 + 1] = hex.charAt(0);
            } else {
                hexOutput[i * 2] = hex.charAt(0);
                hexOutput[i * 2 + 1] = hex.charAt(1);
            }
        }
        return hexOutput;
    }

    /**
     * O método criptografar, ele criptografa a senha que chega para ele.
     *
     * @param pwd senha que chega para ser criptografada.
     * @return a senha criptografada ou nulo.
     *
     */
    public static String criptografar(String pwd) {
        if (md != null) {
            return new String(hexCodes(md.digest(pwd.getBytes())));
        }
        return null;
    }
 ////////////Fim rotinas para criptografia   /////////////////  
}