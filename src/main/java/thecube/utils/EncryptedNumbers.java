package thecube.utils;

import java.util.ArrayList;

import static thecube.utils.Number.*;

public class EncryptedNumbers {
    private final ArrayList<Integer> PRIME_NUMBERS;
    public final ArrayList<Integer> NUMBERS_SUM_OF_DIGITS_1 = new ArrayList<>();
    public final ArrayList<Integer> NUMBERS_SUM_OF_DIGITS_2 = new ArrayList<>();
    public final ArrayList<Integer> NUMBERS_SUM_OF_DIGITS_3 = new ArrayList<>();
    public final ArrayList<Integer> NUMBERS_SUM_OF_DIGITS_4 = new ArrayList<>();
    public final ArrayList<Integer> NUMBERS_SUM_OF_DIGITS_5 = new ArrayList<>();
    public final ArrayList<Integer> NUMBERS_SUM_OF_DIGITS_6 = new ArrayList<>();
    public final ArrayList<Integer> NUMBERS_SUM_OF_DIGITS_7 = new ArrayList<>();
    public final ArrayList<Integer> NUMBERS_SUM_OF_DIGITS_8 = new ArrayList<>();
    public final ArrayList<Integer> NUMBERS_SUM_OF_DIGITS_9 = new ArrayList<>();
    public final ArrayList<Integer> NUMBERS_SUM_OF_DIGITS_10 = new ArrayList<>();
    public final ArrayList<Integer> NUMBERS_SUM_OF_DIGITS_11 = new ArrayList<>();
    public final ArrayList<Integer> NUMBERS_SUM_OF_DIGITS_12 = new ArrayList<>();
    public final ArrayList<Integer> NUMBERS_SUM_OF_DIGITS_13 = new ArrayList<>();
    public final ArrayList<Integer> NUMBERS_SUM_OF_DIGITS_14 = new ArrayList<>();
    public final ArrayList<Integer> NUMBERS_SUM_OF_DIGITS_15 = new ArrayList<>();
    public final ArrayList<Integer> NUMBERS_SUM_OF_DIGITS_16 = new ArrayList<>();
    public final ArrayList<Integer> NUMBERS_SUM_OF_DIGITS_17 = new ArrayList<>();
    public final ArrayList<Integer> NUMBERS_SUM_OF_DIGITS_18 = new ArrayList<>();
    public final ArrayList<Integer> NUMBERS_SUM_OF_DIGITS_19 = new ArrayList<>();
    public final ArrayList<Integer> NUMBERS_SUM_OF_DIGITS_20 = new ArrayList<>();
    public final ArrayList<Integer> NUMBERS_SUM_OF_DIGITS_21 = new ArrayList<>();
    public final ArrayList<Integer> NUMBERS_SUM_OF_DIGITS_22 = new ArrayList<>();
    public final ArrayList<Integer> NUMBERS_SUM_OF_DIGITS_23 = new ArrayList<>();
    public final ArrayList<Integer> NUMBERS_SUM_OF_DIGITS_24 = new ArrayList<>();
    public final ArrayList<Integer> NUMBERS_SUM_OF_DIGITS_25 = new ArrayList<>();
    public final ArrayList<Integer> NUMBERS_SUM_OF_DIGITS_26 = new ArrayList<>();

    public EncryptedNumbers() {
        this.PRIME_NUMBERS = getAllPrimeNumber(1000);
      //  createListForEncryptedNumbers();
        completeListForEncryptedNumbers();
    }

    private ArrayList<Integer> getFullList(ArrayList<Integer> list, int limit) {
        int sizeRepeat = 2029;
        while (list.size() < sizeRepeat) {
            for (int i = 1; i < 1000; i++) {
           //    if (!isPrimeNumber(i) && getSumDigitsInNumber(i) == limit) {
                if (getSumDigitsInNumber(i) == limit) {
                    if (list.size() < sizeRepeat)
                        list.add(i);
                    else
                        break;
                }
            }
        }
        return list;
    }

