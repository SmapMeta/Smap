package br.com.smap.tablemodel;

import br.com.smap.odds.MantelHaenszel;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Ederson
 */
public class MantelTableModel extends AbstractTableModel {

    private static final int COL_ID = 0;
    private static final int COL_AUTOR = 1;
    private static final int COL_ESTUDO = 2;
    private static final int COL_VP = 3;
    private static final int COL_FN = 4;
    private static final int COL_FP = 5;
    private static final int COL_VN = 6;
    List<MantelHaenszel> linhas;
    private String[] colunas = new String[]{"ID", "Horário", "Data da consulta", "Nome", "Tipo de Consulta"};


    @Override
    public int getRowCount() {
        return linhas.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int row, int column) {
        MantelHaenszel m = linhas.get(row);
        if (column == COL_ID) {
            return m.getId();
        } else if (column == COL_AUTOR) {
            return m.getAutor();
        } else if (column == COL_ESTUDO) {
            return m.getEstudo();
        } else if (column == COL_FN) {
            return m.getItemColunaA();
        } else if (column == COL_FP) {
            return m.getItemColunaB();
        }else if (column == COL_VN) {
            return m.getItemColunaC();
        }else if (column == COL_VP) {
            return m.getItemColunaD();
        }
        return "";
    }

    public MantelTableModel(List<MantelHaenszel> mantel) {
        this.linhas = new ArrayList<>(mantel);
    }
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex){
        return false;
    }
    
    public MantelHaenszel getConsulta(int indiceLinha){
        return linhas.get(indiceLinha);
    }
    
    public void addConsulta(MantelHaenszel mantel){
        linhas.add(mantel);
        int ultimoIndice = getRowCount() - 1;
        fireTableRowsInserted(ultimoIndice, ultimoIndice);
    }
    
//    public boolean isCellEditable(int row, int column) {
//         if(column == 0){
//        return false;
//        }
//            return true;
//    }
}