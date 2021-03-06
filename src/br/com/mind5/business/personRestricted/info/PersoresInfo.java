package br.com.mind5.business.personRestricted.info;

import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class PersoresInfo extends InfoRecord implements Cloneable {
	public long codOwner;	
	public long codPerson;
	public long codSnapshot;
	public String name;
	public String nameDisplay;
	public String recordMode;
	public String username;
	
	
	public PersoresInfo() {
		super();
		
		codOwner = DefaultValue.number();
		codSnapshot = DefaultValue.number();
		codPerson = DefaultValue.number();	
		recordMode = DefaultValue.recordMode();
	}
	
	
	
	public static PersoresInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, PersoresInfo.class);
	}
	
	
	
	public static List<PersoresInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, PersoresInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner  ^ (codOwner  >>> 32));
		result = result * 31 + (int) (codPerson ^ (codPerson >>> 32));
		
		if (name != null)
			result = result * 31 + name.hashCode();
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof PersoresInfo))
			return false;
		
		
		PersoresInfo obj = (PersoresInfo) o;		
		return (codOwner 	== obj.codOwner 	&& 
				codPerson 	== obj.codPerson	&&
				super.isStringEqual(name, obj.name));
	}
}
