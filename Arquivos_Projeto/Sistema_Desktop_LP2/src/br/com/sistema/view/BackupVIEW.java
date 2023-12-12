package br.com.sistema.view;

import java.awt.EventQueue;
import java.util.ArrayList;
import javax.swing.JInternalFrame;
import javax.swing.JButton;
import java.awt.Dimension;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import br.com.sistema.ctr.BackupCTR;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class BackupVIEW extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private BackupCTR backupCTR;
	ArrayList<String> arquivosBackup;
	String[] nomesBackup;
	private String itemSelecionado;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BackupVIEW frame = new BackupVIEW();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public BackupVIEW() {
		setTitle("Backup");
		setBounds(100, 100, 741, 359);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(48, 30, 633, 234);
		getContentPane().add(scrollPane);
		
		backupCTR = new BackupCTR();
		arquivosBackup = new ArrayList<>();
		arquivosBackup = backupCTR.listarArquivos();
		nomesBackup = arquivosBackup.toArray(new String[arquivosBackup.size()]);
		
		JList list = new JList();
		list.setListData(nomesBackup);
		
		scrollPane.setViewportView(list);
		
		JButton btnRealizarBackup = new JButton("Realizar Backup");
		btnRealizarBackup.setIcon(new ImageIcon(BackupVIEW.class.getResource("/br/com/sistema/view/imagens/backup.png")));
		btnRealizarBackup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			       if(JOptionPane.showConfirmDialog(null, "Deseja Realmente Realizar um Backup?","Aviso", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
			    	backupCTR.gerarBackup();
					arquivosBackup = backupCTR.listarArquivos();
					nomesBackup = arquivosBackup.toArray(new String[arquivosBackup.size()]);
					list.setListData(nomesBackup);
					revalidate();
					repaint();
				}
			}
		});
		btnRealizarBackup.setBounds(101, 279, 160, 35);
		getContentPane().add(btnRealizarBackup);
		
		JButton btnRestaurarBackup = new JButton("Restaurar Backup");
		btnRestaurarBackup.setEnabled(false);
		btnRestaurarBackup.setIcon(new ImageIcon(BackupVIEW.class.getResource("/br/com/sistema/view/imagens/restaurar.png")));
		btnRestaurarBackup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Deseja Realmente Restaurar o Backup?","Aviso", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
					try {
						backupCTR.restaurarBackup(itemSelecionado);
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnRestaurarBackup.setBounds(297, 279, 161, 35);
		getContentPane().add(btnRestaurarBackup);
		
		list.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if(!e.getValueIsAdjusting()) {
					if(list.getSelectedIndex() == -1) {
						list.setSelectedIndex(e.getFirstIndex());						
					}
					itemSelecionado = ((JList<String>)e.getSource()).getSelectedValue();
					if(itemSelecionado != null) {
						btnRestaurarBackup.setEnabled(true);
					}
				}
			}
		});
		
		JButton btnSair = new JButton();
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnSairActionPerformed(evt);
			}
		});
		btnSair.setIcon(new ImageIcon(BackupVIEW.class.getResource("/br/com/sistema/view/imagens/sair.png")));
		btnSair.setText("Sair");
		btnSair.setEnabled(true);
		btnSair.setBounds(496, 279, 113, 35);
		getContentPane().add(btnSair);
		
		JLabel lblBackup = new JLabel();
		lblBackup.setText("Backup");
		lblBackup.setHorizontalAlignment(SwingConstants.CENTER);
		lblBackup.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblBackup.setBounds(0, 7, 732, 17);
		getContentPane().add(lblBackup);
	}
	
    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {
        this.dispose();
    }
	
    public void setPosicao() {
        Dimension d = this.getDesktopPane().getSize();
        this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2); 
    }
}