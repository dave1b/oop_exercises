package ch.hslu.sw06.übung;

import java.util.Objects;

/**
 * Modell eines Punktes im 2D-Raum. Klasse ist Immutable implementiert.
 */
@SuppressWarnings("PMD.ShortVariable")
public final class Point {

	/**
	 * Punkt keinem Quadrant zugeordnet.
	 */
	private static final int NO_QUADRANT = 0;
	
	/**
	 * Quadrant 1. Positiv x, Positiv y.
	 */
	private static final int QUADRANT_1 = 1;

	/**
	 * Quadrant 1. Negativ x, Positiv y.
	 */
	private static final int QUADRANT_2 = 2;

	/**
	 * Quadrant 1. Negativ x, Negativ y.
	 */
	private static final int QUADRANT_3 = 3;

	/**
	 * Quadrant 4. Positiv x, Negativ y.
	 */
	private static final int QUADRANT_4 = 4;

	private int x;
	private int y;
	
	private double winkel;
	private double betrag;
	
	private double xPolar;
	private double yPolar;

	/**
	 * Konstruktor für Punkt mit Koordinaten.
	 * 
	 * @param x x-Koordinate.
	 * @param y y-Koordinate.
	 */
	public Point(final int x, final int y) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Konstruktor für die Kopie eines Punktes.
	 * 
	 * @param ein Objekt des Typs Point
	 * 
	 */
	public Point(Point point) {
		this(point.getX(),point.getY());
		}
	
	
	public Point(double betrag, double winkel) {
		this.betrag = betrag;
		this.winkel = Math.toRadians(winkel);;
	}
	
	public double getXByPolar() {
		System.out.println(Math.cos(winkel));
		return this.xPolar = this.betrag * (Math.cos(this.winkel));
	}
	
	public double getYByPolar() {
		return this.yPolar = this.betrag * Math.sin(this.winkel);
	}
	
	

	/**
	 * Liefert den Quadranten in welchem der Punkt liegt. Liegen die Koordinaten auf
	 * den Achsen oder auf dem Nullpunkt, liefert die Funktion den Wert 0 zurück.
	 * 
	 * @return Nummer des Quadranten.
	 */
	public int getQuadrant() {
		int quadrant = NO_QUADRANT;
		if (this.x != 0 && this.y != 0) {
			if (this.x > 0) {
				if (this.y > 0) {
					quadrant = QUADRANT_1;
				} else {
					quadrant = QUADRANT_4;
				}
			} else {
				if (this.y > 0) {
					quadrant = QUADRANT_2;
				} else {
					quadrant = QUADRANT_3;
				}
			}
		}
		return quadrant;
	}

	/**
	 * Liefert x-Koordinate zurück.
	 * 
	 * @return x-Koordinate des Punktes.
	 */
	public int getX() {
		return this.x;
	}

	/**
	 * Liefert y-Koordinate zurück.
	 * 
	 * @return y-Koordinate des Punktes.
	 */
	public int getY() {
		return y;
	}

	/**
	 * Zwei Punkte mit identischen Koordinaten sind gleich. {@inheritDoc}.
	 */
	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Point)) {
			return false;
		}
		final Point other = (Point) obj;
		return this.x == other.x && this.y == other.y;
	}

	/**
	 * Liefert Hashcode auf Basis von x und y-Koordinate. {@inheritDoc}.
	 */
	@Override
	public int hashCode() {
		return Objects.hash(this.x, this.y);
	}

	/**
	 * Liefert eine String-Repräsentation des Punktes. {@inheritDoc}.
	 */
	@Override
	public String toString() {
		return "Point[x=" + this.x + ",y=" + this.y + "]";
	}

	public void moveRealative(int x, int y) {
		this.x += x;
		this.y += y;
	}

	public void moveRealative(Point point) {
		this.x += point.getX();
		this.y += point.getY();
	}

}
