package music.microservices.musiccatalogservice.services;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import music.microservices.musiccatalogservice.models.CatalogItem;
import music.microservices.musiccatalogservice.models.Music;
import music.microservices.musiccatalogservice.models.Rating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MusicInfo {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "getFallbackCatalogItem")
    public CatalogItem getCatalogItem(Rating rating) {
        Music music = restTemplate.getForObject("http://music-info-service/music/" + rating.getMusicId(), Music.class);
        return new CatalogItem(music.getName(), music.getRelease(), rating.getRating());
    }

    public CatalogItem getFallbackCatalogItem(Rating rating) {
        return new CatalogItem("Movie name not found", "", rating.getRating());
    }
}
