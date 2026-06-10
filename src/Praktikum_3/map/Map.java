package Praktikum_3.map;

import java.util.ArrayList;
import java.util.List;

public class Map {
    private final List<Room> rooms = new ArrayList<>();

    /**
     * Fügt einen Raum zur Map hinzu
     * @param room der Raum der hinzugefügt werden soll
     * @return room
     */
    public Room addRoom(Room room) {
        this.rooms.add(room);

        return room;
    }

    /**
     * Gibt die Map aus vom aktuellen Raum startend aus
     * @param currentRoom der Raum in dem man sich befindet
     */
    public void printMap(Room currentRoom) {
        int minX = 0;
        int maxX = 0;
        int minY = 0;
        int maxY = 0;

        for (Room r : rooms) {
            int x = r.getX();
            int y = r.getY();

            if (x < minX) minX = x;
            if (x > maxX) maxX = x;
            if (y < minY) minY = y;
            if (y > maxY) maxY = y;
        }

        for (int y = maxY; y >= minY; y--){
            for (int x = minX; x <= maxX; x++) {
                Room i = findRoomWithCoordinate(x, y);

                if (y != currentRoom.getY() || x != currentRoom.getX()) {
                    System.out.print(i != null ? " "+ i.getName() + " " : "     ");
                } else {
                    System.out.print("["+ i.getName() + "]");
                }


            }
            System.out.println();
        }
    }

    /**
     * Sucht einen bestimmten Raum anhand von x und y Koordinaten
     * @param x x-Koordinate
     * @param y y-Koordinate
     * @return der gesuchte Raum
     */
    public Room findRoomWithCoordinate(int x, int y) {
        for (Room r : rooms) {
            if (r.getX() == x && r.getY() == y) {
                return r;
            }
        }
        return null;
    }
}
