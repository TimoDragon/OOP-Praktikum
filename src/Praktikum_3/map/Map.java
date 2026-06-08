package Praktikum_3.map;

import java.util.ArrayList;
import java.util.List;

public class Map {
    private final List<Room> rooms = new ArrayList<>();

    public Room addRoom(Room room) {
        this.rooms.add(room);

        return room;
    }

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

    public Room findRoomWithCoordinate(int x, int y) {
        for (Room r : rooms) {
            if (r.getX() == x && r.getY() == y) {
                return r;
            }
        }
        return null;
    }
}
