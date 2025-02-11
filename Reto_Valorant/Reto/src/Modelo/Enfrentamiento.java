package Modelo;

import java.time.LocalTime;

public class Enfrentamiento {
    private int numJornada;
    private int resultadosEq1;
    private int resultadosEq2;
    private LocalTime hora;
    private Jornada jornada;
    private Equipo equipo1;
    private Equipo equipo2;

    public Enfrentamiento(int numJornada, int resultadosEq1, int resultadosEq2, LocalTime hora, Jornada jornada, Equipo equipo1, Equipo equipo2) {
        this.numJornada = numJornada;
        this.resultadosEq1 = resultadosEq1;
        this.resultadosEq2 = resultadosEq2;
        this.hora = hora;
        this.jornada = jornada;
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
    }

    public Enfrentamiento() {
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public int getNumJornada() {
        return numJornada;
    }

    public void setNumJornada(int numJornada) {
        this.numJornada = numJornada;
    }

    public int getResultadosEq1() {
        return resultadosEq1;
    }

    public void setResultadosEq1(int resultadosEq1) {
        this.resultadosEq1 = resultadosEq1;
    }

    public int getResultadosEq2() {
        return resultadosEq2;
    }

    public void setResultadosEq2(int resultadosEq2) {
        this.resultadosEq2 = resultadosEq2;
    }

    public Jornada getJornada() {
        return jornada;
    }

    public void setJornada(Jornada jornada) {
        this.jornada = jornada;
    }

    public Equipo getEquipo1() {
        return equipo1;
    }

    public void setEquipo1(Equipo equipo1) {
        this.equipo1 = equipo1;
    }

    public Equipo getEquipo2() {
        return equipo2;
    }

    public void setEquipo2(Equipo equipo2) {
        this.equipo2 = equipo2;
    }
}
