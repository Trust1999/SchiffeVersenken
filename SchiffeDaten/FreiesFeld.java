package SchiffeDaten;

//TODO
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