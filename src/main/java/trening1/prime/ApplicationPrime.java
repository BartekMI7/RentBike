package trening1.prime;

import java.util.Scanner;

public class ApplicationPrime {
    public static void main(String[] args) {
        PrimeTask primeTask = new PrimeTask();
        Scanner reader = new Scanner(System.in);
        System.out.print("Podaj liczbe testow: ");
        int testAmount = reader.nextInt();
        int[] tab = new int[testAmount];
        String[] tab1 = new String[testAmount];

        System.out.println("Podaj liczby z zakresu 1-10000: ");
        for (int i =0; i<testAmount; i++){
            tab[i] = reader.nextInt();
            tab1[i] = primeTask.isPrimeOrNot(tab[i]);
        }

        System.out.println("Wynik jest nastpujacy: ");
        for (int j = 0; j<testAmount;j++ ){
            System.out.println(tab1[j]);
        }
    }
}
