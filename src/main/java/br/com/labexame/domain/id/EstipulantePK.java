package br.com.labexame.domain.id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class EstipulantePK implements Serializable {

	private static final long serialVersionUID = 1699017629200057194L;

	@Column(name = "id_oper")
	private Long codigoOperadora;

    @Column(name = "id_estp")
	private Long codigoEstipulante;

	public EstipulantePK() {

	}

	public EstipulantePK(Long codigoOperadora, Long codigoEstipulante) {
		this.codigoOperadora = codigoOperadora;
		this.codigoEstipulante = codigoEstipulante;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigoEstipulante == null) ? 0 : codigoEstipulante.hashCode());
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
		EstipulantePK other = (EstipulantePK) obj;
		if (codigoEstipulante == null) {
			if (other.codigoEstipulante != null)
				return false;
		} else if (!codigoEstipulante.equals(other.codigoEstipulante))
			return false;
		if (codigoOperadora == null) {
			if (other.codigoOperadora != null)
				return false;
		} else if (!codigoOperadora.equals(other.codigoOperadora))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "EstipulantePK [codigoOperadora=" + codigoOperadora + ", codigoEstipulante=" + codigoEstipulante + "]";
	}
}
