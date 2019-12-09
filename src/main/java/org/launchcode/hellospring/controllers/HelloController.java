package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/hello")
public class HelloController {

    // handles request at /hello
//    @GetMapping("hello")
//    public String hello() {
//        return "Hello, Spring!";
//    }

    // lives at /hello/goodbye
//    @GetMapping("goodbye")
//    public String goodbye() {
//        return "Goodbye, Spring!";
//    }

     // handles request of the form /hello?name=LaunchCode
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
    public String helloWithQueryParam(@RequestParam String name, Model model) {
        String greeting = "Hello, " + name + "!";
        model.addAttribute("greeting", greeting);
        return "hello";
    }

    // handles requests of the form /hello/LaunchCode
    @GetMapping("{name}")
    public String helloWithPathParam(@PathVariable String name, Model model) {
        String greeting = "Hello, " + name + "!";
        model.addAttribute("greeting", greeting);
        return "hello";
    }

    // handles form input with both name & language
    @ResponseBody
    @GetMapping("hello")
    public static String createMessage(@RequestParam String name, @RequestParam String language) {
        String greeting = "Hello";
        if (language.equals("arabic")) {
            greeting = "Marhabaan";
        } else if (language.equals("french")) {
            greeting = "Bonjour";
        } else if (language.equals("german")) {
            greeting = "Guten tag";
        } else if (language.equals("japanese")) {
            greeting = "Kon'nichiwa";
        } else if (language.equals("spanish")) {
            greeting = "¡Hola";
        }
        return greeting + ", " + name + "!";
    }

    // lives at /hello/form
    @GetMapping("form")
    public String helloForm() {
        return "form";
    }

    @GetMapping("hello-names")
    public String helloNames(Model model) {
        List<String> names = new ArrayList<>();
        names.add("LaunchCode");
        names.add("Java");
        names.add("JavaScript");
        model.addAttribute("names", names);
        return "hello-list";
    }
}
