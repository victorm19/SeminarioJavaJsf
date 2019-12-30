package controller;

import business.UsuarioDao;
import entities.Usuario;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Victor Martinez, Nicolas Aldana
 * @version 1.0
 */
@ManagedBean(name = "userController")
@SessionScoped
public class UsuarioController {

    private String nameUser;
    private String password;
    private String login;

    public String ValidateLogin() {
        UsuarioDao userDao = new UsuarioDao();
        Usuario userEntity = userDao.ValidateUser(login, password);
        if (userEntity != null) {
            nameUser = userEntity.getName();
            return "login";
        } else {
            return "index";
        }
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
