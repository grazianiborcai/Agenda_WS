package br.com.mind5.business.personBioSnapshot.info;

import java.time.LocalDateTime;
import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class PerbionapInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codPerson;
	public long codSnapshot;	
	public String txtBio;
	public String recordMode;
	public LocalDateTime lastChanged;
	public long lastChangedBy;
	public LocalDateTime createdOn;
	public long createdBy;
	public String username;
	
	public PerbionapInfo() {
		super();
		
		codOwner = DefaultValue.number();
		codPerson = DefaultValue.number();
		codSnapshot = DefaultValue.number();
		recordMode = DefaultValue.recordMode();	
		lastChangedBy = DefaultValue.number();
		createdBy = DefaultValue.number();
	}
	
	
	
	public static PerbionapInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, PerbionapInfo.class);
	}
	
	
	
	public static List<PerbionapInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, PerbionapInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner    ^ (codOwner	 >>> 32));
		result = result * 31 + (int) (codPerson   ^ (codPerson   >>> 32));
		result = result * 31 + (int) (codSnapshot ^ (codSnapshot >>> 32));
		
		if (codLanguage != null)
			result = result * 31 + codLanguage.hashCode();
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof PerbionapInfo))
			return false;
		
		
		PerbionapInfo obj = (PerbionapInfo) o;		
		return (codOwner    == obj.codOwner 	&& 
				codPerson   == obj.codPerson	&&
				codSnapshot == obj.codSnapshot	&&
				super.isStringEqual(codLanguage, obj.codLanguage));
	}
}
