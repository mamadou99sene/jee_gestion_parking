package bdbeans;
// Generated 2 nov. 2022, 16:22:46 by Hibernate Tools 4.3.6.Final

/**
 * GerantId generated by hbm2java
 */
public class GerantId implements java.io.Serializable {

	private int idpersonne;
	private int idgerant;

	public GerantId() {
	}

	public GerantId(int idpersonne, int idgerant) {
		this.idpersonne = idpersonne;
		this.idgerant = idgerant;
	}

	public int getIdpersonne() {
		return this.idpersonne;
	}

	public void setIdpersonne(int idpersonne) {
		this.idpersonne = idpersonne;
	}

	public int getIdgerant() {
		return this.idgerant;
	}

	public void setIdgerant(int idgerant) {
		this.idgerant = idgerant;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof GerantId))
			return false;
		GerantId castOther = (GerantId) other;

		return (this.getIdpersonne() == castOther.getIdpersonne()) && (this.getIdgerant() == castOther.getIdgerant());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getIdpersonne();
		result = 37 * result + this.getIdgerant();
		return result;
	}

}
