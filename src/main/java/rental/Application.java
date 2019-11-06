package rental;

import com.sun.source.tree.IfTree;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Application {
    private static final RentalOffice BICYCLE_RENTAL = new RentalOffice();

    public static void main(String[] args) throws ParseException {
        Scanner read = new Scanner(System.in);
        Scanner readDouble = new Scanner(System.in);
        String tmp;
        String pattern =("YYYY-mm-dd hh:mm:ss");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);


        do {
            System.out.println("1 - jezeli chcesz dodac rower do wypozyczalni");
            System.out.println("2 - jezeli chcesz dodac klienta do listy");
            System.out.println("3 - jezeli chcesz wypozyczyc rower");
            System.out.println("4 - ");
            System.out.println("5 - jezeli chcesz oddac rower");
            System.out.println("6 - jezeli chcesz sprawdzic saldo");
            System.out.println("7 - jezeli chcesz doladowac konto");
            System.out.println("8 - jezeli chcesz wyswietlic liste wszystkich rowerow");
            System.out.println("9 - jezeli chcesz wyswietlic liste wszystkich klientow");
            System.out.println("10 - jezeli chcesz wyswietlic liste aktualnych wypozyczen");
            System.out.println("0 - jezeli chcesz zakonczyc program");
            tmp = read.nextLine();

            switch (tmp) {
                case "1":
                    System.out.println("Wpisz numer ID roweru: ");
                    String id = read.nextLine();
                    System.out.println("Podaj date produkcji: ");
                    int productionDate = readDouble.nextInt();
                    Bike bike = new Bike(id, productionDate);
                    BICYCLE_RENTAL.addBikeToBikeList(bike);
                    break;

                case "2":
                    System.out.println("Podaj imie: ");
                    String firstName = read.nextLine();
                    System.out.println("Podaj nazwisko: ");
                    String lastName = read.nextLine();
                    System.out.println("Podaj numer dowodu: ");
                    String clientID = read.nextLine();
                    Client client = new Client(firstName, lastName, clientID);
                    BICYCLE_RENTAL.addClientToClientList(client);
                    break;

                case "3":
                    System.out.println("Podaj numer roweru: ");
                    String idbike3 = read.nextLine();
                    System.out.println("Podaj numer dowodu klienta: ");
                    String idClient3 = read.nextLine();
                    System.out.println("Podaj date wypozyczenia roweru: ");
                    String  date3 = read.nextLine();
                    Date startDate3 = simpleDateFormat.parse(date3);
                    BICYCLE_RENTAL.rentBikeIfSaldoOk(idbike3,idClient3,startDate3);

                    break;

                case "8":
                    BICYCLE_RENTAL.printBikeList();
                    if (BICYCLE_RENTAL.getBikeList().size()==0){
                        System.out.println("brak rowerow w wypozyczalni");
                        System.out.println();
                    }
                    break;

                case "9":
                    BICYCLE_RENTAL.printClientList();
                    if (BICYCLE_RENTAL.getClientList().size()==0){
                        System.out.println("brak zapisanych klientow");
                        System.out.println();
                    }

                    break;

                case "10":
                    BICYCLE_RENTAL.printActualRentList();
                    if (BICYCLE_RENTAL.getRentedBikeList()==null){
                        System.out.println("Brak wypozyczonych rowerow");
                    }
            }

            if ("0".equals(tmp)) {
                break;
            }
        }
        while (true);
    }
}
