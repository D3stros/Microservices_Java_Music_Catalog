package music.microservices.musiccatalogservice.models;

public class Music {
    public Music(String musicId, String name, String release) {
        this.musicId = musicId;
        this.name = name;
        this.release = release;
    }

    public Music() {

    }

    private String musicId;
    private String name;
    private String release;

    public String getRelease() {
        return release;
    }

    public void setRelease(String release) {
        this.release = release;
    }


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
