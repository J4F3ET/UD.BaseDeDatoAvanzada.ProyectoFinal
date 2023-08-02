package UD.BaseDeDatosAvanzada.ProyectoFinal.Model.DTO;

import java.util.Objects;

public class LoginDTO {
    private String alias;
    private String password;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LoginDTO loginDTO = (LoginDTO) o;
        return Objects.equals(alias, loginDTO.alias) && Objects.equals(password, loginDTO.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(alias, password);
    }

    public String getAlias() {
        return alias;
    }

    @Override
    public String toString() {
        return "LoginDTO{" +
                "alias='" + alias + '\'' +
                ", contrasena='" + password + '\'' +
                '}';
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LoginDTO(String alias, String contrasena) {
        this.alias = alias;
        this.password = contrasena;
    }

    public LoginDTO() {
    }
}
