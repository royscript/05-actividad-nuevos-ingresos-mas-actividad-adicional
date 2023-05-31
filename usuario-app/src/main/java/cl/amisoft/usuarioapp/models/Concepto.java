package cl.amisoft.usuarioapp.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "TG_Concepto", schema = "Actividad")
public class Concepto {
    @Id
    @Column(name = "COD_Concepto")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codConcepto; // Cambiar a tipo Long en lugar de long
    @Column(name = "GLS_Concepto")
    private String glsConcepto;
    @Column(name = "FLG_ACTIVO")
    private Integer flgActivo;
    @Column(name = "FEC_CREACION")
    private Date fecCreacion;

    public Long getCodConcepto() { // Cambiar a tipo Long en lugar de long
        return codConcepto;
    }

    public void setCodConcepto(Long codConcepto) { // Cambiar a tipo Long en lugar de long
        this.codConcepto = codConcepto;
    }

    public String getGlsConcepto() {
        return glsConcepto;
    }

    public void setGlsConcepto(String glsConcepto) {
        this.glsConcepto = glsConcepto;
    }

    public Integer getFlgActivo() {
        return flgActivo;
    }

    public void setFlgActivo(Integer flgActivo) {
        this.flgActivo = flgActivo;
    }

    public Date getFecCreacion() {
        return fecCreacion;
    }

    public void setFecCreacion(Date fecCreacion) {
        this.fecCreacion = fecCreacion;
    }

    public Concepto() {
    }

    public Concepto(Builder builder) {
        this.codConcepto = builder.codConcepto;
        this.glsConcepto = builder.glsConcepto;
        this.flgActivo = builder.flgActivo;
        this.fecCreacion = builder.fecCreacion;
    }

    public static class Builder {
        private Long codConcepto; // Cambiar a tipo Long en lugar de long
        private String glsConcepto;
        private Integer flgActivo;
        private Date fecCreacion;

        public Builder codConcepto(Long codConcepto) {
            this.codConcepto = codConcepto;
            return this;
        }

        public Builder glsConcepto(String glsConcepto) {
            this.glsConcepto = glsConcepto;
            return this;
        }

        public Builder flgActivo(Integer flgActivo) {
            this.flgActivo = flgActivo;
            return this;
        }

        public Builder fecCreacion(Date fecCreacion) {
            this.fecCreacion = fecCreacion;
            return this;
        }

        public Concepto build() {
            return new Concepto(this);
        }
    }
}
