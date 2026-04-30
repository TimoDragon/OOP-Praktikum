/**
 * Inhaber
 */
public class Inhaber {
    private final String nachname;
    private final String vorname;
    private final String adresse;

    /**
     * Konstruktor für einen Inhaber
     * @param vorname   Vorname
     * @param nachname  Nachname
     * @param adresse   Adresse als String
     */
    public Inhaber(String vorname, String nachname, String adresse) {
        this.vorname = vorname;
        this.nachname = nachname;
        this.adresse = adresse;
    }

    /**
     * Gibt den Nachnamen zurück
     * @return Nachname
     */
    public String getNachname() {
        return nachname;
    }

    /**
     * Gibt den Vornamen zurück
     * @return Vorname
     */
    public String getVorname() {
        return vorname;
    }

    /**
     * Gibt die Adresse als String zurück
     * @return  Adresse
     */
    public String getAdresse() {
        return adresse;
    }
}
