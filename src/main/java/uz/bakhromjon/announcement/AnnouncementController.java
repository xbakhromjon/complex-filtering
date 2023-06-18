package uz.bakhromjon.announcement;

import lombok.RequiredArgsConstructor;
import net.kaczmarzyk.spring.data.jpa.domain.Between;
import net.kaczmarzyk.spring.data.jpa.domain.Equal;
import net.kaczmarzyk.spring.data.jpa.domain.In;
import net.kaczmarzyk.spring.data.jpa.web.annotation.And;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/announcements")
@RequiredArgsConstructor
public class AnnouncementController {
    private final AnnouncementRepository announcementRepository;

    @GetMapping("/filter")
    public Page<Announcement> filter(
            @And({
                    @Spec(path = "announcementType", params = "type", spec = Equal.class),
                    @Spec(path = "announcementObject", params = "object", spec = In.class),
                    @Spec(path = "registeredCount", params = "registered_count", spec = Equal.class),
                    @Spec(path = "cost", params = {"from_cost", "to_cost"}, spec = Between.class),
                    @Spec(path = "fitness", params = "fitness", spec = Equal.class)
            }) Specification<Announcement> spec,
            Pageable pageable) {

        return announcementRepository.findAll(spec, pageable);
    }
}
