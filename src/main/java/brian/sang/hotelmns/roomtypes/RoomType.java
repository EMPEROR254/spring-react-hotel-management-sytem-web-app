package brian.sang.hotelmns.roomtypes;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
public class RoomType {
    @Id
    @GeneratedValue(generator = "room_type_generator",
            strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(
            name = "room_type_generator",
            sequenceName = "room_type_generator",
            allocationSize = 1
    )

    private Integer roomTypeId;
    @Lob
    @Column (columnDefinition = "TEXT")
    private String name;
    private String description;
    private List<String> roomImages;
    private Double price;
    private LocalDateTime createdAt;

    public RoomType() {
    }

    public RoomType(String name,
                    String description,
                    Double price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public RoomType(String name,
                    String description,
                    List<String> roomImages,
                    Double price) {
        this.name = name;
        this.description = description;
        this.roomImages = roomImages;
        this.price = price;
    }

    public RoomType(Integer roomTypeId,
                    String name,
                    String description,
                    List<String> roomImages,
                    Double price,
                    LocalDateTime createdAt) {
        this.roomTypeId = roomTypeId;
        this.name = name;
        this.description = description;
        this.roomImages = roomImages;
        this.price = price;
        this.createdAt = createdAt;
    }
}
