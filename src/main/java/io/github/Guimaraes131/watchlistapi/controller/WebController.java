package io.github.Guimaraes131.watchlistapi.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WebController {

    @GetMapping("/")
    @ResponseBody
    public String homePage(Authentication authentication) {
        return "Hello " + authentication.getName();
    }
}
