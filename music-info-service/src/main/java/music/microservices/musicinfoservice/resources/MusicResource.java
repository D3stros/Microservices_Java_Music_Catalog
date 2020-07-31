package music.microservices.musicinfoservice.resources;

import music.microservices.musicinfoservice.models.Music;
import music.microservices.musicinfoservice.models.MusicSummary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/music")
public class MusicResource {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/{musicId}")
    public Music getMusicInfo(@PathVariable("musicId") String musicId) {
        MusicSummary musicSummary = restTemplate.getForObject("https://api.deezer.com/track/" + musicId, MusicSummary.class);
        return new Music(musicId, musicSummary.getTitle(), musicSummary.getRelease_date());

    }
}
