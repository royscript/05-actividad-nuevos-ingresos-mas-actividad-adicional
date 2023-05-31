export class Concepto {
    codConcepto?: number;
    glsConcepto?: string;
    flgActivo?: number;
    fecCreacion?: Date;
    constructor(obj?: any){
        this.codConcepto = obj && obj.codConcepto || null;
        this.glsConcepto = obj && obj.glsConcepto || null;
        this.flgActivo = obj && obj.flgActivo || null;
        this.fecCreacion = obj && obj.fecCreacion || null;
    }
}
