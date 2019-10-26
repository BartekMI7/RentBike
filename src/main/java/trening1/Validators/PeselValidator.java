package trening1.Validators;
/*
Budowa numeru PESEL jest następująca:

    cyfry 1-2 to ostatnie dwie cyfry roku urodzenia
    cyfry 3-4 to dwie cyfry miesiąca urodzenia
    cyfry 5-6 to dwie cyfry dnia urodzenia
    cyfry 7-10 liczba porządkowa z oznaczeniem płci (liczba parzysta - kobieta, liczba nieparzysta - mężczyzna)
    cyfra 11 suma kontrolna

Jak zapewne zauważyłeś zapis taki nie pozwoliłby na rozróżnienie osób urodzonych w latach np. 1999 i 1899.
Dlatego też dla odróżnienia do numeru miesiąca dodawane są następujące wartości:

    dla lat 1900 - 1999 - 0
    dla lat 2000 - 2099 - 20

Rozważmy PESEL osoby urodzonej 8 lipca 1902 roku, płci żeńskiej (parzysta końcówka numeru z serii – 0362).
Czyli mamy wówczas 0207080362.
85 10 03 0165 1

0 2 0 7 0 8   0 3 6 2      =  8
1 3 7 9 1 3   7 9 1 3      =  8

wiec
0 2 0 7 0 8 0 3 6 2 8
0 1 2 3 4 5 6 7 8 9 10

Teraz kolejne cyfry należy przemnożyć przez odpowiednie wagi i dodać do siebie.
0*1 + 2*3 + 0*7 + 7*9 + 0*1 + 8*3 + 0*7 + 3*9 + 6*1 + 2*3 = 0 + 6 + 0 + 63 + 0 + 24 + 0 + 27 + 6 + 6 = 132
Wynik dzielimy modulo przez 10.
132 mod 10 = 2
A następnie odejmujemy od 10
10 - 2 = 8.
I wynik dzielimy znów modulo 10
8 mod 10 = 8
Cyfra kontrolna to 8, zatem nasz prawidłowy numer PESEL to: 02070803628
sprawdzic poprawnosc peselu:
 */

public class PeselValidator {
    public boolean validate(String pesel) {
        if (pesel == null) {
            return false;
        } else if (pesel.length() != 11) {
            return false;
        }

        char[] cyfryZnaki = pesel.toCharArray();
        int[] cyfry = new int[cyfryZnaki.length];

        try {
            for (int i = 0; i < cyfryZnaki.length; i++) {
                cyfry[i] = Integer.valueOf(String.valueOf(cyfryZnaki[i]));
            }
        } catch (NumberFormatException e) {
            return false;
        }

        int suma = cyfry[0] * 1 + cyfry[1] * 3 + cyfry[2] * 7 + cyfry[3] * 9 + cyfry[4] * 1 + cyfry[5] * 3 + cyfry[6] * 7 + cyfry[7] * 9 + cyfry[8] * 1 + cyfry[9] * 3;
        suma = suma % 10;
        suma = 10 - suma;
        suma = suma % 10;

        return suma == cyfry[10];
    }


}
