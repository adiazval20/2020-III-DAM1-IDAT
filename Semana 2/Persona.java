class Persona {
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String nombres;

    public Persona() {
        this.apellidoPaterno = "";
        this.apellidoMaterno = "";
        this.nombres = "";
    }

    public Persona(String apellidoPaterno, String apellidoMaterno, String nombres) {
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.nombres = nombres;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoPaterno() {
        return this.apellidoPaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getApellidoMaterno() {
        return this.apellidoMaterno;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getNombres() {
        return this.nombres;
    }
}