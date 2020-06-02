
package GUI;

import java.util.logging.Level;
import java.util.logging.Logger;


public class frmPrincipal extends javax.swing.JFrame {

    
    public frmPrincipal() {
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jdpCadastro = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        mitCadastro = new javax.swing.JMenuItem();
        menuSair = new javax.swing.JMenu();
        mitSair = new javax.swing.JMenuItem();
        mitRegDel = new javax.swing.JMenuItem();

        jMenu1.setText("jMenu1");

        jMenu2.setText("jMenu2");

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("PRINCIPAL");

        jdpCadastro.setBackground(new java.awt.Color(153, 153, 255));

        javax.swing.GroupLayout jdpCadastroLayout = new javax.swing.GroupLayout(jdpCadastro);
        jdpCadastro.setLayout(jdpCadastroLayout);
        jdpCadastroLayout.setHorizontalGroup(
            jdpCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 792, Short.MAX_VALUE)
        );
        jdpCadastroLayout.setVerticalGroup(
            jdpCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 389, Short.MAX_VALUE)
        );

        jMenu3.setText("CADASTRO");

        mitCadastro.setText("CLIENTES");
        mitCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mitCadastroActionPerformed(evt);
            }
        });
        jMenu3.add(mitCadastro);

        jMenuBar1.add(jMenu3);

        menuSair.setText("OPÇÕES");

        mitSair.setText("SAIR");
        mitSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mitSairActionPerformed(evt);
            }
        });
        menuSair.add(mitSair);

        mitRegDel.setText("TABELA DE REGISTROS DELETADOS");
        mitRegDel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mitRegDelActionPerformed(evt);
            }
        });
        menuSair.add(mitRegDel);

        jMenuBar1.add(menuSair);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jdpCadastro)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jdpCadastro, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mitSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitSairActionPerformed
       
        System.exit(0);
        
    }//GEN-LAST:event_mitSairActionPerformed

    private void mitCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitCadastroActionPerformed
        frmCadClientes frm = null;
        try {
            frm = new frmCadClientes();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(frmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        frm.setVisible(true);
        jdpCadastro.add(frm);
                
    }//GEN-LAST:event_mitCadastroActionPerformed

    private void mitRegDelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitRegDelActionPerformed
         jfrmDel jdel = null;
        try {
            jdel = new jfrmDel();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(frmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        jdel.setVisible(true);
        jdpCadastro.add(jdel);
        
    }//GEN-LAST:event_mitRegDelActionPerformed

    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JDesktopPane jdpCadastro;
    private javax.swing.JMenu menuSair;
    private javax.swing.JMenuItem mitCadastro;
    private javax.swing.JMenuItem mitRegDel;
    private javax.swing.JMenuItem mitSair;
    // End of variables declaration//GEN-END:variables
}
