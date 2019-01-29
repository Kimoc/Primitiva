package com.aarongutierrez.primitiva.simuladorprimitiva;

import com.aarongutierrez.primitiva.util.Lib;

import java.util.Arrays;


public class Sorteo {
    private  enum PREMIOS{PRIMERA,SEGUNDA,TERCERA,QUARTA,QUINTA,ESPECIAL,REINTEGRO,SIN_PREMIO}
    private  static Bombo50 bombo50;
    private  static BomboReintegro bomboReintegro;
    private static int reintegroSorteo;
    private static int complementarioSorteo;
    private static Boleto jugada;
    private static int reintegroJugada;
    private static PREMIOS premio;
    private static int[] numerosJugada;
    private static int[] numerosSorteo;



    //Genera nuevo sorteo
    public Sorteo(){
        //todo quitar new bombos por metodo rllenarbombos

        bombo50 =new Bombo50();
        bomboReintegro=new BomboReintegro();
        premio=PREMIOS.SIN_PREMIO;
        jugada=SimuladorPrimitiva.getBoletoComprado();
        reintegroJugada=SimuladorPrimitiva.getReintegroBoletoComprado();
        reintegroSorteo=bomboReintegro.getReintegro();
        numerosJugada=jugada.getBoleto();
        numerosSorteo=bombo50.getBombo50();




    }


    public String getSorteoString() {
        return Arrays.toString(bombo50.getBombo50());
    }

    public int getReintegro() {
        return bomboReintegro.getReintegro();
    }
    public PREMIOS getPremio(){
        return premio;
    }
    private static void setPremio(PREMIOS premio) {
        Sorteo.premio = premio;
    }


    //METODOS JUGAR SORTEOS

