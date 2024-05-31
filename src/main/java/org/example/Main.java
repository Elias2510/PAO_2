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
    private static LocatieService locatieService;

    private static ManagerService managerService;
    public static void main(String[] args) {
        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) {
            System.out.println("Eroare la conectarea la baza de date!");
            return;
        }

        masinaService = new MasinaService(connection);
        mecanicService = new MecanicService(connection);
        programareService = new ProgramareService(connection);
        locatieService = new LocatieService(connection);
        managerService = new ManagerService(connection);

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
                    case 13:
                        adaugaLocatie(scanner);
                        break;
                    case 14:
                        afiseazaLocatii();
                        break;
                    case 15:
                        actualizeazaLocatie(scanner);
                        break;
                    case 16:
                        stergeLocatie(scanner);
                        break;
                    case 17:
                        adaugaManager(scanner);
                    case 18:
                        afiseazaManager();
                    case 19:
                        actualizeazaSalariu(scanner);
                    case 20:
                        stergeManager(scanner);
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
        System.out.println("13. Adauga locatie");
        System.out.println("14. Afiseaza locatii");
        System.out.println("15. Actualizeaza locatie");
        System.out.println("16. Sterge locatie");
        System.out.println("17. Adauga manager");
        System.out.println("18. Afiseaza manageri");
        System.out.println("19. Actualizeaza manager");
        System.out.println("20. Sterge manager");
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
        AuditService.logAction("Adauga masina");
        System.out.println("Masina a fost adaugata cu succes.");
    }

    private static void afiseazaMasini() throws SQLException {
        List<Masina> masini = masinaService.afiseazaMasini();
        for (Masina masina : masini) {
            System.out.println(masina);
        }
        AuditService.logAction("Afiseaza masini");
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
        AuditService.logAction("Actualizeaza masina");
        System.out.println("Masina a fost actualizata cu succes.");
    }

    private static void stergeMasina(Scanner scanner) throws SQLException {
        System.out.print("ID masina: ");
        int id = Integer.parseInt(scanner.nextLine());
        masinaService.stergeMasina(id);
        AuditService.logAction("Sterge masina");
        System.out.println("Masina a fost stearsa cu succes.");
    }

    private static void adaugaMecanic(Scanner scanner) throws SQLException {
        System.out.print("Nume: ");
        String nume = scanner.nextLine();
        System.out.print("Specializare: ");
        String specializare = scanner.nextLine();

        Mecanic mecanic = new Mecanic(0, nume, specializare);
        mecanicService.adaugaMecanic(mecanic);
        AuditService.logAction("Adauga mecanic");
        System.out.println("Mecanic adaugat cu succes.");
    }

    private static void afiseazaMecanici() throws SQLException {
        List<Mecanic> mecanici = mecanicService.afiseazaMecanici();
        for (Mecanic mecanic : mecanici) {
            System.out.println(mecanic);
        }
        AuditService.logAction("Afiseaza mecanici");
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
        AuditService.logAction("Actualizeaza mecanic");
        System.out.println("Mecanic actualizat cu succes.");
    }

    private static void stergeMecanic(Scanner scanner) throws SQLException {
        System.out.print("ID mecanic: ");
        int id = Integer.parseInt(scanner.nextLine());
        mecanicService.stergeMecanic(id);
        AuditService.logAction("Sterge mecanic");
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
        AuditService.logAction("Adauga programare");
        System.out.println("Programare adaugata cu succes.");
    }

    private static void afiseazaProgramari() throws SQLException {
        List<Programare> programari = programareService.afiseazaProgramari();
        for (Programare programare : programari) {
            System.out.println(programare);
        }
        AuditService.logAction("Afiseaza programari");
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
        AuditService.logAction("Actualizeaza programare");
        System.out.println("Programare actualizata cu succes.");
    }

    private static void stergeProgramare(Scanner scanner) throws SQLException {
        System.out.print("ID programare: ");
        int id = Integer.parseInt(scanner.nextLine());
        programareService.stergeProgramare(id);
        AuditService.logAction("Sterge programare");
        System.out.println("Programare stearsa cu succes.");
    }

    private static void adaugaLocatie(Scanner scanner) throws SQLException {
        System.out.print("Judet: ");
        String judet = scanner.nextLine();
        System.out.print("Oras: ");
        String oras = scanner.nextLine();
        System.out.print("ID mecanic: ");
        int mecanicId = Integer.parseInt(scanner.nextLine());

        Locatie locatie = new Locatie(0, judet, oras, mecanicId);
        locatieService.adaugaLocatie(locatie);
        AuditService.logAction("Adauga locatie");
        System.out.println("Locatie adaugata cu succes.");
    }

    private static void afiseazaLocatii() throws SQLException {
        List<Locatie> locatii = locatieService.afiseazaLocatii();
        for (Locatie locatie : locatii) {
            System.out.println(locatie);
        }
        AuditService.logAction("Afiseaza locatii");
    }

    private static void actualizeazaLocatie(Scanner scanner) throws SQLException {
        System.out.print("ID locatie: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Judet: ");
        String judet = scanner.nextLine();
        System.out.print("Oras: ");
        String oras = scanner.nextLine();
        System.out.print("ID mecanic: ");
        int mecanicId = Integer.parseInt(scanner.nextLine());

        Locatie locatie = new Locatie(id, judet, oras, mecanicId);
        locatieService.actualizeazaLocatie(locatie);
        AuditService.logAction("Actualizeaza locatie");
        System.out.println("Locatie actualizata cu succes.");
    }

    private static void stergeLocatie(Scanner scanner) throws SQLException {
        System.out.print("ID locatie: ");
        int id = Integer.parseInt(scanner.nextLine());
        locatieService.stergeLocatie(id);
        AuditService.logAction("Sterge locatie");
        System.out.println("Locatie stearsa cu succes.");
    }
    private static void adaugaManager(Scanner scanner) throws SQLException {
        System.out.print("ID mecanic: ");
        int idMecanic = Integer.parseInt(scanner.nextLine());
        System.out.print("Salariu: ");
        double salariu = Double.parseDouble(scanner.nextLine());

        Manager manager = new Manager(0, idMecanic, salariu);
        managerService.adaugaManager(manager);
        AuditService.logAction("Adauga manager");
        System.out.println("Manager adăugat cu succes.");
    }

    private static void afiseazaManager() throws SQLException {
        List<Manager> manageri = managerService.afiseazaManageri();
        for (Manager manager : manageri) {
            System.out.println(manager);
        }
        AuditService.logAction("Afiseaza manageri");
    }

    private static void actualizeazaSalariu(Scanner scanner) throws SQLException {
        System.out.print("ID plata: ");
        int idPlata = Integer.parseInt(scanner.nextLine());
        System.out.print("Salariu nou: ");
        double salariuNou = Double.parseDouble(scanner.nextLine());

        managerService.actualizeazaSalariu(idPlata, salariuNou);
        AuditService.logAction("Actualizeaza salariu manager");
        System.out.println("Salariul a fost actualizat cu succes.");
    }

    private static void stergeManager(Scanner scanner) throws SQLException {
        System.out.print("ID plata: ");
        int idPlata = Integer.parseInt(scanner.nextLine());
        managerService.stergeManager(idPlata);
        AuditService.logAction("Sterge manager");
        System.out.println("Managerul a fost șters cu succes.");
    }

}

