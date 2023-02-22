package com.stefanini.service;

import com.stefanini.models.Usuario;
import com.stefanini.repository.UsuarioRepository;
import com.stefanini.util.PasswordManager;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@ApplicationScoped
public class UsuarioService {

    @Inject
    private UsuarioRepository usuarioRepository;

    public List<Usuario> listar(){
        return usuarioRepository.listAll();
    }

    public List<Usuario> anivesariantesDoMes (){
        return usuarioRepository.findBirthdaysOfTheMonth(LocalDate.now().getMonth());
    }

    @Transactional
    public Usuario salvar(Usuario usuario) throws Exception {
        Usuario usuarioRecuperado = usuarioRepository.findByLogin(usuario.getLogin());
        if(usuarioRecuperado != null){
            throw new Exception(String.format("Login %s ja existente", usuario.getLogin()));
        }
        if(!PasswordManager.isValidPassword(usuario.getSenha())){
            throw new Exception(String.format("Senha %s nao e valida", usuario.getSenha()));
        }
        usuario.setSenha(PasswordManager.criptografar(usuario.getSenha()));
        usuario.setDataCriacao(LocalDateTime.now());
        return usuarioRepository.save(usuario);
    }
    @Transactional
    public void deletar(Long id){
        usuarioRepository.delete(id);
    }

    @Transactional
    public Usuario atualizar(Long id, Usuario usuario){
        Usuario usuarioSalvo = usuarioRepository.findById(id);
        usuarioSalvo.setEmail(usuario.getEmail());
        usuarioSalvo.setSenha(usuario.getSenha());
        usuarioSalvo.setLogin(usuario.getLogin());
        usuarioSalvo.setDataNascimento(usuario.getDataNascimento());
        usuarioSalvo.setNome(usuario.getNome());
        usuarioSalvo.setDataUltimaAtualizacao(LocalDateTime.now());
        return usuarioRepository.save(usuarioSalvo);
    }
}