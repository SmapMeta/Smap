/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.smap.persistencia;

import br.com.smap.odds.MantelHaenszel;
import br.com.smap.view.SelecaoDeOpcao;
import java.text.DecimalFormat;
import java.util.List;

/**
 *
 * @author Ederson
 */
public class MantelHaenszelImplements {

    private static double ValorZ = 1.95996398454005;
    private static int porcentagem = 0;
    private static final double valorEuler = 2.718281828459045235360287;
    private static String resultado = "";
    private static double somaTotalPeso = 0;
    private static double somaTotalPesMultipDor = 0;
    private static double somaTotalValorE = 0;
    private static double somaTotalValorF = 0;
    private static double somaTotalValorG = 0;
    private static double somaTotalValorH = 0;
    private static double somaTotalValorR = 0;
    private static double somaTotalValorS = 0;
    private static double DorPooled = 0;

    public MantelHaenszelImplements() {
        somaTotalPeso = 0;
        resultado = "";
        porcentagem = 0;
        somaTotalPesMultipDor = 0;
        somaTotalValorE = 0;
        somaTotalValorF = 0;
        somaTotalValorG = 0;
        somaTotalValorH = 0;
        somaTotalValorR = 0;
        somaTotalValorS = 0;
        DorPooled = 0;
    }

    public static double getSomaTotalValorE() {
        return somaTotalValorE;
    }

    public static void setSomaTotalValorE(double somaTotalValorE) {
        MantelHaenszelImplements.somaTotalValorE = somaTotalValorE;
    }

    public static double getSomaTotalValorF() {
        return somaTotalValorF;
    }

    public static void setSomaTotalValorF(double somaTotalValorF) {
        MantelHaenszelImplements.somaTotalValorF = somaTotalValorF;
    }

    public static double getSomaTotalValorG() {
        return somaTotalValorG;
    }

    public static void setSomaTotalValorG(double somaTotalValorG) {
        MantelHaenszelImplements.somaTotalValorG = somaTotalValorG;
    }

    public static double getSomaTotalValorH() {
        return somaTotalValorH;
    }

    public static void setSomaTotalValorH(double somaTotalValorH) {
        MantelHaenszelImplements.somaTotalValorH = somaTotalValorH;
    }

    public static double getSomaTotalValorR() {
        return somaTotalValorR;
    }

    public static void setSomaTotalValorR(double somaTotalValorR) {
        MantelHaenszelImplements.somaTotalValorR = somaTotalValorR;
    }

    public static double getSomaTotalValorS() {
        return somaTotalValorS;
    }

    public static void setSomaTotalValorS(double somaTotalValorS) {
        MantelHaenszelImplements.somaTotalValorS = somaTotalValorS;
    }
    
    public static double getDorPooled() {
        return DorPooled;
    }

    public static void setDorPooled(double DorPooled) {
        MantelHaenszelImplements.DorPooled = DorPooled;
    }
    
    public static double getSomaTotalPesMultipDor() {
        return somaTotalPesMultipDor;
    }

    public static void setSomaTotalPesMultipDor(double somaTotalPesMultipDor) {
        MantelHaenszelImplements.somaTotalPesMultipDor += somaTotalPesMultipDor;
    }
    
    public static double getSomaTotalPeso() {
        return somaTotalPeso;
    }

    
    public static void setSomaTotalPeso(double somaTotalPeso) {
        MantelHaenszelImplements.somaTotalPeso += somaTotalPeso;
    }
    
    public static String getResultado() {
        return resultado;
    }

    public static void setResultado(String resultado) {
        MantelHaenszelImplements.resultado = resultado;
    }

    public static void setPorcentagem(int porcentagem) {
        MantelHaenszelImplements.porcentagem = porcentagem;
    }

    public static int getPorcentagem() {
        return porcentagem;
    }

    public static double getValorZ() {
        return ValorZ;
    }

    public static void setValorZ(double ValorZ) {
        MantelHaenszelImplements.ValorZ = ValorZ;
    }

    public MantelHaenszel calculaMantelHaenszel(MantelHaenszel mh) {
        System.out.println("calculaMantelHaenszel");
        double dor = 0;
        System.out.println("Resultado da DOR: " + dor);
        double vlr = 0;
        if (mh.getItemColunaA() == 0) {
            mh.setItemColunaA(0.5);
        } else if (mh.getItemColunaB() == 0) {
            mh.setItemColunaB(0.5);
        } else if (mh.getItemColunaC() == 0) {
            mh.setItemColunaC(0.5);
        } else if (mh.getItemColunaD() == 0) {
            mh.setItemColunaD(0.5);
        }

        dor = (mh.getItemColunaA() * mh.getItemColunaD()) / (mh.getItemColunaB() * mh.getItemColunaC());
        System.out.println("Resultado da DOR: " + dor);
        try {
            DecimalFormat dfm = new DecimalFormat("0.0000");
            String valorCalculo = dfm.format(dor).replace(",", ".");
            System.out.println("Resultado da DOR: " + valorCalculo);
            
            vlr = Double.parseDouble(valorCalculo);
            mh.setDor(dor);
        } catch (Exception e) {
            System.out.println("Erro no DecimalFormat: " + e.getMessage());
        }
        SelecaoDeOpcao sl = new SelecaoDeOpcao();
        System.out.println("Resultado da DOR: " + vlr);
        IntervaloConfianca(mh);
        System.out.println("mh.getSeLnDOR(): " + mh.getSeLnDOR());
        System.out.println("ValorZ: " + ValorZ);
        limiteInferior(mh);
        System.out.println("2-Limite inferior: " + mh.getLimiteInferior());
        limiteSuperior(mh);
        System.out.println("2-Limite Superior: " + mh.getLimiteSuperior());
        return mh;

    }

    private void IntervaloConfianca(MantelHaenszel mh) {

        double divisor = 0;
        divisor = (double) ((1 / mh.getItemColunaA()) + (1 / mh.getItemColunaB()) + (1 / mh.getItemColunaC()) + (1 / mh.getItemColunaD()));
        System.out.println("DIVISOR: " + divisor);
        mh.setSeLnDOR((double) Math.sqrt(divisor));
    }

    private double limiteInferior(MantelHaenszel mh) {

        double limiteInferior;
        limiteInferior = mh.getDor() * (Math.pow(valorEuler, -(ValorZ * mh.getSeLnDOR())));
        mh.setLimiteInferior(limiteInferior);
        return limiteInferior;
    }

    private double limiteSuperior(MantelHaenszel mh) {

        double limiteSuperior;
        double powZSeLnDOR = Math.pow(valorEuler, ValorZ * mh.getSeLnDOR());
        limiteSuperior = mh.getDor() * powZSeLnDOR;
        mh.setLimiteSuperior(limiteSuperior);
        return limiteSuperior;
    }
    
    public void CalculaPeso(List lista){
        
    }

}
