package music.microservices.musiccatalogservice.models;

public class Music {
    public Music(String musicId, String name) {
        this.musicId = musicId;
        this.name = name;
    }

    public Music() {

    }

    private String musicId;
    private String name;

    public String getMusicId() {
        return musicId;
    }

    public void setMusicId(String musicId) {
        this.musicId = musicId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
