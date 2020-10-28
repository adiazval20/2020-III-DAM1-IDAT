class Circulo extends Forma {
    private float radio = 8;

    public float calcularArea() {
        return (float) (Math.PI * Math.pow(radio, 2));
    }
}