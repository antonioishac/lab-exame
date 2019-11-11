package br.com.labexame.domain;

/**
 * @author aishac
 *
 * Enum para representar os tipos poss\u00edveis de exames.
 *
 */
public enum TipoExame {

	ANALISE_CLINICA("Análise Clínica"),
	IMAGEM("Imagem");

	private String descricao;

	TipoExame(String descricao) {
		this.descricao = descricao;
	}

	/**
	 * @return the descricao
	 */
	public String getDescricao() {
		return descricao;
	}

}
