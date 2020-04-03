package com.company;
import java.util.*;
public class Hall implements Comparable<Hall>{
    private int id, no_seats;
    private static int ID;
    private String name;
    private ArrayList<Seat> seats;
    public Hall(String name, int no_seats) {
        this.id = ID++;
        this.no_seats = no_seats;
        this.seats = new ArrayList<Seat>();
        this.name = name;
        for (int i = 0; i < no_seats; ++i) {
            seats.add(new Seat());
        }
    }

    public ArrayList<Seat> getSeats() {
        return seats;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Hall{" +
                "id=" + id +
                ", no_seats=" + no_seats +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public int getId() {
        return id;
    }

    @Override
    public int compareTo(Hall hall) {
        return name.compareTo(hall.name);
    }
}



