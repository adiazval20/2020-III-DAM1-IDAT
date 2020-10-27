class Calculadora {
    public int sumar(int x, int y) {
        return x + y;
    }

    public int restar(int x, int y) {
        return x - y;
    }

    public int multiplicar(int x, int y) {
        return x * y;
    }

    public int dividir(int x, int y) {
        return x / y;
    }

    public int max(int x, int y, int z) {
        int mayor = x;

        if (y > mayor) {
            mayor = y;
        }
        if (z > mayor) {
            mayor = z;
        }
        return mayor;
    }

    public int numMax(int x, int y, int z) {
        return Math.max(x, Math.max(y, z));
    }

    // Ejm. 0, 1, 1, 2, 3, 5, 8, 13, 21, 34...
    public void fibonacci(int x) {
        System.out.println("Serie de Fibonacci");

        int prevNum = 0;
        int actualNum = 1;
        int nextNum = prevNum + actualNum;

        System.out.println(prevNum);
        System.out.println(actualNum);

        while(nextNum <= x) {
            System.out.println(nextNum);
            prevNum = actualNum;
            actualNum = nextNum;
            nextNum = prevNum + actualNum;
        }
    }
}