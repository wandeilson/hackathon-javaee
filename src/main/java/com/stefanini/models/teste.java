package com.stefanini.models;


import io.quarkus.elytron.security.common.BcryptUtil;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class teste {

    public static void main(String[] args) {
        //String password = "Co9";
        //String regex = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{4,10}$";
        //System.out.println(isValidPassword(password,regex));
        LocalDate dataNascimenti = LocalDate.of(1997,11,24);
        System.out.println(dataNascimenti);

        LocalDateTime dataCriacao = LocalDateTime.now();
        System.out.println(dataCriacao);
        System.out.println(dataCriacao.getMonthValue());
    }

    public static boolean isValidPassword(String senha,String regex){
        if(senha.trim().isEmpty() || senha == null || hasSpace(senha)){
            return false;
        }
        //Pattern pattern = Pattern.compile(regex);
      //  Matcher matcher = pattern.matcher(senha);
        //return matcher.matches();
        return true;
    }

    public static boolean hasSpace(String str)
    {
        for(int i=0;i<str.length();i++)
        {
            if(str.charAt(0)==' ' || str.charAt(i)==' '&&str.charAt(i+1)!=' ')
            {
                return true;
            }
        }
        return false;
    }

}
