package com.stefanini.service;

import com.stefanini.models.Usuario;
import com.stefanini.repository.UsuarioRepository;
import com.stefanini.util.PasswordManager;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@ApplicationScoped
public class UsuarioService {

    @Inject
    UsuarioRepository usuarioRepository;

    public List<Usuario> listarUsuarios (){
        return usuarioRepository.listAll();
    }
    @Transactional
    public Usuario salvarUsuario (Usuario usuario) throws Exception {
        Usuario usuarioRecuperado = usuarioRepository.findByLogin(usuario.getLogin());
        if(usuarioRecuperado != null){
            throw new Exception(String.format("Login %s ja existente", usuario.getLogin()));
        }
        if(!PasswordManager.isValidPassword(usuario.getSenha())){
            throw new Exception(String.format("Senha %s nao e valida", usuario.getSenha()));
        }
        usuario.setSenha(PasswordManager.criptografar(usuario.getSenha()));
        return usuarioRepository.save(usuario);
    }
    @Transactional
    public void deletarUsuario (Long id){
        usuarioRepository.delete(id);
    }

    @Transactional
    public Usuario atualizarUsuario ( Long id, Usuario usuario){
        Usuario usuarioSalvo = usuarioRepository.findById(id);
        usuarioSalvo.setEmail(usuario.getEmail());
        usuarioSalvo.setSenha(usuario.getSenha());
        usuarioSalvo.setLogin(usuario.getLogin());
        usuarioSalvo.setDataNascimento(usuario.getDataNascimento());
        usuarioSalvo.setNome(usuario.getNome());
        return usuarioRepository.save(usuarioSalvo);
    }
}
