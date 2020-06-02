
package GUI;
import Dao.Conexao;
import java.sql.*;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;


public class jfrmDel extends javax.swing.JInternalFrame {
    Connection conecta;
    PreparedStatement pst;
    ResultSet rs;
   
    public jfrmDel() throws ClassNotFoundException {
        initComponents();
        this.setLocation(200, 100);
        conecta = Conexao.conectar();
        listarDeletados();
    }

public void restaurarReg (){
        String sql = "INSERT INTO public.\"dbCadastro\"(\"Nome\", \"Documento\", \"Endereco\", \"Telefone\", \"Prontuario\",\"Cartao SUS\",\"Data_Nascimento\") VALUES (?,?, ?, ?, ?, ?,?)";
        
        try{
            pst = conecta.prepareStatement(sql);
            
            pst.setString(1,txtNomeDel.getText().trim());
            pst.setString(2,txtDocDel.getText().trim());
            pst.setString(3,txtEndDel.getText().trim());
            pst.setString(4,txtTelDel.getText().trim());
            pst.setString(5,txtProntDel.getText().trim()); 
            pst.setString(6,txtCartSUSDel.getText().trim());
            pst.setString(7,txtDataNascDel.getText().trim());
            
            
            pst.execute();
            
            JOptionPane.showMessageDialog(this, "Registro Restaurado com Sucesso!", "Restaurar Registro",(JOptionPane.INFORMATION_MESSAGE));
            
            
                    
        }catch(SQLException error){
            
            JOptionPane.showMessageDialog(null, error);
            
        }
    }

public void listarDeletados(){
        
        String sql = "SELECT \"Nome\", \"Documento\", \"Endereco\", \"Telefone\", \"Prontuario\",\"Cartao SUS\", \"Data_Nascimento\" FROM public.\"RegDel\"  WHERE \"Nome\" = \"Nome\" ORDER BY \"Nome\" ";
        
        
        try{
            pst = conecta.prepareStatement(sql);
            rs = pst.executeQuery();
            jtbDeletados.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(SQLException error){
            
            JOptionPane.showMessageDialog(null, error);
        }
    }
 public void pesquisarClientesDel(){
        String sql = "SELECT * FROM public.\"RegDel\" WHERE \"Nome\" LIKE ?";
        try{
            
            pst = conecta.prepareStatement(sql);
            pst.setString(1,txtBuscaDel.getText()+"%");            
            rs = pst.executeQuery();
            jtbDeletados.setModel(DbUtils.resultSetToTableModel(rs));
            
        }catch(SQLException error){
            
            JOptionPane.showMessageDialog(null, error);
            
        }
    }
 
  public void mostraItemDel(){
        int seleciona = jtbDeletados.getSelectedRow();
        
        txtNomeDel.setText(jtbDeletados.getModel().getValueAt(seleciona,0).toString());
        txtTelDel.setText(jtbDeletados.getModel().getValueAt(seleciona,3).toString());
        txtEndDel.setText(jtbDeletados.getModel().getValueAt(seleciona,2).toString());
        txtDocDel.setText(jtbDeletados.getModel().getValueAt(seleciona,1).toString());
        txtProntDel.setText(jtbDeletados.getModel().getValueAt(seleciona,4).toString());
        txtCartSUSDel.setText(jtbDeletados.getModel().getValueAt(seleciona,5).toString());
        txtDataNascDel.setText(jtbDeletados.getModel().getValueAt(seleciona,6).toString());
        
        
    }
  
  public void limparCamposDel(){
        
        txtNomeDel.setText(" ");
        txtTelDel.setText(" ");
        txtEndDel.setText(" ");
        txtDocDel.setText(" ");
        txtProntDel.setText(" ");
        txtCartSUSDel.setText(" ");
        txtDataNascDel.setText(" ");
    } 
    
     public void deletarRegDel(){
        
        String sql = "DELETE FROM public.\"RegDel\" WHERE \"Nome\" = ?";
        
        try{
            
            pst = conecta.prepareStatement(sql);
            pst.setString(1,(txtNomeDel.getText()));
            pst.execute();            
                        
            listarDeletados();
            limparCamposDel();
            
        }catch(SQLException error){
            
            JOptionPane.showMessageDialog(null, error);
            
        }
        
    }
       
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jtbDeletados = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtBuscaDel = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtNomeDel = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtProntDel = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtEndDel = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtDataNascDel = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtDocDel = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtTelDel = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtCartSUSDel = new javax.swing.JTextField();
        btnLimparDel = new javax.swing.JButton();
        btnRecupReg = new javax.swing.JButton();
        btnAtualizar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("REGISTROS DELETADOS");

        jtbDeletados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jtbDeletados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbDeletadosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtbDeletados);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("BUSCAR");

        txtBuscaDel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscaDelKeyReleased(evt);
            }
        });

        jLabel2.setText("Nome");

        jLabel3.setText("Prontuário");

        jLabel4.setText("Endereço");

        jLabel5.setText("Data de Nascimento");

        jLabel6.setText("Documento");

        jLabel7.setText("Telefone");

        jLabel8.setText("Cartão SUS");

        btnLimparDel.setText("Limpar Campos");
        btnLimparDel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparDelActionPerformed(evt);
            }
        });

        btnRecupReg.setText("Recuperar Registro");
        btnRecupReg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRecupRegActionPerformed(evt);
            }
        });

        btnAtualizar.setText("Atualizar");
        btnAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(txtBuscaDel))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtProntDel, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtNomeDel))
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtEndDel))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(txtDataNascDel, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtDocDel, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtTelDel, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addComponent(txtCartSUSDel, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addComponent(btnLimparDel)
                .addGap(51, 51, 51)
                .addComponent(btnRecupReg)
                .addGap(45, 45, 45)
                .addComponent(btnAtualizar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscaDel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNomeDel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtProntDel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtEndDel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtDataNascDel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txtDocDel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(txtTelDel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(txtCartSUSDel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLimparDel)
                    .addComponent(btnRecupReg)
                    .addComponent(btnAtualizar))
                .addGap(38, 38, 38))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtBuscaDelKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscaDelKeyReleased
       pesquisarClientesDel();
    }//GEN-LAST:event_txtBuscaDelKeyReleased

    private void jtbDeletadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbDeletadosMouseClicked
        mostraItemDel();
    }//GEN-LAST:event_jtbDeletadosMouseClicked

    private void btnLimparDelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparDelActionPerformed
        limparCamposDel();
    }//GEN-LAST:event_btnLimparDelActionPerformed

    private void btnRecupRegActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRecupRegActionPerformed
        restaurarReg();
        deletarRegDel();
    }//GEN-LAST:event_btnRecupRegActionPerformed

    private void btnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarActionPerformed
        listarDeletados();
        
    }//GEN-LAST:event_btnAtualizarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtualizar;
    private javax.swing.JButton btnLimparDel;
    private javax.swing.JButton btnRecupReg;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtbDeletados;
    private javax.swing.JTextField txtBuscaDel;
    private javax.swing.JTextField txtCartSUSDel;
    private javax.swing.JTextField txtDataNascDel;
    private javax.swing.JTextField txtDocDel;
    private javax.swing.JTextField txtEndDel;
    private javax.swing.JTextField txtNomeDel;
    private javax.swing.JTextField txtProntDel;
    private javax.swing.JTextField txtTelDel;
    // End of variables declaration//GEN-END:variables
}
