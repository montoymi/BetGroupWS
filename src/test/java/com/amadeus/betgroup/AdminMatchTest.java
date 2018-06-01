package com.amadeus.betgroup;

import com.amadeus.betgroup.model.account.User;
import com.amadeus.betgroup.model.tournament.Match;
import com.amadeus.betgroup.model.tournament.Team;
import com.amadeus.betgroup.model.tournament.Tournament;
import com.amadeus.betgroup.service.tournament.TeamService;
import com.amadeus.betgroup.service.tournament.TournamentService;

import java.text.SimpleDateFormat;
import java.util.Scanner;

public class AdminMatchTest {

	public static void main(String args[]) throws Exception {
		System.out.println( "*** Consola de Administracion de Eventos y Torneos");
		boolean flagSalir = false;
		User userBE = BetGroupTest.signin();

		while ( !flagSalir ) {
			System.out.println("Seleccione una de las siguientes opciones: ");
			System.out.println("1. Agregar Equipo");
			System.out.println("2. Agregar Torneo");
			System.out.println("3. Agregar Fase");
			System.out.println("4. Agregar Grupo");
			System.out.println("5. Agregar Partido");
			System.out.println("6. Agregar Plantilla");
			System.out.println("7. Salir");

			Integer option = Integer.parseInt(new Scanner(System.in).nextLine());

			switch ( option ){
				case 1: {
					subOpcionAgregarEquipo(userBE);
					break;
				}case 2: {
					subOpcionAgregarTorneo(userBE);
					break;
				}
				case 3: {
					subOpcionAgregarFase(userBE);
					break;
				}
				case 4: {
					subOpcionAgregarGrupo(userBE);
					break;
				}
				case 5: {
					subOpcionAgregarMatch(userBE);
					break;
				}
				case 6: {
					subOpcionAgregarPlantilla(userBE);
					break;
				}
				case 7: {
					flagSalir = true;
					System.out.println("Procediendo a cerrar la aplicacion de consola...");
					break;
				}
			}

		}

	}

	private static void subOpcionAgregarEquipo(User userBE) {
		System.out.println("Procediendo a ingresar informacion de equipo...");
		Team teamBE = new Team();
		System.out.print("Indique el nombre del equipo o entidad: (string) ");
		teamBE.setTeamName(new Scanner(System.in).nextLine());
		System.out.println("Indique el Sport Id del equipo: (integer) ");
		teamBE.setSportId(Integer.parseInt(new Scanner(System.in).nextLine()));
		System.out.println("Indique el status del equipo: (integer) ");
		teamBE.setEnabled_flag( Integer.parseInt( new Scanner(System.in).nextLine()) );
		System.out.println("Indique la ubicacion de la imagen: (string) ");
		teamBE.setImage( new Scanner(System.in).nextLine() );

		TeamService teamService = new TeamService();
		teamService.createTeam(teamBE);
		System.out.println("Equipo registrado satisfactoriamente");

	}

	private static void subOpcionAgregarMatch(User userBE) {


		Match matchBE = new Match();
		matchBE.setEnabled_flag(1);
		matchBE.setGroupId(1);
		matchBE.setImage("");
		matchBE.setLocalId(1);
		matchBE.setVisitorId(1);
		matchBE.setMatchPlace("");
		matchBE.setMatchDateWithTimezone(null);
		matchBE.setMatchCode("");
	}

	private static void subOpcionAgregarGrupo(User userBE) {
	}

	private static void subOpcionAgregarFase(User userBE) {
	}

	private static void subOpcionAgregarTorneo(User userBE) throws Exception{

		System.out.println("Procediendo a ingresar informacion de equipo...");
		Tournament tournament= new Tournament();
		System.out.print("Indique el nombre del torneo o entidad: (string) ");
		tournament.setTournamentName(new Scanner(System.in).nextLine());
		System.out.println("Indique el Sport Id del torneo: (integer) ");
		tournament.setSportId(Integer.parseInt(new Scanner(System.in).nextLine()));
		System.out.println("Indique el status del torneo: (integer) ");
		tournament.setEnabled_flag( Integer.parseInt( new Scanner(System.in).nextLine()) );
		System.out.println("Indique la fecha de inicio dd/MM/yyyy'T'HH:mm:ssZ (string) ");
		tournament.setStartDate( (new SimpleDateFormat("dd/MM/yyyy'T'HH:mm:ssZ")).parse( new Scanner(System.in).nextLine() ) );

		TournamentService tournamentService = new TournamentService();
		tournamentService.createTournament(tournament);

		System.out.println("Torneo registrado satisfactoriamente");
	}

	private static void subOpcionAgregarPlantilla(User userBE) {
	}

}
