package UD.BaseDeDatosAvanzada.ProyectoFinal.Model;

import jakarta.persistence.*;

@Entity
@Table
public class AgenciaDTO {
    @Id
    @Column
    private long rnt;
    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    private UsuarioDTO usuario;

    @Column
    private String nombre_agencia;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_municipio", referencedColumnName = "id_municipio")
    private MunicipioDTO municipio;
    public AgenciaDTO() {
    }

    public AgenciaDTO(long rnt, long id_usuario) {
        this.rnt = rnt;
    }
    public long getRnt() {
        return rnt;
    }
    public UsuarioDTO getUsuario() {
        return usuario;
    }
    public void setRnt(long rnt) {
        this.rnt = rnt;
    }

}
