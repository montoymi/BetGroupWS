package com.amadeus.betgroup.model.config;

public class SlideIonic {
    private String numSlide;
    private String title;
    private String description;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getNumSlide() {
        return numSlide;
    }

    public void setNumSlide(String numSlide) {
        this.numSlide = numSlide;
    }

    private String image;

}
