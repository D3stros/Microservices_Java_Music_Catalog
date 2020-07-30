package music.microservices.ratingsdataservice.resources;

import music.microservices.ratingsdataservice.models.Rating;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ratingsdata")
public class RatingsResource {

    @RequestMapping("/{musicId}")
    public Rating getRating(@PathVariable("musicId") String musicId) {
        return new Rating(musicId, 7);
    }

}
