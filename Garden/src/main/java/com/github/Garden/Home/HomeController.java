package com.github.Garden.Home;

import com.github.Garden.Model.Tree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HomeController {

    public HomeController() {}

    @GetMapping("/")
    public String home() {
        return "home";
    }


}
