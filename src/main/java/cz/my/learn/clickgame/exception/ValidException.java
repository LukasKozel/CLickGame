package cz.my.learn.clickgame.exception;

/**
 * If attribute isn't valid
 * 
 * @author Lukas Kozel
 */
public class ValidException extends Exception{

    public ValidException() {
    }

    public ValidException(String message) {
        super(message);
    }
    
}
