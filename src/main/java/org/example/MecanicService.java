package org.example;

import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class MecanicService {
    public void adaugaMecanic(ServiciuAuto serviciu, Scanner scanner) {
        System.out.print("Introduceți ID-ul mecanicului: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Introduceți numele mecanicului: ");
        String nume = scanner.nextLine();
        System.out.print("Introduceți specializarea mecanicului: ");
        String specializare = scanner.nextLine();

        Mecanic mecanic = new Mecanic(id, nume, specializare);
        serviciu.adaugaMecanic(mecanic);
        System.out.println("Mecanic adăugat cu succes.");
    }

    public void afiseazaMecanici(ServiciuAuto serviciu) {
        Set<Mecanic> mecanici = serviciu.getListaMecanici();
        if (mecanici.isEmpty()) {
            System.out.println("Nu există mecanici în baza de date.");
        } else {
            System.out.println("Mecanicii disponibili:");
            for (Mecanic mecanic : mecanici) {
                System.out.println(mecanic);
            }
        }
    }

    public void afiseazaProgramariMecanic(ServiciuAuto serviciu, Scanner scanner) {
        System.out.print("Introduceți numele mecanicului: ");
        String numeMecanic = scanner.nextLine();
        List<Programare> programariMecanic = serviciu.getProgramariMecanic(numeMecanic);

        if (programariMecanic.isEmpty()) {
            System.out.println("Nu există programări pentru acest mecanic.");
        } else {
            System.out.println("Programările pentru mecanicul " + numeMecanic + ":");
            for (Programare programare : programariMecanic) {
                System.out.println(programare);
            }
        }
    }
}