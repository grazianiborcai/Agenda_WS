package br.com.mind5.businessContent.material.main.info;

import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class MatbcinInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codStore;
	public int codBusiness;
	public String username;
	
	
	public MatbcinInfo() {
		super();
		
		codOwner = DefaultValue.number();
		codStore = DefaultValue.number();
		codBusiness = DefaultValue.number();
	}
	
	
	
	public static MatbcinInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, MatbcinInfo.class);
	}
	
	
	
	public static List<MatbcinInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, MatbcinInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner  ^ (codOwner	>>> 32));
		result = result * 31 + (int) (codStore 	^ (codStore >>> 32));
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof MatbcinInfo))
			return false;
		
		
		MatbcinInfo obj = (MatbcinInfo) o;		
		return (codOwner == obj.codOwner && 
				codStore == obj.codStore);
	}
}
