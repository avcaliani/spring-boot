package br.avcaliani.springng.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Web Application Controller.
 */
@Controller
@CrossOrigin(allowedHeaders = "*")
public class WebController {

    /**
     * Return Web App Index Page.
     *
     * @return Index Page.
     */
    @RequestMapping("/")
    public String home() {
        return "index.html";
    }
}
