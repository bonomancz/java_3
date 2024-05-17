package cz.bonoman.hotel;
import java.time.LocalDate;

public class Guest {
    private final int id;
    private final String name, surName;
    private final LocalDate birthDay;

    public Guest(String name, String surName, LocalDate birthDay, int id){
        this.name = name;
        this.surName = surName;
        this.birthDay = birthDay;
        this.id = id;
    }

    // getters, setters
    public String getName(){return this.name;}
    public String getSurName(){return this.surName;}
    public LocalDate getBirthDay(){return this.birthDay;}
    public int getId(){return this.id;}
}
