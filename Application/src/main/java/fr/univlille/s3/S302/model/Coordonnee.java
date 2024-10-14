package fr.univlille.s3.S302.model;

public class Coordonnee {
    private final double x;
    private final double y;

    public Coordonnee(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public String toString() {
        return "Coordonnee{" + "x=" + x + ", y=" + y + '}';
    }
}
