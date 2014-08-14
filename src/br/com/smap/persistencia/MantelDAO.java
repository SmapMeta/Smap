/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.smap.persistencia;

import br.com.smap.odds.MantelHaenszel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Ederson
 */
public class MantelDAO {
    private static final String INSERT = "insert into mantel(id, autor, itemColunaA, itemColunaB, itemColunaC, itemColunaD, "
            + "limiteInferior, limiteSuperior, valorPesoPorcento, dor) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

    private static final String DELETE = "DELETE FROM mantel WHERE id > 0";
    
    
    public boolean remove() {
        boolean status = false;
        Connection con = null;
        PreparedStatement pstm = null;
        try {
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(DELETE);
            pstm.execute();
            status = true;
            System.out.println("APAGOU TODA A LISTA.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao excluir: "+ ex.getMessage());
        }
        return status;
    }
    
    public int insere(MantelHaenszel p) {
        Connection con = null;
        PreparedStatement pstm = null;
        int retorno = -1;

        try {
            //(id, autor, itemColunaA, itemColunaB, itemColunaC, itemColunaD, "
            // "limiteInferior, limiteSuperior, valorPesoPorcento)
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            pstm.setInt(1, p.getId());
            pstm.setString(2, p.getAutor());
            pstm.setString(3, Double.toString(p.getItemColunaA()));
            pstm.setString(4, Double.toString(p.getItemColunaB()));
            pstm.setString(5, Double.toString(p.getItemColunaC()));
            pstm.setString(6, Double.toString(p.getItemColunaD()));
            pstm.setString(7, Double.toString(p.getLimiteInferior()));
            pstm.setString(8, Double.toString(p.getLimiteSuperior()));
            pstm.setString(9, Double.toString(p.getValorPesoPorcento()));
            pstm.setString(10, Double.toString(p.getDor()));
            pstm.execute();
            try (ResultSet rs = pstm.getGeneratedKeys()) {
                if (rs.next()) {
                    retorno = rs.getInt(1);
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir paciente: " + ex.getMessage());
        } finally {
            try {

                ConnectionFactory.closeConnection(con, pstm);

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Erro ao finalizar conexão em inserir paciente: " + e.getMessage());
            }
        }
        return retorno;
    }

}
