package br.avcaliani.skeleton.exceptions;

public class TaskException extends RuntimeException {

    /**
     * Default Constructor.
     */
    public TaskException(){
        super();
    }

    /**
     * Message Constructor.
     *
     * @param message Message.
     */
    public TaskException(String message) {
        super(message);
    }

    /**
     * Message and Throwable Constructor.
     *
     * @param message Message.
     * @param throwable Throwable.
     */
    public TaskException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
