package br.com.sistema.view;

import javax.swing.JOptionPane;
import java.awt.Image;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import br.com.sistema.ctr.RelatorioCTR;
import br.com.sistema.dto.FuncionarioDTO;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PrincipalVIEW extends javax.swing.JFrame {
	
	RelatorioCTR relatorioCTR = new RelatorioCTR();

    public PrincipalVIEW(FuncionarioDTO funcionarioDTO) {
        initComponents();
        this.setLocationRelativeTo(null);
        if(funcionarioDTO.getTipo_fun().equalsIgnoreCase("COMUM")){
            itemMenuFuncionario.setVisible(false);
            menuRelatorio.setVisible(false);
            menuBackup.setVisible(false);
        }   
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        ImageIcon imageicon = new ImageIcon(getClass().getResource("imagens/tela_inicial.png"));
        Image image = imageicon.getImage();

        desktopPane = new javax.swing.JDesktopPane(){
            public void paintComponent(Graphics graphics){
                graphics.drawImage(image, 0, 0, getWidth(), getHeight(), this);
            }
        };
        
        menuBar = new javax.swing.JMenuBar();
        menuCadastro = new javax.swing.JMenu();
        itemMenuCliente = new javax.swing.JMenuItem();
        itemMenuFornecedor = new javax.swing.JMenuItem();
        itemMenuFuncionario = new javax.swing.JMenuItem();
        itemMenuProduto = new javax.swing.JMenuItem();
        menuVenda = new javax.swing.JMenu();
        itemMenuVenda = new javax.swing.JMenuItem();
        menuRelatorio = new javax.swing.JMenu();
        itemMenuRelatCliente = new javax.swing.JMenuItem();
        itemMenuRelatFornecedor = new javax.swing.JMenuItem();
        itemMenuRelatFuncionario = new javax.swing.JMenuItem();
        itemMenuRelatProduto = new javax.swing.JMenuItem();
        itemMenuRelatVenda = new javax.swing.JMenuItem();
        menuBackup = new javax.swing.JMenu();
        menuSair = new javax.swing.JMenu();
        menuSair.setForeground(new Color(255, 0, 0));

        jMenuItem1.setText("jMenuItem1");

        jMenuItem3.setText("jMenuItem3");

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        menuCadastro.setMnemonic('c');
        menuCadastro.setText("Cadastro");

        itemMenuCliente.setText("Cliente");
        itemMenuCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemMenuClienteActionPerformed(evt);
            }
        });
        menuCadastro.add(itemMenuCliente);

        itemMenuFornecedor.setMnemonic('f');
        itemMenuFornecedor.setText("Fornecedor");
        itemMenuFornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemMenuFornecedorActionPerformed(evt);
            }
        });
        menuCadastro.add(itemMenuFornecedor);

        itemMenuFuncionario.setText("Funcionário");
        itemMenuFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemMenuFuncionarioActionPerformed(evt);
            }
        });
        menuCadastro.add(itemMenuFuncionario);

        itemMenuProduto.setMnemonic('p');
        itemMenuProduto.setText("Produto");
        itemMenuProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemMenuProdutoActionPerformed(evt);
            }
        });
        menuCadastro.add(itemMenuProduto);

        menuBar.add(menuCadastro);

        menuVenda.setText("Venda");

        itemMenuVenda.setText("Realizar Venda");
        itemMenuVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemMenuVendaActionPerformed(evt);
            }
        });
        menuVenda.add(itemMenuVenda);

        menuBar.add(menuVenda);

        menuSair.setMnemonic('s');
        menuSair.setText("Sair");
        menuSair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuSairMouseClicked(evt);
            }
        });
        
        menuRelatorio.setText("Relatório");
        menuBar.add(menuRelatorio);
        
        itemMenuRelatCliente.addActionListener(new ActionListener() {
        	public void actionPerformed(java.awt.event.ActionEvent evt) {
        		itemMenuRelatClienteActionPerformed(evt);
        	}
        });
        itemMenuRelatCliente.setText("Clientes");
        menuRelatorio.add(itemMenuRelatCliente);
        
        itemMenuRelatFornecedor.addActionListener(new ActionListener() {
        	public void actionPerformed(java.awt.event.ActionEvent evt) {
        		itemMenuRelatFornecedorActionPerformed(evt);
        	}
        });
        itemMenuRelatFornecedor.setText("Fornecedores");
        menuRelatorio.add(itemMenuRelatFornecedor);
        
        itemMenuRelatFuncionario.addActionListener(new ActionListener() {
        	public void actionPerformed(java.awt.event.ActionEvent evt) {
        		itemMenuRelatFuncionarioActionPerformed(evt);
        	}
        });
        itemMenuRelatFuncionario.setText("Funcionários");
        menuRelatorio.add(itemMenuRelatFuncionario);
        
        itemMenuRelatProduto.addActionListener(new ActionListener() {
        	public void actionPerformed(java.awt.event.ActionEvent evt) {
        		itemMenuRelatProdutoActionPerformed(evt);
        	}
        });
        itemMenuRelatProduto.setText("Produtos");
        menuRelatorio.add(itemMenuRelatProduto);
        
        itemMenuRelatVenda.addActionListener(new ActionListener() {
        	public void actionPerformed(java.awt.event.ActionEvent evt) {
        		itemMenuRelatVendaActionPerformed(evt);
        	}
        });
        itemMenuRelatVenda.setText("Vendas");
        menuRelatorio.add(itemMenuRelatVenda);
        
        menuBackup = new JMenu();
        menuBackup.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(java.awt.event.MouseEvent evt) {
        		menuBackupMouseClicked(evt);
        	}
        });
        menuBackup.setText("Backup");
        menuBar.add(menuBackup);
        menuBar.add(menuSair);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            	.addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 1150, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            	.addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 650, Short.MAX_VALUE)
        );

        pack();
    }

    private void menuSairMouseClicked(java.awt.event.MouseEvent evt) {
        sair();
    }
    
    private void menuBackupMouseClicked(java.awt.event.MouseEvent evt) {
        abreBackupVIEW();
    }

    private void itemMenuFornecedorActionPerformed(java.awt.event.ActionEvent evt) {
        abreFornecedorVIEW();
    }

    private void itemMenuProdutoActionPerformed(java.awt.event.ActionEvent evt) {
        abreProdutoVIEW();
    }

    private void itemMenuClienteActionPerformed(java.awt.event.ActionEvent evt) {
        abreClienteVIEW();
    }

    private void itemMenuVendaActionPerformed(java.awt.event.ActionEvent evt) {
        abreVendaVIEW();
    }

    private void itemMenuFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {
        abreFuncionarioVIEW();
    }
    
    private void itemMenuRelatClienteActionPerformed(java.awt.event.ActionEvent evt) {
    	geraRelatorioCliente();
    }
    
    private void itemMenuRelatFornecedorActionPerformed(java.awt.event.ActionEvent evt) {
    	geraRelatorioFornecedor();
    }
    
    private void itemMenuRelatFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {
    	geraRelatorioFuncionario();
    }
    
    private void itemMenuRelatProdutoActionPerformed(java.awt.event.ActionEvent evt) {
    	geraRelatorioProduto();
    }
    
    private void itemMenuRelatVendaActionPerformed(java.awt.event.ActionEvent evt) {
    	geraRelatorioVenda();
    }
    
    /**
     * Método para fechar o sistema.
     */ 
    private void sair(){
        Object[] options = { "Sair", "Cancelar" };
        if(JOptionPane.showOptionDialog(null, "Deseja Sair do Sistema?", "Informação", 
                JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]) == 0){
            System.exit(0);
        } 
    } 
      
    /**
     * Método para abrir a classe ClienteVIEW.
     */
    private void abreClienteVIEW(){
        ClienteVIEW clienteVIEW = new ClienteVIEW();
        this.desktopPane.add(clienteVIEW);
        clienteVIEW.setVisible(true); 
        clienteVIEW.setPosicao();
    }
    
    /**
     * Método para abrir a classe FornecedorVIEW.
     */
    private void abreFornecedorVIEW(){
        FornecedorVIEW fornecedorVIEW = new FornecedorVIEW();
        this.desktopPane.add(fornecedorVIEW);
        fornecedorVIEW.setVisible(true); 
        fornecedorVIEW.setPosicao();
    }
    
    /**
     * Método para abrir a classe FuncionarioVIEW.
     */
    private void abreFuncionarioVIEW(){
        FuncionarioVIEW funcionarioVIEW = new FuncionarioVIEW();
        this.desktopPane.add(funcionarioVIEW);
        funcionarioVIEW.setVisible(true);
        funcionarioVIEW.setPosicao();
    }
    
    /**
     * Método para abrir a classe ProdutoVIEW.
     */
    private void abreProdutoVIEW(){
        ProdutoVIEW produtoVIEW = new ProdutoVIEW();
        this.desktopPane.add(produtoVIEW);
        produtoVIEW.setVisible(true); 
        produtoVIEW.setPosicao();
    }
       
    /**
     * Método para abrir a classe VendaVIEW.
     */
    private void abreVendaVIEW(){
        VendaVIEW vendaVIEW = new VendaVIEW();
        this.desktopPane.add(vendaVIEW);
        vendaVIEW.setVisible(true); 
        vendaVIEW.setPosicao();
    }
    
    /**
     * Método para abrir a classe BackupVIEW.
     */
    private void abreBackupVIEW(){
        BackupVIEW backupVIEW = new BackupVIEW();
        this.desktopPane.add(backupVIEW);
        backupVIEW.setVisible(true); 
        backupVIEW.setPosicao();
    }
    
    /**
     * Método para gerar relatório de Clientes.
     */
    private void geraRelatorioCliente() {
		if(JOptionPane.showConfirmDialog(null, "Deseja Realmente Gerar um Relatório de Clientes?","Aviso", 
				JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
			relatorioCTR.gerarRelatorio("Clientes");
		}
    }
    
    /**
     * Método para gerar relatório de Fornecedores.
     */
    private void geraRelatorioFornecedor() {
		if(JOptionPane.showConfirmDialog(null, "Deseja Realmente Gerar um Relatório de Fornecedores?","Aviso", 
				JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
			relatorioCTR.gerarRelatorio("Fornecedores");
		}
    }
    
    /**
     * Método para gerar relatório de Funcionários.
     */
    private void geraRelatorioFuncionario() {
		if(JOptionPane.showConfirmDialog(null, "Deseja Realmente Gerar um Relatório de Funcionários?","Aviso", 
				JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
			relatorioCTR.gerarRelatorio("Funcionarios");
		}
    }
    
    /**
     * Método para gerar relatório de Produtos.
     */
    private void geraRelatorioProduto() {
		if(JOptionPane.showConfirmDialog(null, "Deseja Realmente Gerar um Relatório de Produtos?","Aviso", 
				JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
			relatorioCTR.gerarRelatorio("Produtos");
		}
    }
    
    /**
     * Método para gerar relatório de Vendas.
     */
    private void geraRelatorioVenda() {
		if(JOptionPane.showConfirmDialog(null, "Deseja Realmente Gerar um Relatório de Vendas?","Aviso", 
				JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
			relatorioCTR.gerarRelatorio("Vendas");
		}
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JMenuItem itemMenuCliente;
    private javax.swing.JMenuItem itemMenuFornecedor;
    private javax.swing.JMenuItem itemMenuFuncionario;
    private javax.swing.JMenuItem itemMenuProduto;
    private javax.swing.JMenuItem itemMenuVenda;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenu menuCadastro;
    private javax.swing.JMenu menuSair;
    private javax.swing.JMenu menuVenda;
    private javax.swing.JMenu menuRelatorio;
    private javax.swing.JMenuItem itemMenuRelatCliente;
    private javax.swing.JMenuItem itemMenuRelatFornecedor;
    private javax.swing.JMenuItem itemMenuRelatFuncionario;
    private javax.swing.JMenuItem itemMenuRelatProduto;
    private javax.swing.JMenuItem itemMenuRelatVenda;
    private javax.swing.JMenu menuBackup;
}