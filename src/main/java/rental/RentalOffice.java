package rental;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Getter
@RequiredArgsConstructor

public class RentalOffice {
    private final List<Bike> bikeList = new ArrayList<>();
    private final List<Client> clientList = new ArrayList<>();
    private final List<Rent> rentedBikeList = new ArrayList<>();

    SimpleDateFormat format = new SimpleDateFormat("yy/MM/dd HH:mm:ss");

    //public RentalOffice(ArrayList<Client> clientList) {
    //}
    /*
    public void dodajKlienta(Klient klient) {
        Optional<Klient> foundKlient = klienci.stream().filter(a -> a.getNumerDowodu().equals(klient.getNumerDowodu()))
                .findAny();
        if (!foundKlient.isPresent()) {
            klienci.add(klient);
        }
     */

    public void addClientToClientList(Client client) {
        Optional<Client> foundClient = clientList
                .stream()
                .filter(a -> a.getIdNumber().equals(client.getIdNumber()))
                .findAny();
        if (!foundClient.isPresent()) {
            clientList.add(client);
        } else {
            throw new IllegalArgumentException("Client with this ID number already exist in the Rental Office");
        }
    }

    public void removeClientFromClientList(Client client) {
        Client client1 = clientList
                .stream()
                .filter(a -> a.getIdNumber().equals(client.getIdNumber()))
                .findAny()
                .orElse(null);
        if (client1 != null) {
            clientList.remove(client1);
        }
        if (client1 == null) {
            throw new IllegalArgumentException("Client with this ID number doesn't exist in the Rental Office!");
        }
    }

    public void addBikeToBikeList(Bike bike) {
        Optional<Bike> foundBike = bikeList
                .stream()
                .filter(a -> a.getIdBikeNr().equals(bike.getIdBikeNr()))
                .findAny();
        if (!foundBike.isPresent()) {
            bikeList.add(bike);
        } else {
            throw new IllegalArgumentException("Bike with this ID already exist");
        }
    }

    public void removeBikeFromBikeList(Bike bike) {
        Bike bike1 = bikeList
                .stream()
                .filter(a -> a.getIdBikeNr().equals(bike.getIdBikeNr()))
                .findAny()
                .orElse(null);
        if (bike1 != null) {
            bikeList.remove(bike1);
        } else {
            throw new IllegalArgumentException("Bike with this ID doesn't exist or already removed!");
        }
    }

    public void printClientList() {
        clientList
                .stream()
                .forEach(a -> System.out.println(a));
    }

    public void printBikeList() {
        bikeList
                .stream()
                .forEach(a -> System.out.println(a));
    }

    public void printRentList() {
        rentedBikeList
                .stream()
                .forEach(a -> System.out.println(a));
    }

    public void printActualRentList() {
        rentedBikeList
                .stream()
                .filter(a -> a.getDateEnd() == null)
                .forEach(a -> System.out.println(a));
    }

    public void rentBike(String idBike, String idClient, Date startDate) { //saldo w obiekcie klienta i uwzglednienie w przypadku wypozyczenia

        Bike bike1 = bikeList
                .stream()
                .filter(a -> a.getIdBikeNr().equals(idBike))
                .findAny()
                .orElse(null);
        if (bike1 == null) {
            throw new IllegalArgumentException("Bike with this ID doesn't exist or is just rented!");
        }

        Client client1 = clientList
                .stream()
                .filter(a -> a.getIdNumber().equals(idClient))
                .findAny().orElse(null);
        if (client1 == null) {
            throw new IllegalArgumentException("Client doesn't exist in the actual client list!");
        }

        Rent rent = new Rent(client1, bike1, startDate, null);
        rentedBikeList.add(rent);
    }

