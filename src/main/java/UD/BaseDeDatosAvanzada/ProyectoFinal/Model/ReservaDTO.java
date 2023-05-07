package UD.BaseDeDatosAvanzada.ProyectoFinal.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.sql.Date;

@Entity
@Table
public class ReservaDTO {
    @Id
    private long id_reserva;
    @Column
    private Date fecha_inicio;
    @Column
    private Date fecha_final;
    @Column
    private int valor_total_pagar;
    @Column
    private int valor_min_pagar;
    @Column
    private int cant_personas;
    @Column
    private int cant_habitaciones;


}
