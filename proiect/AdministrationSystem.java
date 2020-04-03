package com.company;
import java.io.IOException;
import java.util.*;
class AdministrationSystem { //Singleton
    private static AdministrationSystem myInstance = null;
    private VendingBooth vendingBooth;
    private TreeSet<Client> clients = new TreeSet<Client>();
    private TreeSet<Employee> employees = new TreeSet<Employee>();
    private TreeSet<Hall> halls = new TreeSet<Hall>();
    private TreeSet<Show> shows = new TreeSet<Show>();
    private static Scanner in = new Scanner(System.in);
    private String name, email;
    private AdministrationSystem() {
        vendingBooth = new VendingBooth();
    }

    public static AdministrationSystem getInstance() {
        if (myInstance == null)
            myInstance = new AdministrationSystem();
        return myInstance;
    }

    private Client findClient(String name, String email) {
        Client auxClient  = new Client(name, email, -1);
        Client bottom = clients.floor(auxClient);
        if (bottom == null || bottom.equals(auxClient)) {
            return bottom;
        }
        else {
            return null;
        }
    }

    private Client addClient(String name, String email) {
        Client auxClient  = new Client(name, email);
        clients.add(auxClient);
        return auxClient;
    }

    private void removeClient(String name, String email) {
        Client c  = findClient(name, email);
        if (c != null) {
            clients.remove(c);
        }
        else {
            System.out.println("Client inexistent");
        }
    }

    private Employee  findEmployee(String name, String email) {
        Employee auxClient  = new Employee(name, email, -1);
        Employee bottom = employees.floor(auxClient);
        if (bottom == null || bottom.equals(auxClient)) {
            return bottom;
        }
        else {
            return null;
        }
    }

    private Employee addEmployee(String name, String email) {
        Employee auxClient  = new Employee(name, email);
        employees.add(auxClient);
        return auxClient;
    }

    private void removeEmployee(String name, String email) {
        Employee c  = findEmployee(name, email);
        if (c != null) {
            employees.remove(c);
        }
        else {
            System.out.println("Client inexistent");
        }
    }

    private Show findShow(String name) {
        Show auxShow  = new Show(name);
        Show bottom = shows.floor(auxShow);
        if (bottom == null || bottom.equals(auxShow)) {
            return bottom;
        }
        else {
            return null;
        }
    }

    private Show addShow(String name) {
        Show auxShow  = new Show(name);
        shows.add(auxShow);
        return auxShow;
    }

    private void removeShow(String name) {
        Show c  = findShow(name);
        if (c != null) {
            shows.remove(c);
        }
        else {
            System.out.println("Show inexistent");
        }
    }

    private void readName() {
        System.out.println("Introduceti numele:");
        in.nextLine();
        name = in.nextLine();
    }

    private void readNameEmail() {
        System.out.println("Introduceti numele si emailul, fiecare pe cate o linie:");
        in.nextLine();
        name = in.nextLine();
        email = in.nextLine();
    }

    private void printShows() {
        for (Show s: shows) {
            System.out.println(s);
        }
    }

    private Hall findHall (int id) {
        for (Hall h: halls) {
            if (h.getId() == id)
                return h;
        }
        return null;
    }

    private void printHalls() {
        for (Hall h : halls) {
            System.out.println(h);
        }
    }

    private void auxInit() {
        for (int i = 0; i < 8; ++i) {
            halls.add(new Hall("Sala" + i, 10 * (i + 1)));
            clients.add(new Client("Nume" + i, "Email" + i));
            employees.add(new Employee("NumeE" + i, "EmailE" + i));
        }
        for (Hall h : halls) {
            for (int i = 0; i < 3; ++i) {
                shows.add(new Show(h.getName() + " Show" + i, h, 100 * (i + 1)));
            }
        }

    }

