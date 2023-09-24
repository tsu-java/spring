package ge.tsu.controller.advice;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.time.LocalDate;
import java.util.List;

// Specialization of @Component for classes that declare @ExceptionHandler, @InitBinder, or @ModelAttribute methods
// to be shared across multiple @Controller classes.
// It can also be viewed as an interceptor.
// NOTE: By default, the methods in an @ControllerAdvice apply globally to all controllers!
@ControllerAdvice
public class SetSharedVariablesController { // We'll use interceptor as an exception handler too, in future...

    @Autowired
    private Environment env;

    // Annotation that binds a method parameter or method return value to a named model attribute,
    // exposed to a web view. Supported for controller classes with @RequestMapping methods.
    @ModelAttribute("appName")
    public String appName() {
        return env.getProperty("appName");
    }

    @ModelAttribute("appPages")
    public List<Navigation> appPages() {
        return List.of(
                new Navigation("Home Page", "/"),
                new Navigation("About Us", "/about"),
                new Navigation("Contact Us", "/contact")
        );
    }

    @ModelAttribute("currentYear")
    public int currentYear() {
        return LocalDate.now().getYear();
    }

    @ModelAttribute("activeLink")
    public String activeLink(HttpServletRequest request) { // HttpServletRequest will be injected automatically!
        return request.getRequestURI();
    }

    record Navigation(String name, String link) {
    }
}

