package sg.edu.rp.c346.id20008787.fashionbrandratingapp;

import androidx.annotation.NonNull;

import java.io.Serializable;

 public class Brand implements Serializable {

    private int id;
    private String title;
    private String Countrys;
    private int yearReleased;
    private int stars;

    public Brand(int id, String title, String Countrys, int yearReleased, int stars) {
        this.id = id;
        this.title = title;
        this.Countrys = Countrys;
        this.yearReleased = yearReleased;
        this.stars = stars;
    }

    public int getId() {
        return id;
    }

    public Brand setId(int id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Brand setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getCountrys() {
        return Countrys;
    }

    public Brand setCountrys(String countrys) {
        this.Countrys = countrys;
        return this;
    }

    public int getYearReleased() {
        return yearReleased;
    }

    public Brand setYearReleased(int yearReleased) {
        this.yearReleased = yearReleased;
        return this;
    }

    public int getStars() {
        return stars;
    }

    public Brand setStars(int stars) {
        this.stars = stars;
        return this;
    }

    @NonNull
    @Override
    public String toString() {
        String starsString = "";
        for(int i = 0; i < stars; i++){
            starsString += "*";
        }
        return title + "\n" + countrys + " - " + yearReleased + "\n" + starsString;

    }
}
