package uk.ac.aston.paskannm.pockettraveler;

public class Holiday {
    private String title, startDay, endDay, notes;
    private int thumbnail;

    public Holiday(String title, String startDay, String endDay, String notes, int thumbnail) {
        this.title = title;
        this.startDay = startDay;
        this.endDay = endDay;
        this.notes = notes;
        this.thumbnail = thumbnail;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStartDay() {
        return startDay;
    }

    public void setStartDay(String startDay) {
        this.startDay = startDay;
    }

    public String getEndDay() {
        return endDay;
    }

    public void setEndDay(String endDay) {
        this.endDay = endDay;
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
