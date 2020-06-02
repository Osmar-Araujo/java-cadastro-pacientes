
package GUI;
import Dao.Conexao;
import java.sql.*;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;
import GUI.jfrmDel;

public class frmCadClientes extends javax.swing.JInternalFrame {

    Connection conecta;
    PreparedStatement pst;
    ResultSet rs;
   
    public frmCadClientes() throws ClassNotFoundException {
        initComponents();
        this.setLocation(0,40);
        conecta = Conexao.conectar();
        listarClientes();
    }
    
    public void cadastrarCliente(){
        String sql = "INSERT INTO public.\"dbCadastro\"(\"Nome\", \"Documento\", \"Endereco\", \"Telefone\", \"Prontuario\",\"Cartao SUS\",\"Data_Nascimento\") VALUES (?,?, ?, ?, ?, ?,?)";
        
        try{
            pst = conecta.prepareStatement(sql);
            
            
            pst.setString(1,txtNome.getText().trim());
            pst.setString(2,txtDocumento.getText().trim());
            pst.setString(3,txtEndereco.getText().trim());
            pst.setString(4,txtTelefone.getText().trim());
            pst.setString(5,txtProntuario.getText().trim()); 
            pst.setString(6,txtCartaoSUS.getText().trim());
            pst.setString(7,txtDataNascimento.getText().trim());
            
            
            pst.execute();
            
            JOptionPane.showMessageDialog(this, "Cadastro Realizado com Sucesso!", "CADASTRO",(JOptionPane.INFORMATION_MESSAGE));
            
            listarClientes();
            limparCampos();
                    
        }catch(SQLException error){
            
            JOptionPane.showMessageDialog(null, error);
            
        }
    }
    
