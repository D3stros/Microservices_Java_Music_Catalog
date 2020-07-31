package music.microservices.musicinfoservice.resources;

import music.microservices.musicinfoservice.models.Music;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/music")
public class MusicResource {

    @RequestMapping("/{musicId}")
    public Music getMusicInfo(@PathVariable("musicId") String musicId) {
        return new Music(musicId, "Test name2");

    }
}
