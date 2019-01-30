package com.aarongutierrez.primitiva.simuladorprimitiva;

import com.aarongutierrez.primitiva.util.Lib;

import java.util.Arrays;


public class Sorteo {
    private  enum Premios{PRIMERA,SEGUNDA,TERCERA,QUARTA,QUINTA,ESPECIAL,REINTEGRO,SIN_PREMIO}
    private  static Bombo50 bombo50;
    private  static BomboReintegro bomboReintegro;
    private static Boleto jugada;
    private static Premios premio;
    private static int reintegroSorteo;
    private static int reintegroJugada;
    private static int complementarioSorteo;
    private static int[] numerosJugada;
    private static int[] numerosSorteo;




    //Genera nuevo sorteo
    public Sorteo(){

        bombo50 =new Bombo50();
        bomboReintegro=new BomboReintegro();
        jugada=SimuladorPrimitiva.getBoletoComprado();
        reintegroJugada=SimuladorPrimitiva.getReintegroBoletoComprado();
        reintegroSorteo=bomboReintegro.getReintegro();
        numerosJugada=jugada.getBoleto();
        numerosSorteo=bombo50.getBombo50();
        complementarioSorteo=bombo50.getComplementario();
        premio=Premios.SIN_PREMIO;



    }


    public String getSorteoString() {
        return Arrays.toString(bombo50.getBombo50());
    }

    public int getReintegro() {
        return bomboReintegro.getReintegro();
    }
    public Premios getPremio(){
        return premio;
    }
    private void setPremio(Premios premio) {
        this.premio = premio;
    }


    //METODOS JUGAR SORTEOS

    //METODO JUGADA UNICA
    public  void jugadaUnica(){

        System.out.println("\n"+getSorteoString());
        System.out.println("Reintegro: "+getReintegro()+"\n");
        comprobarPremioConReintegro();

    }
    //METDODO JUGAR HASTA OBTENER PREMIO
    public  void jugarHastaObtenerPremio(){
        int contadorIntentos=0;

        do{
            Lib.borrarPantalla();
            bombo50.rellenarBombo();
            bombo50.nuevoNumeroSorteo();
            bomboReintegro.generarReintegro();
            comprobarPremioConReintegro();
            contadorIntentos++;
        }while (premio==Premios.SIN_PREMIO);
        System.out.println("\n"+getSorteoString());
        System.out.println("Reintegro: "+getReintegro());
        System.out.println("Intentos: "+contadorIntentos+"\n");
    }
    //METODO JUGAR HASTA OBTENER PREMIO SIN REINTEGRO
    public  void jugarHastaObtenerPremioSinReintegro(){
        int contadorIntentos=0;
        do{
            Lib.borrarPantalla();
            bombo50.rellenarBombo();
            bombo50.nuevoNumeroSorteo();
            bomboReintegro.generarReintegro();
            comprobarPremioSinReintegro();
            contadorIntentos++;


        }while (premio==Premios.SIN_PREMIO);
        System.out.print(contadorIntentos);
        System.out.println("Intentos: "+contadorIntentos);
    }
    //METODO JUGAR 10000 VECES
    public void jugar10000veces(){
        int contador=0;
        int contadorPremioPrimera=0;
        int contadorPremioSegunda=0;
        int contadorPremioTercera=0;
        int contadorPremioQuarta=0;
        int contadorPremioQuinta=0;
        int contadorPremioEspecial=0;
        int contadorPremioReintegro=0;
        do{
            Lib.borrarPantalla();
            bombo50.rellenarBombo();
            bombo50.nuevoNumeroSorteo();
            bomboReintegro.generarReintegro();
            comprobarPremioConReintegro();

            if(Premios.ESPECIAL==getPremio()){
                contadorPremioEspecial++;
            }
            else if(Premios.PRIMERA==getPremio()){
                contadorPremioPrimera++;
            }
            else if(Premios.SEGUNDA==getPremio()){
                contadorPremioSegunda++;
            }
            else if(Premios.TERCERA==getPremio()){
                contadorPremioTercera++;
            }
            else if(Premios.QUARTA==getPremio()){
                contadorPremioQuarta++;
            }
            else if(Premios.QUINTA==getPremio()){
                contadorPremioQuinta++;
            }
            else if(Premios.REINTEGRO==getPremio()){
                contadorPremioReintegro++;
            }
            contador++;
        }while (contador<10000);

        System.out.println("********************");
        System.out.println("***    PREMIOS     *");
        System.out.println("Premios conseguidos:");
        System.out.println("REINTEGROS: "+contadorPremioReintegro);
        System.out.println("PRIMERA: "+contadorPremioPrimera);
        System.out.println("SEGUNDA: "+contadorPremioSegunda);
        System.out.println("TERCERA: "+contadorPremioTercera);
        System.out.println("QUARTA: "+contadorPremioQuarta);
        System.out.println("QUINTA: "+contadorPremioQuinta);
        System.out.println("ESPECIAL: "+contadorPremioEspecial);
    }


