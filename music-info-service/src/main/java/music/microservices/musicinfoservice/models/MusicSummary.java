package music.microservices.musicinfoservice.models;

public class MusicSummary {

    public MusicSummary(String id, String title, String release_date) {
        this.id = id;
        this.title = title;
        this.release_date = release_date;
    }

    public MusicSummary() {

    }

    private String id;
    private String title;
    private String release_date;

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
