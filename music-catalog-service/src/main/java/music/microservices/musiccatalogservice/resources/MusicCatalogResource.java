package music.microservices.musiccatalogservice.resources;

import music.microservices.musiccatalogservice.models.CatalogItem;
import music.microservices.musiccatalogservice.models.Music;
import music.microservices.musiccatalogservice.models.Rating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class MusicCatalogResource {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {

        //Hardcoding the ratings temporarily
        List<Rating> ratings = Arrays.asList(
                new Rating("1234", 8),
                new Rating("5678", 9)
        );

        return ratings.stream().map(rating -> {
            Music music = restTemplate.getForObject("http://localhost:8082/music/" + rating.getMusicId(), Music.class);
            return new CatalogItem(music.getName(), "Pop", rating.getRating());
        }).collect(Collectors.toList());
    }
}
