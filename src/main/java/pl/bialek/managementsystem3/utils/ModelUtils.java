package pl.bialek.managementsystem3.utils;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

public class ModelUtils {

    public static void addMessage(RedirectAttributes attributes, String message){
        attributes.addFlashAttribute("message",message);

    }
}
