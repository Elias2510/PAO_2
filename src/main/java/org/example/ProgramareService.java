package org.example;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class ProgramareService {
    public void programareMasina(ServiciuAuto serviciu, Scanner scanner) {
        System.out.println("Introduceți detalii despre programare:");
        System.out.print("Introduceți ID-ul programării: ");
        int idProgramare = scanner.nextInt();
        scanner.nextLine(); // Consumă newline
        System.out.print("Introduceți ID-ul mașinii: ");
        int idMasina = scanner.nextInt();
        scanner.nextLine(); // Consumă newline
        System.out.print("Introduceți data programării (YYYY-MM-DD): ");
        String dataProgramareString = scanner.nextLine();
        System.out.print("Introduceți numele mecanicului: ");
        String numeMecanic = scanner.nextLine();

        Date dataProgramare = null;
        try {
            dataProgramare = new SimpleDateFormat("yyyy-MM-dd").parse(dataProgramareString);
        } catch (ParseException e) {
            System.out.println("Formatul datei este invalid. Reîncercați.");
            return;
        }

        Programare programare = new Programare(idProgramare, idMasina, dataProgramare, numeMecanic);
        serviciu.programareMasina(programare);
        System.out.println("Programare realizată cu succes.");
    }

    public void afiseazaProgramari(ServiciuAuto serviciu) {
        List<Programare> programari = serviciu.getListaProgramari();
        if (programari.isEmpty()) {
            System.out.println("Nu există programări în baza de date.");
        } else {
            System.out.println("Programările existente:");
            for (Programare programare : programari) {
                System.out.println(programare);
            }
        }
    }

    public void stergeProgramare(ServiciuAuto serviciu, Scanner scanner) {
        afiseazaProgramari(serviciu);
        System.out.print("Introduceți ID-ul programării pentru ștergere: ");
        int idProgramare = scanner.nextInt();
        scanner.nextLine();

        if (serviciu.stergeProgramare(idProgramare)) {
            System.out.println("Programarea a fost ștearsă cu succes.");
        } else {
            System.out.println("Programarea nu a fost găsită.");
        }
    }

    public void actualizeazaDetaliiProgramare(ServiciuAuto serviciu, Scanner scanner) {
        afiseazaProgramari(serviciu);
        System.out.print("Introduceți ID-ul programării pentru actualizare: ");
        int idProgramare = scanner.nextInt();
        scanner.nextLine(); // Consumă newline

        Programare programare = serviciu.cautaProgramare(idProgramare);
        if (programare == null) {
            System.out.println("Programarea nu a fost găsită.");
        } else {
            System.out.print("Introduceți noua dată (YYYY-MM-DD): ");
            String newDataString = scanner.nextLine();
            Date newData = null;
            try {
                newData = new SimpleDateFormat("yyyy-MM-dd").parse(newDataString);
            } catch (ParseException e) {
                System.out.println("Formatul datei este invalid. Reîncercați.");
                return;
            }
            programare.setData(newData);

            System.out.println("Detaliile programării au fost actualizate cu succes.");
        }
    }
}