package com.aarongutierrez.primitiva.simuladorprimitiva;

import com.aarongutierrez.primitiva.util.Lib;

public class BomboReintegro {
    private int reintegro;


    //Constructor Bombo reintegro
    BomboReintegro(){
        generarReintegro();
    }
    //Getter reintegro
    public int getReintegro() {
        return reintegro;
    }
    public int generarReintegro (){
        reintegro= Lib.random(0,9);
        return reintegro;
    }

}
