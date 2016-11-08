/*
 * TODO Copyright
 */

package com.company.demo.portal.mycontrollers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/protected")
public class MyOauth2ProtectedController {

    @GetMapping("/hello")
    public String doSmth() {
        return "hello";
    }
}