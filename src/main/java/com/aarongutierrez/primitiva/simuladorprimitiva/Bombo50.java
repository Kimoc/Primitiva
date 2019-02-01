package com.aarongutierrez.primitiva.simuladorprimitiva;

import com.aarongutierrez.primitiva.util.Lib;

import java.util.Arrays;

public class Bombo50 {

    private int[] bombo50;
    private int complementario;
    private int[] numerosBombo;


    //Contructor bombo de [0-49]
    //Saca un array de 7 numeros 6 + el complementario
    public Bombo50(){
        bombo50=new int[7];
        numerosBombo=new int[49];
        //rellenamos bombo
        rellenarBombo();
        //
       nuevoNumeroSorteo();

    }
    //retorna un array de numeros 6+complementario
    public int[] getBombo50() {
        Arrays.sort(bombo50);
        return bombo50;
    }
    //Retorna el valor del numero ocmplementario que ha salido en el bombo
    public int getComplementario() {
        return complementario=bombo50[bombo50.length-1];
    }
    //rellena  el bombo ordenado de 1 a 49
    public void rellenarBombo(){
        for(int i =1 ; i<=numerosBombo.length;i++){
            numerosBombo[i-1]=i;
        }
    }
    //genera nuevo numero para el sorteo
    public void nuevoNumeroSorteo(){
        int numeroRandom;
        int punteroPosicionFinal=numerosBombo.length-1;
        for(int i=0;i<bombo50.length;i++){
            numeroRandom=Lib.random(0,punteroPosicionFinal);
            bombo50[i]=numerosBombo[numeroRandom];
            numerosBombo[numeroRandom]=numerosBombo[punteroPosicionFinal];
            punteroPosicionFinal--;
        }
    }

}
