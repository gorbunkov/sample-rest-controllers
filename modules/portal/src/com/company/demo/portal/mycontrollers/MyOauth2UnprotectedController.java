/*
 * TODO Copyright
 */

package com.company.demo.portal.mycontrollers;

import com.company.demo.service.GreetingService;
import com.haulmont.cuba.core.global.Configuration;
import com.haulmont.cuba.core.global.GlobalConfig;
import com.haulmont.cuba.core.sys.AppContext;
import com.haulmont.cuba.core.sys.SecurityContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.util.UUID;

@RestController
@RequestMapping("/unprotected")
public class MyOauth2UnprotectedController {

    @Inject
    private GreetingService greetingService;

    @Inject
    private Configuration configuration;

    @GetMapping("/hi")
    public String doSmth() {
        UUID anonymousSessionId = configuration.getConfig(GlobalConfig.class).getAnonymousSessionId();
        AppContext.setSecurityContext(new SecurityContext(anonymousSessionId));
        return greetingService.sayHi();
    }
}