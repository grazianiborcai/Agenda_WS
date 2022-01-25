package br.com.mind5.business.personBio.info;

import java.time.LocalDateTime;
import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class PerbioInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codPerson;
	public long codSnapshot;	
	public String txtBio;
	public boolean isDeleted;
	public String recordMode;
	public LocalDateTime lastChanged;
	public long lastChangedBy;
	public LocalDateTime createdOn;
	public long createdBy;
	public String username;
	
	
	public PerbioInfo() {
		super();
		
		codOwner = DefaultValue.number();
		codPerson = DefaultValue.number();
		codSnapshot = DefaultValue.number();
		isDeleted = DefaultValue.boole();
		recordMode = DefaultValue.recordMode();	
		lastChangedBy = DefaultValue.number();
		createdBy = DefaultValue.number();
	}
	
	
	
	public static PerbioInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, PerbioInfo.class);
	}
	
	
	
	public static List<PerbioInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, PerbioInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner  ^ (codOwner	 >>> 32));
		result = result * 31 + (int) (codPerson ^ (codPerson >>> 32));
		
		if (codLanguage != null)
			result = result * 31 + codLanguage.hashCode();
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof PerbioInfo))
			return false;
		
		
		PerbioInfo obj = (PerbioInfo) o;		
		return (codOwner  == obj.codOwner 	&& 
				codPerson == obj.codPerson	&&
				super.isStringEqual(codLanguage, obj.codLanguage));
	}
}
