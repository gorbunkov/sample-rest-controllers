/*
 * TODO Copyright
 */

package com.company.demo.portal.mycontrollers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/unprotected")
public class MyOauth2UnprotectedController {

    @GetMapping("/hi")
    public String doSmth() {
        return "hi";
    }
}