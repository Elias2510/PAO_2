package org.example;

import java.util.Scanner;

public class InterfataUtilizator {
    private Scanner scanner;

    public InterfataUtilizator() {
        scanner = new Scanner(System.in);
    }

    public void afisareMesaj(String mesaj) {
        System.out.println(mesaj);
    }

    public int citireNumar() {
        return scanner.nextInt();
    }

    public String citireString() {
        return scanner.nextLine().trim();
    }

    public void afisareMeniu() {
        System.out.println("\n===== Meniu =====");
        System.out.println("1. Adăugare mașină");
        System.out.println("2. Programare mașină");
        System.out.println("3. Afișare mașini");
        System.out.println("4. Afișare programări");
        System.out.println("5. Afișare mecanici");
        System.out.println("6. Actualizare detaliilor unei mașini sau programări");
        System.out.println("7. Ștergere mașină sau programare");
        System.out.println("8. Afișare programări pentru un anumit mecanic");
        System.out.println("9. Adăugare mecanic");
        System.out.println("10. Adăugare client");
        System.out.println("0.  --Ieșire--");
        System.out.println("=================\n");
    }
}

