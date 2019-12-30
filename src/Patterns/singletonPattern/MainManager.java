package Patterns.singletonPattern;

public class MainManager {
    public static void main(String[] args) {
        SingletonClass singletonInstance = SingletonClass.getInstance();

        SingletonClass attemptOfSecondInstance = SingletonClass.getInstance();

        System.out.println(singletonInstance.getFullTimeOfCreation());
        System.out.println(attemptOfSecondInstance.getFullTimeOfCreation());
        if(singletonInstance.getFullTimeOfCreation() == attemptOfSecondInstance.getFullTimeOfCreation()) {
            System.out.println("Since both times are the same we have a working proof that singleton pattern was implemented correctly");
        }else System.out.println("Something is seriously wrong");
    }
}
