package com.aarongutierrez.primitiva.simuladorprimitiva;
import com.aarongutierrez.primitiva.util.Lib;

import java.util.Scanner;
public class SimuladorPrimitiva {

    private Scanner lector;
//todo quitar el instanciar boleto

    private static Boleto boleto;
    private static Sorteo sorteo;

    public SimuladorPrimitiva(){
        lector = new Scanner(System.in);
        int opcion;
        do{
            //Menu Principal
            opcion=menuPrincipal();
            switch (opcion){
                case 1:
                    //Menu Comprar Boleto
                    opcion=menuBoleto();
                    switch (opcion){
                        case 1:
                            //Jugador rellena Boleto
                            boleto=Boleto.rellenarBoleto();
                            mostrarJugada(boleto);
                            System.out.println("\nGracias por su compra y mucha suerte");
                            Lib.pausa();
                            break;
                        case 2:
                            //Jugador se le da un Boleto aleatorio
                            Boleto boletoRandom=new Boleto();
                            boleto=boletoRandom;
                            mostrarJugada(boleto);
                            System.out.println("\nGracias por su compra y mucha suerte");
                            Lib.pausa();
                            break;
                        case 0:
                            //Vuelve a menu Principal
                            System.out.println("\nVuelva pronto");
                            Lib.pausa();
                            opcion=-1;

                            break;
                    }
                    break;
                case 2:
                    //Muestra el boleto del Jugador
                    mostrarJugada(boleto);
                    Lib.pausa();
                    break;
                case 3:
                    //Menu Jugar
                    opcion=menuJugar();
                    switch (opcion){
                        //Jugada unica
                        case 1:
                            sorteo=new Sorteo();
                            Sorteo.JugadaUnica(sorteo);
                            mostrarJugada(boleto);
                            Lib.pausa();
                            break;
                        //Jugar hasta obtener premio
                        case 2:
                            sorteo=new Sorteo();
                            Sorteo.JugarHastaObtenerPremio(sorteo);
                            mostrarJugada(boleto);
                            Lib.pausa();
                            break;
                        //Jugar hasta obtener premio sin el reintegro
                        case 3:
                            sorteo=new Sorteo();
                            Sorteo.jugarHastaObtenerPremioSinReintegro(sorteo);
                            mostrarJugada(boleto);
                            Lib.pausa();
                            break;
                        //Jugar 10000 veces
                        case 4:
                            sorteo=new Sorteo();
                            Sorteo.jugar10000veces(sorteo);
                            Lib.pausa();
                            mostrarJugada(boleto);
                            break;
                        //Jugar hasta obtener el premio espcial
                        case 5:
                            sorteo=new Sorteo();
                            Sorteo.jugarHastaGanarPremioEspecial(sorteo);
                            mostrarJugada(boleto);
                            Lib.pausa();
                            break;
                    }
                    break;

                case 0:
                    System.out.println("Gracias por Jugar");
                    Lib.pausa();
                    break;
            }
        }while (opcion!=0);

    }


    //METODOS MENU

    //Metodo que muestra el menu principal
    private int menuPrincipal(){
        int opcion=-1;
        do{
            Lib.borrarPantalla();
            System.out.println("*****************************");
            System.out.println("***  PRIMITIVA SIMULATOR  ***");
            System.out.println("*****************************");
            System.out.println("*1.Comprar boleto           *");
            System.out.println("*2.Ver boleto               *");
            System.out.println("*3.Jugar                    *");
            System.out.println("-----------------------------");
            System.out.println(" 0.Salir\n");
            opcion =lector.nextInt();
            lector.nextLine();
            /*
             *Validacion input opcion en consola
             */
            if(opcion<0||opcion>3){
                System.out.println("Opcion incorrecta! Elija una opcion del menu[0-3]");
            }
        }while(opcion<0||opcion>3);
        return opcion;
    }

    //Submenu de Menu principal opcion PRIMITIVA SIMULATOR [1]
    private int menuBoleto(){
        int opcion=-1;
        do{
            Lib.borrarPantalla();
            System.out.println("*****************************");
            System.out.println("***     COMPRAR BOLETO    ***");
            System.out.println("*****************************");
            System.out.println("*1.Rellenar boleto         *");
            System.out.println("*2.Generar boleto aleatorio*");
            System.out.println("-----------------------------");
            System.out.println(" 0.Salir\n");
            opcion =lector.nextInt();
            lector.nextLine();
            /*
             *Validacion input opcion en consola
             */
            if(opcion<0||opcion>2){
                System.out.println("Opcion incorrecta! Elija una opcion del menu[0-2]");
            }
        }while(opcion<0||opcion>2);
        return opcion;
    }
    private int menuJugar(){
        int opcion=-1;
        do{
            Lib.borrarPantalla();
            System.out.println("**********************************************");
            System.out.println("***            MODALIDAD DE JUEGO          ***");
            System.out.println("**********************************************");
            System.out.println("*1.Jugada unica                              *");
            System.out.println("*2.Jugar hasta obtener premio                *");
            System.out.println("*3.Jugar hasta obtener premio (sin reintegro)*");
            System.out.println("*4.Jugar 10000 sorteos                       *");
            System.out.println("*5.Jugar hasta obtener premio ESPECIAL       *");
            System.out.println("----------------------------------------------");
            System.out.println(" 0.Salir\n");
            opcion =lector.nextInt();
            lector.nextLine();
            /*
             *Validacion input opcion en consola
             */
            if(opcion<0||opcion>5){
                System.out.println("Opcion incorrecta! Elija una opcion del menu[0-5]");
            }
        }while(opcion<0||opcion>5);
        return opcion;
    }

    //METODOS VISUALIZACION

    //Metodo para mostra el boleto comprado
    private static void mostrarJugada(Boleto jugada) {
            System.out.println("Su boleto es :");
            for (int i = 0; i < jugada.getBoletoString().length(); i++) {
                System.out.print("=");
            }
            System.out.println();
            for (int z = 0; z < jugada.getBoletoString().length() -1; z++) {
                System.out.print(" ");
            }
            System.out.print("R \n");
            System.out.println(jugada.getBoletoString());
            for (int y = 0; y < jugada.getBoletoString().length(); y++) {
                System.out.print("=");
            }
    }
    //Metodo para visualizar Sorteo


    //getter boleto generado
    public static Boleto getBoletoComprado(){
        return boleto;
    }
    //getter reintegro boleto comprado
    public static int getReintegroBoletoComprado(){
        return boleto.getReintegro();
    }



}
