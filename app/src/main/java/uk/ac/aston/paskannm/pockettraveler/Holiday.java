package uk.ac.aston.paskannm.pockettraveler;

public class Holiday {
    private String title, date, notes;
    private int thumbnail;

    public Holiday(String title, String date, String notes, int thumbnail) {
        this.title = title;
        this.date = date;
        this.notes = notes;
        this.thumbnail = thumbnail;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }
}
