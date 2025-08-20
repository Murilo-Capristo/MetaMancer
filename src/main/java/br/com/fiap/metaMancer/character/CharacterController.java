package br.com.fiap.metaMancer.character;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/character")
@RequiredArgsConstructor
public class CharacterController {

    private final CharacterService characterService;
    private final MessageSource messageSource;



    @GetMapping
    public String index(Model model){
        model.addAttribute("characters", characterService.getAllCharacters());
        return "index";
    }

    @GetMapping("/form")
    public String form(Character character){
        return"form";
    }

    @PostMapping("/form")
    public String create(@Valid Character character, BindingResult result, RedirectAttributes redirect){
        if (result.hasErrors()) return "form";
        characterService.save(character);
        var message = messageSource.getMessage("character.save.success", null , LocaleContextHolder.getLocale());
        redirect.addFlashAttribute("message", message);
        return "redirect:/character";
    }
}
