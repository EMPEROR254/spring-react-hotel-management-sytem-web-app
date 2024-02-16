package brian.sang.hotelmns.rooms;

import brian.sang.hotelmns.exceptions.BadRequestException;
import brian.sang.hotelmns.exceptions.NotFoundException;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/rooms")
public class RoomController {
    private final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping("/find/all")
    private List<Room> fetchAllRooms(){
        return roomService.fetchAllRooms();
    }

    @GetMapping("/find/id")
    private Room findRoomById(@RequestBody String roomIdString){
        return roomService.findRoomById(Long.parseLong(roomIdString))
                .orElseThrow(()-> new NotFoundException("Room with id: "+roomIdString+" was not found in database"));
    }

    @PostMapping("/new")
    private void addNewRoom(@RequestBody Room room){
//       if(room.getRoomId()==null){
//           throw new BadRequestException("You are trying to create a room without an id");
//       }
        room.setCreatedAt(LocalDateTime.now());
       roomService.addNewRoom(room);
    }

    @PutMapping("/update")
    private void updateRoom(@RequestBody @Validated Room room){
        roomService.updateRoom(room);
    }

    @DeleteMapping("/delete/id")
    private void deleteRoomById(@RequestBody String roomIdString){
        roomService.deleteRoomById(Long.parseLong(roomIdString));
    }

    @DeleteMapping("/delete/multiple")
    private void deleteMultipleRoomsById(@RequestBody List<Long> roomIds){
        roomService.deleteMultipleRoomsById(roomIds);
    }


}
