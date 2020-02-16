package br.com.labexame.service.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class PrestadorDTO implements Serializable {

	private static final long serialVersionUID = 2271940674325357599L;

	private OperadoraDTO operadora;

	private String cnpjCpf;

	private String razaoSocial;

	private String descricao;

	@JsonIgnore
	private LocalDateTime dataAlteracao;

	@JsonIgnore
	private UsuarioDTO usuario;

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
	 * @return the cnpjCpf
	 */
	public String getCnpjCpf() {
		return cnpjCpf;
	}

	/**
	 * @param cnpjCpf the cnpjCpf to set
	 */
	public void setCnpjCpf(String cnpjCpf) {
		this.cnpjCpf = cnpjCpf;
	}

	/**
	 * @return the razaoSocial
	 */
	public String getRazaoSocial() {
		return razaoSocial;
	}

	/**
	 * @param razaoSocial the razaoSocial to set
	 */
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	/**
	 * @return the descricao
	 */
	public String getDescricao() {
		return descricao;
	}

	/**
	 * @param descricao the descricao to set
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
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

	/**
	 * @return the usuario
	 */
	public UsuarioDTO getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(UsuarioDTO usuario) {
		this.usuario = usuario;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cnpjCpf == null) ? 0 : cnpjCpf.hashCode());
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
		PrestadorDTO other = (PrestadorDTO) obj;
		if (cnpjCpf == null) {
			if (other.cnpjCpf != null)
				return false;
		} else if (!cnpjCpf.equals(other.cnpjCpf))
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
		return "PrestadorDTO [operadora=" + operadora + ", cnpjCpf=" + cnpjCpf + ", razaoSocial=" + razaoSocial
				+ ", descricao=" + descricao + ", dataAlteracao=" + dataAlteracao + ", usuario=" + usuario + "]";
	}
}
