package eventi;

import java.util.Scanner; //input utente
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Dichiarazione variabili
        String titolo = "";
        String dataInput = "";
        LocalDate data = null;
        int postiTotali = 0;
        Evento evento = null;
        String risposta = "";
        int prenotazioni = 0;
        int disdette = 0;

        try {
            // Chiedi all'utente di inserire i dettagli dell'evento
            System.out.print("Inserisci il titolo dell'evento: ");
            titolo = scanner.nextLine();

            System.out.print("Inserisci la data dell'evento (formato: dd/MM/yyyy): ");
            dataInput = scanner.nextLine();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            data = LocalDate.parse(dataInput, formatter);

            System.out.print("Inserisci il numero totale di posti disponibili: ");
            postiTotali = Integer.parseInt(scanner.nextLine());

            // Creazione evento
            evento = new Evento(titolo, data, postiTotali);
            System.out.println("\nEvento creato con successo!");
            System.out.println(evento);  // Mostra i dettagli dell'evento

            // Prenotazioni
            System.out.print("\nVuoi fare delle prenotazioni? (si/no): ");
            risposta = scanner.nextLine();

            //while alla conferma
            while (risposta.equalsIgnoreCase("si")) {
                System.out.print("Quanti posti vuoi prenotare? ");
                prenotazioni = Integer.parseInt(scanner.nextLine());

                // Prenotazione
                for (int i = 0; i < prenotazioni; i++) {
                    String risultato = evento.prenota();
                    System.out.println(risultato);
                }

                System.out.println("\nPosti prenotati: " + evento.getPostiPrenotati());
                System.out.println("Posti disponibili: " + (evento.getPostiTotali() - evento.getPostiPrenotati()));

                // Chiedi se l'utente vuole fare altre prenotazioni
                System.out.print("\nVuoi fare altre prenotazioni? (si/no): ");
                risposta = scanner.nextLine();
            }

            // Disdette
            System.out.print("\nVuoi disdire delle prenotazioni? (si/no): ");
            risposta = scanner.nextLine();

            while (risposta.equalsIgnoreCase("si")) {
                System.out.print("Quanti posti vuoi disdire? ");
                disdette = Integer.parseInt(scanner.nextLine());

                // Disdici i posti
                for (int i = 0; i < disdette; i++) {
                    String risultato = evento.disdici();
                    System.out.println(risultato);
                }

                System.out.println("\nPosti prenotati: " + evento.getPostiPrenotati());
                System.out.println("Posti disponibili: " + (evento.getPostiTotali() - evento.getPostiPrenotati()));

                // Chiedi se l'utente vuole fare altre disdette
                System.out.print("\nVuoi disdire altri posti? (si/no): ");
                risposta = scanner.nextLine();
                
                //fine
                System.out.println("\nFine prenotazione, posti prenotati: " + evento.getPostiPrenotati());
            }

        } catch (IllegalArgumentException e) {
            System.out.println("Errore: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Si è verificato un errore. Assicurati di inserire i dati correttamente.");
        } finally {
            scanner.close();
        }
    }
}
