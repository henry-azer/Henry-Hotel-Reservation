package henry.hotel.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HotelErrorController implements ErrorController  {
 
	// handle any http that didn't defined and redirect to home
    @RequestMapping("/error")
    public String handleError() {
        return "redirect:/";
    }
    
    // set error path
    @Override
    public String getErrorPath() {
        return null;
    }
}