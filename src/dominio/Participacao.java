package dominio;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tb_participacoes")
public class Participacao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codParticipacao;
	private Integer ordem;
	
	@ManyToOne
	@JoinColumn(name="banda")
	private Banda banda;
	
	@ManyToOne
	@JoinColumn(name="espetaculo")
	private Espetaculo espetaculo;
		
	public Participacao() {	
	}
	

	public Participacao(Integer codParticipacao, Integer ordem, Banda banda, Espetaculo espetaculo) {
		super();
		this.codParticipacao = codParticipacao;
		this.ordem = ordem;
		this.banda = banda;
		this.espetaculo = espetaculo;
	}


	public Banda getBanda() {
		return banda;
	}


	public void setBanda(Banda banda) {
		this.banda = banda;
	}


	public Espetaculo getEspetaculo() {
		return espetaculo;
	}


	public void setEspetaculo(Espetaculo espetaculo) {
		this.espetaculo = espetaculo;
	}


	public Integer getCodParticipacao() {
		return codParticipacao;
	}

	public void setCodParticipacao(Integer codParticipacao) {
		this.codParticipacao = codParticipacao;
	}

	public Integer getOrdem() {
		return ordem;
	}

	public void setOrdem(Integer ordem) {
		this.ordem = ordem;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ordem == null) ? 0 : ordem.hashCode());
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
		Participacao other = (Participacao) obj;
		if (ordem == null) {
			if (other.ordem != null)
				return false;
		} else if (!ordem.equals(other.ordem))
			return false;
		return true;
	}

	
	@Override
	public String toString() {
		return "Participacao [codParticipacao=" + codParticipacao + ", ordem=" + ordem + "]";
	}
	
}