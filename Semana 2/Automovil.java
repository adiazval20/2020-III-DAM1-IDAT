class Automovil implements Vehiculo {
    @Override
    public void desplazarse() {
        System.out.println("Me estoy desplazando!");
    }

    @Override
    public void frenar() {
        System.out.println("Estod frenando!");
    }
}