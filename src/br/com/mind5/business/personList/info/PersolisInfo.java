package br.com.mind5.business.personList.info;

import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class PersolisInfo extends InfoRecord implements Cloneable {
	public long codOwner;	
	public long codPerson;
	public long codSnapshot;
	public String name;
	public String recordMode;
	public String username;
	
	
	public PersolisInfo() {
		super(PersolisInfo.class);
		
		codOwner = DefaultValue.number();
		codSnapshot = DefaultValue.number();
		codPerson = DefaultValue.number();	
		recordMode = DefaultValue.recordMode();
	}
	
	
	
	public static PersolisInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, PersolisInfo.class);
	}
	
	
	
	public static List<PersolisInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, PersolisInfo.class);
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
		
		
		if (!(o instanceof PersolisInfo))
			return false;
		
		
		PersolisInfo obj = (PersolisInfo) o;		
		return (codOwner 	== obj.codOwner 	&& 
				codPerson 	== obj.codPerson	&&
				super.isStringEqual(name, obj.name));
	}
}
