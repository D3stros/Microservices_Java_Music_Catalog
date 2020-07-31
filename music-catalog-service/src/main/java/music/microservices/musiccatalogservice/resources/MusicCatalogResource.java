package music.microservices.musiccatalogservice.resources;

import music.microservices.musiccatalogservice.models.CatalogItem;
import music.microservices.musiccatalogservice.models.Music;
import music.microservices.musiccatalogservice.models.Rating;
import music.microservices.musiccatalogservice.models.UserRating;
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
        UserRating ratings = restTemplate.getForObject("http://ratings-data-service/ratingsdata/users/" + userId, UserRating.class);

        return ratings.getUserRating().stream().map(rating -> {
            Music music = restTemplate.getForObject("http://music-info-service/music/" + rating.getMusicId(), Music.class);
            return new CatalogItem(music.getName(), "Pop", rating.getRating());
        }).collect(Collectors.toList());
    }
}
