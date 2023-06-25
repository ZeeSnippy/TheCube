package thecube.objects;

import thecube.utils.EncryptedNumbers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static thecube.utils.Number.*;

public class Room {
    private ArrayList<Integer> descartes = new ArrayList<>();
    private final ArrayList<Integer> encrypted = new ArrayList<>();
    private final EncryptedNumbers numbers;

    private String color;
    private final boolean isPowerPrime;
    private final boolean isPrime;
    private final boolean isSave;
    public final Trap trap;
    private final String hintedCoordinates;


    public Room(int x, int y, int z, EncryptedNumbers numbers, String color) {

        this.descartes.add(x);
        this.descartes.add(y);
        this.descartes.add(z);
        this.numbers = numbers;
        int xEnc = getValue(x), yEnc = getValue(y), zEnc = getValue(z);
        this.encrypted.add(xEnc);
        this.encrypted.add(yEnc);
        this.encrypted.add(zEnc);
        this.isPowerPrime = ((aNumberHasThePowerOfPrimes(xEnc)) || (aNumberHasThePowerOfPrimes(yEnc)) || (aNumberHasThePowerOfPrimes(zEnc)));
        this.isPrime = ((isPrimeNumber(xEnc)) || (isPrimeNumber(yEnc)) || (isPrimeNumber(zEnc)));
        this.isSave = analyzeSave();
        this.trap = new Trap(!this.isSave);
        this.color = color;
        this.hintedCoordinates = getHinted(xEnc, yEnc, zEnc);
    }

    private String getHinted(int x, int y, int z) {
        return "[" +
                getStringHint(x) + ", " +
                getStringHint(y) + ", " +
                getStringHint(z) + "]";
    }

    private String getStringHint(int number) {
        StringBuilder hint = new StringBuilder();
        if (isPrimeNumber(number)) {
            hint.append("'").append(getCode(number)).append("'");
        } else if (aNumberHasThePowerOfPrimes(number))
            hint.append("*").append(getCode(number)).append("*");
        else
            hint.append(number);
        return hint.toString();
    }

    public void moveRoomToRound(int round) {
        List<Integer> elementX = getElement(getEncrypted().get(0));
        List<Integer> elementY = getElement(getEncrypted().get(1));
        List<Integer> elementZ = getElement(getEncrypted().get(2));
        switch (round) {
//            case 0 -> setDescartes(new ArrayList<>(Arrays.asList(
//                    getSumDigitsInNumber(getEncrypted().get(0)),
//                    getSumDigitsInNumber(getEncrypted().get(1)),
//                    getSumDigitsInNumber(getEncrypted().get(2))
//            )));
            case 1 -> setDescartes(new ArrayList<>(Arrays.asList(
                    getDescartes().get(0) + elementX.get(0),
                    getDescartes().get(1),
                    getDescartes().get(2)
            )));
            case 2 -> setDescartes(new ArrayList<>(Arrays.asList(
                    getDescartes().get(0),
                    getDescartes().get(1) + elementY.get(0),
                    getDescartes().get(2)
            )));
            case 3 -> setDescartes(new ArrayList<>(Arrays.asList(
                    getDescartes().get(0),
                    getDescartes().get(1),
                    getDescartes().get(2) + elementZ.get(0)
            )));
            case 4 -> setDescartes(new ArrayList<>(Arrays.asList(
                    getDescartes().get(0) + elementX.get(1),
                    getDescartes().get(1),
                    getDescartes().get(2)
            )));
            case 5 -> setDescartes(new ArrayList<>(Arrays.asList(
                    getDescartes().get(0),
                    getDescartes().get(1) + elementY.get(1),
                    getDescartes().get(2)
            )));
            case 6 -> setDescartes(new ArrayList<>(Arrays.asList(
                    getDescartes().get(0),
                    getDescartes().get(1),
                    getDescartes().get(2) + elementZ.get(1)
            )));
            case 7 -> setDescartes(new ArrayList<>(Arrays.asList(
                    getDescartes().get(0) + elementX.get(2),
                    getDescartes().get(1),
                    getDescartes().get(2)
            )));
            case 8 -> setDescartes(new ArrayList<>(Arrays.asList(
                    getDescartes().get(0),
                    getDescartes().get(1) + elementY.get(2),
                    getDescartes().get(2)
            )));
            case 9 -> setDescartes(new ArrayList<>(Arrays.asList(
                    getDescartes().get(0),
                    getDescartes().get(1),
                    getDescartes().get(2) + elementZ.get(2)
            )));
            default -> {
            }
        }

    }

    private boolean analyzeSave() {
        return ((descartes.get(0) == 27 || descartes.get(1) == 27 || descartes.get(2) == 27) || (!isPrime && !isPowerPrime));
    }

