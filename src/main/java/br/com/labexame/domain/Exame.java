package br.com.labexame.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author aishac
 *
 * Entidade que representa a tabela de exames TB_EXAME
 *
 */
@Entity
@Table(name = "TB_EXAME")
public class Exame implements Serializable {

	/**
	 * Serial UID
	 */
	private static final long serialVersionUID = 3193309461517989301L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	@NotBlank(message = "labexame-exa-nam")
	@Column(name = "NOME")
	private String nome;

	@Enumerated(EnumType.STRING)
	@NotNull(message = "labexame-exa-tip")
	@Column(name = "TIPO")
	private TipoExame tipo;

	@NotNull(message = "labexame-exa-sta")
	@Column(name = "STATUS")
	private Status status;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "TB_EXAME_LABORATORIO", joinColumns = @JoinColumn(name = "ID_EXAME")
		, inverseJoinColumns = @JoinColumn(name = "ID_LABORATORIO"))
	private List<Laboratorio> laboratorios;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the tipo
	 */
	public TipoExame getTipo() {
		return tipo;
	}

	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(TipoExame tipo) {
		this.tipo = tipo;
	}

	/**
	 * @return the status
	 */
	public Status getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(Status status) {
		this.status = status;
	}

	/**
	 * @return the laboratorios
	 */
	public List<Laboratorio> getLaboratorios() {
		return laboratorios;
	}

	/**
	 * @param laboratorios the laboratorios to set
	 */
	public void setLaboratorios(List<Laboratorio> laboratorios) {
		this.laboratorios = laboratorios;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Exame other = (Exame) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Exame [id=" + id + ", nome=" + nome + ", tipo=" + tipo + ", status=" + status + ", laboratorios="
				+ laboratorios + "]";
	}

}
