package music.microservices.musiccatalogservice.models;

public class CatalogItem {
    private String name;
    private String release_date;
    private int rating;

    public CatalogItem(String name, String release_date, int rating) {
        this.name = name;
        this.release_date = release_date;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
