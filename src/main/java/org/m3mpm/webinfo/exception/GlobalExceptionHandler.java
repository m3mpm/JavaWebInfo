package org.m3mpm.webinfo.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public String handleEntityNotFound(EntityNotFoundException ex, Model model) {

        model.addAttribute("errorMessage", ex.getMessage());

        /*ver.1 */
        String entityName = extractEntityNameFromException(ex.getMessage());
        model.addAttribute("entityName", entityName);

        /*ver.2*/
//        String entityName = ex.getEntityName();
//        model.addAttribute("entityName", entityName);

//        model.addAttribute("entityName", entityName != null ? entityName : "");

//        if (entityName != null && !entityName.isEmpty()) {
//            model.addAttribute("entityName", entityName);
//        }

        return "exception/entityNotFound";
    }

    private String extractEntityNameFromException(String message){
        Pattern pattern = Pattern.compile("(\\w+)");
        Matcher matcher = pattern.matcher(message);
        if(matcher.find()){
            return matcher.group(1);
        }
        return "";
    }
}
