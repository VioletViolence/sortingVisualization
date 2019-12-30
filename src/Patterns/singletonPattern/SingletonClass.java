package Patterns.singletonPattern;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class SingletonClass {
    //variables
    private String nameOfTheClass;
    private LocalDateTime dateOfCreation;
    private LocalDateTime fullTimeOfCreation;


    //Singleton stuff
    private static final SingletonClass singletonInstance = new SingletonClass();
    private static boolean initialized = false;
    private SingletonClass() {}

    private void init(){
        nameOfTheClass = "SingletonClass";
        LocalDateTime date = LocalDateTime.now();
        fullTimeOfCreation = date;
        dateOfCreation = date.truncatedTo(ChronoUnit.DAYS);
    }

    public static synchronized SingletonClass getInstance(){
        if(initialized) return singletonInstance;
        initialized = true;
        singletonInstance.init();
        return singletonInstance;
    }

    //Getters
    public String getNameOfTheClass() {
        return nameOfTheClass;
    }

    public LocalDateTime getDateOfCreation() {
        return dateOfCreation;
    }

    public LocalDateTime getFullTimeOfCreation() {
        return fullTimeOfCreation;
    }
}
