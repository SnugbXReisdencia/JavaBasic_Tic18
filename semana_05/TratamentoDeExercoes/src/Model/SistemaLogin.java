package Model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ClienteExcercoes.AutenticacaoFalhouException;
import ClienteExcercoes.CredenciaisInvalidasException;
import ClienteExcercoes.UsuarioBloqueadoException;
import ClienteExcercoes.UsuarioErradoException;

public class SistemaLogin {

    private List<Cliente> usuarios;
    private int tentativasAutenticacao;

    public SistemaLogin() {
        this.usuarios = new ArrayList<>();
        this.tentativasAutenticacao = 3;
    }

    public void cadastrarUsuario(String nomeUsuario, String senha) throws CredenciaisInvalidasException {
        if (nomeUsuario.isEmpty()) {
            throw new CredenciaisInvalidasException();
        } else if (senha.length() < 6) {
            throw new CredenciaisInvalidasException();
        } else {
            this.usuarios.add(new Cliente(nomeUsuario,new Date(), senha));
        }
    }

    public void login(String nomeUsuario, String senha) throws UsuarioErradoException, AutenticacaoFalhouException, UsuarioBloqueadoException {
        if (nomeUsuario.isEmpty()) {
            throw new UsuarioErradoException();
        }

        Cliente usuario = this.usuarios.stream().filter(u -> u.getNome().equals(nomeUsuario)).findFirst().orElse(null);
        if (usuario == null) {
            throw new UsuarioErradoException();
        } else if (senha.length() < 6) {
            throw new AutenticacaoFalhouException();
        } else if (!usuario.getSenha().equals(senha)) {
            this.tentativasAutenticacao++;
            if (this.tentativasAutenticacao >= 3) {
                usuario.setBloqueado(true);
                throw new UsuarioBloqueadoException();
            } else {
                throw new AutenticacaoFalhouException("A senha não está correta.");
            }
        } else {
            this.tentativasAutenticacao = 0;
        }
    }
}

