import java.util.Scanner;

class MyParkingArea {
    public static void main(String[] args) {
        System.out.println("*WELCOME TO SMART PARKING SYSTEM.*");

        for (int k = 0; k < 5; k++) {
            new Entry();
            System.out.println("--------------------------------------------------------------------------------------------------------");
            Vehicle c1 = new Vehicle();
            System.out.println("--------------------------------------------------------------------------------------------------------");
            new ParkArea().Park(c1);
            System.out.println("--------------------------------------------------------------------------------------------------------");
        }

        System.out.println("Enter true to enter Parking Lot 1.");
        boolean check;
        try (Scanner inp = new Scanner(System.in)) {
            check = inp.nextBoolean();
            if (check) {
                for (int S = 0; S < ParkArea.maxS; S++) {
                    System.out.println("Enter Your Alloted ID.");
                    int newId = inp.nextInt();
                    if (newId == ParkArea.Slot1[1][0]) {
                        System.out.println("Welcome, VC. You have entered your reserved slot!");
                    } else if (newId == ParkArea.Slot1[1][1]) {
                        System.out.println("Welcome, Registrar. You have entered your reserved slot!");
                    } else if (ParkArea.Slot1[1][S] == newId) {
                        System.out.println("You have entered your registered slot!");
                    } else {
                        System.out.println("Access Denied!");
                    }
                    System.out.println();
                    System.out.println();
                }
            } else {
                for (int S = 0; S < ParkArea.maxS; S++) {
                    System.out.println("Enter Your Alloted ID.");
                    int newId = inp.nextInt();
                    if (newId == ParkArea.Slot2[2][S]) {
                        System.out.println("You have entered your registered slot!");
                    } else {
                        System.out.println("Access Denied!");
                    }
                }
            }
        }
        System.out.println("--------------------------------------------------------------------------------------------------------");
    }
}

class Entry {
    private static final int[] ids = {20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39};

    Entry() {
        System.out.println("Enter Your ID.");
        try (Scanner obj1 = new Scanner(System.in)) {
            int userId = obj1.nextInt();
            boolean entryAllowed = false;
            for (int id : ids) {
                if (userId == id) {
                    System.out.println("Entry Allowed!");
                    entryAllowed = true;
                    System.out.println("Control Moving To Parking Areas.");
                    break;
                }
            }
            if (!entryAllowed) {
                System.out.println("Entry Denied!");
            }
        }
    }
}

class ParkArea {
    public static final int maxS = 4;
    public static final int maxP = 2;
    public static final int[][] Slot1 = new int[maxP][maxS];
    public static final int[][] Slot2 = new int[maxP][maxS];

    ParkArea() {
        Slot1[1][0] = -1;
        Slot1[1][1] = -2;
    }

    void Park(Vehicle v1) {
        boolean slotAssigned = false;
        for (int S = 0; S < maxS; S++) {
            if (Slot1[1][S] == 0) {
                Slot1[1][S] = v1.id;
                System.out.println("Your allotted slot no. in parking is: P1S" + S);
                slotAssigned = true;
                break;
            }
        }
        if (!slotAssigned) {
            for (int S = 0; S < maxS; S++) {
                if (Slot2[1][S] == 0) {
                    Slot2[1][S] = v1.id;
                    System.out.println("Your allotted slot no. in parking is: P2S" + S);
                    slotAssigned = true;
                    break;
                }
            }
        }
        if (!slotAssigned) {
            System.out.println("Parking is full. No slot available.");
        }
    }
}

class Vehicle {
    public final int id;
    private static int i = 1;
    private static final int maxCapacity = 20;

    Vehicle() {
        id = i++;
        if (i > maxCapacity) {
            System.out.println("NO MORE CAPACITY!");
        }
        System.out.println("VehicleIn. Your alloted id is:" + id);
    }
}