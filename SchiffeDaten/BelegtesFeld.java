package SchiffeDaten;

/**
 * @brief Deklaration der Klasse BelegtesFeld
 * 
 * Diese Klasse ist eine Unterklasse der Klasse Felder und legt fest, welche Eigenschaften dieses bestimmte
 * Feld genau hat.
 * In diesem Fall handelt es sich um ein belegtes Feld, welches ein Feld ist, welches dieselben Eigenschaften wie
 * ein freies Feld hat, aber kein Schiffsfeld ('Schiffe') werden kann. Dies wird dafür benutzt, dass die Spieler
 * keine Schiffe direkt nebeneinander setzen können.
 * Es kann wie jedes andere Feld auch getroffen werden, was dann auch abgespeichert wird (damit die GUI das auch
 * anzeigen kann).
 * 
 * @lastModified 26.08.2024
 * @since 21.08.2024
 * @author Johannes Schönwälder
 */	
public class BelegtesFeld extends Felder { 
	
	
	/**
	 * @brief Gibt heraus, ob das Feld getroffen wurde.
	 * 
	 * @return Gibt 'true' zurück, wenn das Feld getroffen ist; andernfalls 'false'.
	 * 
	 * @lastModified 26.08.2024
	 * @since 21.08.2024
	 * @author Johannes Schönwälder
	 */	
	public boolean getTreffer() {
		return treffer;
	}
	
	/**
	 * @brief Speichert einen Treffer auf das Feld ab.
	 * 
	 * @lastModified 26.08.2024
	 * @since 21.08.2024
	 * @author Johannes Schönwälder
	 */	
	public void setTreffer() {
		this.treffer = true;
	}
}