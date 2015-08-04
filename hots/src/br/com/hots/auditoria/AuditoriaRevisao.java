package br.com.hots.auditoria;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.envers.RevisionEntity;
import org.hibernate.envers.RevisionNumber;
import org.hibernate.envers.RevisionTimestamp;

@Entity
@Table(name="auditoriaRevisao")
@RevisionEntity(AuditoriaListener.class)
public class AuditoriaRevisao implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@RevisionNumber
	private int idRevisao;
	
	@RevisionTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataRevisao;
	
	private String login;

	public int getIdRevisao() {
		return idRevisao;
	}

	public void setIdRevisao(int idRevisao) {
		this.idRevisao = idRevisao;
	}

	public Date getDataRevisao() {
		return dataRevisao;
	}

	public void setDataRevisao(Date dataRevisao) {
		this.dataRevisao = dataRevisao;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

}