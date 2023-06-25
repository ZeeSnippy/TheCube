package thecube;

import thecube.objects.Cube;
import thecube.objects.Room;
import thecube.objects.Trap;

import java.util.Scanner;

public class Main {
    private static final Cube cube = new Cube();

    private static final Room bridge = cube.getBridge();
    private static final Room exit = cube.getExit();
    private static Room currentRoom = cube.getSaveCenterRoom();
    private static Room leftRoom, rightRoom, upRoom, downRoom, frontRoom, backRoom;
    public static int minutes = 0;
    public static int hour = 0;
    public static int day = 0;

    public static void main(String[] args) {
        cube.nextRound();
        currentRoom.setColor("Белый");
        updateInfo();
        Scanner mainMenu;
        int value;
        while (true) {
            mainMenu = new Scanner(System.in);
            System.out.println(cube.getStatistic());
            System.out.println("Round room: " + cube.getRoundForRoom() + " Минуты: " + minutes + " Часы: " + hour + " Дни: " + day);
            System.out.println("BRIDGE: " + getMsgInfoRoom(bridge));
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
            if (currentRoom != bridge || cube.getRoundForRoom() != 1) {
                System.out.println("[4] - Перейти в комнату слева");
                System.out.println("[6] - Перейти в комнату справа");
                System.out.println("[8] - Перейти в комнату сверху");
                System.out.println("[2] - Перейти в комнату снижу");
                System.out.println("[1] - Перейти в комнату спереди (FRONT)");
                System.out.println("[9] - Перейти в комнату сзади (BACK)");
                System.out.println("----------------------------------------------");
                System.out.println("[0] - Длительный отдых (9 час)");
                System.out.println("[5] - Короткий отдых (1 час)");
                System.out.print("You select: ");
            }
            try {
                value = mainMenu.nextInt();
            } catch (Exception e) {
                value = 11;
            }
            switch (value) {
                case 0 -> {
                    for (int i = cube.getRoundForRoom(); i <= 9; i++) {
                        minutes += 50;
                        inc();
                        updateInfo();
                    }
                }
                case 4 -> {
                    moveTheNextRoom(leftRoom);
                }
                case 6 -> {
                    moveTheNextRoom(rightRoom);
                }
                case 8 -> {
                    moveTheNextRoom(upRoom);
                }
                case 2 -> {
                    moveTheNextRoom(downRoom);
                }
                case 1 -> {
                    moveTheNextRoom(frontRoom);
                }
                case 9 -> {
                    moveTheNextRoom(backRoom);
                }
                case 5 -> {
                    minutes += 50;
                    inc();
                    updateInfo();
                }
            }
        }

    }

    private static void moveTheNextRoom(Room route) {
        try {


            if (route != null) {
                if (route.isSave())
                    currentRoom = route;
                else {
                    System.out.println(getMsgInfoTrap(route.getTrap()));
                    Scanner roomScanner = new Scanner(System.in);
                    try {
                        System.out.println("Войти в комнату с ловушкой: 1");
                        System.out.println("Вернуться назад: 0");
                        System.out.print("Что вы делаете? ");
                        int answer = roomScanner.nextInt();

                        if (answer == 1) {
                            currentRoom = route;
                            minutes += 10;
                        }
                    } catch (Exception ignored) {
                    }
                }
                inc();
                updateInfo();
                System.out.println();
            }
        } catch (Exception ignored) {

        }

    }

    private static void inc() {
        minutes += 10;
        int temp = minutes - 60;
        if (minutes >= 60) {
            hour++;
            cube.nextRound();
            minutes = temp;
        }
        if (hour >= 24) {
            day++;
            hour = 0;
        }
    }


    private static void updateInfo() {
        if (cube.getRoundForRoom() == 1 && currentRoom == bridge) {
            leftRoom = exit;
            rightRoom = exit;
            upRoom = exit;
            downRoom = exit;
            frontRoom = exit;
            backRoom = exit;
        } else {
            if (getLeftRoom() != null)
                leftRoom = getLeftRoom();
            else {
                if (currentRoom.getDescartes().get(0) == 1 || leftRoom.getDescartes().get(0) == 1) {
                    leftRoom = null;
                } else if (currentRoom == leftRoom) leftRoom = bridge;
            }
            if (getRightRoom() != null)
                rightRoom = getRightRoom();
            else {
                if (currentRoom.getDescartes().get(0) == 26 || rightRoom.getDescartes().get(0) == 26) {
                    rightRoom = null;
                } else if (currentRoom == rightRoom) rightRoom = bridge;
            }
            if (getUpRoom() != null)
                upRoom = getUpRoom();
            else {
                if (currentRoom.getDescartes().get(1) == 1 || upRoom.getDescartes().get(1) == 1) {
                    upRoom = null;
                } else if (currentRoom == upRoom) upRoom = bridge;
            }
            if (getDownRoom() != null)
                downRoom = getDownRoom();
            else {
                if (currentRoom.getDescartes().get(1) == 26 || downRoom.getDescartes().get(1) == 26) {
                    downRoom = null;
                } else if (currentRoom == downRoom) downRoom = bridge;
            }
            if (getFrontRoom() != null)
                frontRoom = getFrontRoom();
            else {
                if (currentRoom.getDescartes().get(2) == 1 || frontRoom.getDescartes().get(2) == 1) {
                    frontRoom = null;
                } else if (currentRoom == frontRoom) frontRoom = bridge;
            }
            if (getBackRoom() != null)
                backRoom = getBackRoom();
            else {
                if (currentRoom.getDescartes().get(2) == 26 || backRoom.getDescartes().get(2) == 26) {
                    backRoom = null;
                } else if (currentRoom == backRoom) backRoom = bridge;
            }
        }
    }

    private static Room getLeftRoom() {
        return cube.getRoomDescartes(currentRoom.getDescartes().get(0) + -1, currentRoom.getDescartes().get(1), currentRoom.getDescartes().get(2));
    }

    private static Room getRightRoom() {
        return cube.getRoomDescartes(currentRoom.getDescartes().get(0) + 1, currentRoom.getDescartes().get(1), currentRoom.getDescartes().get(2));
    }

    private static Room getUpRoom() {
        return cube.getRoomDescartes(currentRoom.getDescartes().get(0), currentRoom.getDescartes().get(1) + -1, currentRoom.getDescartes().get(2));
    }

    private static Room getDownRoom() {
        return cube.getRoomDescartes(currentRoom.getDescartes().get(0), currentRoom.getDescartes().get(1) + 1, currentRoom.getDescartes().get(2));
    }

    private static Room getFrontRoom() {
        return cube.getRoomDescartes(currentRoom.getDescartes().get(0), currentRoom.getDescartes().get(1), currentRoom.getDescartes().get(2) + -1);
    }

    private static Room getBackRoom() {
        return cube.getRoomDescartes(currentRoom.getDescartes().get(0), currentRoom.getDescartes().get(1), currentRoom.getDescartes().get(2) + 1);
    }

    private static String getMsgInfoRoom(Room room) {
        return room != null ? room.toString() : "Граница внутреней части куба";
    }

    private static String getMsgInfoTrap(Trap trap) {
        return trap != null ? trap.toString() : "";
    }
}
