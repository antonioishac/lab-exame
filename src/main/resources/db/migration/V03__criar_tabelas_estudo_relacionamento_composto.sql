CREATE TABLE tb_opr_oper (
    id_oper        BIGINT(20) NOT NULL,
    nm_oper        VARCHAR(60) NOT NULL,
    nr_cnpj        VARCHAR(14) NOT NULL,
    fl_atvo        CHAR(1) NOT NULL,
    dt_alte        DATETIME NOT NULL
);
ALTER TABLE tb_opr_oper ADD CONSTRAINT pk_oper PRIMARY KEY (id_oper);

CREATE TABLE tb_opr_estp (
    id_oper   BIGINT(10) NOT NULL,
    id_estp   BIGINT(10) NOT NULL,
    nm_estp   VARCHAR(60) NOT NULL,
    fl_atvo   CHAR(1) NOT NULL,
    dt_alte   DATETIME NOT NULL
);
ALTER TABLE tb_opr_estp ADD CONSTRAINT pk_estp PRIMARY KEY (id_oper, id_estp);

CREATE TABLE tb_opr_sest (
    id_oper   BIGINT(10) NOT NULL,
    id_estp   BIGINT(10) NOT NULL,
    id_sest   BIGINT(10) NOT NULL,
    nm_sest   VARCHAR(60) NOT NULL,
    fl_atvo   CHAR(1) NOT NULL,
    dt_alte   DATETIME NOT NULL
);
ALTER TABLE tb_opr_sest ADD CONSTRAINT pk_sest PRIMARY KEY (id_oper, id_estp, id_sest);

ALTER TABLE tb_opr_estp ADD CONSTRAINT fk_estp_oper FOREIGN KEY (id_oper) REFERENCES tb_opr_oper (id_oper);

ALTER TABLE tb_opr_sest ADD CONSTRAINT fk_sest_estp FOREIGN KEY (id_oper, id_estp) REFERENCES tb_opr_estp (id_oper, id_estp);
