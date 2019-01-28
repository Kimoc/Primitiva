package com.aarongutierrez.primitiva.simuladorprimitiva;

import java.util.Arrays;
import java.util.Scanner;

import com.aarongutierrez.primitiva.util.Lib;

//La clase boleto repesenta el boleto que compramos
public class Boleto {
 //getter para salida de consola

    //ATRIBUTOS
    private static Scanner lector;
    private static int[] boleto;
    private int reintegro; //Reintegro
    private boolean esRepetido; //Si un numero ya se ha repetido


    //CONSTRUCTORES

    //Boleto por defecto generara un boleto aleatorio
    public Boleto(){

        boleto=new int[6];
        int random;
        boolean esRepetido=false;
        //rellena array con los 6 numeros principales
        for(int i=0;i<boleto.length;i++){
            //generar random para rellenar
            random=Lib.random(0,49);
            //comprueba que no este repetido
            for(int z=0;z>i;z++){
                if(random==boleto[z]){
                    esRepetido=true;
                }
            }
            boleto[i]=random;
        }
        //añade el complementario
        reintegro=Lib.random(0,9);
    }

    //Construcotr para el metetodo Rellenar boleto
    public Boleto(int[] numeros,int reintegro){
        this.boleto=numeros;
        this.reintegro=reintegro;
    }

    //GETTERS

    //Getter para la administracion
    public int[] getBoleto() {
          return boleto;
    }

    //getter para salida de consola
    //Devuelve el objeto Boleto en formato String
    public String getBoletoString() {

        return Arrays.toString(boleto)+" "+reintegro;
    }



    //Getter para reintegro Boleto
    public int getReintegro(){
        return reintegro;
    }


    public int getNum1(){
        return boleto[0];
    }
    public int getNum2(){
        return  boleto[1];
    }
    public int getNum3(){
        return boleto[2];
    }
    public int getNum4(){
        return boleto[3];
    }
    public int getNum5(){
        return boleto[4];
    }
    public int getNum6(){
        return boleto[5];
    }


    //METODOS

    //Metodo para rellenar boleto
    public static Boleto rellenarBoleto(){
        Boleto boletoJugador;
        int numero;
        lector=new Scanner(System.in);
        boolean estaRepetido=false;
        boleto=new int[6];
        int reintegro;

        System.out.println("*****************************");
        System.out.println("*     Rellenar Boleto       *");
        System.out.println("*****************************\n");

        //Bucle para rellenar el boleto sin reintegro
        for (int i=0;i<boleto.length;i++){

            do{
                System.out.println(i+1+".- Introduzca un numero [0-49]:");
                numero=lector.nextInt();
                if(numero<0||numero>49){
                    System.out.println("Numero incorrecto introduzca numero [0-49");
                }
            }while(numero<0||numero>49);

            //Comprueba que no este repetido
            for(int z=0;z<i;z++){
                if(numero==boleto[z]){
                    estaRepetido=true;
                    System.out.println("El numero ya se ha elegido no se pueden repetir");
                }
            }
            boleto[i]=numero;

        }
        //añade un complementario random
        reintegro= Lib.random(0,9);


        boletoJugador=new Boleto(boleto,reintegro);
        return boletoJugador;

    }

}



