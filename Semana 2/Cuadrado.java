class Cuadrado extends Forma {
    private float lado;

    public Cuadrado() {
        this.lado = 5;
    }

    public Cuadrado(float lado) {
        this.lado = lado;
        System.out.println("Instanciando un nuevo cuadrado");
    }

    public float calcularArea() {
        return lado * lado;
    }
}