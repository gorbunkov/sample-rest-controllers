/*
 * TODO Copyright
 */

package com.company.demo.portal.mycontrollers;

import com.company.demo.service.GreetingService;
import com.haulmont.cuba.core.global.Configuration;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.core.global.GlobalConfig;
import com.haulmont.cuba.core.global.LoadContext;
import com.haulmont.cuba.core.sys.AppContext;
import com.haulmont.cuba.core.sys.SecurityContext;
import com.haulmont.cuba.portal.config.PortalConfig;
import com.haulmont.cuba.security.app.LoginService;
import com.haulmont.cuba.security.entity.User;
import com.haulmont.cuba.security.global.LoginException;
import com.haulmont.cuba.security.global.UserSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/unprotected")
public class MyOauth2UnprotectedController {

    @Inject
    private GreetingService greetingService;

    @Inject
    private GlobalConfig globalConfig;

    @Inject
    private LoginService loginService;

    @Inject
    private PortalConfig portalConfig;

    @Inject
    private DataManager dataManager;

    private static Logger log = LoggerFactory.getLogger(MyOauth2UnprotectedController.class);

    @GetMapping("/hi")
    public String doSmth() {
        UUID anonymousSessionId = globalConfig.getAnonymousSessionId();
        AppContext.setSecurityContext(new SecurityContext(anonymousSessionId));
        return greetingService.sayHi();
    }

    @GetMapping("/users")
    public String loginAndGetUsersCount(@RequestParam String login) throws LoginException {
        Map<String, Locale> availableLocales = globalConfig.getAvailableLocales();
        Locale defaultLocale = availableLocales.values().iterator().next();
        UserSession userSession = loginService.loginTrusted(login, portalConfig.getTrustedClientPassword(), defaultLocale);
        log.info("Logged in with login {}", login);
        AppContext.setSecurityContext(new SecurityContext(userSession));
        LoadContext<User> ctx = LoadContext.create(User.class)
                .setQuery(LoadContext.createQuery("select u from sec$User u"));
        List<User> users = dataManager.loadList(ctx);
        log.info("{} users found", users.size());
        AppContext.setSecurityContext(null);
        return "Number of users: " + users.size();
    }
}