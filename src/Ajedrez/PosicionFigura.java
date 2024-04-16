package Ajedrez;

public class PosicionFigura {
    private Posicion pos;
    private Figura figura;

    public PosicionFigura(Posicion pos, Figura figura) {
        this.pos = pos;
        this.figura = figura;
    }

    public Posicion getPosicion() {
        return pos;
    }

    public Figura getFigura() {
        return figura;
    }
}
