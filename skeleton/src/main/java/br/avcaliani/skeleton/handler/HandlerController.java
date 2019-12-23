package br.avcaliani.skeleton.handler;

import br.avcaliani.skeleton.exception.TaskException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class HandlerController {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Response<Object>> exceptionHandler(Exception ex){
        return ResponseEntity.status(500).body(new Response<>(ex));
    }

    @ExceptionHandler(TaskException.class)
    public ResponseEntity<Response<Object>> taskExceptionHandler(TaskException ex){
        return ResponseEntity.ok(new Response<>(ex));
    }

}