    private int getValue(int limit) {
        int result = 0;
        switch (limit) {
            case 1 -> result = getRndNumberIndex(numbers.NUMBERS_SUM_OF_DIGITS_1);
            case 2 -> result = getRndNumberIndex(numbers.NUMBERS_SUM_OF_DIGITS_2);
            case 3 -> result = getRndNumberIndex(numbers.NUMBERS_SUM_OF_DIGITS_3);
            case 4 -> result = getRndNumberIndex(numbers.NUMBERS_SUM_OF_DIGITS_4);
            case 5 -> result = getRndNumberIndex(numbers.NUMBERS_SUM_OF_DIGITS_5);
            case 6 -> result = getRndNumberIndex(numbers.NUMBERS_SUM_OF_DIGITS_6);
            case 7 -> result = getRndNumberIndex(numbers.NUMBERS_SUM_OF_DIGITS_7);
            case 8 -> result = getRndNumberIndex(numbers.NUMBERS_SUM_OF_DIGITS_8);
            case 9 -> result = getRndNumberIndex(numbers.NUMBERS_SUM_OF_DIGITS_9);
            case 10 -> result = getRndNumberIndex(numbers.NUMBERS_SUM_OF_DIGITS_10);
            case 11 -> result = getRndNumberIndex(numbers.NUMBERS_SUM_OF_DIGITS_11);
            case 12 -> result = getRndNumberIndex(numbers.NUMBERS_SUM_OF_DIGITS_12);
            case 13 -> result = getRndNumberIndex(numbers.NUMBERS_SUM_OF_DIGITS_13);
            case 14 -> result = getRndNumberIndex(numbers.NUMBERS_SUM_OF_DIGITS_14);
            case 15 -> result = getRndNumberIndex(numbers.NUMBERS_SUM_OF_DIGITS_15);
            case 16 -> result = getRndNumberIndex(numbers.NUMBERS_SUM_OF_DIGITS_16);
            case 17 -> result = getRndNumberIndex(numbers.NUMBERS_SUM_OF_DIGITS_17);
            case 18 -> result = getRndNumberIndex(numbers.NUMBERS_SUM_OF_DIGITS_18);
            case 19 -> result = getRndNumberIndex(numbers.NUMBERS_SUM_OF_DIGITS_19);
            case 20 -> result = getRndNumberIndex(numbers.NUMBERS_SUM_OF_DIGITS_20);
            case 21 -> result = getRndNumberIndex(numbers.NUMBERS_SUM_OF_DIGITS_21);
            case 22 -> result = getRndNumberIndex(numbers.NUMBERS_SUM_OF_DIGITS_22);
            case 23 -> result = getRndNumberIndex(numbers.NUMBERS_SUM_OF_DIGITS_23);
            case 24 -> result = getRndNumberIndex(numbers.NUMBERS_SUM_OF_DIGITS_24);
            case 25 -> result = getRndNumberIndex(numbers.NUMBERS_SUM_OF_DIGITS_25);
            case 26 -> result = getRndNumberIndex(numbers.NUMBERS_SUM_OF_DIGITS_26);
            case 27 -> result = 999;
        }
        return result;
    }

    public ArrayList<Integer> getDescartes() {
        return descartes;
    }

    public void setDescartes(ArrayList<Integer> descartes) {
        this.descartes = descartes;
    }

    public ArrayList<Integer> getEncrypted() {
        return encrypted;
    }

    public boolean isPowerPrime() {
        return isPowerPrime;
    }

    public boolean isPrime() {
        return isPrime;
    }

    public boolean isSave() {
        return isSave;
    }

    public Trap getTrap() {
        return trap;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getHintedCoordinates() {
        return hintedCoordinates;
    }

    @Override
    public String toString() {
        try {
            if (getDescartes().get(0) == 28 || getDescartes().get(1) == 28 || getDescartes().get(2) == 28)
                return "Выход !!!";
            else {
                return
                        "[" + getColor() +
                                "] Номер комнаты = " + getHintedCoordinates() +
                                " Текущее положение = " + getDescartes() +
                                " Изначальное положение = [" +
                                getSumDigitsInNumber(getEncrypted().get(0)) + ", " +
                                getSumDigitsInNumber(getEncrypted().get(1)) + ", " +
                                getSumDigitsInNumber(getEncrypted().get(2)) + "] ";
            }
        } catch (NullPointerException ex) {
            return "Null";
        }
    }

    private static ArrayList<String> getTreeDigits(ArrayList<Integer> arrayList) {
        ArrayList<String> newList = new ArrayList<>();
        newList.add(getCode(arrayList.get(0)));
        newList.add(getCode(arrayList.get(1)));
        newList.add(getCode(arrayList.get(2)));
        return newList;
    }

    private static String getCode(int number) {
        int count = (int) (Math.log10(number) + 1);
        if (count == 3)
            return "" + number;
        else if (count == 2)
            return "0" + number;
        else if (count == 1)
            return "00" + number;
        else
            return "000";
    }
}
