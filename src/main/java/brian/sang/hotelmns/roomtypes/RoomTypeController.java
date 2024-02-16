package brian.sang.hotelmns.roomtypes;

import brian.sang.hotelmns.exceptions.BadRequestException;
import brian.sang.hotelmns.exceptions.NotFoundException;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rooms/type")
public class RoomTypeController {
    private final RoomTypeService roomTypeService;

    public RoomTypeController(RoomTypeService roomTypeService) {
        this.roomTypeService = roomTypeService;
    }

    @GetMapping("/find/all")
    private List<RoomType> fetchAllRoomTypes(){
        return roomTypeService.fetchAllRoomTypes();
    }

    @GetMapping("/find/id")
    private RoomType findById(@RequestBody String roomTypeIdString){
        return roomTypeService.findById(Integer.valueOf(roomTypeIdString))
                .orElseThrow(() -> new NotFoundException("Room type with id: "+roomTypeIdString+" was not found in the db"));
    }

    @PostMapping("/new")
    private void addNewRoomType(@RequestBody RoomType roomType){
//        if(roomType.getRoomTypeId()==null){
//            throw new BadRequestException("You are trying to add a room type which does not have an id");
//        }
        if(roomType.getCreatedAt()==null){
            roomType.setCreatedAt(LocalDateTime.now());
        }
        roomTypeService.addNewRoomType(roomType);
    }

    @PutMapping("/update")
    private void updateRoomType(@RequestBody @Validated RoomType roomType){
        roomTypeService.updateRoomType(roomType);
    }

    @DeleteMapping("/delete/id")
    private void deleteRoomTypeById(@RequestBody String roomTypeId){
        roomTypeService.deleteRoomTypeById(Integer.valueOf(roomTypeId));
    }

    @DeleteMapping("/delete/multiple")
    private void batchDeleteRoomTypeById(@RequestBody List<Integer> roomTypeIds){
        roomTypeService.batchDeleteRoomTypeById(roomTypeIds);
    }


}
