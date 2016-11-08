/*
 * TODO Copyright
 */

package com.company.demo.portal.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 */
@RestController
public class MyNonRestController {

    @GetMapping("/my/bye")
    public String bye() {
        return "bye";
    }
}
