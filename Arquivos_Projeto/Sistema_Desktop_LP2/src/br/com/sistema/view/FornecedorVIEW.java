package br.com.sistema.view;

import java.awt.Dimension;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;
import br.com.sistema.ctr.FornecedorCTR;
import br.com.sistema.dto.FornecedorDTO;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.GroupLayout;

public class FornecedorVIEW extends javax.swing.JInternalFrame {
    FornecedorDTO fornecedorDTO = new FornecedorDTO(); 
    FornecedorCTR fornecedorCTR = new FornecedorCTR(); 
    
    int gravar_alterar; 
        
    ResultSet rs;
    DefaultTableModel modelo_jtl_consultar_fornecedor; 

    public FornecedorVIEW() {
        initComponents();
        liberaCampos(false);
        liberaBotoes(true, false, false, false, true);
        modelo_jtl_consultar_fornecedor = (DefaultTableModel) jtl_consultar_fornecedor.getModel();
    }

       @SuppressWarnings("unchecked")
    private void initComponents() {

        nome_for = new javax.swing.JTextField();
        cnpj_for = new javax.swing.JTextField();
        tel_for = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnNovo = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        btnSalvar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        pesquisa_nome = new javax.swing.JTextField();
        btnPesquisar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtl_consultar_fornecedor = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Fornecedor");

        nome_for.setNextFocusableComponent(cnpj_for);

        cnpj_for.setNextFocusableComponent(tel_for);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); 
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Fornecedor");

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Nome:");

        btnNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sistema/view/imagens/novo.png"))); 
        btnNovo.setText("Novo");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("CNPJ:");

        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel15.setText("Telefone:");

        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sistema/view/imagens/salvar.png"))); 
        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sistema/view/imagens/cancelar.png"))); 
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sistema/view/imagens/excluir.png"))); 
        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sistema/view/imagens/sair.png")));
        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Nome:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); 
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Consulta");

        btnPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sistema/view/imagens/pesquisar.png"))); 
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        jtl_consultar_fornecedor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtl_consultar_fornecedor.getTableHeader().setReorderingAllowed(false);
        jtl_consultar_fornecedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtl_consultar_fornecedorMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtl_consultar_fornecedor);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(layout.createSequentialGroup()
        					.addContainerGap()
        					.addGroup(layout.createParallelGroup(Alignment.LEADING)
        						.addGroup(layout.createSequentialGroup()
        							.addGap(2)
        							.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        								.addComponent(jLabel8)
        								.addComponent(jLabel4)
        								.addComponent(jLabel15))
        							.addPreferredGap(ComponentPlacement.RELATED)
        							.addGroup(layout.createParallelGroup(Alignment.LEADING, false)
        								.addComponent(cnpj_for, GroupLayout.PREFERRED_SIZE, 208, GroupLayout.PREFERRED_SIZE)
        								.addComponent(tel_for, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
        								.addComponent(nome_for, GroupLayout.PREFERRED_SIZE, 403, GroupLayout.PREFERRED_SIZE))
        							.addPreferredGap(ComponentPlacement.RELATED)
        							.addGroup(layout.createParallelGroup(Alignment.LEADING)
        								.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 257, GroupLayout.PREFERRED_SIZE)
        								.addGroup(layout.createSequentialGroup()
        									.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        										.addGroup(layout.createSequentialGroup()
        											.addComponent(jLabel5)
        											.addPreferredGap(ComponentPlacement.RELATED)
        											.addComponent(pesquisa_nome, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE)
        											.addGap(0, 0, Short.MAX_VALUE))
        										.addGroup(layout.createSequentialGroup()
        											.addGap(0, 81, Short.MAX_VALUE)
        											.addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)))
        									.addPreferredGap(ComponentPlacement.RELATED)
        									.addComponent(btnPesquisar, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
        									.addGap(14))))
        						.addComponent(jLabel1, GroupLayout.DEFAULT_SIZE, 730, Short.MAX_VALUE)))
        				.addGroup(layout.createSequentialGroup()
        					.addGap(71)
        					.addComponent(btnNovo, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(btnSalvar, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(btnCancelar, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(btnExcluir, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(btnSair, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)))
        			.addContainerGap())
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(jLabel1)
        			.addGap(16)
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(layout.createSequentialGroup()
        					.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        						.addComponent(btnPesquisar)
        						.addGroup(layout.createSequentialGroup()
        							.addComponent(jLabel2)
        							.addPreferredGap(ComponentPlacement.UNRELATED)
        							.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        								.addComponent(jLabel5)
        								.addComponent(pesquisa_nome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE))
        				.addGroup(layout.createSequentialGroup()
        					.addGap(28)
        					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(jLabel4)
        						.addComponent(nome_for, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(jLabel8)
        						.addComponent(cnpj_for, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(jLabel15)
        						.addComponent(tel_for, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        					.addGap(0, 102, Short.MAX_VALUE)))
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(btnNovo)
        				.addComponent(btnSalvar)
        				.addComponent(btnCancelar)
        				.addComponent(btnExcluir)
        				.addComponent(btnSair))
        			.addContainerGap(22, Short.MAX_VALUE))
        );
        getContentPane().setLayout(layout);

        pack();
    }

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {
        liberaCampos(true);
        liberaBotoes(false, true, true, false, true);
        gravar_alterar = 1;
    }

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {
        if(gravar_alterar == 1){
            gravar();
            gravar_alterar = 0;
        }
        else{
            if(gravar_alterar == 2){
                alterar();
                gravar_alterar = 0;
            }
            else{
                JOptionPane.showMessageDialog(null, "Erro no Sistema!!!");
            }
        }
          
        limpaCampos();
        liberaCampos(false);
        liberaBotoes(true, false, false, false, true);       
    }

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {
        preencheTabela(pesquisa_nome.getText());     
    }

    private void jtl_consultar_fornecedorMouseClicked(java.awt.event.MouseEvent evt) { 
        preencheCampos(Integer.parseInt(String.valueOf(
                jtl_consultar_fornecedor.getValueAt(
                jtl_consultar_fornecedor.getSelectedRow(), 0))));
        liberaBotoes(false, true, true, true, true);
    }

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {
        excluir();
        limpaCampos();
        liberaCampos(false);
        liberaBotoes(true, false, false, false, true);
        modelo_jtl_consultar_fornecedor.setNumRows(0);
    }

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {
        limpaCampos();
        liberaCampos(false);
        modelo_jtl_consultar_fornecedor.setNumRows(0);
        liberaBotoes(true, false, false, false, true);
        gravar_alterar=0;
    }

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {
        this.dispose();
    }

    /**
     * Método para centralizar o internalFrame.
     */
    public void setPosicao() {
        Dimension d = this.getDesktopPane().getSize();
        this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2); 
    }   
    
    /**
     * Método utilizado para gravar os dados do fornecedor.
     */
    private void gravar(){
        try{
            fornecedorDTO.setNome_for(nome_for.getText());
            fornecedorDTO.setCnpj_for(cnpj_for.getText());
            fornecedorDTO.setTel_for(tel_for.getText());
           
            JOptionPane.showMessageDialog(null,
                    fornecedorCTR.inserirFornecedor(fornecedorDTO)
            );
        }
        catch(Exception e){
            System.out.println("Erro ao Gravar" + e.getMessage());
        }
    }    
    
    /**
     * Método utilizado para alterar os dados do fornecedor.
     */
    private void alterar(){
        try{
            fornecedorDTO.setNome_for(nome_for.getText());
            fornecedorDTO.setCnpj_for(cnpj_for.getText());
            fornecedorDTO.setTel_for(tel_for.getText());
            
            JOptionPane.showMessageDialog(null,
                    fornecedorCTR.alterarFornecedor(fornecedorDTO)
            );
        }
        catch(Exception e){
            System.out.println("Erro ao Alterar" + e.getMessage());
        }
    }   
    
    /**
     * Método utilizado para excluir os dados do fornecedor.
     */
    private void excluir(){
       if(JOptionPane.showConfirmDialog(null, "Deseja Realmente excluir o Fornecedor?","Aviso", 
            JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
            JOptionPane.showMessageDialog(null,
                    fornecedorCTR.excluirFornecedor(fornecedorDTO)
            );
       }
    }        
    
    /**
     * Método utilizado para liberar/bloquear os campos da tela.
     * @param a, boolean com true(libera) false(bloqueia).
     */
    private void liberaCampos(boolean a){
        nome_for.setEnabled(a);
        cnpj_for.setEnabled(a);
        tel_for.setEnabled(a);
    }   
    
    /**
     * Método utilizado para liberar os botões da tela.
     * @param a, boolean com true(libera) false(bloqueia) para o btnNovo.
     * @param b, boolean com true(libera) false(bloqueia) para o btnSalvar.
     * @param c, boolean com true(libera) false(bloqueia) para o btnCancelar.
     * @param d, boolean com true(libera) false(bloqueia) para o btnExcluir.
     * @param e, boolean com true(libera) false(bloqueia) para o btnSair.
     */
    private void liberaBotoes(boolean a, boolean b, boolean c, boolean d, boolean e){
        btnNovo.setEnabled(a);
        btnSalvar.setEnabled(b);
        btnCancelar.setEnabled(c);
        btnExcluir.setEnabled(d);
        btnSair.setEnabled(e);
    }   
    
    /**
     * Método utilizado para limpar os campos da tela.
     */
    private void limpaCampos(){
        nome_for.setText("");
        cnpj_for.setText("");
        tel_for.setText("");
    }    
    
    /**
     * Método utilizado para preencher/contruir a Jtable.
     * @param nome_for, String com o nome do fornecedor
     */
    private void preencheTabela(String nome_for){
        try{
            modelo_jtl_consultar_fornecedor.setNumRows(0);
            fornecedorDTO.setNome_for(nome_for);
            rs = fornecedorCTR.consultarFornecedor(fornecedorDTO, 1); 
            while(rs.next()){
                modelo_jtl_consultar_fornecedor.addRow(new Object[]{
                  rs.getString("id_for"),
                  rs.getString("nome_for"),
                });
            }        
        }
        catch(Exception erTab){
            System.out.println("Erro SQL: "+erTab);
        } 
        finally{
            fornecedorCTR.CloseDB();
        }
    }
    
    /**
     * Método utilizado para preencher os campos da tela com 
     * valores do fornecedor.
     * @param id_for, int com o id do fornecedor.
     */
    private void preencheCampos(int id_for){
        try{
            fornecedorDTO.setId_for(id_for);
            rs = fornecedorCTR.consultarFornecedor(fornecedorDTO, 2);
            if(rs.next()){
                limpaCampos();
                
                nome_for.setText(rs.getString("nome_for"));
                cnpj_for.setText(rs.getString("cnpj_for"));
                tel_for.setText(rs.getString("tel_for"));
                
                gravar_alterar = 2;
                liberaCampos(true);
            }
        }
        catch(Exception erTab){
            System.out.println("Erro SQL: "+erTab);
        }  
        finally{
            fornecedorCTR.CloseDB();
        }
    }
            
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JTextField cnpj_for;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtl_consultar_fornecedor;
    private javax.swing.JTextField nome_for;
    private javax.swing.JTextField pesquisa_nome;
    private javax.swing.JTextField tel_for;
    // End of variables declaration//GEN-END:variables
}