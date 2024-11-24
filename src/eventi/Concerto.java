package eventi;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Concerto extends Evento {

	//variabili
    private LocalTime ora;
    private double prezzo;

    public Concerto(String titolo, LocalDate data, int postiTotali, LocalTime ora, double prezzo) {
        super(titolo, data, postiTotali);  // Chiamata classe Evento, titolo, data, posti totali
        this.ora = ora;
        this.prezzo = prezzo;
    }

    // Getter e setter per ora
    public LocalTime getOra() {
        return ora;
    }

    public void setOra(LocalTime ora) {
        this.ora = ora;
    }

    // Getter e setter per prezzo
    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    //Data formattata
    public String getDataFormattata() {
        return getData().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    //Ora formattata
    public String getOraFormattata() {
        return ora.format(DateTimeFormatter.ofPattern("HH:mm"));
    }

    //Prezzo formattato
    public String getPrezzoFormattato() {
        return String.format("%.2f€", prezzo);
    }

    // Sovrascrittura del metodo toString()
    @Override
    public String toString() {
        return getDataFormattata() + " - " + getOraFormattata() + " - " + getTitolo() + " - " + getPrezzoFormattato();
    }

    // Metodo main per testare la creazione e stampa dell'evento concerto
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);

            // Chiedi all'utente di inserire i dettagli dell'evento concerto
            System.out.print("Inserisci il titolo del concerto: ");
            String titolo = scanner.nextLine();

            System.out.print("Inserisci la data del concerto (formato: dd/MM/yyyy): ");
            String dataInput = scanner.nextLine();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate data = LocalDate.parse(dataInput, formatter);

            System.out.print("Inserisci il numero totale di posti disponibili: ");
            int postiTotali = Integer.parseInt(scanner.nextLine());

            // Chiedi anche ora e prezzo per il concerto
            System.out.print("Inserisci l'orario del concerto (formato: HH:mm): ");
            String oraInput = scanner.nextLine();
            LocalTime ora = LocalTime.parse(oraInput);

            System.out.print("Inserisci il prezzo del biglietto: ");
            double prezzo = Double.parseDouble(scanner.nextLine());

            // Creazione dell'evento concerto
            Concerto concerto = new Concerto(titolo, data, postiTotali, ora, prezzo);
            System.out.println("\nConcerto creato con successo!");
            System.out.println(concerto);  // Mostra i dettagli del concerto

            scanner.close();

        } catch (Exception e) {
            System.out.println("Errore: " + e.getMessage());
        }
    }
}

