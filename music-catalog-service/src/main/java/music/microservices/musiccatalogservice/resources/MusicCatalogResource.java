package music.microservices.musiccatalogservice.resources;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import music.microservices.musiccatalogservice.models.CatalogItem;
import music.microservices.musiccatalogservice.models.Music;
import music.microservices.musiccatalogservice.models.Rating;
import music.microservices.musiccatalogservice.models.UserRating;
import music.microservices.musiccatalogservice.services.MusicInfo;
import music.microservices.musiccatalogservice.services.UserRatingInfo;
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
    @Autowired
    MusicInfo musicInfo;
    @Autowired
    UserRatingInfo userRatingInfo;

    @RequestMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {

        UserRating userRating = userRatingInfo.getUserRating(userId);
        return userRating.getUserRating().stream().map(rating -> {
            return musicInfo.getCatalogItem(rating);
        }).collect(Collectors.toList());
    }

}
