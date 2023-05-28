package UD.BaseDeDatosAvanzada.ProyectoFinal.Model.DTO;

public class AgenciaUsuarioDTO {


    private String nombre_agencia;
    private String rnt_agencia;
    private String municipio;
    private String correo_electronico;
    private String password ;
    private String alias ;
    private String direccion;
    private String telefono;

    public AgenciaUsuarioDTO() {
    }

    public String getNombre_agencia() {
        return nombre_agencia;
    }

    public void setNombre_agencia(String nombre_agencia) {
        this.nombre_agencia = nombre_agencia;
    }

    public String getRnt_agencia() {
        return rnt_agencia;
    }

    public void setRnt_agencia(String rnt_agencia) {
        this.rnt_agencia = rnt_agencia;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getCorreo_electronico() {
        return correo_electronico;
    }

    public void setCorreo_electronico(String correo_electronico) {
        this.correo_electronico = correo_electronico;
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "AgenciaUsuarioDTO{" +
                "nombreAgencia='" + nombre_agencia + '\'' +
                ", rntAgencia='" + rnt_agencia + '\'' +
                ", municipio='" + municipio + '\'' +
                ", correoElectronico='" + correo_electronico + '\'' +
                ", password='" + password + '\'' +
                ", alias='" + alias + '\'' +
                ", direccion='" + direccion + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }
}