    private void completeListForEncryptedNumbers() {
        for (int i = 1; i < 27; i++) {
            switch (i) {
                case 1 -> getFullList(NUMBERS_SUM_OF_DIGITS_1, 1);
                case 2 -> getFullList(NUMBERS_SUM_OF_DIGITS_2, 2);
                case 3 -> getFullList(NUMBERS_SUM_OF_DIGITS_3, 3);
                case 4 -> getFullList(NUMBERS_SUM_OF_DIGITS_4, 4);
                case 5 -> getFullList(NUMBERS_SUM_OF_DIGITS_5, 5);
                case 6 -> getFullList(NUMBERS_SUM_OF_DIGITS_6, 6);
                case 7 -> getFullList(NUMBERS_SUM_OF_DIGITS_7, 7);
                case 8 -> getFullList(NUMBERS_SUM_OF_DIGITS_8, 8);
                case 9 -> getFullList(NUMBERS_SUM_OF_DIGITS_9, 9);
                case 10 -> getFullList(NUMBERS_SUM_OF_DIGITS_10, 10);
                case 11 -> getFullList(NUMBERS_SUM_OF_DIGITS_11, 11);
                case 12 -> getFullList(NUMBERS_SUM_OF_DIGITS_12, 12);
                case 13 -> getFullList(NUMBERS_SUM_OF_DIGITS_13, 13);
                case 14 -> getFullList(NUMBERS_SUM_OF_DIGITS_14, 14);
                case 15 -> getFullList(NUMBERS_SUM_OF_DIGITS_15, 15);
                case 16 -> getFullList(NUMBERS_SUM_OF_DIGITS_16, 16);
                case 17 -> getFullList(NUMBERS_SUM_OF_DIGITS_17, 17);
                case 18 -> getFullList(NUMBERS_SUM_OF_DIGITS_18, 18);
                case 19 -> getFullList(NUMBERS_SUM_OF_DIGITS_19, 19);
                case 20 -> getFullList(NUMBERS_SUM_OF_DIGITS_20, 20);
                case 21 -> getFullList(NUMBERS_SUM_OF_DIGITS_21, 21);
                case 22 -> getFullList(NUMBERS_SUM_OF_DIGITS_22, 22);
                case 23 -> getFullList(NUMBERS_SUM_OF_DIGITS_23, 23);
                case 24 -> getFullList(NUMBERS_SUM_OF_DIGITS_24, 24);
                case 25 -> getFullList(NUMBERS_SUM_OF_DIGITS_25, 25);
                case 26 -> getFullList(NUMBERS_SUM_OF_DIGITS_26, 26);
                default -> {
                }
            }
        }
    }

    private void createListForEncryptedNumbers() {
        int sum;
        for (int prime : PRIME_NUMBERS) {
            sum = getSumDigitsInNumber(prime);
            switch (sum) {
                case 1 -> NUMBERS_SUM_OF_DIGITS_1.add(prime);
                case 2 -> NUMBERS_SUM_OF_DIGITS_2.add(prime);
                case 3 -> NUMBERS_SUM_OF_DIGITS_3.add(prime);
                case 4 -> NUMBERS_SUM_OF_DIGITS_4.add(prime);
                case 5 -> NUMBERS_SUM_OF_DIGITS_5.add(prime);
                case 6 -> NUMBERS_SUM_OF_DIGITS_6.add(prime);
                case 7 -> NUMBERS_SUM_OF_DIGITS_7.add(prime);
                case 8 -> NUMBERS_SUM_OF_DIGITS_8.add(prime);
                case 9 -> NUMBERS_SUM_OF_DIGITS_9.add(prime);
                case 10 -> NUMBERS_SUM_OF_DIGITS_10.add(prime);
                case 11 -> NUMBERS_SUM_OF_DIGITS_11.add(prime);
                case 12 -> NUMBERS_SUM_OF_DIGITS_12.add(prime);
                case 13 -> NUMBERS_SUM_OF_DIGITS_13.add(prime);
                case 14 -> NUMBERS_SUM_OF_DIGITS_14.add(prime);
                case 15 -> NUMBERS_SUM_OF_DIGITS_15.add(prime);
                case 16 -> NUMBERS_SUM_OF_DIGITS_16.add(prime);
                case 17 -> NUMBERS_SUM_OF_DIGITS_17.add(prime);
                case 18 -> NUMBERS_SUM_OF_DIGITS_18.add(prime);
                case 19 -> NUMBERS_SUM_OF_DIGITS_19.add(prime);
                case 20 -> NUMBERS_SUM_OF_DIGITS_20.add(prime);
                case 21 -> NUMBERS_SUM_OF_DIGITS_21.add(prime);
                case 22 -> NUMBERS_SUM_OF_DIGITS_22.add(prime);
                case 23 -> NUMBERS_SUM_OF_DIGITS_23.add(prime);
                case 24 -> NUMBERS_SUM_OF_DIGITS_24.add(prime);
                case 25 -> NUMBERS_SUM_OF_DIGITS_25.add(prime);
                case 26 -> NUMBERS_SUM_OF_DIGITS_26.add(prime);
                default -> {
                }
            }
        }
    }

