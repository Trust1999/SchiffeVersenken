package SchiffeDaten;

/**
 * @brief Deklaration der Klasse Schiffe
 * 
 * Diese Klasse ist eine Unterklasse der Klasse Felder und legt fest, welche Eigenschaften dieses bestimmte
 * Feld genau hat.
 * In diesem Fall handelt es sich um ein Schiff, welches verschiedene besondere Eigenschaften zu einem anderen Feld hat.
 * Es werden wichtige Daten wie die Länge, wie viele Treffer es bereits bekommen hat und in welche Richtung
 * es ausgerichtet ist jeweils abgespeichert.
 * 
 * @lastModified 26.08.2024
 * @since 21.08.2024
 * @author Johannes Schönwälder
 */	
public abstract class Schiffe extends Felder {

    protected int laenge;
    protected int[] richtung = new int[1];
    protected int arrayPosition;
	protected int anzTreffer = 0;
    
	public abstract int getLaenge();
	public abstract int[] getRichtung();
	public abstract void setRichtung(int[] ausrichtung);
	
	public abstract boolean getVersenkt();
	
	public abstract int getArrayPosition();
	
	public abstract int getAnzTreffer();
	public abstract void setAnzTreffer();
}
