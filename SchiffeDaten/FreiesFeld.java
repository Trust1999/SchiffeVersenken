package SchiffeDaten;

/**
 * @brief Deklaration der Klasse FreiesFeld
 * 
 * Diese Klasse ist eine Unterklasse der Klasse Felder und legt fest, welche Eigenschaften dieses bestimmte
 * Feld genau hat.
 * In diesem Fall handelt es sich um ein freies Feld, welches ein "normales" Feld ist, welches keine besonderen
 * Eigenschaften hat, außer dass es leer ist und somit ein Schiffsfeld ('Schiffe') oder ein belegtes 
 * Feld ('BelegtesFeld') werden kann.
 * Es kann wie jedes andere Feld auch getroffen werden, was dann auch abgespeichert wird (damit die GUI das auch
 * anzeigen kann).
 * 
 * @lastModified 26.08.2024
 * @since 21.08.2024
 * @author Johannes Schönwälder
 */	
public class FreiesFeld extends Felder {
	
	
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