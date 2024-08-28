package SchiffeDaten;

import java.util.Arrays;

public class Schlachtschiff extends Schiffe{

	protected static int anzahl = 1;
	
    public Schlachtschiff() {
    	this.laenge = 5;
    	this.arrayPosition = 0;
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
        System.out.println("[Kreuzer] Treffer " + treffer);
    	return treffer;
    }
    
    /**
	 * @brief Speichert einen Treffer auf das Schiffsfeld ab.
	 * 
	 * @return ---
	 * 
	 * @lastModified 26.08.2024
	 * @since 21.08.2024
	 * @author Johannes Schönwälder
	 */	
    public void setTreffer() {
		System.out.println("[Kreuzer] Treffer gespeichert");
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
    	System.out.println("[Kreuzer] Laenge " + laenge);
        return laenge;
    }
    
    /**
	 * @brief Gibt die Richtung des Schhiffs heraus.
	 * 
	 * @return Gibt die Einheits-Richtungsmatrix (immer Länge 1 bzw. -1 oder 0) in Ganzzahlform aus.
	 * 
	 * @lastModified 26.08.2024
	 * @since 21.08.2024
	 * @author Johannes Schönwälder
	 */	
	public int[] getRichtung() {
		System.out.println("[Kreuzer] Ausrichtung " + Arrays.toString(richtung));
		return richtung;
	}
	
	/**
	 * @brief Speichert die Richtung des Schiffs ab.
	 * 
	 * @param ausrichtung Richtung des Schiffs in Form einer Richtungsmatrix.
	 * @return ---
	 * 
	 * @lastModified 26.08.2024
	 * @since 21.08.2024
	 * @author Johannes Schönwälder
	 */	
	public void setRichtung(int[] ausrichtung) {
		System.out.println("[Kreuzer] Ausrichtung gespeichert");
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
    	System.out.println("[Kreuzer] Anzahl Treffer " + anzTreffer);
        return anzTreffer;
    }
    
    /**
	 * @brief Erhöht die Anzahl der Treffer eines Schiffes um genau ainen Wert.
	 * 
	 * @return ---
	 * 
	 * @lastModified 26.08.2024
	 * @since 21.08.2024
	 * @author Johannes Schönwälder
	 */	
    public void setAnzTreffer() {
    	System.out.println("[Kreuzer] Anzahl Treffer gespeichert");
    	this.anzTreffer++;
    }
    
    /**
	 * @brief Gibt heraus, an welcher Position im Positionsarray das Schiff steht..
	 * 
	 * @return Gibt die Stelle in Ganzzahkform zurück..
	 * 
	 * @lastModified 26.08.2024
	 * @since 21.08.2024
	 * @author Johannes Schönwälder, Anton Unger
	 */	
    public int getArrayPosition() {
    	System.out.println("[Kreuzer] Position im Array " + arrayPosition);
		return arrayPosition;
	}
}
