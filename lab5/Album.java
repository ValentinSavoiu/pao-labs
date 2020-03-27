package com.company;

public class Album implements Comparable<Album> {
    private int publishYear;
    private String name;
    private double rating;
    Album(int py, String nm, double rt) {
        this.publishYear = py;
        this.name =nm;
        this.rating = rt;
    }

    public String getName() {
        return name;
    }

    public double getRating() {
        return rating;
    }

    public int getPublishYear() {
        return publishYear;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPublishYear(int publishYear) {
        this.publishYear = publishYear;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Album{" +
                "publishYear=" + publishYear +
                ", name='" + name + '\'' +
                ", rating=" + rating +
                '}';
    }

    @Override
    public int compareTo(Album album) {
        int x = this.name.compareTo(album.name);
        if (x != 0)
            return x;
        if (this.rating < album.rating) return -1;
        if (this.rating == album.rating) return 0;
        return 1;
    }
}
