package uk.ac.aston.paskannm.pockettraveler;

public class Place {

    private String title, dateVisited;
    private int thumbnail;

    public Place(String title, String dateVisited, int thumbnail) {
        this.title = title;
        this.dateVisited = dateVisited;
        this.thumbnail = thumbnail;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDateVisited() {
        return dateVisited;
    }

    public void setDateVisited(String dateVisited) {
        this.dateVisited = dateVisited;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }
}
