package br.avcaliani.springng.controller;

import br.avcaliani.springng.domain.Contact;
import org.springframework.web.bind.annotation.*;

/**
 * Contact Rest Controller.
 */
@RestController
@RequestMapping("/api/contact")
@CrossOrigin(allowedHeaders = "*")
public class ContactController {

    /**
     * Return my contact :)
     *
     * @return {@link Contact}.
     */
    @GetMapping
    @ResponseBody
    public Contact get() {
        return new Contact(
                "Anthony Caliani",
                "@avcaliani",
                "https://github.com/avcaliani",
                "https://gitlab.com/avcaliani"
        );
    }
}
