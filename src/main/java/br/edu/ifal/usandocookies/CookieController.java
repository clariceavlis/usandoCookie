package br.edu.ifal.usandocookies;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
public class CookieController {

    @GetMapping("/")
    public ModelAndView lerCookie(@CookieValue(value = "primeiroAcesso", defaultValue = "sim") 
        String primeiroAcesso, 
        HttpServletResponse response){

            ModelAndView mv = new ModelAndView("index");

            if(primeiroAcesso.equals("sim")) {
                mv.addObject("msg", "Este é seu primeiro acesso!");
            } else{
                mv.addObject("msg", "Esse NÃO é o seu primeiro acesso! Bem vindo de volta " + primeiroAcesso);
        }
        return mv;
    }       

        @PostMapping("/adicionarcookie")
        public ModelAndView mudaNomeCookie(String nome, HttpServletResponse response){
            Cookie c = new Cookie("primeiroAcesso", nome);
            response.addCookie(c);
            return new ModelAndView("redirect:/");
        }
    }



