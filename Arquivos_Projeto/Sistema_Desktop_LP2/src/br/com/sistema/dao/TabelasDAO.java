package br.com.sistema.dao;

import java.sql.*;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TabelasDAO {
	public static void main(String args[]) {
		Connection connection = null;
        Statement stmt = null;
		
        try {
            Class.forName("org.sqlite.JDBC");

            String caminhoBD = "resources/bdsistema.db";
            File arquivoBD = new File(caminhoBD);

            if (arquivoBD.exists()) {
                connection = DriverManager.getConnection("jdbc:sqlite:" + caminhoBD);
                System.out.println("Banco de dados criado com sucesso");

                stmt = connection.createStatement();

                String criarTabelaFornecedor = "CREATE TABLE IF NOT EXISTS fornecedor ("
                    + "id_for INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,"
                    + "nome_for VARCHAR(50),"
                    + "cnpj_for VARCHAR(15),"
                    + "tel_for VARCHAR(13))";
                stmt.executeUpdate(criarTabelaFornecedor);
            
                String criarTabelaProduto = "CREATE TABLE IF NOT EXISTS produto ("
                    + "id_prod INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,"
                    + "nome_prod VARCHAR(50),"
                    + "desc_prod VARCHAR(50),"
                    + "cod_bar_prod VARCHAR(13),"
                    + "p_custo_prod DOUBLE,"
                    + "p_venda_prod DOUBLE,"
                    + "id_for INTEGER,"
                    + "CONSTRAINT fornecedor_fk FOREIGN KEY (id_for) REFERENCES fornecedor (id_for))";
                stmt.executeUpdate(criarTabelaProduto);

                String criarTabelaCliente = "CREATE TABLE IF NOT EXISTS cliente ("
                    + "id_cli INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,"
                    + "nome_cli VARCHAR(50),"
                    + "logradouro_cli VARCHAR(50),"
                    + "numero_cli INTEGER,"
                    + "bairro_cli VARCHAR(30),"
                    + "cidade_cli VARCHAR(30),"
                    + "estado_cli VARCHAR(2),"
                    + "cep_cli VARCHAR(9),"
                    + "cpf_cli VARCHAR(14) UNIQUE,"
                    + "rg_cli VARCHAR(15))";
                stmt.executeUpdate(criarTabelaCliente);
            
                String criarTabelaVenda = "CREATE TABLE IF NOT EXISTS venda ("
                    + "id_vend INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,"
                    + "dat_vend DATE,"
                    + "val_vend DOUBLE,"
                    + "id_cli INTEGER,"
                    + "CONSTRAINT venda_id_cli_fkey FOREIGN KEY (id_cli) REFERENCES cliente (id_cli))";
                stmt.executeUpdate(criarTabelaVenda);
            
                String criarTabelaProdutoVenda = "CREATE TABLE IF NOT EXISTS produto_venda ("
                    + "id_prod INTEGER,"
                    + "id_vend INTEGER,"
                    + "val_prod DOUBLE,"
                    + "qtd_prod INTEGER,"
                    + "CONSTRAINT produto_venda_id_prod_fkey FOREIGN KEY (id_prod) REFERENCES produto (id_prod),"
                    + "CONSTRAINT produto_venda_id_vend_fkey FOREIGN KEY (id_vend) REFERENCES venda (id_vend))";
                stmt.executeUpdate(criarTabelaProdutoVenda);
            
                String criarTabelaFuncionario = "CREATE TABLE IF NOT EXISTS funcionario ("
                    + "id_fun INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,"
                    + "nome_fun VARCHAR(50),"
                    + "cpf_fun VARCHAR(14) UNIQUE,"
                    + "login_fun VARCHAR(30) UNIQUE,"
                    + "senha_fun VARCHAR(50),"
                    + "tipo_fun VARCHAR(13))";
                stmt.executeUpdate(criarTabelaFuncionario);

                stmt.close();
                connection.close();
            }
            else {
            	System.out.println("Arquivo 'bdsistema.db' não encontrado na pasta 'resources'.");
            }
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Tabelas criadas com sucesso");
	}
}