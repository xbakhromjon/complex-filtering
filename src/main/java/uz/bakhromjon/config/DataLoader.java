package uz.bakhromjon.config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import uz.bakhromjon.announcement.*;

import java.util.List;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {
    private final AnnouncementRepository announcementRepository;

    @Override
    public void run(String... args) throws Exception {
        List<Announcement> announcements = List.of(
                new Announcement(EAnnouncementType.SALE, EAnnouncementObject.APARTMENT, ERoom.ONE, 100L, ERepair.EURO, 3, true),
                new Announcement(EAnnouncementType.RENT, EAnnouncementObject.COTTAGE, ERoom.TWO, 80L, ERepair.DESIGNER, 5, false),
                new Announcement(EAnnouncementType.SALE, EAnnouncementObject.APARTMENT, ERoom.FIVE_PLUS, 100L, ERepair.EURO, 3, true),
                new Announcement(EAnnouncementType.SALE, EAnnouncementObject.APARTMENT, ERoom.FIVE_PLUS, 100L, ERepair.EURO, 3, true),
                new Announcement(EAnnouncementType.SALE, EAnnouncementObject.APARTMENT, ERoom.FIVE_PLUS, 100L, ERepair.EURO, 3, true)
        );
        announcementRepository.saveAll(announcements);
    }
}