    //METODO JUGADA UNICA
    public static void JugadaUnica(Sorteo sorteo){

        System.out.println("\n"+sorteo.getSorteoString());
        System.out.println("Reintegro: "+sorteo.getReintegro());
        comprobarPremioConReintegro();

    }
    //METDODO JUGAR HASTA OBTENER PREMIO
    public static void JugarHastaObtenerPremio(Sorteo sorteo){
        int contadorIntentos=0;

        do{
            Lib.borrarPantalla();
            sorteo=new Sorteo();
            comprobarPremioConReintegro();
            contadorIntentos++;
            System.out.println("Intentos: "+contadorIntentos);
        }while (sorteo.getPremio()==PREMIOS.SIN_PREMIO);
        System.out.println("\n"+sorteo.getSorteoString());
        System.out.println("Reintegro: "+sorteo.getReintegro());
        System.out.println("Intentos: "+contadorIntentos);
    }
    //METODO JUGAR HASTA OBTENER PREMIO SIN REINTEGRO
    public static void jugarHastaObtenerPremioSinReintegro(Sorteo sorteo){
        int contadorIntentos=0;
        do{
            Lib.borrarPantalla();
            sorteo=new Sorteo();
            comprobarPremioSinReintegro();
            contadorIntentos++;
            System.out.print(contadorIntentos);
            System.out.println("Intentos: "+contadorIntentos);

        }while (sorteo.getPremio()==PREMIOS.SIN_PREMIO);

    }
    //METODO JUGAR 10000 VECES
    public static void jugar10000veces(Sorteo sorteo){
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
            sorteo=new Sorteo();
            System.out.println("\n"+sorteo.getSorteoString());
            System.out.println("Reintegro: "+sorteo.getReintegro());
            System.out.println("Jugada: "+(contador+1));

            comprobarPremioConReintegro();

            if(PREMIOS.ESPECIAL==sorteo.getPremio()){

            }
            else if(PREMIOS.PRIMERA==sorteo.getPremio()){
                contadorPremioPrimera++;
            }
            else if(PREMIOS.SEGUNDA==sorteo.getPremio()){
                contadorPremioSegunda++;
            }
            else if(PREMIOS.TERCERA==sorteo.getPremio()){
                contadorPremioTercera++;
            }
            else if(PREMIOS.QUARTA==sorteo.getPremio()){
                contadorPremioQuarta++;
            }
            else if(PREMIOS.QUINTA==sorteo.getPremio()){
                contadorPremioQuinta++;
            }
            else if(PREMIOS.REINTEGRO==sorteo.getPremio()){
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
    public static void jugarHastaGanarPremioEspecial(Sorteo sorteo){
        int contador=0;
        do{
            Lib.borrarPantalla();
            sorteo=new Sorteo();
            comprobarEspecial();
            contador++;
        }while(sorteo.getPremio()!=PREMIOS.ESPECIAL);
        System.out.println("\n"+sorteo.getSorteoString());
        System.out.println("Reintegro: "+sorteo.getReintegro());
        System.out.println("Lo has conseguido en: "+contador+" intentos.");
    }
    //
    //METODOS COMPROBACION
    //

    //Metodo comprobar Reintegro
    public static PREMIOS compruebaReintegro(){

        if(reintegroSorteo==reintegroJugada){
            setPremio(PREMIOS.REINTEGRO);
            System.out.println("\n"+premio+"!\n");
        }else {
            setPremio(PREMIOS.SIN_PREMIO);
            System.out.println("\n"+premio+" =( \n");
        }
        return premio;
    }


    //Metodo comprobar Premio con reintegro
    public static PREMIOS comprobarPremioConReintegro(){
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
        if (contador==3){
            setPremio(PREMIOS.QUINTA);
            System.out.println("\nHA GANADO!!!");
            System.out.println("\n"+premio+"!\n");return premio;
        }
        else if(contador==4){
            setPremio(PREMIOS.QUARTA);
            System.out.println("\nHA GANADO!!!");
            System.out.println("\n"+premio+"!\n");
        }
        else if(contador==5){
            setPremio(PREMIOS.TERCERA);
            System.out.println("\nHA GANADO!!!");
            System.out.println("\n"+premio+"!\n");
        }
        else if(contador==5&&acertoComplementario){
            setPremio(PREMIOS.SEGUNDA);
            System.out.println("\nHA GANADO!!!");
            System.out.println("\n"+premio+"!\n");

        }
        else if(contador==6){
            setPremio(PREMIOS.PRIMERA);
            premio=PREMIOS.QUARTA;
            System.out.println("\nHA GANADO!!!");
            System.out.println("\n"+premio+"!\n");
        }
        else if(contador==6&&reintegroSorteo==reintegroJugada){
            setPremio(PREMIOS.ESPECIAL);
            System.out.println("\nFUCK YEAHH!!! PREMIO ESPECIAL!!! DING DING DING MONEY MONEY");
            System.out.println("\n"+premio+"!\n");

        }
        else if(reintegroSorteo==reintegroJugada){
            premio=PREMIOS.REINTEGRO;
            System.out.println("\nRecupera su dinero");
            System.out.println("\n"+premio+"!\n");
        }
        else {
            premio=PREMIOS.SIN_PREMIO;
            System.out.println("\nLo sentimos no hay premio para su boleto");
            System.out.println("\n"+premio+" =( \n");
        }
        return premio;

    }

    //Comprobar premio sin Reintegro
    public static PREMIOS comprobarPremioSinReintegro(){
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
        if (contador==3){
            setPremio(PREMIOS.QUINTA);
            System.out.println("\nHA GANADO!!!");
            System.out.println("\n"+premio+"!\n");return premio;
        }
        else if(contador==4){
            setPremio(PREMIOS.QUARTA);
            System.out.println("\nHA GANADO!!!");
            System.out.println("\n"+premio+"!\n");
        }
        else if(contador==5){
            setPremio(PREMIOS.TERCERA);
            System.out.println("\nHA GANADO!!!");
            System.out.println("\n"+premio+"!\n");
        }
        else if(contador==5&&acertoComplementario){
            setPremio(PREMIOS.SEGUNDA);
            System.out.println("\nHA GANADO!!!");
            System.out.println("\n"+premio+"!\n");

        }
        else if(contador==6){
            setPremio(PREMIOS.PRIMERA);
            premio=PREMIOS.QUARTA;
            System.out.println("\nHA GANADO!!!");
            System.out.println("\n"+premio+"!\n");
        }
        else {
            premio=PREMIOS.SIN_PREMIO;
            System.out.println("\nLo sentimos no hay premio para su boleto");
            System.out.println("\n"+premio+" =( \n");
        }
        return premio;

    }
    //Metodo comprobar premio Escpecial
    public static PREMIOS comprobarEspecial(){
        int contador=0;
        
        for(int i=0;i<numerosSorteo.length-1;i++){
            for(int z=0;z<i;z++){
                if(numerosSorteo[i]==numerosJugada[z]){
                    contador++;
                }
            }
        }
        if(contador==6&&reintegroSorteo==reintegroJugada){
            setPremio(PREMIOS.ESPECIAL);
            System.out.println("\n"+premio+"!\n");
            System.out.println("\nFUCK YEAHH!!! PREMIO ESPECIAL!!! DING DING DING MONEY MONEY");


        }
        return premio;
    }
}
