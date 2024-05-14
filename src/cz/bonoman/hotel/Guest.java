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
    public String gsName(){return this.name;}
    //public void gsName(String input){this.name = input;}
    public String gsSurName(){return this.surName;}
    //public void gsSurName(String input){this.surName = input;}
    public LocalDate gsBirthDay(){return this.birthDay;}
    //public void gsBirthDay(LocalDate input){this.birthDay = input;}
    public int gsId(){return this.id;}
    //public void gsId(int input){this.id = input;}
}
