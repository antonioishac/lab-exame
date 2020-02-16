package br.com.labexame.service.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class EstipulanteDTO {

	private OperadoraDTO operadora;

	private Long codigoEstipulante;

    private String nomeEstipulante;

    @JsonIgnore
    private String flagAtivo;

    @JsonIgnore
    private LocalDateTime dataAlteracao;

	/**
	 * @return the operadora
	 */
	public OperadoraDTO getOperadora() {
		return operadora;
	}

	/**
	 * @param operadora the operadora to set
	 */
	public void setOperadora(OperadoraDTO operadora) {
		this.operadora = operadora;
	}

	/**
	 * @return the codigoEstipulante
	 */
	public Long getCodigoEstipulante() {
		return codigoEstipulante;
	}

	/**
	 * @param codigoEstipulante the codigoEstipulante to set
	 */
	public void setCodigoEstipulante(Long codigoEstipulante) {
		this.codigoEstipulante = codigoEstipulante;
	}

	/**
	 * @return the nomeEstipulante
	 */
	public String getNomeEstipulante() {
		return nomeEstipulante;
	}

	/**
	 * @param nomeEstipulante the nomeEstipulante to set
	 */
	public void setNomeEstipulante(String nomeEstipulante) {
		this.nomeEstipulante = nomeEstipulante;
	}

	/**
	 * @return the flagAtivo
	 */
	public String getFlagAtivo() {
		return flagAtivo;
	}

	/**
	 * @param flagAtivo the flagAtivo to set
	 */
	public void setFlagAtivo(String flagAtivo) {
		this.flagAtivo = flagAtivo;
	}

	/**
	 * @return the dataAlteracao
	 */
	public LocalDateTime getDataAlteracao() {
		return dataAlteracao;
	}

	/**
	 * @param dataAlteracao the dataAlteracao to set
	 */
	public void setDataAlteracao(LocalDateTime dataAlteracao) {
		this.dataAlteracao = dataAlteracao;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigoEstipulante == null) ? 0 : codigoEstipulante.hashCode());
		result = prime * result + ((operadora == null) ? 0 : operadora.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EstipulanteDTO other = (EstipulanteDTO) obj;
		if (codigoEstipulante == null) {
			if (other.codigoEstipulante != null)
				return false;
		} else if (!codigoEstipulante.equals(other.codigoEstipulante))
			return false;
		if (operadora == null) {
			if (other.operadora != null)
				return false;
		} else if (!operadora.equals(other.operadora))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "EstipulanteDTO [operadora=" + operadora + ", codigoEstipulante=" + codigoEstipulante
				+ ", nomeEstipulante=" + nomeEstipulante + ", flagAtivo=" + flagAtivo + ", dataAlteracao="
				+ dataAlteracao + "]";
	}
}
