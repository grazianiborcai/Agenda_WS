package br.com.mind5.business.personBioList.info;

import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class PerbiolisInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codPerson;
	public long codSnapshot;
	public String txtBio;
	public String recordMode;
	public String username;
	
	
	public PerbiolisInfo() {
		super();
		
		codOwner = DefaultValue.number();
		codPerson = DefaultValue.number();
		codSnapshot = DefaultValue.number();
		recordMode = DefaultValue.recordMode();	
	}
	
	
	
	public static PerbiolisInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, PerbiolisInfo.class);
	}
	
	
	
	public static List<PerbiolisInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, PerbiolisInfo.class);
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
		
		
		if (!(o instanceof PerbiolisInfo))
			return false;
		
		
		PerbiolisInfo obj = (PerbiolisInfo) o;		
		return (codOwner  == obj.codOwner 		&& 
				codPerson == obj.codPerson		&&
				super.isStringEqual(codLanguage, obj.codLanguage));
	}
}
