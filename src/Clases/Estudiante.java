/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author Samir Rojas
 */
public class Estudiante {
    private String Nombre;
    private String Apellido;
    private String NumeroDocumento;
    private int Asignatura;
    
     public Estudiante(){

}

    public Estudiante(String Nombre, String Apellido, String NumeroDocumento, int Asignatura) {
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.NumeroDocumento = NumeroDocumento;
        this.Asignatura = Asignatura;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public String getNumeroDocumento() {
        return NumeroDocumento;
    }

    public void setNumeroDocumento(String NumeroDocumento) {
        this.NumeroDocumento = NumeroDocumento;
    }

    public int getAsignatura() {
        return Asignatura;
    }

    public void setAsignatura(int Asignatura) {
        this.Asignatura = Asignatura;
    }
     
     
}
