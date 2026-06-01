package Praktikum_3;

import java.util.List;

public class Map {
    private List<Room> rooms;


    public Map() {
        createMap();
    }

    public void createMap() {

    }

    public void printMap() {
        /**
         * Setze die int Werte aufs maximale Value
         */
        int minX = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxY = Integer.MIN_VALUE;

        for (Room i : rooms) {
            for (Room r : rooms) {
                int x = r.getXCoordinate();
                int y = r.getYCoordinate();

                if (x < minX) minX = x;
                if (x > maxX) maxX = x;
                if (y < minY) minY = y;
                if (y > maxY) maxY = y;
            }
        }

        for (int j = maxY; j <= minY; j++){
            for (int k = minX; k <= maxX; k++) {
                Room r = findRoommWithCoordinate(j, k);
                System.out.println(r != null ? "[Room]" : "   ");
            }
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
