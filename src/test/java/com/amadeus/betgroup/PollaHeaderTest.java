package com.amadeus.betgroup;

import com.amadeus.betgroup.model.account.User;
import com.amadeus.betgroup.model.polla.PollaHeader;
import com.amadeus.betgroup.service.polla.PollaHeaderService;

import java.util.List;
import java.util.Scanner;

public class PollaHeaderTest {

    public static void main ( String args[] ) throws Exception{
        boolean flagSalir = false;
        while ( !flagSalir ){
            System.out.println( "Seleccione una de las siguientes opciones: ");
            System.out.println( "1. Mis Juegos");
            System.out.println( "2. Juegos Disponibles");
            System.out.println( "3. Crear Juego");
            System.out.println( "4. Creditos");
            System.out.println( "5. Mis Amigos");
            System.out.println( "6. Mis Pronosticos");
            System.out.println( "7. Mi Perfil");
            System.out.println( "8. Salir");

            Scanner in = new Scanner(System.in);
            String sOption = in.nextLine();
            Integer option = Integer.parseInt(sOption);

            switch ( sOption ){

                case "1": {
                    subOpcionMisJuegos();
                    break;
                }
                case "2": {
                   // subOpcionMisJuegos();
                    break;
                }
            }





        }

    }

    private static void subOpcionMisJuegos() {
        User userBE = BetGroupTest.signin();

        PollaHeaderService pollaHeaderS = new PollaHeaderService();
        List<PollaHeader> pollaHeaderList = pollaHeaderS.getMisPollasByUserId( userBE.getUserId());
        System.out.println( "Seleccione una de las siguientes opciones: ");
        for (int i=0; i < pollaHeaderList.size(); i++ ){
            PollaHeader pollaHeader = pollaHeaderList.get(i);
            System.out.println( (i+1) + " # - ID: " + pollaHeader.getPollaId() + " - Nombre: " + pollaHeader.getPollaName() + " - Costo Inscripcion: " + (( pollaHeader.getCostFlag() == 0 )? 0 : pollaHeader.getPollaCost()) + "  -  Acceso: " + ((pollaHeader.getAccessFlag()==0)? "Publico": "Private"));
        }



    }
}
