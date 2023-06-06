package thecube;

import thecube.objects.Cube;
import thecube.objects.Room;
import thecube.objects.Trap;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    private static final ArrayList<Integer> emptyCell = new ArrayList<>();
    private static final Cube cube = new Cube();

    private static Room bridge = cube.getBridge();
    private static boolean bridgeBlock = true;
    //  private static Room currentRoom = bridge;
    private static Room currentRoom = cube.getSaveCenterRoom();
    private static Room leftRoom, rightRoom, upRoom, downRoom, frontRoom, backRoom;
    public static int count = 0;
    public static int hour = 0;
    public static int day = 0;

    public static void main(String[] args) {
        cube.nextRound();
        updateInfo();
        Scanner mainMenu;
        int value;
        while (true) {
            mainMenu = new Scanner(System.in);
            System.out.println("Round room: " + cube.getRoundForRoom() + " Minutes: " + count + "0 Hour: " + hour + " Day: " + day);
            // System.out.println("BRIDGE: " + getMsgInfoRoom(bridge));
            System.out.println("----------------------------------------------");
            System.out.println("THIS: " + getMsgInfoRoom(currentRoom));
            System.out.println("----------------------------------------------");
            System.out.println("Left: " + getMsgInfoRoom(leftRoom));
            System.out.println("Right: " + getMsgInfoRoom(rightRoom));
            System.out.println("Up: " + getMsgInfoRoom(upRoom));
            System.out.println("Down: " + getMsgInfoRoom(downRoom));
            System.out.println("Front: " + getMsgInfoRoom(frontRoom));
            System.out.println("Back: " + getMsgInfoRoom(backRoom));
            System.out.println("----------------------------------------------");
            System.out.println("[0] - Next Round");
            System.out.println("[1] - Move left room");
            System.out.println("[2] - Move right room");
            System.out.println("[3] - Move up room");
            System.out.println("[4] - Move down room");
            System.out.println("[5] - Move front room");
            System.out.println("[6] - Move back room");
            System.out.println("----------------------------------------------");
            System.out.println("[7] - Rest");
            System.out.print("You select: ");
            try {
                value = mainMenu.nextInt();
            } catch (Exception e) {
                value = 11;
            }
            switch (value) {
                case 0 -> {
                    cube.nextRound();
                    updateInfo();
                }
                case 1 -> {
                    if (leftRoom != null)
                        if (leftRoom.isSave())
                            currentRoom = leftRoom;
                        else
                            System.out.println(getMsgInfoTrap(leftRoom.getTrap()));
                    inc();
                    updateInfo();
                }
                case 2 -> {
                    if (rightRoom != null)
                        if (rightRoom.isSave())
                            currentRoom = rightRoom;
                        else
                            System.out.println(getMsgInfoTrap(rightRoom.getTrap()));
                    inc();
                    updateInfo();
                }
                case 3 -> {
                    if (upRoom != null)
                        if (upRoom.isSave())
                            currentRoom = upRoom;
                        else
                            System.out.println(getMsgInfoTrap(upRoom.getTrap()));
                    inc();
                    updateInfo();
                }
                case 4 -> {
                    if (downRoom != null)
                        if (downRoom.isSave())
                            currentRoom = downRoom;
                        else
                            System.out.println(getMsgInfoTrap(downRoom.getTrap()));
                    inc();
                    updateInfo();
                }
                case 5 -> {
                    if (frontRoom != null)
                        if (frontRoom.isSave())
                            currentRoom = frontRoom;
                        else
                            System.out.println(getMsgInfoTrap(frontRoom.getTrap()));
                    inc();
                    updateInfo();
                }
                case 6 -> {
                    if (backRoom != null)
                        if (backRoom.isSave())
                            currentRoom = backRoom;
                        else
                            System.out.println(getMsgInfoTrap(backRoom.getTrap()));
                    inc();
                    updateInfo();
                }
                case 7 -> {
                    inc();
                    updateInfo();
                }
            }
        }

    }

    private static void inc() {
        if (hour == 1 && cube.getRoundForRoom() == 2) {
            bridgeBlock = day % 2 != 0;
        } else
            bridgeBlock = true;

        if (count < 6)
            count++;
        else {
            cube.nextRound();
            count = 0;
            hour++;
        }
        if (hour >= 24) {
            day++;
            hour = 1;
        }
    }


    private static void setBridgeRoom() {
        if (emptyCell.size() > 0 && !bridgeBlock) {
            Random rnd = new Random();
            int index = rnd.nextInt(emptyCell.size());
            switch (index) {
                case 0 -> {
                    leftRoom = bridge;
                    emptyCell.clear();
                }
                case 1 -> {
                    rightRoom = bridge;
                    emptyCell.clear();
                }
                case 2 -> {
                    upRoom = bridge;
                    emptyCell.clear();
                }
                case 3 -> {
                    downRoom = bridge;
                    emptyCell.clear();
                }
                case 4 -> {
                    frontRoom = bridge;
                    emptyCell.clear();
                }
                case 5 -> {
                    backRoom = bridge;
                    emptyCell.clear();
                }
            }
        } else {
            emptyCell.clear();
        }
    }

    private static void updateInfo() {
        currentRoom = cube.getRoomDescartes(currentRoom.getDescartes().get(0), currentRoom.getDescartes().get(1), currentRoom.getDescartes().get(2));
        leftRoom = getLeftRoom();
        rightRoom = getRightRoom();
        upRoom = getUpRoom();
        downRoom = getDownRoom();
        frontRoom = getFrontRoom();
        backRoom = getBackRoom();
        if (currentRoom == bridge)
            bridgeBlock = true;
        setBridgeRoom();
    }

    private static Room getLeftRoom() {
        if (currentRoom.getDescartes().get(0) == 1)
            return null;
        else {
            Room room = cube.getRoomDescartes(currentRoom.getDescartes().get(0) + -1, currentRoom.getDescartes().get(1), currentRoom.getDescartes().get(2));
            if (room == null) {
                if (currentRoom == bridge && cube.getRoundForRoom() == 1)
                    return null;
                else {
                    emptyCell.add(0);
                    return cube.getRandomRoom(currentRoom, leftRoom, rightRoom, upRoom, downRoom, frontRoom, backRoom);
                }
            } else
                return room;
        }
    }

    private static Room getRightRoom() {
        if (currentRoom.getDescartes().get(0) == 26)
            return null;
        else {
            Room room = cube.getRoomDescartes(currentRoom.getDescartes().get(0) + 1, currentRoom.getDescartes().get(1), currentRoom.getDescartes().get(2));
            if (room == null) {
                if (currentRoom == bridge && cube.getRoundForRoom() == 1)
                    return cube.getExit();
                else {
                    emptyCell.add(1);
                    return cube.getRandomRoom(currentRoom, leftRoom, rightRoom, upRoom, downRoom, frontRoom, backRoom);
                }
            } else
                return room;
        }
    }

    private static Room getUpRoom() {
        if (currentRoom.getDescartes().get(1) == 1)
            return null;
        else {
            Room room = cube.getRoomDescartes(currentRoom.getDescartes().get(0), currentRoom.getDescartes().get(1) + -1, currentRoom.getDescartes().get(2));
            if (room == null) {
                if (currentRoom == bridge && cube.getRoundForRoom() == 1)
                    return null;
                else {
                    emptyCell.add(2);
                    return cube.getRandomRoom(currentRoom, leftRoom, rightRoom, upRoom, downRoom, frontRoom, backRoom);
                }
            } else
                return room;
        }
    }

    private static Room getDownRoom() {
        if (currentRoom.getDescartes().get(1) == 26)
            return null;
        else {
            Room room = cube.getRoomDescartes(currentRoom.getDescartes().get(0), currentRoom.getDescartes().get(1) + 1, currentRoom.getDescartes().get(2));
            if (room == null) {
                if (currentRoom == bridge && cube.getRoundForRoom() == 1)
                    return null;
                else {
                    emptyCell.add(3);
                    return cube.getRandomRoom(currentRoom, leftRoom, rightRoom, upRoom, downRoom, frontRoom, backRoom);
                }
            } else
                return room;
        }
    }

    private static Room getFrontRoom() {
        if (currentRoom.getDescartes().get(2) == 1)
            return null;
        else {
            Room room = cube.getRoomDescartes(currentRoom.getDescartes().get(0), currentRoom.getDescartes().get(1), currentRoom.getDescartes().get(2) + -1);
            if (room == null) {
                if (currentRoom == bridge && cube.getRoundForRoom() == 1)
                    return null;
                else {
                    emptyCell.add(4);
                    return cube.getRandomRoom(currentRoom, leftRoom, rightRoom, upRoom, downRoom, frontRoom, backRoom);
                }
            } else
                return room;
        }
    }

    private static Room getBackRoom() {
        if (currentRoom.getDescartes().get(2) == 26)
            return null;
        else {
            Room room = cube.getRoomDescartes(currentRoom.getDescartes().get(0), currentRoom.getDescartes().get(1), currentRoom.getDescartes().get(2) + 1);
            if (room == null) {
                if (currentRoom == bridge && cube.getRoundForRoom() == 1)
                    return null;
                else {
                    emptyCell.add(5);
                    return cube.getRandomRoom(currentRoom, leftRoom, rightRoom, upRoom, downRoom, frontRoom, backRoom);
                }
            } else
                return room;
        }
    }

    private static String getMsgInfoRoom(Room room) {
        return room != null ? room.toString() : "void";
    }

    private static String getMsgInfoTrap(Trap trap) {
        return trap != null ? trap.toString() : "";
    }
}
