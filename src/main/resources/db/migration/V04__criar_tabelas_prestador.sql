CREATE TABLE tb_uaa_user (
    id_user   BIGINT(10) NOT NULL,
    nm_user   VARCHAR(100) NOT NULL,
    ds_logi   VARCHAR(50) NOT NULL,
    fl_atvo   CHAR(1) NOT NULL,
    dt_alte   DATETIME NOT NULL
);

ALTER TABLE tb_uaa_user ADD CONSTRAINT pk_user PRIMARY KEY ( id_user );

CREATE TABLE tb_prst (
    id_oper        BIGINT(10) NOT NULL,
    nr_cnpj_cpf    VARCHAR(14) NOT NULL,
    ds_razo_soci   VARCHAR(100) NOT NULL,
    ds_nota_ctto   VARCHAR(4000),
    dt_alte        DATETIME NOT NULL,
    id_user        BIGINT(10) NOT NULL
);

ALTER TABLE tb_prst ADD CONSTRAINT pk_prst PRIMARY KEY (id_oper, nr_cnpj_cpf);

ALTER TABLE tb_prst ADD CONSTRAINT fk_prst_user FOREIGN KEY (id_user) REFERENCES tb_uaa_user ( id_user );

CREATE TABLE tb_pnto_atnd (
    id_oper        BIGINT(20) NOT NULL,
    nr_cnpj_cpf    VARCHAR(14) NOT NULL,
    id_pnto_atnd   BIGINT(10) NOT NULL,
    nm_fant        VARCHAR(100) NOT NULL,
    ds_ende        VARCHAR(500) NOT NULL,
    nm_cida        VARCHAR(60) NOT NULL,
    sg_uf          VARCHAR(2) NOT NULL,
    vl_geol_lati   DECIMAL(20, 7),
    vl_geol_long   DECIMAL(20, 7),
    nr_tele_prnc   VARCHAR(30) NOT NULL,
    nr_tele_secd   VARCHAR(15),
    dt_alte        DATETIME NOT NULL,
    id_user        BIGINT(10) NOT NULL
);

ALTER TABLE tb_pnto_atnd ADD CONSTRAINT pk_pnto_atnd PRIMARY KEY (id_oper, nr_cnpj_cpf, id_pnto_atnd);

ALTER TABLE tb_pnto_atnd ADD CONSTRAINT fk_pnto_atnd_prst FOREIGN KEY (id_oper, nr_cnpj_cpf) REFERENCES tb_prst (id_oper, nr_cnpj_cpf);

ALTER TABLE tb_pnto_atnd ADD CONSTRAINT fk_pnto_atnd_user FOREIGN KEY (id_user) REFERENCES tb_uaa_user (id_user);