package UD.BaseDeDatosAvanzada.ProyectoFinal.Model.DTO;

import java.util.Objects;

public class ResponsableUsuarioDTO {
    private String nombre;
    private long identificacion;
    private short categoria;
    private String correo ;
    private String password;
    private String alias ;
    private String direccion;
    private long telefonoCelular;

    @Override
    public String toString() {
        return "ResponsableUsuarioDTO{" +
                "nombre='" + nombre + '\'' +
                ", identificacion=" + identificacion +
                ", categoria=" + categoria +
                ", correo='" + correo + '\'' +
                ", password='" + password + '\'' +
                ", alias='" + alias + '\'' +
                ", direccion='" + direccion + '\'' +
                ", telefonoCelular=" + telefonoCelular +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResponsableUsuarioDTO that = (ResponsableUsuarioDTO) o;
        return identificacion == that.identificacion && categoria == that.categoria && telefonoCelular == that.telefonoCelular && Objects.equals(nombre, that.nombre) && Objects.equals(correo, that.correo) && Objects.equals(password, that.password) && Objects.equals(alias, that.alias) && Objects.equals(direccion, that.direccion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, identificacion, categoria, correo, password, alias, direccion, telefonoCelular);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public long getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(long identificacion) {
        this.identificacion = identificacion;
    }

    public short getCategoria() {
        return categoria;
    }

    public void setCategoria(short categoria) {
        this.categoria = categoria;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public long getTelefonoCelular() {
        return telefonoCelular;
    }

    public void setTelefonoCelular(long telefonoCelular) {
        this.telefonoCelular = telefonoCelular;
    }
}
