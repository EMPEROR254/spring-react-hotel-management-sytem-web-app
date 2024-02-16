package brian.sang.hotelmns.roomtypes;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomTypeService {
    private final RoomTypeRepository repository;

    public RoomTypeService(RoomTypeRepository repository) {
        this.repository = repository;
    }


    public List<RoomType> fetchAllRoomTypes() {
        return repository.findAll();
    }


    public Optional<RoomType> findById(Integer roomTypeId) {
        return repository.findById(roomTypeId);
    }

    public void addNewRoomType(RoomType roomType) {
        repository.save(roomType);
    }

    public void updateRoomType(RoomType roomType) {
        repository.save(roomType);
    }

    public void deleteRoomTypeById(Integer roomTypeId) {
        repository.deleteById(roomTypeId);
    }

    public void batchDeleteRoomTypeById(List<Integer> roomTypeIds) {
        repository.deleteAllByIdInBatch(roomTypeIds);
    }
}
