CREATE TABLE TB_LABORATORIO (
	ID BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	NOME VARCHAR(150) NOT NULL,
	STATUS VARCHAR(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE TB_ENDERECO (
	ID BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	LOGRADOURO VARCHAR(150) NOT NULL,
	NUMERO VARCHAR(5) NOT NULL,
	CEP VARCHAR(20) NOT NULL,
	BAIRRO VARCHAR(100) NOT NULL,
	CIDADE VARCHAR(100) NOT NULL,
	UF CHAR(2) NOT NULL,
	DDD CHAR(2) NOT NULL,
	TELEFONE VARCHAR(20) NOT NULL,
	ID_LABORATORIO BIGINT(20) NOT NULL,
	FOREIGN KEY (ID_LABORATORIO) REFERENCES TB_LABORATORIO(ID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE TB_EXAME (
	ID BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	NOME VARCHAR(150) NOT NULL,
	TIPO VARCHAR(20) NOT NULL,
	STATUS VARCHAR(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE TB_EXAME_LABORATORIO (
	ID_EXAME BIGINT(20) NOT NULL,
	ID_LABORATORIO BIGINT(20) NOT NULL,
	PRIMARY KEY (ID_EXAME, ID_LABORATORIO),
	FOREIGN KEY (ID_EXAME) REFERENCES TB_EXAME(ID),
	FOREIGN KEY (ID_LABORATORIO) REFERENCES TB_LABORATORIO(ID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
