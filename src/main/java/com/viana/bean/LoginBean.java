package com.viana.bean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;

@ManagedBean
@SessionScoped
public class LoginBean implements Serializable {
    private String usuario;
    private String senha;

    public String efetuarLogin() {
        if ("admin".equals(usuario) && "123".equals(senha)) {
            // Guarda na sessão para o Filtro de segurança (se houver)
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuarioLogado", usuario);
            // O redirect=true limpa a URL e evita erro de submissão dupla
            return "index?faces-redirect=true";
        } else {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Usuário ou senha inválidos"));
            return null;
        }
    }

    public String getUsuario() {
        return usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}