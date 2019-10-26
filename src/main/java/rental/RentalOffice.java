package rental;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@Getter
@RequiredArgsConstructor

public class RentalOffice {
    private final List<Bike> bikeList = new ArrayList<>();
    private final List<Client> clientList = new ArrayList<>();
    private final List<Rent> rentedBikeList = new ArrayList<>();

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

    public void printClientList(){
        clientList
                .stream()
                .forEach(a-> System.out.println(a));
    }

    public void printBikeList(){
        bikeList
                .stream()
                .forEach(a-> System.out.println(a));
    }

    public void rentBike(String idBike, String idClient, Date startDate){
        Bike bike1 = bikeList
                .stream()
                .filter(a -> a.getIdBikeNr().equals(idBike))
                .findAny()
                .orElse(null);
        if (bike1==null){
            throw new IllegalArgumentException("Bike with this ID doesn't exist or is just rented!");
        }

        Client client1 = clientList
                .stream()
                .filter(a->a.getIdNumber().equals(idClient))
                .findAny().orElse(null);
        if (client1==null){
            throw new IllegalArgumentException("Client doesn't exist in the actual client list!");
        }

        Rent rent = new Rent(client1,bike1,startDate,null);
        rentedBikeList.add(rent);
    }

    public void giveBackBike(String idBike, Date endDate){

        Rent rent = rentedBikeList
                .stream()
                .filter(a -> a.getBorrowedBike().getIdBikeNr().equals(idBike))
                .findAny()
                .orElse(null);
        if (rent==null){
            throw new IllegalArgumentException("This rent is not exist!");
        }

        rent.setDateEnd(endDate);


    }
}