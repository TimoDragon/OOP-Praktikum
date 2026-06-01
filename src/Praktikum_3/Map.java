package Praktikum_3;

import java.util.List;

public class Map {
    private List<Room> rooms;


    public Map(List<Room> pRooms) {
        this.rooms = pRooms;
    }

    public void printMap() {
        System.out.println("Tst");
        /**
         * Setze die int Werte aufs maximale Value
         */
        int minX = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxY = Integer.MIN_VALUE;

        for (Room r : rooms) {
            int x = r.getXCoordinate();
            int y = r.getYCoordinate();

            if (x < minX) minX = x;
            if (x > maxX) maxX = x;
            if (y < minY) minY = y;
            if (y > maxY) maxY = y;
        }

        for (int y = maxY; y >= minY; y--){
            for (int x = minX; x <= maxX; x++) {
                Room i = findRoommWithCoordinate(x, y);
                System.out.print(i != null ? "[Room]" : "      ");
            }
            System.out.println();
        }
    }

    public Room findRoommWithCoordinate(int x, int y) {
        for (Room r : rooms) {
            if (r.getXCoordinate() == x &&  r.getYCoordinate() == y) {
                return r;
            }
        }
        return null;
    }

}