    public void listarClientes(){
        
        String sql = "SELECT \"Nome\", \"Documento\", \"Endereco\", \"Telefone\", \"Prontuario\", \"Cliente ID\",\"Cartao SUS\", \"Data_Nascimento\" FROM public.\"dbCadastro\"  WHERE \"Cliente ID\" = \"Cliente ID\" ORDER BY \"Nome\" ";
        
        
        try{
            pst = conecta.prepareStatement(sql);
            rs = pst.executeQuery();
            jtbCadastro.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(SQLException error){
            
            JOptionPane.showMessageDialog(null, error);
        }
    }
    
    public void pesquisarClientes(){
        String sql = "SELECT * FROM public.\"dbCadastro\" WHERE \"Nome\" LIKE ?";
        try{
            
            pst = conecta.prepareStatement(sql);
            pst.setString(1,txtBuscar.getText()+"%");            
            rs = pst.executeQuery();
            jtbCadastro.setModel(DbUtils.resultSetToTableModel(rs));
            
        }catch(SQLException error){
            
            JOptionPane.showMessageDialog(null, error);
            
        }
    }
    
    public void mostraItem(){
        int seleciona = jtbCadastro.getSelectedRow();
        txtCodigo.setText(jtbCadastro.getModel().getValueAt(seleciona,5).toString());
        txtNome.setText(jtbCadastro.getModel().getValueAt(seleciona,0).toString());
        txtTelefone.setText(jtbCadastro.getModel().getValueAt(seleciona,3).toString());
        txtEndereco.setText(jtbCadastro.getModel().getValueAt(seleciona,2).toString());
        txtDocumento.setText(jtbCadastro.getModel().getValueAt(seleciona,1).toString());
        txtProntuario.setText(jtbCadastro.getModel().getValueAt(seleciona,4).toString());
        txtCartaoSUS.setText(jtbCadastro.getModel().getValueAt(seleciona,6).toString());
        txtDataNascimento.setText(jtbCadastro.getModel().getValueAt(seleciona,7).toString());
        
        
    }
    
    public void limparCampos(){
        txtCodigo.setText(" ");
        txtNome.setText(" ");
        txtTelefone.setText(" ");
        txtEndereco.setText(" ");
        txtDocumento.setText(" ");
        txtProntuario.setText(" ");
        txtCartaoSUS.setText(" ");
        txtDataNascimento.setText(" ");
        
    }
    
    public void editarClientes(){
        
        String sql = "UPDATE public.\"dbCadastro\" SET \"Nome\"=?, "
                + "\"Documento\"=?, \"Endereco\"=?, \"Telefone\"=?, \"Prontuario\"=?, \"Cartao SUS\"= ?, \"Data_Nascimento\"=?  WHERE \"Cliente ID\" = ?";
        
        try{
                        
            pst = conecta.prepareStatement(sql);
            
            pst.setString(1,txtNome.getText());
            pst.setString(2,txtDocumento.getText());
            pst.setString(3,txtEndereco.getText());
            pst.setString(4,txtTelefone.getText());
            pst.setString(5,txtProntuario.getText());
            pst.setString(6,txtCartaoSUS.getText());
            pst.setInt(8,Integer.parseInt(txtCodigo.getText()));
            pst.setString(7,txtDataNascimento.getText());
            
            pst.executeUpdate();
            
            JOptionPane.showMessageDialog(null,"Alteração Realizada com Sucesso!");
            listarClientes();
            limparCampos();
            
            
        }catch(SQLException error){
            
            JOptionPane.showMessageDialog(null, error);
        }
    }
    
    public void deletarClientes(){
        
        String sql = "DELETE FROM public.\"dbCadastro\" WHERE \"Cliente ID\" = ?";
        
        try{
            
            pst = conecta.prepareStatement(sql);
            pst.setInt(1, Integer.parseInt(txtCodigo.getText()));
            pst.execute();
            
            JOptionPane.showMessageDialog(null,"Cliente Excluído com Sucesso!");
            
            listarClientes();
            limparCampos();            
            
        }catch(SQLException error){
            
            JOptionPane.showMessageDialog(null, error);
            
        }
        
    }   
   
    public void enviarRegDel(){
        String sql = "INSERT INTO public.\"RegDel\"(\"Nome\", \"Documento\", \"Endereco\", \"Telefone\", \"Prontuario\",\"Cartao SUS\",\"Data_Nascimento\") VALUES (?,?, ?, ?, ?, ?,?)";
        
        try{
            pst = conecta.prepareStatement(sql);
            
            pst.setString(1,txtNome.getText().trim());
            pst.setString(2,txtDocumento.getText().trim());
            pst.setString(3,txtEndereco.getText().trim());
            pst.setString(4,txtTelefone.getText().trim());
            pst.setString(5,txtProntuario.getText().trim()); 
            pst.setString(6,txtCartaoSUS.getText().trim());
            pst.setString(7,txtDataNascimento.getText().trim());
            
            
            pst.execute();
            
            JOptionPane.showMessageDialog(this, "Os registros deletados poderão ser recuperados a partir do menu OPÇÃO - TABELA DE REGISTROS DELETADOS", "AVISO!",(JOptionPane.INFORMATION_MESSAGE));
            
                    
        }catch(SQLException error){
            
            JOptionPane.showMessageDialog(null, error);
            
        }
    } 

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jtbCadastro = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtDocumento = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtEndereco = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtProntuario = new javax.swing.JTextField();
        txtTelefone = new javax.swing.JTextField();
        btnCadastro = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnDeletar = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txtCartaoSUS = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtDataNascimento = new javax.swing.JTextField();
        btnAtualizar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("CADASTRO DE CLIENTES");

        jtbCadastro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6"
            }
        ));
        jtbCadastro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbCadastroMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtbCadastro);

        jLabel1.setText("BUSCAR");

        txtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarActionPerformed(evt);
            }
        });
        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });

        jLabel2.setText("CÓDIGO");

        txtCodigo.setBackground(new java.awt.Color(0, 51, 51));
        txtCodigo.setEnabled(false);

        jLabel3.setText("NOME");

        jLabel4.setText("DOCUMENTO");

        jLabel5.setText("ENDEREÇO");

        jLabel6.setText("TELEFONE");

        jLabel7.setText("PRONTUÁRIO");

        btnCadastro.setText("CADASTRAR");
        btnCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastroActionPerformed(evt);
            }
        });

        btnEditar.setText("EDITAR");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnDeletar.setText("DELETAR");
        btnDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeletarActionPerformed(evt);
            }
        });

        btnLimpar.setText("LIMPAR");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        jLabel8.setText("CARTÃO SUS");

        jLabel9.setText("DATA DE NASCIMENTO");

        btnAtualizar.setText("ATUALIZAR");
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
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel5)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtProntuario, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtNome))
                            .addComponent(txtEndereco)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(btnCadastro)
                                .addGap(40, 40, 40)
                                .addComponent(btnEditar)
                                .addGap(42, 42, 42)
                                .addComponent(btnDeletar)
                                .addGap(44, 44, 44)
                                .addComponent(btnLimpar)
                                .addGap(51, 51, 51)
                                .addComponent(btnAtualizar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(28, 28, 28)
                                .addComponent(txtDataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(69, 69, 69)
                                .addComponent(jLabel4)
                                .addGap(47, 47, 47)
                                .addComponent(txtDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38)))
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtCartaoSUS, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(txtBuscar))
                    .addComponent(jScrollPane1)))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnCadastro, btnDeletar, btnEditar, btnLimpar});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtProntuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel4)
                    .addComponent(txtDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(txtCartaoSUS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(txtDataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCadastro)
                    .addComponent(btnEditar)
                    .addComponent(btnDeletar)
                    .addComponent(btnLimpar)
                    .addComponent(btnAtualizar))
                .addGap(44, 44, 44))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnCadastro, btnDeletar, btnEditar, btnLimpar});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed
       
    }//GEN-LAST:event_txtBuscarActionPerformed

    private void btnCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastroActionPerformed
        
        if (txtProntuario.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(null,"O campo Prontuário não está preenchido!");
        
        }else if (txtNome.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(null,"O campo Nome não está preenchido!");
        
        }else if (txtDataNascimento.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(null,"O campo Data Nascimento não está preenchido!");
            
        }else if (txtDocumento.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(null,"O campo Documento não está preenchido!");    
            
        }else if (txtTelefone.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(null,"O campo Telefone não está preenchido!");
            
        }else if (txtCartaoSUS.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(null,"O campo Cartão SUS não está preenchido!");
            
        }       
        else{
            cadastrarCliente();  
        }
    }//GEN-LAST:event_btnCadastroActionPerformed

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
       pesquisarClientes();
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void jtbCadastroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbCadastroMouseClicked
       mostraItem();
    }//GEN-LAST:event_jtbCadastroMouseClicked

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
       
        limparCampos();
    }//GEN-LAST:event_btnLimparActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        
         if (txtNome.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(null,"O campo Nome não está preenchido!");
        
        }else if (txtProntuario.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(null,"O campo Prontuário não está preenchido!");
        
        }else if (txtEndereco.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(null,"O campo Endereço não está preenchido!");
            
        }else if (txtTelefone.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(null,"O campo Telefone não está preenchido!");
            
        }else if (txtDataNascimento.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(null,"O campo Data Nascimento não está preenchido!");
            
        }else if (txtDocumento.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(null,"O campo Documento não está preenchido!");
            
        }else if (txtCartaoSUS.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(null,"O campo Cartão SUS não está preenchido!");
            
        }else{
          editarClientes();   
        }
        
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletarActionPerformed
        enviarRegDel();
        deletarClientes();
    }//GEN-LAST:event_btnDeletarActionPerformed

    private void btnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarActionPerformed
        listarClientes();
    }//GEN-LAST:event_btnAtualizarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtualizar;
    private javax.swing.JButton btnCadastro;
    private javax.swing.JButton btnDeletar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtbCadastro;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtCartaoSUS;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtDataNascimento;
    private javax.swing.JTextField txtDocumento;
    private javax.swing.JTextField txtEndereco;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtProntuario;
    private javax.swing.JTextField txtTelefone;
    // End of variables declaration//GEN-END:variables
}
