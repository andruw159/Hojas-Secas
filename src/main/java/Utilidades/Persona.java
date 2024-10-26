
package Utilidades;

import java.io.Serializable;

public class Persona implements Serializable{
    private String id, nombre, sexo, empresa, requerimiento, estado, fecha, motivoMulta, motivoPago;
    int multas, totalPagar, transporte;

    public Persona() {
    }

    public Persona(String id, String nombre, String sexo, String empresa, String requerimiento, String estado, String fecha,
            int multas, String motivo, int totalPagar, String motivoPago, int transporte) {
        this.id = id;
        this.nombre = nombre;
        this.sexo = sexo;
        this.empresa = empresa;
        this.requerimiento = requerimiento;
        this.estado = estado;
        this.fecha = fecha;
        this.multas = multas;
        this.motivoMulta = motivo;
        this.totalPagar = totalPagar;
        this.motivoPago = motivoPago;
        this.transporte = transporte;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getRequerimiento() {
        return requerimiento;
    }

    public void setRequerimiento(String requerimiento) {
        this.requerimiento = requerimiento;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getMultas() {
        return multas;
    }

    public void setMultas(int multas) {
        this.multas = multas;
    }

    public String getMotivoMulta() {
        return motivoMulta;
    }

    public void setMotivoMulta(String motivoMulta) {
        this.motivoMulta = motivoMulta;
    }

    public String getMotivoPago() {
        return motivoPago;
    }

    public void setMotivoPago(String motivoPago) {
        this.motivoPago = motivoPago;
    }

    public int getTotalPagar() {
        return totalPagar;
    }

    public void setTotalPagar(int totalPagar) {
        this.totalPagar = totalPagar;
    }

    public int getTransporte() {
        return transporte;
    }

    public void setTransporte(int transporte) {
        this.transporte = transporte;
    }

    @Override
    public String toString() {
        return "Persona{" + "id=" + id + ", nombre=" + nombre + ", sexo=" + sexo + ", empresa=" + empresa + ", requerimiento=" + requerimiento + ", estado=" + estado + ", fecha=" + fecha + ", motivoMulta=" + motivoMulta + ", motivoPago=" + motivoPago + ", multas=" + multas + ", totalPagar=" + totalPagar + ", transporte=" + transporte + '}';
    }
}