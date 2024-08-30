package SchiffeDaten;

/**
 * @brief Deklaration der Klasse Felder
 * 
 * Diese Klasse ist die Klasse, auf der das ganze Spielfeld beruht. Mit der Klasse 'Felder' sollen die 
 * Spielfelder (1x1-Felder) der jeweiligen Spielbretter bzw. Notizzettel der Spieler dargestellt werden.
 * 
 * @lastModified 26.08.2024
 * @since 21.08.2024
 * @author Johannes Schönwälder
 */	
public abstract class Felder {

	protected boolean treffer = false;

	public abstract boolean getTreffer();
	public abstract void setTreffer();
}