    public void rentBikeByOneClient(String idBike, String idClient, Date startDate) { //saldo w obiekcie klienta i uwzglednienie w przypadku wypozyczenia

        Bike bike1 = bikeList
                .stream()
                .filter(a -> a.getIdBikeNr().equals(idBike))
                .findAny()
                .orElse(null);
        if (bike1 == null) {
            throw new IllegalArgumentException("Bike with this ID doesn't exist or is just rented!");
        }

        Client client1 = clientList
                .stream()
                .filter(a -> a.getIdNumber().equals(idClient))
                .findAny().orElse(null);
        if (client1 == null) {
            throw new IllegalArgumentException("Client doesn't exist in the actual client list!");
        }
        Rent rent1 = rentedBikeList
                .stream()
                .filter(a -> a.getBorrower().getIdNumber().equals(idClient))
                .filter(a -> a.getDateEnd() == null)
                .findAny()
                .orElse(null);
        if (rent1 == null) {
            Rent rent = new Rent(client1, bike1, startDate, null);
            rentedBikeList.add(rent);
        } else {
            throw new IllegalArgumentException("Client has already 1 borrowed a bike");
        }
    }


    public void giveBackBike(String idBike, Date endDate) {

        Rent rent = rentedBikeList
                .stream()
                .filter(a -> a.getBorrowedBike().getIdBikeNr().equals(idBike))
                .findAny()
                .orElse(null);
        if (rent == null) {
            throw new IllegalArgumentException("This rent is not exist!");
        }

        rent.setDateEnd(endDate);
    }


    public void rentBikeIfSaldoOk(String idBike, String idClient, Date startDate) {
        Bike bike1 = bikeList
                .stream()
                .filter(a -> a.getIdBikeNr().equals(idBike))
                .findAny()
                .orElse(null);
        if (bike1 == null) {
            throw new IllegalArgumentException("Bike with this ID doesn't exist or is just rented!");
        }

        Client client1 = clientList
                .stream()
                .filter(a -> a.getIdNumber().equals(idClient))
                .findAny()
                .orElse(null);
        if (client1 == null) {
            throw new IllegalArgumentException("Client doesn't exist in the actual client list!");
        }
        if (client1.getSaldoClient() > 10) {
            Rent rent = new Rent(client1, bike1, startDate, null);
            rentedBikeList.add(rent);
        } else {
            throw new IllegalArgumentException("Not enough money on your account: " + client1.getSaldoClient() + ". Please top up your account! Min saldo is 10 zl.");
        }
    }

    public void giveBackBikeWithPayment(String idBike, Date endDate) {
        Rent rent = rentedBikeList
                .stream()
                .filter(a -> a.getBorrowedBike().getIdBikeNr().equals(idBike))
                .findAny()
                .orElse(null);
        if (rent == null) {
            throw new IllegalArgumentException("Bike with this ID doesn't exist or is just rented!");
        }
        rent.setDateEnd(endDate);
        if (rent.differenceDateMinute() > 15) {
            rent.getBorrower().setSaldoClient((rent.getBorrower().getSaldoClient()) - (rent.differenceDateMinute() - 15) * 0.1); // każd minuta powyzej 15min kosztuje 10groszy.
        }

    }

    public void topUpAccount(String idClient, double money) { //doladowanie konta
        Client client = clientList
                .stream()
                .filter(a -> idClient.equals(a.getIdNumber()))
                .findAny()
                .orElse(null);
        if (client == null) {
            throw new IllegalArgumentException("Client doesn't exist. To top up account please first add client to the client list");
        }
        client.setSaldoClient(client.getSaldoClient() + money);
    }

    public String toStringBikeList() {
        return bikeList
                .stream()
                .map(a -> a.toString())
                .reduce("", (tmp, a) -> tmp += a + "\n");
    }

    public String toStringClientList() {

        return clientList
                .stream()
                .map(a -> a.toString())
                .reduce("", (tmp, a) -> tmp += a + "\n");
    }

    public String toStringActualRentList() {
        return rentedBikeList
                .stream()
                .filter(a -> a.getDateEnd() == null)
                .map(a -> a.toString())
                .reduce("", (tmp, a) -> tmp += a + "\n");
    }


    public void saveClientListToFile() throws FileNotFoundException {
        PrintWriter write = new PrintWriter("all_clients.txt");
        clientList.forEach(client -> {
            String idClient = client.getIdNumber();
            String lastnameClient = client.getLastName();
            String firstnameClient = client.getFirstName();
            double saldoClient = client.getSaldoClient();

            write.print(idClient);
            write.print("  ");
            write.print(lastnameClient);
            write.print("  ");
            write.print(firstnameClient);
            write.print("  ");
            write.print(saldoClient);
            write.println();
        } );
        write.close();
    }


    public double getProfits() {

        return 2;
    }


}