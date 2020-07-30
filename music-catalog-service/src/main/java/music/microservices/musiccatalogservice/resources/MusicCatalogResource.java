package music.microservices.musiccatalogservice.resources;

import music.microservices.musiccatalogservice.models.CatalogItem;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/catalog")
public class MusicCatalogResource {

    @RequestMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable("userId")String userId) {

        return Collections.singletonList(
                new CatalogItem("Thriller", "Pop", 8)
        );
    }
}
