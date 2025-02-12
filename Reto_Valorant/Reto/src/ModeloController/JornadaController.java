package ModeloController;

import Modelo.Equipo;
import Modelo.Jornada;
import ModeloDAO.EquipoDAO;
import ModeloDAO.JornadaDAO;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class JornadaController {
    private static JornadaDAO jornadaDAO;
    private static EquipoDAO equipoDAO;
    private static ArrayList<Jornada> jornadas;
    private static EnfrentamientoController enfrentamientoController;
    private static List<Equipo> equipos;

    private static final int[] meses31 = {1,3,5,7,8,10,12};
    public boolean validarCreacionJornada(){
        boolean resultado;
        if (equipos.size() % 2 == 0){
            declararVariables();
            crearJornada();
            resultado = false;
        }else {
            System.out.println("La cantidad de equipos no es par");
            resultado = true;
        }
        return resultado;
    }
    public void declararVariables(){
        jornadas = jornadaDAO.getJornadas();
        equipos = equipoDAO.obtenerTodosLosEquipos();
    }
    public void crearJornada(){
        for (int i = 0; i < equipos.size(); i++){
            Jornada jornada = new Jornada();
            jornada.setNumJornada(elegirNumJornada());
            jornada.setFechaInicio(elegirFecha());
            enfrentamientoController.crearEnfrentamientos();
            jornadaDAO.anadirJornada(jornada);
        }
        for (Jornada jornada : jornadas){
            System.out.println(jornada.getNumJornada() + " " + jornada.getFechaInicio());
        }
    }
    public int elegirNumJornada(){
        int numJornada;
        try {
            numJornada = jornadas.getLast().getNumJornada()+1;
        }catch (NullPointerException e){
            numJornada = 1;
        }
        return numJornada;
    }
    public LocalDate elegirFecha(){
        int mes;
        int dia;
        int year;
        try {
            LocalDate fecha = elegirDia();
            mes = fecha.getMonthValue();
            dia = fecha.getDayOfMonth();
            year = fecha.getYear();
        }catch (NullPointerException e){
            mes = elegirMes();
            dia = elegirDiaInicial(mes);
            year = 2025;
        }
        return LocalDate.of(year,mes,dia);
    }
    private int elegirMes(){
        Random random = new Random();
        return random.nextInt(11)+1;
    }
    private int elegirDiaInicial(int mes){
        Random random = new Random();
        int randomDia = 0;
        if (mes == 2)
            randomDia = random.nextInt(27)+1;
        else{
            for (int i : meses31) {
                if (mes == i)
                    randomDia = random.nextInt(30)+1;
                else
                    randomDia = random.nextInt(29)+1;
            }
        }
        return randomDia;
    }
    private LocalDate elegirDia(){
        Random random = new Random();
        int randomDia;
        randomDia = random.nextInt(7);
        DayOfWeek diaJornada = jornadas.getLast().getFechaInicio().getDayOfWeek();
        int diasHastaDomingo = DayOfWeek.SUNDAY.getValue() - diaJornada.getValue();
        // Si el día actual no es domingo, suma los días necesarios
        if (diasHastaDomingo < 0) {
            diasHastaDomingo += 7;
        }
        return jornadas.getLast().getFechaInicio().plusDays(diasHastaDomingo).plusDays(randomDia);
    }
}
