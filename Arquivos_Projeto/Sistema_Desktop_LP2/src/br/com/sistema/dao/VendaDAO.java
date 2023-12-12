package br.com.sistema.dao;

import java.sql.*;
import java.text.SimpleDateFormat;
import javax.swing.JTable;
import br.com.sistema.dto.ClienteDTO;
import br.com.sistema.dto.VendaDTO;

public class VendaDAO {

    private ResultSet rs = null;
    Statement stmt = null;
    Statement stmt1 = null;
    SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
    private ConexaoDAO conexaoDAO;
	
    public VendaDAO() {
    	conexaoDAO = new ConexaoDAO();
    }  

    /**
     * Método utilizado para inserir um objeto vendaDTO no banco de dados
     *
     * @param vendaDTO, que vem da classe da página (VIEW)
     * @param clienteDTO, que vem da classe da página (VIEW) 
     * @param produtos, que vem da classe da página (VIEW)
     * @return Um boolean
     */
    public boolean inserirVenda(VendaDTO vendaDTO, ClienteDTO clienteDTO, JTable produtos) {
    	Connection connection = null;
        try {
            connection = conexaoDAO.abrirConexao();
            connection.setAutoCommit(false); 

            String comando1 = "Insert into venda (dat_vend, val_vend, id_cli) values ( "
                    + "'" + date.format(vendaDTO.getDat_vend()) + "', "
                    + vendaDTO.getVal_vend() + ", "
                    + clienteDTO.getId_cli() + ")";

            stmt = connection.createStatement();
            stmt.executeUpdate(comando1);

            ResultSet rs = stmt.getGeneratedKeys();
            int idVenda = -1;

            if (rs.next()) {
                idVenda = rs.getInt(1);
            } else {
                throw new SQLException("Nenhum ID de venda gerado.");
            }

            stmt1 = connection.createStatement();
            for (int cont = 0; cont < produtos.getRowCount(); cont++) {
                String comando2 = "Insert into produto_venda (id_vend, id_prod, val_prod, qtd_prod) values ( "
                        + idVenda + ", "
                        + produtos.getValueAt(cont, 0) + ", "
                        + produtos.getValueAt(cont, 2) + ", "
                        + produtos.getValueAt(cont, 3) + "); ";

                stmt1.executeUpdate(comando2);
            }

            connection.commit();
            stmt.close();
            stmt1.close();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        } finally {
            try {
                if (connection != null) {
                    connection.setAutoCommit(true); 
                    conexaoDAO.fecharConexao();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}