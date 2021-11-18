package Clases;

public class Docente {

    private String Nombre;
    private String Apellido;
    private int Edad;
    private int TipoDocumento;
    private String NumeroDocumento;
    private int Asignatura;

 


    public  Docente(){
        
    }

    public Docente(String Nombre, String Apellido, int Edad, int TipoDocumento, String NumeroDocumento, int Asignatura) {
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Edad = Edad;
        this.TipoDocumento = TipoDocumento;
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

    public int getEdad() {
        return Edad;
    }

    public void setEdad(int Edad) {
        this.Edad = Edad;
    }

    public int getTipoDocumento() {
        return TipoDocumento;
    }

    public void setTipoDocumento(int TipoDocumento) {
        this.TipoDocumento = TipoDocumento;
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