package br.com.labexame.domain.id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class PrestadorPK implements Serializable {

	private static final long serialVersionUID = -8538617199531275156L;

	@Column(name = "id_oper")
	private Long codigoOperadora;

	@Column(name = "nr_cnpj_cpf")
	private String cnpjCpf;

	public PrestadorPK() {

	}

	public PrestadorPK(Long codigoOperadora, String cnpjCpf) {
		this.codigoOperadora = codigoOperadora;
		this.cnpjCpf = cnpjCpf;
	}

	/**
	 * @return the codigoOperadora
	 */
	public Long getCodigoOperadora() {
		return codigoOperadora;
	}

	/**
	 * @param codigoOperadora the codigoOperadora to set
	 */
	public void setCodigoOperadora(Long codigoOperadora) {
		this.codigoOperadora = codigoOperadora;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PrestadorPK [codigoOperadora=" + codigoOperadora + ", cnpjCpf=" + cnpjCpf + "]";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cnpjCpf == null) ? 0 : cnpjCpf.hashCode());
		result = prime * result + ((codigoOperadora == null) ? 0 : codigoOperadora.hashCode());
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
		PrestadorPK other = (PrestadorPK) obj;
		if (cnpjCpf == null) {
			if (other.cnpjCpf != null)
				return false;
		} else if (!cnpjCpf.equals(other.cnpjCpf))
			return false;
		if (codigoOperadora == null) {
			if (other.codigoOperadora != null)
				return false;
		} else if (!codigoOperadora.equals(other.codigoOperadora))
			return false;
		return true;
	}
}