# 05-actividad-nuevos-ingresos-mas-actividad-adicional
<br/>
Video
https://drive.google.com/file/d/1BVlp841CkdGHt5CAyh9EaRRnLcxmdsoE/view?usp=sharing
<br/>
ESQUEMA SQL
<br/>

```sql

PS C:\WINDOWS\system32> psql -U postgres -p 5433
password : utf0808
CREATE DATABASE actividad;
\c actividad;

CREATE SCHEMA IF NOT EXISTS Actividad;

SET search_path TO Actividad;

CREATE TABLE Actividad.TO_USUARIOS (
  CRR_USUARIO         NUMERIC(11) NOT NULL,
  COD_USUARIO_CREA    NUMERIC(11) NOT NULL,
  COD_USUARIO_MOD     NUMERIC(11) NOT NULL,
  GLS_FUNCIONARIO_CREA VARCHAR(50) NOT NULL,
  GLS_FUNCIONARIO_MOD VARCHAR(50) NOT NULL,
  FEC_CREA            DATE NOT NULL,
  FEC_MOD             DATE NOT NULL,
  GLS_USERNAME        VARCHAR(30),
  GLS_CONCEPTO        VARCHAR(50),
  FEC_CONCEPTO        DATE,
  COD_CONCEPTO        NUMERIC,
  RUT                 NUMERIC(10),
  RUT_DV              CHAR(1),
  -- Agregar aquí más columnas adicionales según sea necesario

  CONSTRAINT PK_TO_USUARIOS PRIMARY KEY (CRR_USUARIO),
  CONSTRAINT UK_TO_USUARIOS UNIQUE (CRR_USUARIO)
);
-- Mostrar todas las tablas
SELECT table_name
FROM information_schema.tables
WHERE table_schema = 'public'
AND table_type = 'BASE TABLE';

-- Agregar PK a tabla usuarios
ALTER TABLE Actividad.TO_USUARIOS
ALTER COLUMN CRR_USUARIO SET DATA TYPE INTEGER;

ALTER TABLE TO_USUARIOS ALTER COLUMN CRR_USUARIO ADD GENERATED ALWAYS AS IDENTITY;

--Actividad 02

CREATE TABLE TG_Concepto (
    COD_Concepto NUMERIC(5) PRIMARY KEY,
    GLS_Concepto VARCHAR(255),
    FLG_ACTIVO NUMERIC(1),
    FEC_CREACION DATE
);

-- Agregar la columna COD_TG_CONCEPTO en la tabla TO_USUARIOS
ALTER TABLE Actividad.TO_USUARIOS
ADD COLUMN COD_TG_CONCEPTO NUMERIC(5);


-- Agregar la restricción FOREIGN KEY para establecer la relación
ALTER TABLE Actividad.TO_USUARIOS
ADD CONSTRAINT FK_TO_USUARIOS_TG_CONCEPTO
FOREIGN KEY (COD_TG_CONCEPTO) REFERENCES TG_Concepto (COD_Concepto);


--AGREGAR REGISTROS A TABLA TG_CONCEPTO
-- Insertar el concepto Administrador
INSERT INTO TG_Concepto (COD_Concepto, GLS_Concepto, FLG_ACTIVO, FEC_CREACION)
VALUES (1, 'Administrador', 1, CURRENT_DATE);

-- Insertar el concepto Vendedor
INSERT INTO TG_Concepto (COD_Concepto, GLS_Concepto, FLG_ACTIVO, FEC_CREACION)
VALUES (2, 'Vendedor', 1, CURRENT_DATE);

-- Insertar el concepto Cliente
INSERT INTO TG_Concepto (COD_Concepto, GLS_Concepto, FLG_ACTIVO, FEC_CREACION)
VALUES (3, 'Cliente', 1, CURRENT_DATE);

-- Insertar el concepto Proveedor
INSERT INTO TG_Concepto (COD_Concepto, GLS_Concepto, FLG_ACTIVO, FEC_CREACION)
VALUES (4, 'Proveedor', 1, CURRENT_DATE);



--Estrategia para llenar tabla usuarios
INSERT INTO Actividad.TO_USUARIOS (
  COD_USUARIO_CREA,
  COD_USUARIO_MOD,
  GLS_FUNCIONARIO_CREA,
  GLS_FUNCIONARIO_MOD,
  FEC_CREA,
  FEC_MOD,
  GLS_USERNAME,
  GLS_CONCEPTO,
  FEC_CONCEPTO,
  COD_CONCEPTO,
  RUT,
  RUT_DV
)
VALUES (
  floor(random() * 99999999999) + 1,  -- COD_USUARIO_CREA
  floor(random() * 99999999999) + 1,  -- COD_USUARIO_MOD
  'FuncionarioCrea ' || floor(random() * 100),  -- GLS_FUNCIONARIO_CREA (genera una cadena con 'FuncionarioCrea ' seguido de un número aleatorio entre 0 y 99)
  'FuncionarioMod ' || floor(random() * 100),  -- GLS_FUNCIONARIO_MOD
  current_date,  -- FEC_CREA (fecha actual)
  current_date,  -- FEC_MOD
  'Username ' || floor(random() * 100),  -- GLS_USERNAME
  'Concepto ' || floor(random() * 100),  -- GLS_CONCEPTO
  current_date,  -- FEC_CONCEPTO
  floor(random() * 999999),  -- COD_CONCEPTO (genera un número aleatorio entre 0 y 999999)
  floor(random() * 9999999999) + 1,  -- RUT (genera un número aleatorio entre 1 y 9999999999)
  chr(65 + floor(random() * 26)::integer)  -- RUT_DV (genera una letra mayúscula aleatoria)
);



```
