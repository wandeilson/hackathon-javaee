package com.stefanini.util;

import io.quarkus.elytron.security.common.BcryptUtil;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordManager {

    public static String criptografar(String senha){
        return BcryptUtil.bcryptHash(senha);
    }

    public static boolean verificarSeSenhaEIgual(String senhaOriginal, String senhaCriptografada){
        return BcryptUtil.matches(senhaOriginal,senhaCriptografada);
    }

    public static boolean isValidPassword(String senha){
        String regex = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{4,10}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(senha);
        return matcher.matches();
    }
}
