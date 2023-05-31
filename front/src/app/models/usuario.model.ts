import { Concepto } from "./concepto.model";

export class Usuario {
    ccrUsuario?: number;
    codUsuarioCrea?: number;
    codUsuarioMod?: number;
    glsFuncionarioCrea?: string;
    glsFuncionarioMod?: string;
    fecCrea?: Date;
    fecMod?: Date;
    glsUsername?: string;
    glsConcepto?: string;
    fecConcepto?: Date;
    codConcepto?: number;
    rut?: number;
    rutDiv?: string;
    concepto?: Concepto;
    constructor(obj?: any) {
        this.ccrUsuario = obj && obj.ccrUsuario || null;
        this.codUsuarioCrea = obj && obj.codUsuarioCrea || null;
        this.codUsuarioMod = obj && obj.codUsuarioMod || null;
        this.glsFuncionarioCrea = obj && obj.glsFuncionarioCrea || null;
        this.glsFuncionarioMod = obj && obj.glsFuncionarioMod || null;
        this.fecCrea = obj && obj.fecCrea || null;
        this.fecMod = obj && obj.fecMod || null;
        this.glsUsername = obj && obj.glsUsername || null;
        this.glsConcepto = obj && obj.glsConcepto || null;
        this.fecConcepto = obj && obj.fecConcepto || null;
        this.codConcepto = obj && obj.codConcepto || null;
        this.rut = obj && obj.rut || null;
        this.rutDiv = obj && obj.rutDiv || null;
        this.concepto = obj && obj.concepto || null;
    }
}
