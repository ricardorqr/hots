package br.com.hots.modelo.seguranca;

// Generated 26/08/2015 10:41:16 by Hibernate Tools 4.3.1

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import org.hibernate.envers.Audited;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Transacao generated by hbm2java
 */
@Cacheable
@Entity
@Audited
@Table(name = "transacao", catalog = "hots", uniqueConstraints = @UniqueConstraint(columnNames = "deTransacao"))
public class Transacao implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer idTransacao;
	private String deTransacao;
	private String pagina;
	private String observacao;
	private Date dataCadastro;
	private String flagAtivo;
	private Set<Perfiltransacao> perfiltransacaos = new HashSet<Perfiltransacao>(0);

	public Transacao() {
	}

	public Transacao(Integer idTransacao, String deTransacao, String pagina, Date dataCadastro,
			String flagAtivo) {
		this.idTransacao = idTransacao;
		this.deTransacao = deTransacao;
		this.pagina = pagina;
		this.dataCadastro = dataCadastro;
		this.flagAtivo = flagAtivo;
	}

	public Transacao(Integer idTransacao, String deTransacao, String pagina, String observacao,
			Date dataCadastro, String flagAtivo,
			Set<Perfiltransacao> perfiltransacaos) {
		this.idTransacao = idTransacao;
		this.deTransacao = deTransacao;
		this.pagina = pagina;
		this.observacao = observacao;
		this.dataCadastro = dataCadastro;
		this.flagAtivo = flagAtivo;
		this.perfiltransacaos = perfiltransacaos;
	}
	
	@PrePersist
	public void atualizaCamposParaInsercao() {
		setDataCadastro(Calendar.getInstance().getTime());
		setFlagAtivo("S");
	}

	@PreUpdate
	public void atualizaCamposParaAtualizacao() {
		setDataCadastro(Calendar.getInstance().getTime());
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idTransacao", unique = true, nullable = false)
	public Integer getIdTransacao() {
		return this.idTransacao;
	}

	public void setIdTransacao(Integer idTransacao) {
		this.idTransacao = idTransacao;
	}

	@NotEmpty(message = "O campo transa��o � obrigat�rio")
	@Column(name = "deTransacao", unique = true, nullable = false, length = 100)
	public String getDeTransacao() {
		return this.deTransacao;
	}

	public void setDeTransacao(String deTransacao) {
		this.deTransacao = deTransacao;
	}

	@NotEmpty(message = "O campo pagina � obrigat�rio")
	@Column(name = "pagina", nullable = false, length = 200)
	public String getPagina() {
		return this.pagina;
	}

	public void setPagina(String pagina) {
		this.pagina = pagina;
	}

	@Column(name = "observacao", length = 500)
	public String getObservacao() {
		return this.observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dataCadastro", nullable = false, length = 19)
	public Date getDataCadastro() {
		return this.dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	@Column(name = "flagAtivo", nullable = false, length = 1)
	public String getFlagAtivo() {
		return this.flagAtivo;
	}

	public void setFlagAtivo(String flagAtivo) {
		this.flagAtivo = flagAtivo;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "transacao")
	public Set<Perfiltransacao> getPerfiltransacaos() {
		return this.perfiltransacaos;
	}

	public void setPerfiltransacaos(Set<Perfiltransacao> perfiltransacaos) {
		this.perfiltransacaos = perfiltransacaos;
	}

}