    public void master() {
        auxInit();
        while (true) {
            System.out.println("Introduceti operatia:\n0: Iesire\n1: Adauga client\n2: Adauga vechime angajati\n3: Sterge client:");
            System.out.println("4: Afiseaza clienti\n5: Schimba vechime singur angajat\n6: Adauga Angajat\n7: Sterge Angajat");
            System.out.println("8: Afiseaza sali\n9: Afiseaza spectacole\n10: Cumpara bilet\n11: Adauga spectacole");
            System.out.println("12: Sterge spectacol\n13: Afiseaza angajati");
            int option = in.nextInt();
            if (option == 0) {
                System.out.println("Procesul s-a incheiat cu succes");
                break;
            }

            if (option == 1) {
                readNameEmail();
                Client c = findClient(name, email);
                if (c == null) {
                    c = addClient(name, email);
                }
                else {
                    System.out.println("Clientul exista deja");
                }

            }

            if (option == 2) {
                for (Employee e: employees) {
                    e.addNoYears(1);
                }
            }

            if (option == 3) {
                readNameEmail();
                removeClient(name, email);
            }

            if (option == 4) {
                for (Client c : clients) {
                    System.out.println(c);
                }
            }

            if (option == 5) {
                readNameEmail();
                Employee e = findEmployee(name, email);
                if (e == null) {
                    System.out.println("Angajat inexistent");
                }
                else {
                    System.out.println("Introduceti noua vechime");
                    int x = in.nextInt();
                    e.setNoYears(x);
                }
            }

            if (option == 6) {
                readNameEmail();
                Employee e = findEmployee(name, email);
                if (e == null) {
                    e = addEmployee(name, email);
                }
                else {
                    System.out.println("Angajatul exista deja");
                }
            }

            if (option == 7) {
                readNameEmail();
                Employee e = findEmployee(name, email);
                if (e == null) {
                    System.out.println("Angajatul nu exista");
                }
                else {
                    employees.remove(e);
                }
            }

            if (option == 8) {
                printHalls();
            }

            if (option == 9) {
                printShows();
            }

            if (option == 10) {
                readNameEmail();
                Client C = findClient(name, email);
                if (C == null) {
                    String s = null;
                    System.out.println("Clientul nu exista, Doriti sa creati client nou? Y/N");
                    s = in.next();
                    if (s.equals("Y")) {
                        C = addClient(name, email);
                    }
                    else {
                        continue;
                    }
                }
                System.out.println("Introduceti ID-ul spectacolui. -1 Pentru a vedea toate spectacolele");
                int x = in.nextInt();
                while (x == -1) {
                    printShows();
                    System.out.println("Introduceti ID-ul spectacolui. -1 Pentru a vedea toate spectacolele");
                    x = in.nextInt();
                }
                System.out.println(x);
                Show sh = null;
                for (Show s: shows) {
                    if (s.getId() == x) {
                        sh = s;
                        break;
                    }
                }
                if (sh == null) {
                    System.out.println("Spectacol inexistent");
                    continue;
                }
                double price = sh.getPrice();
                if (C.getSpentMoney() > 1000) {
                    price = price * 0.9;
                }
                Seat seat = sh.getFirstUnoccupiedSeat();
                if (seat == null) {
                    System.out.println("Sold out");
                    continue;
                }
                price += vendingBooth.sell(in);
                System.out.println("Aveti de platit " + Double.toString(price));
                seat.assign(sh, C);
                C.addSpentMoney(price);

                System.out.println("Succes");
            }

            if (option == 11) {
                readName();
                Show sh = new Show(name);
                if (shows.contains(sh)) {
                    System.out.println("Exista deja un show cu acest nume");
                }
                else {
                    System.out.println("Introduceti ID-ul salii in care se afla, sau -1 pt a afisa salile:");
                    int x = in.nextInt();
                    while (x == -1) {
                        printHalls();
                        System.out.println("Introduceti ID-ul salii in care se afla, sau -1 pt a afisa salile:");
                        x = in.nextInt();
                    }
                    Hall h = findHall(x);
                    if (h == null) {
                        System.out.println("Show inexistent");
                        continue;
                    }
                    System.out.println("Introduceti pretul:");
                    int price = in.nextInt();
                    shows.add(new Show(name, h, price));
                }
            }

            if (option == 12) {
                readName();
                Show sh = new Show(name);
                if (shows.contains(sh))
                    shows.remove(sh);
                else {
                    System.out.println("Nu exista show cu acest nume");
                }
            }

            if (option == 13) {
                for (Employee e: employees) {
                    System.out.println(e);
                }
            }
        }

    }
}