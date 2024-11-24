package eventi;

//librerie per date
import java.time.LocalDate;
import java.time.format.DateTimeFormatter; //dd/mm/yyyy

public class Evento {

	//variabili per evento: titolo/data/posti totali/posti prenotati
    private String titolo;
    private LocalDate data;
    private int postiTotali;
    private int postiPrenotati;


    //messaggio errore
    public Evento(String titolo, LocalDate data, int postiTotali) throws IllegalArgumentException {
        if (data.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("La data dell'evento non può essere nel passato.");
        }
        if (postiTotali <= 0) {
            throw new IllegalArgumentException("Il numero di posti totali deve essere positivo.");
        }

        this.titolo = titolo;
        this.data = data;
        this.postiTotali = postiTotali;
        this.postiPrenotati = 0;
    }

    // Getter e setter per modificare i valori
    //titolo
    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    //data
    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    // posti totali
    public int getPostiTotali() {
        return postiTotali;
    }

    //posti prenotati
    public int getPostiPrenotati() {
        return postiPrenotati;
    }

    // if per prenotare un posto
    public String prenota() {
        if (data.isBefore(LocalDate.now())) {
            return "Impossibile prenotare: l'evento è già passato.";
        }
        if (postiPrenotati >= postiTotali) {
            return "Impossibile prenotare: posti esauriti.";
        }
        postiPrenotati++;
        return "Prenotazione effettuata con successo.";
    }

    // if per disdetta prenotazione
    public String disdici() {
        if (data.isBefore(LocalDate.now())) {
            return "Impossibile disdire: l'evento è già passato.";
        }
        if (postiPrenotati <= 0) {
            return "Impossibile disdire: non ci sono prenotazioni.";
        }
        postiPrenotati--;
        return "Prenotazione annullata con successo.";
    }

    //formattazione data dd/mm/yyyy
    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return data.format(formatter) + " - " + titolo; //stampa data e titolo
    }

    //nuovo evento
    /*public static void main(String[] args) {
        try {
            // Creazione di un nuovo evento
            Evento concerto = new Evento("Concerto Milano", LocalDate.of(2024, 12, 10), 100); //LocalDate of(anno,mese,giorno)

            // Stampa dell'evento
            System.out.println(concerto);

            // Prenotazione di posti
            System.out.println(concerto.prenota()); // Prenotazione riuscita
            System.out.println(concerto.prenota()); // Prenotazione riuscita
            System.out.println("Posti prenotati: " + concerto.getPostiPrenotati());  //postiPrenotati++;

            // Disdetta di una prenotazione
            System.out.println(concerto.disdici()); // Prenotazione annullata
            System.out.println("Disdetta riuscita, posti prenotati aggiornati: " + concerto.getPostiPrenotati()); //postiPrenotati --

            // Tentativo di prenotazione per un evento passato
            Evento eventoPassato = new Evento("Conferenza 2023", LocalDate.of(2023, 5, 10), 200);
            System.out.println(eventoPassato.prenota()); // Impossibile prenotare, evento passato

        } catch (IllegalArgumentException e) {
            System.out.println("Errore: " + e.getMessage());
        }
    }
    */
}




