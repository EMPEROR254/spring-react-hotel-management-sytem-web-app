package brian.sang.hotelmns.rooms;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomService {
    private final RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public void addNewRoom(Room room) {
        roomRepository.save(room);
    }

    public List<Room> fetchAllRooms() {
        return roomRepository.findAll();
    }

    public Optional<Room> findRoomById(Long roomId) {
        return roomRepository.findById(roomId);
    }

    public void updateRoom(Room room) {
        roomRepository.save(room);
    }

    public void deleteRoomById(long roomId) {
        roomRepository.deleteById(roomId);
    }

    public void deleteMultipleRoomsById(List<Long> roomIds) {
        roomRepository.deleteAllById(roomIds);
    }
}
