package uz.bakhromjon.announcement;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "announcement")
public class Announcement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private EAnnouncementType announcementType;


    @Enumerated(EnumType.STRING)
    private EAnnouncementObject announcementObject;

    @Enumerated(EnumType.STRING)
    private ERoom room;

    private Long cost;

    @Enumerated(EnumType.STRING)
    private ERepair repair;

    private Integer registeredCount;
    private Boolean fitness;

    public Announcement(EAnnouncementType announcementType, EAnnouncementObject announcementObject, ERoom room, Long cost, ERepair repair, Integer registeredCount, Boolean fitness) {
        this.announcementType = announcementType;
        this.announcementObject = announcementObject;
        this.room = room;
        this.cost = cost;
        this.repair = repair;
        this.registeredCount = registeredCount;
        this.fitness = fitness;
    }
}


