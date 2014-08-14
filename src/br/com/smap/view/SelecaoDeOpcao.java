/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.smap.view;

import br.com.smap.persistencia.MantelHaenszelImplements;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;

/**
 *
 * @author Ederson
 */
public class SelecaoDeOpcao extends javax.swing.JFrame {

    /**
     * Creates new form SelecaoDeOpcao
     */
    public SelecaoDeOpcao() {
        initComponents();
        grupoRadioBotao();
        selectOpc95();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelPrincipal = new javax.swing.JPanel();
        btRadio90 = new javax.swing.JRadioButton();
        btRadio95 = new javax.swing.JRadioButton();
        btRadio99 = new javax.swing.JRadioButton();
        btSalvar = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btRadio90.setText("90%");
        btRadio90.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRadio90ActionPerformed(evt);
            }
        });

        btRadio95.setText("95%");
        btRadio95.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRadio95ActionPerformed(evt);
            }
        });

        btRadio99.setText("99%");
        btRadio99.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRadio99ActionPerformed(evt);
            }
        });

        btSalvar.setText("Salvar");
        btSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarActionPerformed(evt);
            }
        });

        btCancelar.setText("Cancelar");
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelPrincipalLayout = new javax.swing.GroupLayout(painelPrincipal);
        painelPrincipal.setLayout(painelPrincipalLayout);
        painelPrincipalLayout.setHorizontalGroup(
            painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelPrincipalLayout.createSequentialGroup()
                .addContainerGap(60, Short.MAX_VALUE)
                .addGroup(painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelPrincipalLayout.createSequentialGroup()
                        .addGroup(painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btRadio90)
                            .addComponent(btRadio95)
                            .addComponent(btRadio99))
                        .addGap(92, 92, 92))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelPrincipalLayout.createSequentialGroup()
                        .addComponent(btSalvar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btCancelar)
                        .addGap(57, 57, 57))))
        );
        painelPrincipalLayout.setVerticalGroup(
            painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btRadio90)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btRadio95)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btRadio99)
                .addGap(18, 18, 18)
                .addGroup(painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btSalvar)
                    .addComponent(btCancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btRadio90ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRadio90ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btRadio90ActionPerformed

    private void btRadio95ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRadio95ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btRadio95ActionPerformed

    private void btRadio99ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRadio99ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btRadio99ActionPerformed

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
        if (btRadio90.isSelected()) {
            MantelHaenszelImplements.setValorZ(1.64485362695147);
            MantelHaenszelImplements.setPorcentagem(90);
        } else if (btRadio95.isSelected()) {
            MantelHaenszelImplements.setValorZ(1.95996398454005);
            MantelHaenszelImplements.setPorcentagem(95);
        } else if (btRadio99.isSelected()) {
            MantelHaenszelImplements.setValorZ(2.57582930354890);
            MantelHaenszelImplements.setPorcentagem(95);
        } else {
            JOptionPane.showMessageDialog(this, "POR FAVOR SELECIONE UMA DAS OPÇÕES.");
        }
        dispose();
    }//GEN-LAST:event_btSalvarActionPerformed

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btCancelarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCancelar;
    private javax.swing.JRadioButton btRadio90;
    private javax.swing.JRadioButton btRadio95;
    private javax.swing.JRadioButton btRadio99;
    private javax.swing.JButton btSalvar;
    private javax.swing.JPanel painelPrincipal;
    // End of variables declaration//GEN-END:variables
    private void grupoRadioBotao() {
        ButtonGroup bt = new ButtonGroup();
        bt.add(btRadio90);
        bt.add(btRadio95);
        bt.add(btRadio99);
    }

    public void selectOpc95() {

        if (MantelHaenszelImplements.getPorcentagem() == 0) {
            btRadio95.setSelected(true);
            MantelHaenszelImplements.setPorcentagem(95);
            MantelHaenszelImplements.setValorZ(1.95996398454005);
        } else if (MantelHaenszelImplements.getPorcentagem() == 90) {
            btRadio90.setSelected(true);
            MantelHaenszelImplements.setPorcentagem(90);
            MantelHaenszelImplements.setValorZ(1.64485362695147);
        } else if (MantelHaenszelImplements.getPorcentagem() == 95) {
            btRadio95.setSelected(true);
            MantelHaenszelImplements.setPorcentagem(95);
            MantelHaenszelImplements.setValorZ(1.95996398454005);
        } else if (MantelHaenszelImplements.getPorcentagem() == 99) {
            btRadio95.setSelected(true);
            MantelHaenszelImplements.setPorcentagem(99);
            MantelHaenszelImplements.setValorZ(2.57582930354890);
        }
    }

}