package thecube.objects;

import thecube.utils.EncryptedNumbers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Cube {
    private final ArrayList<Room> THE_CUBE;
    private final EncryptedNumbers numbers = new EncryptedNumbers();

    private Room bridge = new Room(13, 14, 27, numbers, "Синий");
    private final Room exit = new Room(13, 14, 28, numbers, "Белый");

    private int roundForRoom = 0;

    public Cube() {
        this.THE_CUBE = buildCube();
    }

    public int getRoundForRoom() {
        return roundForRoom;
    }

    public ArrayList<Integer> getCoordinateRoom(int x, int y, int z) {
        Room foundRoom = null;
        for (Room room : THE_CUBE) {
            if (room.getDescartes().get(0) == x && room.getDescartes().get(1) == y && room.getDescartes().get(2) == z) {
                foundRoom = room;
            }
        }
        assert foundRoom != null;
        return foundRoom.getEncrypted();
    }

    public Room getSaveCenterRoom() {
        return findSaveCenterRoom(13, 26);
    }

    public Room findSaveCenterRoom(int start, int stop) {
        Room room;
        for (int x = start; x <= stop; x++) {
            for (int y = start; y <= stop; y++) {
                for (int z = start; z <= stop; z++) {
                    room = getRoomDescartes(x, y, z);
                    if (room.isSave())
                        return room;
                }
            }
        }
        return findSaveCenterRoom(1, 13);
    }

    public Room getRandomRoom(Room current, Room left, Room right, Room up, Room down, Room front, Room back) {
        Random rnd = new Random();
        Room room;
        int index;
        while (true) {
            index = rnd.nextInt(THE_CUBE.size());
            room = THE_CUBE.get(index);
            if (room != current && room != bridge && room != exit
                    && room != left && room != right
                    && room != up && room != down
                    && room != front && room != back
            ) return room;
        }
    }

    public Room getRoom(int x, int y, int z) {
        Room foundRoom = null;
        for (Room room : THE_CUBE) {
            if (room.getEncrypted().get(0) == x && room.getEncrypted().get(1) == y && room.getEncrypted().get(2) == z) {
                foundRoom = room;
            }
        }
        return foundRoom;
    }

    public Room getRoomDescartes(int x, int y, int z) {
        Room foundRoom = null;
        for (Room room : THE_CUBE) {
            if (room.getDescartes().get(0) == x && room.getDescartes().get(1) == y && room.getDescartes().get(2) == z) {
                foundRoom = room;
            }
        }
        return foundRoom;
    }

    public void nextRound() {
        moveRoom(roundForRoom);
        if (roundForRoom < 9) roundForRoom++;
        else roundForRoom = 1;
    }

    private void moveRoom(int round) {
        for (Room room : THE_CUBE) {
            room.moveRoomToRound(round);
        }
    }


    @Override
    public String toString() {
        for (Room room : THE_CUBE) {
            System.out.println(room.toString());
        }
        return "";
    }

    public String getStatistic() {
        int save = 0;
        int trap = 0;
        for (Room room : THE_CUBE) {
            if (room.isSave())
                save++;
            else
                trap++;
        }

        return "Всего комнат = " + THE_CUBE.size() +
                "\nБезопасных комнат = " + save +
                "\nКомнат с ловушками = " + trap;
    }

    private ArrayList<Room> buildCube() {
        ArrayList<Room> cube = new ArrayList<>();
        int SIZE_CUBE = 26;
        for (int x = 1; x <= SIZE_CUBE; x++) {
            for (int y = 1; y <= SIZE_CUBE; y++) {
                for (int z = 1; z <= SIZE_CUBE; z++) {
                    cube.add(new Room(x, y, z, numbers, getRandomColor()));
                }
            }
        }
        cube.add(bridge);
        return cube;
    }

    private String getRandomColor() {
        Random rnd = new Random();
        List<String> colors = new ArrayList<>(Arrays.asList("Красный", "Зеленый", "Желтый", "Синий", "Белый", "Оранжевый"));
        int index = rnd.nextInt(colors.size());
        return colors.get(index);
    }

    public Room getBridge() {
        return bridge;
    }

    public void setBridge(Room bridge) {
        this.bridge = bridge;
    }

    public Room getExit() {
        return exit;
    }
}
