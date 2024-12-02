package ssf.day18_am.model;

public class Carpark {

    private int id;
    private String carpark;
    private String category;
    private String weekday1_rate;
    private String weekday2_rate;
    private String saturday_rate;
    private String sunday_rate;

    public Carpark(int id, String carpark, String category, String weekday1_rate, String weekday2_rate,
            String saturday_rate, String sunday_rate) {
        this.id = id;
        this.carpark = carpark;
        this.category = category;
        this.weekday1_rate = weekday1_rate;
        this.weekday2_rate = weekday2_rate;
        this.saturday_rate = saturday_rate;
        this.sunday_rate = sunday_rate;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getCarpark() {
        return carpark;
    }
    public void setCarpark(String carpark) {
        this.carpark = carpark;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public String getWeekday1_rate() {
        return weekday1_rate;
    }
    public void setWeekday1_rate(String weekday1_rate) {
        this.weekday1_rate = weekday1_rate;
    }
    public String getWeekday2_rate() {
        return weekday2_rate;
    }
    public void setWeekday2_rate(String weekday2_rate) {
        this.weekday2_rate = weekday2_rate;
    }
    public String getSaturday_rate() {
        return saturday_rate;
    }
    public void setSaturday_rate(String saturday_rate) {
        this.saturday_rate = saturday_rate;
    }
    public String getSunday_rate() {
        return sunday_rate;
    }
    public void setSunday_rate(String sunday_rate) {
        this.sunday_rate = sunday_rate;
    }

    @Override
    public String toString() {
        return "Carpark [id=" + id + ", carpark=" + carpark + ", category=" + category + ", weekday1_rate="
                + weekday1_rate + ", weekday2_rate=" + weekday2_rate + ", saturday_rate=" + saturday_rate
                + ", sunday_rate=" + sunday_rate + "]";
    }
    
}
