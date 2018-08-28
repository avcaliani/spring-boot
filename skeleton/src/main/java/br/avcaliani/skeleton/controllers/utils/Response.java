package br.avcaliani.skeleton.controllers.utils;

import lombok.Data;

/**
 * This is a Generic Response Object. You don't have to use It. But can be a good idea.
 * If you decide to use this solution, all your responses will follow this pattern.
 */
@Data
public class Response<T> {

    private Integer status;
    private String error;
    private T data;

    /**
     * Success Constructor.
     * @param data Response Object.
     */
    public Response(T data) {
        this.status = 200;
        this.error = null;
        this.data = data;
    }

    /**
     * Error Constructor.
     * @param throwable Response Error.
     */
    public Response(Throwable throwable) {
        this.status = 500;
        this.error = throwable.getMessage();
        this.data = null;
    }

}
