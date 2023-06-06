package thecube.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Number {

    public static int getRndNumberIndex(ArrayList<Integer> arrayList) {
        Random rnd = new Random();
        int index = arrayList.size() > 0 ? rnd.nextInt(arrayList.size()) : -1;
        return index == -1 ? 0 : arrayList.remove(index);
    }

    public static ArrayList<Integer> getAllPrimeNumber(int rightLimit) {
        ArrayList<Integer> primeNumber = new ArrayList<>();
        for (int i = 1; i < rightLimit; i++) {
            if (isPrimeNumber(i))
                primeNumber.add(i);
        }
        return primeNumber;
    }

    public static List<Integer> getElement(int number) {
        int count = (int) (Math.log10(number) + 1);
        int a = 0, b = 0, c = 0;
        ArrayList<Integer> elements = new ArrayList<>();
        if (count == 1) {
            a = 0;
            b = 0;
            c = number;
        } else if (count == 2) {
            a = 0;
            b = number / 10;
            c = number % 10;
        } else if (count == 3) {
            a = number / 100;
            b = number / 10 % 10;
            c = number % 100 % 10;
        }
        elements.add(a - b);
        elements.add(b - c);
        elements.add(c - a);
        return elements;
    }

    public static boolean isPrimeNumber(int i) {
        if (i <= 1)
            return false;
        else if (i <= 3)
            return true;
        else if (i % 2 == 0 || i % 3 == 0)
            return false;
        int n = 5;
        while (n * n <= i) {
            if (i % n == 0 || i % (n + 2) == 0)
                return false;
            n = n + 6;
        }
        return true;
    }

    public static boolean aNumberHasThePowerOfPrimes(int number) {
        List<Integer> prime = new ArrayList<>(Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31));
        int temp;
        for (int base : prime) {
            for (int degree : prime) {
                temp = (int) Math.pow(base, degree);
                if ((int) (Math.log10(temp) + 1) <= 3) {
                    if (temp == number)
                        return true;
                } else
                    break;
            }
        }
        return false;
    }

    public static int getSumDigitsInNumber(int number) {
        return String.valueOf(number)
                .chars()
                .map(Character::getNumericValue)
                .sum();
    }
}
