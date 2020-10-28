class Alumno extends Persona {
    private String codigoUniversitario;
    private String cicloIngreso;

    public Alumno(){
        this.codigoUniversitario = "";
        this.cicloIngreso = "";
    }

    public Alumno(String codigoUniversitario, String cicloIngreso) {
        this.codigoUniversitario = codigoUniversitario;
        this.cicloIngreso = cicloIngreso;
    }

    public void setCodigoUniversitario(String codigoUniversitario) {
        this.codigoUniversitario = codigoUniversitario;
    }

    public String getCodigoUniversitario() {
        return this.codigoUniversitario;
    }

    public void setCicloIngreso(String cicloIngreso) {
        this.cicloIngreso = cicloIngreso;
    }

    public String getCicloIngreso() {
        return this.cicloIngreso;
    }
}