    public ArrayList<Integer> getPRIME_NUMBERS() {
        return PRIME_NUMBERS;
    }

    @Override
    public String toString() {
        System.out.println("01 = [" + NUMBERS_SUM_OF_DIGITS_1.size() + "] : " + NUMBERS_SUM_OF_DIGITS_1);
        System.out.println("02 = [" + NUMBERS_SUM_OF_DIGITS_2.size() + "] : " + NUMBERS_SUM_OF_DIGITS_2);
        System.out.println("03 = [" + NUMBERS_SUM_OF_DIGITS_3.size() + "] : " + NUMBERS_SUM_OF_DIGITS_3);
        System.out.println("04 = [" + NUMBERS_SUM_OF_DIGITS_4.size() + "] : " + NUMBERS_SUM_OF_DIGITS_4);
        System.out.println("05 = [" + NUMBERS_SUM_OF_DIGITS_5.size() + "] : " + NUMBERS_SUM_OF_DIGITS_5);
        System.out.println("06 = [" + NUMBERS_SUM_OF_DIGITS_6.size() + "] : " + NUMBERS_SUM_OF_DIGITS_6);
        System.out.println("07 = [" + NUMBERS_SUM_OF_DIGITS_7.size() + "] : " + NUMBERS_SUM_OF_DIGITS_7);
        System.out.println("08 = [" + NUMBERS_SUM_OF_DIGITS_8.size() + "] : " + NUMBERS_SUM_OF_DIGITS_8);
        System.out.println("09 = [" + NUMBERS_SUM_OF_DIGITS_9.size() + "] : " + NUMBERS_SUM_OF_DIGITS_9);
        System.out.println("10 = [" + NUMBERS_SUM_OF_DIGITS_10.size() + "] : " + NUMBERS_SUM_OF_DIGITS_10);
        System.out.println("11 = [" + NUMBERS_SUM_OF_DIGITS_11.size() + "] : " + NUMBERS_SUM_OF_DIGITS_11);
        System.out.println("12 = [" + NUMBERS_SUM_OF_DIGITS_12.size() + "] : " + NUMBERS_SUM_OF_DIGITS_12);
        System.out.println("13 = [" + NUMBERS_SUM_OF_DIGITS_13.size() + "] : " + NUMBERS_SUM_OF_DIGITS_13);
        System.out.println("14 = [" + NUMBERS_SUM_OF_DIGITS_14.size() + "] : " + NUMBERS_SUM_OF_DIGITS_14);
        System.out.println("15 = [" + NUMBERS_SUM_OF_DIGITS_15.size() + "] : " + NUMBERS_SUM_OF_DIGITS_15);
        System.out.println("16 = [" + NUMBERS_SUM_OF_DIGITS_16.size() + "] : " + NUMBERS_SUM_OF_DIGITS_16);
        System.out.println("17 = [" + NUMBERS_SUM_OF_DIGITS_17.size() + "] : " + NUMBERS_SUM_OF_DIGITS_17);
        System.out.println("18 = [" + NUMBERS_SUM_OF_DIGITS_18.size() + "] : " + NUMBERS_SUM_OF_DIGITS_18);
        System.out.println("19 = [" + NUMBERS_SUM_OF_DIGITS_19.size() + "] : " + NUMBERS_SUM_OF_DIGITS_19);
        System.out.println("20 = [" + NUMBERS_SUM_OF_DIGITS_20.size() + "] : " + NUMBERS_SUM_OF_DIGITS_20);
        System.out.println("21 = [" + NUMBERS_SUM_OF_DIGITS_21.size() + "] : " + NUMBERS_SUM_OF_DIGITS_21);
        System.out.println("22 = [" + NUMBERS_SUM_OF_DIGITS_22.size() + "] : " + NUMBERS_SUM_OF_DIGITS_22);
        System.out.println("23 = [" + NUMBERS_SUM_OF_DIGITS_23.size() + "] : " + NUMBERS_SUM_OF_DIGITS_23);
        System.out.println("24 = [" + NUMBERS_SUM_OF_DIGITS_24.size() + "] : " + NUMBERS_SUM_OF_DIGITS_24);
        System.out.println("25 = [" + NUMBERS_SUM_OF_DIGITS_25.size() + "] : " + NUMBERS_SUM_OF_DIGITS_25);
        System.out.println("26 = [" + NUMBERS_SUM_OF_DIGITS_26.size() + "] : " + NUMBERS_SUM_OF_DIGITS_26);
        return "";
    }
}
