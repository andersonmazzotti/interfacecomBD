/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.telas;

import br.senac.conexaoBD.conexao;
import java.sql.*;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;


/**
 *
 * @author anderson.mazzotti
 */
public class frm_cadastro_usuario extends javax.swing.JFrame {

    Connection Conexao = null;
    PreparedStatement ps = null; // Prepara a Consulta para 
    ResultSet rs = null;

    /**
     * Creates new form frm_cadastro_usuario
     */
    public frm_cadastro_usuario() {
        initComponents();

        Conexao = conexao.Conector();

    }

    private void adicionar() {
        String sql = "insert into usuarios(nome_usuario, telefone, login, senha) values(?,?,?,?)";
        try {
            ps = Conexao.prepareStatement(sql);
            ps.setString(1, txtnome.getText());
            ps.setString(2, txtfone.getText());
            ps.setString(3, txtlogin.getText());
            ps.setString(4, txtsenha.getText());

            if (txtnome.getText().isEmpty() || txtlogin.getText().isEmpty() || txtsenha.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, " Nome, Login e Senha são obrigatorios!");
            } else {
                int adicionado = ps.executeUpdate();
                if (adicionado > 0) {
                    JOptionPane.showMessageDialog(null, "Usuario add com sucesso!");    
                    txtnome.setText(null);
                    txtfone.setText(null);
                    txtlogin.setText(null);
                    txtsenha.setText(null);
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }
    
    
     private void pesquisar() {
        String sql = "select * from usuarios where nome_usuario like ?";
         try {
             ps = Conexao.prepareStatement(sql);
             ps.setString(1, txtbuscar.getText()+"%");
             rs = ps.executeQuery();
             tb_lista.setModel(DbUtils.resultSetToTableModel(rs));
             
         } catch (Exception e) {
              JOptionPane.showMessageDialog(null, e);
         }
         }
    
    
    private void carregaCampos(){
        int carregar = tb_lista.getSelectedRow();
        txt_id.setText(tb_lista.getModel().getValueAt(carregar,0).toString());
        txtnome.setText(tb_lista.getModel().getValueAt(carregar,1).toString());
        txtfone.setText(tb_lista.getModel().getValueAt(carregar,2).toString());
        txtlogin.setText(tb_lista.getModel().getValueAt(carregar,3).toString());
        txtsenha.setText(tb_lista.getModel().getValueAt(carregar,4).toString());
    }
    

    private void carregaDadosJaCadastrados() {

        String sql = "select * from usuarios ";
         try {
             ps = Conexao.prepareStatement(sql);
             
             rs = ps.executeQuery();
             tb_lista.setModel(DbUtils.resultSetToTableModel(rs));
             
         } catch (Exception e) {
              JOptionPane.showMessageDialog(null, e);
         }


}
    
    
       private void alterarDados() {
         
           String sql = "update usuarios set nome_usuario=?, telefone=?, login=?, senha=? where id_usuario =? ";
         try {
             ps = Conexao.prepareStatement(sql);
             ps.setString(1, txtnome.getText());
             ps.setString(2, txtfone.getText());
             ps.setString(3, txtlogin.getText());
             ps.setString(4, txtsenha.getText());
             ps.setString(5, txt_id.getText());
             
             int adicionado = ps.executeUpdate();
             
             if (adicionado>0) {
              JOptionPane.showMessageDialog(null, "Dados Alterados");
                    txt_id.setText(null);
                    txtnome.setText(null);
                    txtfone.setText(null);
                    txtlogin.setText(null);
                    txtsenha.setText(null);
              
             }
             
             
         } catch (Exception e) {
              JOptionPane.showMessageDialog(null, e);
         }
       
       
       }
       
       
        private void remover() {
       
            int confirma = JOptionPane.showConfirmDialog(null, "Tem Certeza?", "Atenção", JOptionPane.YES_NO_OPTION);
            
            
            
            if (confirma==JOptionPane.YES_OPTION) {
            
            String sql = " delete from usuarios where id_usuario=?";
            
            
            try {
                
                ps = Conexao.prepareStatement(sql);
                ps.setString(1, txt_id.getText());
                
                int apagado = ps.executeUpdate();
                
                
                if (apagado>0) {
                 JOptionPane.showMessageDialog(null, "Usuario Apagado");
                    txt_id.setText(null);
                    txtnome.setText(null);
                    txtfone.setText(null);
                    txtlogin.setText(null);
                    txtsenha.setText(null);
                }
                
                
                
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        
            }
        }
       
       
       
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_id = new javax.swing.JTextField();
        txtnome = new javax.swing.JTextField();
        txtlogin = new javax.swing.JTextField();
        txtsenha = new javax.swing.JTextField();
        txtbuscar = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_lista = new javax.swing.JTable();
        btninserir = new javax.swing.JButton();
        btnremover = new javax.swing.JButton();
        btnalterar = new javax.swing.JButton();
        txtfone = new javax.swing.JFormattedTextField();
        btnir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("Cadastro:");

        jLabel2.setText("Nome:");

        jLabel3.setText("Telefone:");

        jLabel4.setText("Login:");

        jLabel5.setText("Senha:");

        txt_id.setEditable(false);

        txtbuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtbuscarKeyReleased(evt);
            }
        });

        jLabel6.setText("Pesquisar:");

        tb_lista.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "Login"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tb_lista.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_listaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tb_lista);

        btninserir.setText("Inserir");
        btninserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btninserirActionPerformed(evt);
            }
        });

        btnremover.setText("Remover");
        btnremover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnremoverActionPerformed(evt);
            }
        });

        btnalterar.setText("Alterar");
        btnalterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnalterarActionPerformed(evt);
            }
        });

        try {
            txtfone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)#.####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        btnir.setText("ir");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btninserir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnremover)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnalterar)
                .addGap(138, 138, 138))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtnome, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtlogin)
                            .addComponent(txtfone, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
                            .addComponent(txtsenha)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnir))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtnome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtfone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtlogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtsenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btninserir)
                    .addComponent(btnremover)
                    .addComponent(btnalterar))
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(btnir))
                .addGap(48, 48, 48)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 71, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btninserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btninserirActionPerformed
        // TODO add your handling code here:
        adicionar();
        
    }//GEN-LAST:event_btninserirActionPerformed

    private void txtbuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbuscarKeyReleased

        pesquisar();

        // TODO add your handling code here:
    }//GEN-LAST:event_txtbuscarKeyReleased

    private void tb_listaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_listaMouseClicked
        // TODO add your handling code here:
        carregaCampos();
        
        
    }//GEN-LAST:event_tb_listaMouseClicked

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        
        carregaDadosJaCadastrados();
        
    }//GEN-LAST:event_formWindowOpened

    private void btnalterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnalterarActionPerformed
        // TODO add your handling code here:
        
        alterarDados();
        
    }//GEN-LAST:event_btnalterarActionPerformed

    private void btnremoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnremoverActionPerformed
        // TODO add your handling code here:
        
        remover();
        
    }//GEN-LAST:event_btnremoverActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frm_cadastro_usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_cadastro_usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_cadastro_usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_cadastro_usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frm_cadastro_usuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnalterar;
    private javax.swing.JButton btninserir;
    private javax.swing.JButton btnir;
    private javax.swing.JButton btnremover;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tb_lista;
    private javax.swing.JTextField txt_id;
    private javax.swing.JTextField txtbuscar;
    private javax.swing.JFormattedTextField txtfone;
    private javax.swing.JTextField txtlogin;
    private javax.swing.JTextField txtnome;
    private javax.swing.JTextField txtsenha;
    // End of variables declaration//GEN-END:variables
}
