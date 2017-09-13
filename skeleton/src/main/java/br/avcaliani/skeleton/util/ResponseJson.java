package br.avcaliani.skeleton.util;

import lombok.Data;

/**
 * This is a Generic Response Object. You don't have to use It. But can be a good idea.
 * If you decide to use this solution, all your responses will follow this pattern.
 */
@Data
public class ResponseJson {

    private Integer status;
    private String error;
    private Object data;

    /**
     * Success Constructor.
     * @param data Response Object.
     */
    public ResponseJson(Object data) {
        this.status = 200;
        this.error = "No Error.";
        this.data = data;
    }

    /**
     * Error Constructor.
     * @param throwable Response Error.
     */
    public ResponseJson(Throwable throwable) {
        this.status = 500;
        this.error = throwable.getMessage();
        this.data = null;
    }

}
