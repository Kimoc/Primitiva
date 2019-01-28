package com.aarongutierrez.primitiva.util;

import java.util.Random;
import java.util.Scanner;
public class Lib {

    public static Scanner lector = new Scanner(System.in);

    //Borrar pantalla consola
    public static void borrarPantalla() {
        System.out.print("\u001B[H\u001B[2J");
        System.out.flush();
    }
    //Generar un numero random comprendido entre 2 nuemros enteros.
    public static int random(int min, int max){
        int aleatorio;
        Random rnd=new Random();
        aleatorio=rnd.nextInt(max-min+1)+min;
        return aleatorio;
    }

    public static void pausa() {
        System.out.println("\nPulsa INTRO para continuar...");
        lector.nextLine();
    }

}
