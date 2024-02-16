package brian.sang.hotelmns.rooms;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@ToString
public class Room {
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "room_sequence_generator")
    @SequenceGenerator(
            name = "room_sequence_generator",
            sequenceName = "room_sequence_generator",
            allocationSize = 1
    )


    @Id
    private Long roomId;
    private String roomName;
    @ManyToOne
    @JoinColumn (name = "room_type", referencedColumnName = "room_type_id")
    private Integer roomType;
    private LocalDateTime createdAt;

    public Room() {
    }

    public Room(String roomName,
                Integer roomType) {
        this.roomName = roomName;
        this.roomType = roomType;
    }

    public Room(Long roomId,
                String roomName,
                Integer roomType) {
        this.roomId = roomId;
        this.roomName = roomName;
        this.roomType = roomType;
    }
}
