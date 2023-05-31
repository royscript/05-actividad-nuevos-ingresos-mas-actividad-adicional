package cl.amisoft.usuarioapp.models;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "TO_USUARIOS", schema = "Actividad")
public class Usuarios {
    @Id
    @Column(name = "CRR_USUARIO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ccrUsuario;
    @Column(name = "COD_USUARIO_CREA")
    private long codUsuarioCrea;
    @Column(name = "COD_USUARIO_MOD")
    private long codUsuarioMod;
    @Column(name = "GLS_FUNCIONARIO_CREA")
    private String glsFuncionarioCrea;
    @Column(name = "GLS_FUNCIONARIO_MOD")
    private String glsFuncionarioMod;
    @Column(name = "FEC_CREA")
    private LocalDate fecCrea;
    @Column(name = "FEC_MOD")
    private LocalDate fecMod;
    @Column(name = "GLS_USERNAME")
    private String glsUsername;
    @Column(name = "GLS_CONCEPTO")
    private String glsConcepto;
    @Column(name = "FEC_CONCEPTO")
    private LocalDate fecConcepto;
    @Column(name = "COD_CONCEPTO")
    private Long codConcepto;
    @Column(name = "RUT")
    private Long rut;
    @Column(name = "RUT_DV")
    private String rutDiv;

    // Relación de clave externa con la tabla TG_CONCEPTO
    @ManyToOne
    @JoinColumn(name = "COD_TG_CONCEPTO", referencedColumnName = "COD_CONCEPTO")
    private Concepto concepto;

    public long getCcrUsuario() {
        return ccrUsuario;
    }

    public void setCcrUsuario(long ccrUsuario) {
        this.ccrUsuario = ccrUsuario;
    }

    public long getCodUsuarioCrea() {
        return codUsuarioCrea;
    }

    public void setCodUsuarioCrea(long codUsuarioCrea) {
        this.codUsuarioCrea = codUsuarioCrea;
    }

    public long getCodUsuarioMod() {
        return codUsuarioMod;
    }

    public void setCodUsuarioMod(long codUsuarioMod) {
        this.codUsuarioMod = codUsuarioMod;
    }

    public String getGlsFuncionarioCrea() {
        return glsFuncionarioCrea;
    }

    public void setGlsFuncionarioCrea(String glsFuncionarioCrea) {
        this.glsFuncionarioCrea = glsFuncionarioCrea;
    }

    public String getGlsFuncionarioMod() {
        return glsFuncionarioMod;
    }

    public void setGlsFuncionarioMod(String glsFuncionarioMod) {
        this.glsFuncionarioMod = glsFuncionarioMod;
    }

    public LocalDate getFecCrea() {
        return fecCrea;
    }

    public void setFecCrea(LocalDate fecCrea) {
        this.fecCrea = fecCrea;
    }

    public LocalDate getFecMod() {
        return fecMod;
    }

    public void setFecMod(LocalDate fecMod) {
        this.fecMod = fecMod;
    }

    public String getGlsUsername() {
        return glsUsername;
    }

    public void setGlsUsername(String glsUsername) {
        this.glsUsername = glsUsername;
    }

    public String getGlsConcepto() {
        return glsConcepto;
    }

    public void setGlsConcepto(String glsConcepto) {
        this.glsConcepto = glsConcepto;
    }

    public LocalDate getFecConcepto() {
        return fecConcepto;
    }

    public void setFecConcepto(LocalDate fecConcepto) {
        this.fecConcepto = fecConcepto;
    }

    public Long getCodConcepto() {
        return codConcepto;
    }

    public void setCodConcepto(Long codConcepto) {
        this.codConcepto = codConcepto;
    }

    public Long getRut() {
        return rut;
    }

    public void setRut(Long rut) {
        this.rut = rut;
    }

    public String getRutDiv() {
        return rutDiv;
    }

    public void setRutDiv(String rutDiv) {
        this.rutDiv = rutDiv;
    }

    public Concepto getConcepto() {
        return concepto;
    }

    public void setConcepto(Concepto concepto) {
        this.concepto = concepto;
    }

    public Usuarios() {
    }
    public Usuarios(Builder builder){
        this.ccrUsuario = builder.ccrUsuario;
        this.codUsuarioCrea = builder.codUsuarioCrea;
        this.codUsuarioMod = builder.codUsuarioMod;
        this.glsFuncionarioCrea = builder.glsFuncionarioCrea;
        this.glsFuncionarioMod = builder.glsFuncionarioMod;
        this.fecCrea = builder.fecCrea;
        this.fecMod = builder.fecMod;
        this.glsUsername = builder.glsUsername;
        this.glsConcepto = builder.glsConcepto;
        this.fecConcepto = builder.fecConcepto;
        this.codConcepto = builder.codConcepto;
        this.rut = builder.rut;
        this.rutDiv = builder.rutDiv;
        this.concepto = builder.concepto;
    }

    public static class Builder{
        private long ccrUsuario;
        private long codUsuarioCrea;
        private long codUsuarioMod;
        private String glsFuncionarioCrea;
        private String glsFuncionarioMod;
        private LocalDate fecCrea;
        private LocalDate fecMod;
        private String glsUsername;
        private String glsConcepto;
        private LocalDate fecConcepto;
        private Long codConcepto;
        private Long rut;
        private String rutDiv;
        private Concepto concepto;

        public Builder ccrUsuario(long ccrUsuario) {
            this.ccrUsuario = ccrUsuario;
            return this;
        }

        public Builder codUsuarioCrea(long codUsuarioCrea) {
            this.codUsuarioCrea = codUsuarioCrea;
            return this;
        }

        public Builder codUsuarioMod(long codUsuarioMod) {
            this.codUsuarioMod = codUsuarioMod;
            return this;
        }

        public Builder glsFuncionarioCrea(String glsFuncionarioCrea) {
            this.glsFuncionarioCrea = glsFuncionarioCrea;
            return this;
        }

        public Builder glsFuncionarioMod(String glsFuncionarioMod) {
            this.glsFuncionarioMod = glsFuncionarioMod;
            return this;
        }

        public Builder fecCrea(LocalDate fecCrea) {
            this.fecCrea = fecCrea;
            return this;
        }

        public Builder fecMod(LocalDate fecMod) {
            this.fecMod = fecMod;
            return this;
        }

        public Builder glsUsername(String glsUsername) {
            this.glsUsername = glsUsername;
            return this;
        }

        public Builder glsConcepto(String glsConcepto) {
            this.glsConcepto = glsConcepto;
            return this;
        }

        public Builder fecConcepto(LocalDate fecConcepto) {
            this.fecConcepto = fecConcepto;
            return this;
        }

        public Builder codConcepto(Long codConcepto) {
            this.codConcepto = codConcepto;
            return this;
        }

        public Builder rut(Long rut) {
            this.rut = rut;
            return this;
        }

        public Builder rutDiv(String rutDiv) {
            this.rutDiv = rutDiv;
            return this;
        }

        public Builder concepto(Concepto concepto) {
            this.concepto = concepto;
            return this;
        }

        public Usuarios build(){
            return new Usuarios(this);
        }
    }
}
