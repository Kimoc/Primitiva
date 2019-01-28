package com.aarongutierrez.primitiva.simuladorprimitiva;

import com.aarongutierrez.primitiva.util.Lib;

public class Bombo50 {

    private int[] bombo50;
    private int complementario;
    private boolean esRepetido;



    //Contructor bombo de [0-49]
    //Saca un array de 7 numeros 6 + el complementario
    public Bombo50(){
        bombo50=new int[7];
        int random;
        boolean esRepetido=false;
        for(int i=0;i<bombo50.length;i++){
            random= Lib.random(0,49);
            for(int z=0;z>i;z++){
                if(random==bombo50[z]){
                    esRepetido=true;
                }
            }
            bombo50[i]=random;
        }


    }
    //retorna un array de numeros 6+complementario
    public int[] getBombo50() {
        return bombo50;
    }
    //Retorna el valor del numero ocmplementario que ha salido en el bombo
    public int getComplementario() {
        return complementario=bombo50[bombo50.length-1];
    }

}