    //Metodo jugar hasta obtener el premio ESPECIAL
    public void jugarHastaGanarPremioEspecial(){
        int contador=0;
        do{
            Lib.borrarPantalla();
            bombo50.rellenarBombo();
            bombo50.getBombo50();
            bombo50.nuevoNumeroSorteo();
            bomboReintegro.generarReintegro();
            comprobarEspecial();
            contador++;
        }while(premio!=Premios.ESPECIAL);
        System.out.println("\n"+getSorteoString());
        System.out.println("Reintegro: "+getReintegro());
        System.out.println("Lo has conseguido en: "+contador+" intentos.");
    }
    //
    //METODOS COMPROBACION
    //
    //Metodo comprobar Premio con reintegro
    public  Premios comprobarPremioConReintegro(){
        int contador=0;
        boolean acertoComplementario=false;
        for(int i=0;i<numerosSorteo.length-1;i++){
           for(int z=0;z<numerosJugada.length;z++){
               if(numerosSorteo[i]==numerosJugada[z]){
                   contador++;
               }
           }
        }
        for(int i=0;i<numerosJugada.length;i++){
            if (numerosJugada[i]==complementarioSorteo){
                acertoComplementario=true;
            }
        }
        //


        //
        if(contador==6&&getReintegro()==reintegroJugada){
            premio=Premios.ESPECIAL;
            System.out.println("\n"+Premios.ESPECIAL+"!!");
            System.out.println("\nFUCK YEAHH!!! PREMIO ESPECIAL!!! DING DING DING MONEY MONEY");
        }else if(contador==6){
            premio=Premios.PRIMERA;
            System.out.println("\n"+Premios.PRIMERA+"!!");
            System.out.println("\nHA GANADO!!!");
        }
        else if(contador==5&&acertoComplementario){
            premio=Premios.SEGUNDA;
            System.out.println("\n"+Premios.SEGUNDA);
            System.out.println("\nHA GANADO!!!");
        }
        else if(contador==5){
            premio=Premios.TERCERA;
            System.out.println("\n"+Premios.TERCERA+"!!");
            System.out.println("\nHA GANADO!!!");
        }
        else if(contador==4){
            premio=Premios.QUARTA;
            System.out.println("\n"+Premios.QUARTA+"!!");
            System.out.println("\nHA GANADO!!!");
        }
        else if (contador==3){
            premio=Premios.QUINTA;
            System.out.println("\n"+Premios.QUINTA+"!!");
            System.out.println("\nHA GANADO!!!");
        }
        else if(getReintegro()==reintegroJugada){
            premio=Premios.REINTEGRO;
            System.out.println("\n"+Premios.REINTEGRO);
            System.out.println("\nRecupera su dinero");
        }
        else {
            premio=Premios.SIN_PREMIO;
            System.out.println("\nLo sentimos no hay premio para su boleto");
        }

        return premio;

    }

    //Comprobar premio sin Reintegro
    public  Premios comprobarPremioSinReintegro(){
        int contador=0;
        boolean acertoComplementario=false;
        for(int i=0;i<numerosSorteo.length-1;i++){
            for(int z=0;z<i;z++){
                if(numerosSorteo[i]==numerosJugada[z]){
                    contador++;
                }
            }
        }
        for(int i=0;i<numerosJugada.length;i++){
            if (numerosJugada[i]==complementarioSorteo){
                acertoComplementario=true;
            }
        }
        if(contador==6&&getReintegro()==reintegroJugada){
            premio=Premios.ESPECIAL;
            System.out.println("\n"+Premios.ESPECIAL+"!!");
            System.out.println("\nFUCK YEAHH!!! PREMIO ESPECIAL!!! DING DING DING MONEY MONEY");
        }else if(contador==6){
            premio=Premios.PRIMERA;
            System.out.println("\n"+Premios.PRIMERA+"!!");
            System.out.println("\nHA GANADO!!!");
        }
        else if(contador==5&&acertoComplementario){
            premio=Premios.SEGUNDA;
            System.out.println("\n"+Premios.SEGUNDA);
            System.out.println("\nHA GANADO!!!");
        }
        else if(contador==5){
            premio=Premios.TERCERA;
            System.out.println("\n"+Premios.TERCERA+"!!");
            System.out.println("\nHA GANADO!!!");
        }
        else if(contador==4){
            premio=Premios.QUARTA;
            System.out.println("\n"+Premios.QUARTA+"!!");
            System.out.println("\nHA GANADO!!!");
        }
        else if (contador==3){
            premio=Premios.QUINTA;
            System.out.println("\n"+Premios.QUINTA+"!!");
            System.out.println("\nHA GANADO!!!");
        }
        else {
            premio=Premios.SIN_PREMIO;
            System.out.println("\nLo sentimos no hay premio para su boleto");
        }
        return premio;

    }
    //Metodo comprobar premio Escpecial
    public Premios comprobarEspecial(){
        int contador=0;
        
        for(int i=0;i<numerosSorteo.length-1;i++){
            for(int z=0;z<numerosJugada.length;z++){
                if(numerosSorteo[i]==numerosJugada[z]){
                    contador++;
                }
            }
        }
        if(contador==6&&getReintegro()==reintegroJugada){
            premio=Premios.ESPECIAL;
            System.out.println("\n"+premio+"!\n");
            System.out.println("\nFUCK YEAHH!!! PREMIO ESPECIAL!!! DING DING DING MONEY MONEY");


        }
        return premio;
    }
    private void nuevoSorteo(){

    }
}
