package common;

public class Messaggio {
    private String mittente;
    private String destinatario;
    private String contenuto;

    public Messaggio(String mittente, String destinatario, String contenuto) {
        this.mittente = mittente;
        this.destinatario = destinatario;
        this.contenuto = contenuto;
    }

    public String getMittente() {
        return mittente;
    }

    public void setMittente(String mittente) {
        this.mittente = mittente;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public String getContenuto() {
        return contenuto;
    }

    public void setContenuto(String contenuto) {
        this.contenuto = contenuto;
    }
}
