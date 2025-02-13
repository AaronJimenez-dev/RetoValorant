import ModeloController.EnfrentamientoController;
import ModeloController.EquipoController;
import ModeloController.JornadaController;
import ModeloController.JugadorController;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static JugadorController jugadorController;
    public static EquipoController equipoController;
    public static JornadaController jornadaController;
    public static EnfrentamientoController enfrentamientoController;
    public static String opcionesSinJornadas;
    public static String opcionesConJornadas;

    public static void main(String[] args) {
        declararVariables();
        opcionesSinJornadas();
        opcionesConJornadas();
    }
    public static void declararVariables() {
        jugadorController = new JugadorController();
        equipoController = new EquipoController();
        jornadaController = new JornadaController();
        enfrentamientoController = new EnfrentamientoController();
        opcionesSinJornadas = """
                                1. Crear un Jugador.
                                2. Crear un Equipo.
                                3. Modificar un Jugador.
                                4. Modificar un Equipo.
                                5. Eliminar un Jugador.
                                6. Eliminar un Equipo.
                                7. Ver todos los jugadores.
                                8. Ver todos los equipos.
                                9. Ver informacion de un jugador en concreto.
                                10. Ver informacion de un equipo en concreto.
                                11. Ver los jugadores de un equipo.
                                12. Crear las jornadas.
                                """;
        opcionesConJornadas = """
                                1. Modificar un Jugador.
                                2. Modificar un Equipo.
                                3. Ver todos los jugadores.
                                4. Ver todos los equipos.
                                5. Ver informacion de un jugador en concreto.
                                6. Ver informacion de un equipo en concreto.
                                7. Ver los jugadores de un equipo.
                                8. Ver los enfrentamientos de una jornada.
                                9. Ver los enfrentamientos de un equipo.
                                10. Añadir un resultado a un enfrentamiento.
                                11. Ver la puntuacion de un equipo.
                                """;
    }

    public static void opcionesSinJornadas() {
        Scanner sc = new Scanner(System.in);
        boolean yes=true;
        do {
            try {
                System.out.println(opcionesSinJornadas);
                int opcion = sc.nextInt();
                switch (opcion) {
                    case 1 -> jugadorController.dataValidation();
                    case 2 -> equipoController.validarDatosEquipo();
                    case 3 -> jugadorController.modificarJugador();
                    case 4 -> equipoController.modificarEquipo();
                    case 5 -> jugadorController.eliminarJugador();
                    case 6 -> equipoController.eliminarEquipo();
                    case 7 -> jugadorController.verTodosJugadores();
                    case 8 -> equipoController.verTodosEquipos();
                    case 9 -> jugadorController.verPorNombre();
                    case 10 -> equipoController.verPorNombre();
                    default -> {
                        yes = jornadaController.validarCreacionJornada();
                        enfrentamientoController.crearEnfrentamientos();
                    }
                }
            }catch (InputMismatchException e){
                sc.nextLine();
                System.out.println("Vuelve a teclear la opcion por favor " + e.getMessage()+"\n");
                // para notificar que ha pasado, ocurre cuando se 'lia' el Scanner
            }catch (NullPointerException e){
                System.out.println("La opcion es nula, aconsejamos crear antes para despues modificar\n");
            }catch (NumberFormatException e){
                System.out.println("No se acepta ese numero " +e.getMessage() +"\n");
            }
        }while(yes);
    }

    public static void opcionesConJornadas() {
        Scanner sc = new Scanner(System.in);
        boolean yes = true;
        do {
            System.out.println(opcionesConJornadas);
            int opcion = sc.nextInt();
            switch (opcion) {
                case 1 -> jornadaController.validarCreacionJornada();
                default -> yes = false;
            }
        }while(yes);
    }
}