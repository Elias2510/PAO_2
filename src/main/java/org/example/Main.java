package org.example;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static MasinaService masinaService;
    private static MecanicService mecanicService;
    private static ProgramareService programareService;

    public static void main(String[] args) {
        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) {
            System.out.println("Eroare la conectarea la baza de date!");
            return;
        }

        masinaService = new MasinaService(connection);
        mecanicService = new MecanicService(connection);
        programareService = new ProgramareService(connection);

        Scanner scanner = new Scanner(System.in);
        int option = -1;

        while (option != 0) {
            showMenu();
            option = Integer.parseInt(scanner.nextLine());

            try {
                switch (option) {
                    case 1:
                        adaugaMasina(scanner);
                        break;
                    case 2:
                        afiseazaMasini();
                        break;
                    case 3:
                        actualizeazaMasina(scanner);
                        break;
                    case 4:
                        stergeMasina(scanner);
                        break;
                    case 5:
                        adaugaMecanic(scanner);
                        break;
                    case 6:
                        afiseazaMecanici();
                        break;
                    case 7:
                        actualizeazaMecanic(scanner);
                        break;
                    case 8:
                        stergeMecanic(scanner);
                        break;
                    case 9:
                        adaugaProgramare(scanner);
                        break;
                    case 10:
                        afiseazaProgramari();
                        break;
                    case 11:
                        actualizeazaProgramare(scanner);
                        break;
                    case 12:
                        stergeProgramare(scanner);
                        break;
                    case 0:
                        System.out.println("La revedere!");
                        break;
                    default:
                        System.out.println("Opțiune invalidă. Încercați din nou.");
                        break;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        DatabaseConnection.closeConnection();
    }

    private static void showMenu() {
        System.out.println("Meniu:");
        System.out.println("1. Adauga masina");
        System.out.println("2. Afiseaza masini");
        System.out.println("3. Actualizeaza masina");
        System.out.println("4. Sterge masina");
        System.out.println("5. Adauga mecanic");
        System.out.println("6. Afiseaza mecanici");
        System.out.println("7. Actualizeaza mecanic");
        System.out.println("8. Sterge mecanic");
        System.out.println("9. Adauga programare");
        System.out.println("10. Afiseaza programari");
        System.out.println("11. Actualizeaza programare");
        System.out.println("12. Sterge programare");
        System.out.println("0. Iesire");
        System.out.print("Alege o opțiune: ");
    }

    private static void adaugaMasina(Scanner scanner) throws SQLException {
        System.out.print("Marca: ");
        String marca = scanner.nextLine();
        System.out.print("Model: ");
        String model = scanner.nextLine();
        System.out.print("An fabricatie: ");
        int anFabricatie = Integer.parseInt(scanner.nextLine());

        Masina masina = new Masina(0, marca, model, anFabricatie);
        masinaService.adaugaMasina(masina);
        System.out.println("Masina a fost adaugata cu succes.");
    }

    private static void afiseazaMasini() throws SQLException {
        List<Masina> masini = masinaService.afiseazaMasini();
        for (Masina masina : masini) {
            System.out.println(masina);
        }
    }

    private static void actualizeazaMasina(Scanner scanner) throws SQLException {
        System.out.print("ID masina: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Marca: ");
        String marca = scanner.nextLine();
        System.out.print("Model: ");
        String model = scanner.nextLine();
        System.out.print("An fabricatie: ");
        int anFabricatie = Integer.parseInt(scanner.nextLine());

        Masina masina = new Masina(id, marca, model, anFabricatie);
        masinaService.actualizeazaMasina(masina);
        System.out.println("Masina a fost actualizata cu succes.");
    }

    private static void stergeMasina(Scanner scanner) throws SQLException {
        System.out.print("ID masina: ");
        int id = Integer.parseInt(scanner.nextLine());
        masinaService.stergeMasina(id);
        System.out.println("Masina a fost stearsa cu succes.");
    }

    private static void adaugaMecanic(Scanner scanner) throws SQLException {
        System.out.print("Nume: ");
        String nume = scanner.nextLine();
        System.out.print("Specializare: ");
        String specializare = scanner.nextLine();

        Mecanic mecanic = new Mecanic(0, nume, specializare);
        mecanicService.adaugaMecanic(mecanic);
        System.out.println("Mecanic adaugat cu succes.");
    }

    private static void afiseazaMecanici() throws SQLException {
        List<Mecanic> mecanici = mecanicService.afiseazaMecanici();
        for (Mecanic mecanic : mecanici) {
            System.out.println(mecanic);
        }
    }

    private static void actualizeazaMecanic(Scanner scanner) throws SQLException {
        System.out.print("ID mecanic: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Nume: ");
        String nume = scanner.nextLine();
        System.out.print("Specializare: ");
        String specializare = scanner.nextLine();

        Mecanic mecanic = new Mecanic(id, nume, specializare);
        mecanicService.actualizeazaMecanic(mecanic);
        System.out.println("Mecanic actualizat cu succes.");
    }

    private static void stergeMecanic(Scanner scanner) throws SQLException {
        System.out.print("ID mecanic: ");
        int id = Integer.parseInt(scanner.nextLine());
        mecanicService.stergeMecanic(id);
        System.out.println("Mecanic sters cu succes.");
    }

    private static void adaugaProgramare(Scanner scanner) throws SQLException {
        System.out.print("ID masina: ");
        int idMasina = Integer.parseInt(scanner.nextLine());
        System.out.print("Data (YYYY-MM-DD): ");
        Date data = Date.valueOf(scanner.nextLine());
        System.out.print("Nume mecanic: ");
        String numeMecanic = scanner.nextLine();

        Programare programare = new Programare(0, idMasina, data, numeMecanic);
        programareService.adaugaProgramare(programare);
        System.out.println("Programare adaugata cu succes.");
    }

    private static void afiseazaProgramari() throws SQLException {
        List<Programare> programari = programareService.afiseazaProgramari();
        for (Programare programare : programari) {
            System.out.println(programare);
        }
    }

    private static void actualizeazaProgramare(Scanner scanner) throws SQLException {
        System.out.print("ID programare: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("ID masina: ");
        int idMasina = Integer.parseInt(scanner.nextLine());
        System.out.print("Data (YYYY-MM-DD): ");
        Date data = Date.valueOf(scanner.nextLine());
        System.out.print("Nume mecanic: ");
        String numeMecanic = scanner.nextLine();

        Programare programare = new Programare(id, idMasina, data, numeMecanic);
        programareService.actualizeazaProgramare(programare);
        System.out.println("Programare actualizata cu succes.");
    }

    private static void stergeProgramare(Scanner scanner) throws SQLException {
        System.out.print("ID programare: ");
        int id = Integer.parseInt(scanner.nextLine());
        programareService.stergeProgramare(id);
        System.out.println("Programare stearsa cu succes.");
    }
}
