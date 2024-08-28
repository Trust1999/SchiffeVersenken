package SchiffeDaten;

import java.util.Arrays;

//TODO
public class Zerstoerer extends Schiffe{

	protected static int anzahl = 3;
	
	//TODO
	public Zerstoerer() {
	    this.laenge = 3;
	    this.arrayPosition = 2;
	}
	 
	/**
	 * @brief Gibt heraus, ob das Schiffsfeld getroffen wurde.
	 * 
	 * @return Gibt 'true' zurück, wenn das Schiffsfeld getroffen ist; andernfalls 'false'.
	 * 
	 * @lastModified 26.08.2024
	 * @since 21.08.2024
	 * @author Johannes Schönwälder
	 */	
    public boolean getTreffer() {
        System.out.println("[Zerstoerer] Treffer " + treffer);
    	return treffer;
    }
    
    /**
	 * @brief Speichert einen Treffer auf das Schiffsfeld ab.
	 *  
	 * @lastModified 26.08.2024
	 * @since 21.08.2024
	 * @author Johannes Schönwälder
	 */	
    public void setTreffer() {
		System.out.println("[Zerstoerer] Treffer gespeichert");
    	treffer = true;
	}
    
    /**
	 * @brief Gibt heraus, wie lang das gesamte Schiff ist.
	 * 
	 * @return Gibt die Länge in Form einer Ganzzahl heraus.
	 * 
	 * @lastModified 26.08.2024
	 * @since 21.08.2024
	 * @author Johannes Schönwälder
	 */	
    public int getLaenge() {
    	System.out.println("[Zerstoerer] Laenge " + laenge);
        return laenge;
    }
    
    /**
	 * @brief Gibt die Richtung des Schiffs heraus.
	 * 
	 * @return Gibt die Einheits-Richtungsmatrix (immer Länge 1 bzw. -1 oder 0) in Ganzzahlform aus.
	 * 
	 * @lastModified 26.08.2024
	 * @since 21.08.2024
	 * @author Johannes Schönwälder
	 */	
	public int[] getRichtung() {
		System.out.println("[Zerstoerer] Ausrichtung " + Arrays.toString(richtung));
		return richtung;
	}
	
	/**
	 * @brief Speichert die Richtung des Schiffs ab.
	 * 
	 * @param ausrichtung Richtung des Schiffs in Form einer Richtungsmatrix.
	 * 
	 * @lastModified 26.08.2024
	 * @since 21.08.2024
	 * @author Johannes Schönwälder
	 */	
	public void setRichtung(int[] ausrichtung) {
		System.out.println("[Zerstoerer] Ausrichtung gespeichert");
		this.richtung = ausrichtung;
	}
	
	/**
	 * @brief Gibt heraus, wie viele Teile eines Schiffs bereits getroffen worden sind.
	 * 
	 * @return Gibt die Anzahl in Form einer Ganzzahl aus.
	 * 
	 * @lastModified 26.08.2024
	 * @since 21.08.2024
	 * @author Johannes Schönwälder
	 */	
    public int getAnzTreffer() {
    	System.out.println("[Zerstoerer] Anzahl Treffer " + anzTreffer);
        return anzTreffer;
    }
    
    /**
	 * @brief Erhöht die Anzahl der Treffer eines Schiffes um genau einen Wert.
	 *
	 * @lastModified 26.08.2024
	 * @since 21.08.2024
	 * @author Johannes Schönwälder
	 */	
    public void setAnzTreffer() {
    	System.out.println("[Zerstoerer] Anzahl Treffer gespeichert");
    	this.anzTreffer++;
    }
    
    /**
	 * @brief Gibt heraus, an welcher Position im Positionsarray das Schiff steht.
	 * 
	 * @return Gibt die Stelle in Ganzzahkform zurück.
	 * 
	 * @lastModified 26.08.2024
	 * @since 21.08.2024
	 * @author Johannes Schönwälder, Anton Unger
	 */	
    public int getArrayPosition() {
    	System.out.println("[Zerstoerer] Position im Array " + arrayPosition);
		return arrayPosition;
	}

    /**
     * @brief Überprüft, ob das Schiff vollständig versenkt wurde.
     * 
     * Diese Methode prüft, ob die Anzahl der Treffer auf das Schiff gleich seiner Länge ist,
     * d.h., ob das Schiff vollständig getroffen und somit versenkt wurde.
     * 
     * @return Gibt 'true' zurück, wenn das Schiff versenkt wurde, andernfalls 'false'.
     * 
     * @lastModified 28.08.2024
     * @since 28.08.2024
     * @author Anton Unger
     */
	public boolean getVersenkt() {
		System.out.println("[Zerstoerer] Schiff wurde versenkt " + (laenge == anzTreffer));
		return laenge == anzTreffer;
	}	
}