package com.aarongutierrez.primitiva.simuladorprimitiva;

import com.aarongutierrez.primitiva.util.Lib;

public class BomboReintegro {
    private int reintegro;


    //Constructor Bombo reintegro
    BomboReintegro(){
        reintegro= Lib.random(0,9);
    }
    //Getter reintegro
    public int getReintegro() {
        return reintegro;
    }

}
