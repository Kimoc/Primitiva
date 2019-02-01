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
    private int[] numerosBoleto;

    //CONSTRUCTORES

    //Boleto por defecto generara un boleto aleatorio
    public Boleto(){
        numerosBoleto=new int[49];
        //rellenamos array numeros boleto(igual que un bombo)
        rellenarNumerosDisponibles();
        boleto=new int[6];
        int random;
        int puntero=numerosBoleto.length-1;
        //rellena array con los 6 numeros principales
        for(int i=0;i<boleto.length;i++){
            random=Lib.random(0,puntero);
            boleto[i]=numerosBoleto[random];
            numerosBoleto[random]=numerosBoleto[puntero];
            puntero--;
        }
        //ordena el boleto


        //añade el complementario
        reintegro=Lib.random(0,9);
    }

    //GETTERS

    //Getter para la administracion
    public int[] getNumerosBoleto() {
          Arrays.sort(boleto);
          return boleto;
    }


    //getter para salida de consola
    //Devuelve el objeto Boleto en formato String
    public String getBoletoString() {
        Arrays.sort(boleto);
        return Arrays.toString(boleto)+" "+reintegro;
    }



    //Getter para reintegro Boleto
    public int getReintegro(){
        return reintegro;
    }



    //METODOS

    //Metodo para rellenar boleto
    public void rellenarBoleto(){

        int numero;
        lector=new Scanner(System.in);
        boleto=new int[6];
        int reintegro;
        boolean estarepetido=false;

        System.out.println("*****************************");
        System.out.println("*     Rellenar Boleto       *");
        System.out.println("*****************************\n");

        //Bucle para rellenar el boleto sin reintegro

        for (int i=0;i<boleto.length;i++){
            do {
                estarepetido=false;
                do {
                    System.out.println(i + 1 + ".- Introduzca un numero [0-49]:");
                    numero = lector.nextInt();
                    if (numero < 0 || numero > 49) {
                        System.out.println("Numero incorrecto introduzca numero [0-49");
                    }
                } while (numero < 0 || numero > 49);

                //Comprueba que no este repetido
                for (int z = 0; z < i; z++) {
                    if (numero == boleto[z]) {
                        System.out.println("El numero ya se ha elegido no se pueden repetir");
                        estarepetido=true;
                    }
                }

            }while(estarepetido);
            boleto[i] = numero;
        }
        //añade un complementario random
        reintegro= Lib.random(0,9);

        Arrays.sort(boleto);




    }
    public void rellenarNumerosDisponibles(){
        for (int i=1; i<=numerosBoleto.length;i++){
            numerosBoleto[i-1]=i;
        }
    }

    //METODOS VISUALIZACION

    //Metodo para mostra el boleto comprado
    public void mostrarJugada() {
        System.out.println("Su boleto es :");
        for (int i = 0; i <getBoletoString().length(); i++) {
            System.out.print("=");
        }
        System.out.println();
        for (int z = 0; z < getBoletoString().length() -1; z++) {
            System.out.print(" ");
        }
        System.out.print("R \n");
        System.out.println(getBoletoString());
        for (int y = 0; y < getBoletoString().length(); y++) {
            System.out.print("=");
        }
    }


}



