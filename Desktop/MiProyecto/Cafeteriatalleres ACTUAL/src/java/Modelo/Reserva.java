package Modelo;

public class Reserva {

    private String num_personas;
    private String hora;
    private String fecha;
    private int usuarios_idUsuarios;
    private int getidReserva;
    private int idReserva;

    public Reserva() {
    }

    public Reserva(String num_personas, String hora, String fecha, int usuarios_idUsuarios) {
        this.num_personas = num_personas;
        this.hora = hora;
        this.fecha = fecha;
        this.usuarios_idUsuarios = usuarios_idUsuarios;
    }

    public String getNum_personas() {
        return num_personas;
    }

    public void setNum_personas(String num_personas) {
        this.num_personas = num_personas;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getUsuarios_idUsuarios() {
        return usuarios_idUsuarios;
    }

    public void setUsuarios_idUsuarios(int usuarios_idUsuarios) {
        this.usuarios_idUsuarios = usuarios_idUsuarios;
    }

    public void setidReserva(int idReserva) {
        this.getidReserva = idReserva;
    }

    public int getidReserva() {
        return idReserva;
    }
}
