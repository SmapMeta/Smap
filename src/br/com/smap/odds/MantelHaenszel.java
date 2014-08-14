
package br.com.smap.odds;

/**
 *
 * @author Ederson
 */
public class MantelHaenszel {

    private int id;
    private String autor;
    private String estudo;
    private double itemColunaA;
    private double itemColunaB;
    private double itemColunaC;
    private double itemColunaD;
    private double dor;
    private double seLnDOR;
    private double limiteInferior;
    private double limiteSuperior;
    private double valorPesoPorcento;
    private double valorPeso;
    private double PesoMultipDor;

    public double getPesoMultipDor() {
        return PesoMultipDor;
    }

    public void setPesoMultipDor(double PesoMultipDor) {
        this.PesoMultipDor = PesoMultipDor;
    }
    
    public double getValorPeso() {
        return valorPeso;
    }

    public void setValorPeso(double valorPeso) {
        this.valorPeso = valorPeso;
    }
    public double getValorPesoPorcento() {
        return valorPesoPorcento;
    }

    public void setValorPesoPorcento(double valorPesoPorcento) {
        this.valorPesoPorcento = valorPesoPorcento;
    }
       
    public double getLimiteInferior() {
        return limiteInferior;
    }

    public void setLimiteInferior(double limiteInferior) {
        this.limiteInferior = limiteInferior;
    }

    public double getLimiteSuperior() {
        return limiteSuperior;
    }

    public void setLimiteSuperior(double limiteSuperior) {
        this.limiteSuperior = limiteSuperior;
    }
    
    public double getSeLnDOR() {
        return seLnDOR;
    }

    public void setSeLnDOR(double seLnDOR) {
        this.seLnDOR = seLnDOR;
    }
    
    public MantelHaenszel() {
    
    }

    public double getDor() {
        return dor;
    }

    public void setDor(double dor) {
        this.dor = dor;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEstudo() {
        return estudo;
    }

    public void setEstudo(String estudo) {
        this.estudo = estudo;
    }

    public double getItemColunaA() {
        return itemColunaA;
    }

    public void setItemColunaA(double itemColunaA) {
        this.itemColunaA = itemColunaA;
    }

    public double getItemColunaB() {
        return itemColunaB;
    }

    public void setItemColunaB(double itemColunaB) {
        this.itemColunaB = itemColunaB;
    }

    public double getItemColunaC() {
        return itemColunaC;
    }

    public void setItemColunaC(double itemColunaC) {
        this.itemColunaC = itemColunaC;
    }

    public double getItemColunaD() {
        return itemColunaD;
    }

    public void setItemColunaD(double itemColunaD) {
        this.itemColunaD = itemColunaD;
    }

}
